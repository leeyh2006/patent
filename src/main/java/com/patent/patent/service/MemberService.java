package com.patent.patent.service;

import com.patent.patent.dto.Response;
import com.patent.patent.exception.AlreadyExistsException;
import com.patent.patent.exception.LoginFailException;
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
public class MemberService implements MemberServiceInterface{

    @Autowired
    private MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    //회원가입
    public Member add(String memId, String memPw, String memNm, Long memTp, Long phoneNum, Long telNum) {
        Member mem = memberRepository.findByMemId(memId);
        if (mem != null)
            throw new AlreadyExistsException("Duplicate ID");
        return memberRepository.save(new Member(memId, memPw, memNm, memTp, phoneNum, telNum));
    }

    //로그인
    public  Member login(String memId, String memPw){
        Member mem = memberRepository.findByMemIdAndMemPw(memId, memPw);
        if(mem == null) {
            //로그인 실패 Exception 추가
            Member mem1 = memberRepository.findByMemId(memId);
            if(mem1 != null){
                throw new LoginFailException("비밀번호를 확인하세요.");
            }else {
                throw new LoginFailException("아이디를 확인하세요.");
            }

        }else{
            return mem;
        }
    }



   /* public Member findOne(Long memNo){
        return this.memberRepository.findOne(memNo);
    }
    public Response<Member> add(@NotNull Member member) {
        try {
            //회원가입 로직 추가
        } catch (Exception e) {
            log.error("Cannot join member => [{}]", member, e);
            return Response.fail(member, HttpStatus.INTERNAL_SERVER_ERROR, e.getLocalizedMessage());
        }
        return Response.success(member, HttpStatus.OK);
    }
    */
}
