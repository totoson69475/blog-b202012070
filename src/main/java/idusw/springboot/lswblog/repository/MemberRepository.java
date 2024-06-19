package idusw.springboot.lswblog.repository;

import idusw.springboot.lswblog.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MemberRepository extends
        JpaRepository<MemberEntity, Long> {

    Optional<MemberEntity> findByIdx(Long idx);
    Optional<MemberEntity> findByIdAndPw(String id, String pw);

    @Query("SELECT m FROM MemberEntity m WHERE " +
            "(:name IS NULL OR m.name LIKE %:name%) AND " +
            "(:email IS NULL OR m.email LIKE %:email%) AND " +
            "(:phone IS NULL OR m.phone LIKE %:phone%)")
    List<MemberEntity> searchMembers(@Param("name") String name,
                                     @Param("email") String email,
                                     @Param("phone") String phone);


    //QuerydslPredicateExecutor<MemberEntity> {
    /*
    @Query("select m from MemberEntity m where m.id = :id and m.pw = :pw")
    Object getMemberEntityById(@Param("id") String id, @Param("pw") String pw);

     */

}
