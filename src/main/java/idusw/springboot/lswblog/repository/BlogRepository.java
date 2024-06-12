package idusw.springboot.lswblog.repository;

import idusw.springboot.lswblog.entity.BlogEntity;
import idusw.springboot.lswblog.model.BlogDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface
BlogRepository extends JpaRepository<BlogEntity, Long> {
    Optional<BlogEntity> findByIdx(BlogDto dto); // interface 상속,

}
