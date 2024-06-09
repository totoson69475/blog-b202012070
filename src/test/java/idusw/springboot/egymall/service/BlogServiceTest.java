package idusw.springboot.egymall.service;

import idusw.springboot.egymall.entity.BlogEntity;
import idusw.springboot.egymall.entity.MemberEntity;
import idusw.springboot.egymall.model.BlogDto;
import idusw.springboot.egymall.repository.BlogRepository;
import idusw.springboot.egymall.serivce.BlogService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BlogServiceTest {
    @Autowired
    BlogRepository blogRepository;

    @Test
    public void registerBlog() {
        BlogDto dto = BlogDto.builder()
                .title("test1")
                .content("content1")
                .writerIdx(3L)
                .block("non")
                .build();

        blogRepository.save(dtoToEntity(dto));
    }
    BlogEntity dtoToEntity(BlogDto dto) {
        MemberEntity member = MemberEntity.builder()
                .idx(dto.getWriterIdx())
                .build();
        BlogEntity entity = BlogEntity.builder()
                .bno(dto.getBno())
                .title(dto.getTitle())
                .content(dto.getContent())
                .block(dto.getBlock())
                .views(dto.getViews())
                .writer(member)
                .build();
        return entity;
    }
    // MemberEntity -> : Controller에서는 Member를 다룸
    BlogDto entityToDto(BlogEntity entity, MemberEntity member) {
        BlogDto dto = BlogDto.builder()
                .bno(entity.getBno())
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
