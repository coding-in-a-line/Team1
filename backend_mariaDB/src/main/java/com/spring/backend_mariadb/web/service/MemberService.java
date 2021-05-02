package com.spring.backend_mariadb.web.service;

import com.spring.backend_mariadb.web.domain.member.Members;
import com.spring.backend_mariadb.web.domain.member.MembersRepository;
import com.spring.backend_mariadb.web.dto.MembersDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class MemberService {
    private final MembersRepository membersRepository;

    @Transactional
    public Long save(MembersDto requestDto) {
        return membersRepository.save(requestDto.toEntity()).getIdx();
    }
    @Transactional
    public boolean Auth(String id, String pw){
        return membersRepository.findByIdAndPw(id,pw).size()==1;
    }
    @Transactional
    public List<MembersDto> getMembers(){
        List<Members> membersList = membersRepository.findAll();
        List<MembersDto> membersDtoList = new ArrayList<>();
        for(Members members : membersList){
            membersDtoList.add(
                    MembersDto.builder()
                            .idx(members.getIdx())
                            .id(members.getId())
                            .pw(members.getPw())
                            .ctz_number(members.getCtz_number())
                            .real_name(members.getReal_name())
                            .login_status(members.getLogin_status())
                            .reg_date(members.getReg_date())
                            .upd_date(members.getUpd_date())
                            .manager(members.getManager())
                    .build()
            );
        }
        return membersDtoList;
    }
}
