package idusw.springboot.lswblog.serivce;

import idusw.springboot.lswblog.entity.MemberEntity;
import idusw.springboot.lswblog.model.MemberDto;

import java.util.List;

public interface MemberService {
    int create(MemberDto memberDto);
    MemberDto readByIdx(Long idx);
    List<MemberDto> readAll();
    int update(MemberDto memberDto);
    int delete(MemberDto memberDto);

    MemberDto loginById(MemberDto memberDto); // id / pw 활용

    List<MemberDto> searchMembers(String name, String email, String phone);
    // Conversion
    default MemberEntity dtoToEntity(MemberDto memberDto) {
        MemberEntity entity = MemberEntity.builder()
                .idx(memberDto.getIdx())
                .id(memberDto.getId())
                .pw(memberDto.getPw())
                .name(memberDto.getName())
                .email(memberDto.getEmail())
                .phone(memberDto.getPhone())
                .address(memberDto.getAddress())
                .build();
        return entity;
    }
    
    default MemberDto entityToDto(MemberEntity entity) {
        MemberDto memberDto = MemberDto.builder()
                .idx(entity.getIdx())
                .id(entity.getId())
                .pw(entity.getPw())
                .name(entity.getName())
                .email(entity.getEmail())
                .regDate(entity.getRegDate())
                .modDate(entity.getModDate())
                .phone(entity.getPhone())
                .address(entity.getAddress())
                .build();
        return memberDto;
    }
}
