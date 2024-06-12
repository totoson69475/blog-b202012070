package idusw.springboot.lswblog.service;

import idusw.springboot.lswblog.entity.BlogEntity;
import idusw.springboot.lswblog.entity.MemberEntity;
import idusw.springboot.lswblog.model.BlogDto;
import idusw.springboot.lswblog.repository.BlogRepository;
import idusw.springboot.lswblog.serivce.BlogService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class BlogServiceTest {
    // field DI : test, constructor DI : development, deployment code
    @Autowired
    BlogService blogService;

    @Test
    public void registerBlog() {
        BlogDto dto = BlogDto.builder()
                .title("제목4")
                .content("곧 장마도 시작!")
                .writerIdx(4L) // idx가 3번인 멤버(blogger)가 미리 생성되어 있어야 함.
                .block("non")
                .build();
        blogService.create(dto);

    }
    @Test
    public void getBlogs() { // DB로 부터 등록된 블로그를 가져옴
        List<BlogDto> blogDtoList = blogService.readList();
        // getBlogs()는 service에게 요청하는 코드와 controller에게 반환/출력하는 코드
        // -> readList()에는 repository에게 요청하는 코드가 존재함
        for(BlogDto dto : blogDtoList)
            System.out.println(dto.toString());
    }
    @Test
    public void getBlog() {
        BlogDto dto = BlogDto.builder()
                .idx((long)1)
                .build();
        BlogDto blogDto = blogService.read(dto);    // repository에게 요청할 것임
        System.out.println(blogDto.toString());

    }
    @Test
    public void deleteBlog(){
        BlogDto dto = BlogDto.builder()
                .idx((long) 4)
                .build();
        blogService.delete(dto); // repository에게 요청하는 코드가 있을 것임
    }
    BlogEntity dtoToEntity(BlogDto dto) {
        MemberEntity member = MemberEntity.builder()
                .idx(dto.getWriterIdx())
                .build();
        BlogEntity entity = BlogEntity.builder()
                .idx(dto.getIdx())
                .title(dto.getTitle())
                .content(dto.getContent())
                .block(dto.getBlock())
                .views(dto.getViews())
                .blogger(member)
                .build();
        return entity;
    }
    // MemberEntity -> : Controller에서는 Member를 다룸
    BlogDto entityToDto(BlogEntity entity, MemberEntity member) {
        BlogDto dto = BlogDto.builder()
                .idx(entity.getIdx())
                .title(entity.getTitle())
                .views(entity.getViews())
                .content(entity.getContent())
                .writerIdx(member.getIdx())
                .writerName(member.getName())
                .writerEmail(member.getEmail())
                .regDate((entity.getRegDate()))
                .modDate(entity.getModDate())
                .build();
        return dto;
    }
}
