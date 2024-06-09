package idusw.springboot.egymall.serivce;

import idusw.springboot.egymall.model.BlogDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {

    @Override
    public int create(BlogDto dto) {
        return 0;
    }

    @Override
    public BlogDto read(BlogDto dto) {
        return null;
    }

    @Override
    public List<BlogDto> readList() {
        return null;
    }

    @Override
    public int update(BlogDto dto) {
        return 0;
    }

    @Override
    public int delete(BlogDto dto) {
        return 0;
    }
}
