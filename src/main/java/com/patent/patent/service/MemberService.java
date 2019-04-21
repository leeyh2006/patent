package com.patent.patent.service;

import com.patent.patent.dto.Response;
import com.patent.patent.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.patent.patent.dto.member.Member;

import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;

@Slf4j
@Service
@Transactional
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    //회원가입 로직
    //회원조회 로직
    //회원정보변경 로직
    //회원삭제 로직

   /* public Member findOne(Long memNo){
        return this.memberRepository.findOne(memNo);
    }*/

    @SuppressWarnings("unchecked")
    public Response<Member> add(@NotNull Member member) {
        try {
            //회원가입 로직 추가
        } catch (Exception e) {
            log.error("Cannot join member => [{}]", member, e);
            return Response.fail(member, HttpStatus.INTERNAL_SERVER_ERROR, e.getLocalizedMessage());
        }
        return Response.success(member, HttpStatus.OK);
    }
}
