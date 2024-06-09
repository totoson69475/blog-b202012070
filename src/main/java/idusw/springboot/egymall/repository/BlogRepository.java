package idusw.springboot.egymall.repository;

import idusw.springboot.egymall.entity.BlogEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<BlogEntity, Long> { // interface 상속,
}
