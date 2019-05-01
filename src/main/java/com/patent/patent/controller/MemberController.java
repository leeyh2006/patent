package com.patent.patent.controller;

import com.patent.patent.dto.Response;
import com.patent.patent.service.MemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.patent.patent.dto.member.Member;

@Api(value = "Member Controller", produces = "application/json")
@RestController
@RequestMapping(value = "/api/member")
public class MemberController {

    private MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }
    @ApiOperation(value = "join member")
    @PostMapping(value = "/join")
    //회원 정보를 새로운 Member를 생성하고 그 결과를 반환
    //추후 비밀번호의 형태를 정의하여 로직에 추가.
    //추후 필수 회원정보를 정하여 체크하도록 추가.
    public Member create(@RequestParam String memId, String memPw, String memNm, Long memTp, Long phoneNum, Long telNum ){
        return memberService.add(memId, memPw, memNm, memTp, phoneNum, telNum);
    }

    @ApiOperation(value = "Login member")
    @PostMapping(value = "/login")
    //회원 id, pw를 입력받아 로그인
    //추후 비즈니스 로직을 정의하여 적용하고 oauth2 적용으로 넘어가겠다.
    public Member retrieve(@RequestParam String memId, String memPw){
        return memberService.login(memId, memPw);
    }

    @PostMapping(value = "/me")
    public Member getMe(@RequestAttribute Member member){
        return member;
    }


    //
    /*
    @ApiOperation(value = "join member")
    @PostMapping(value = "/join")
    public Response<Member> joinMember(@RequestBody(required = true) Member member) {
        return memberService.add(member);
    }*/

}
