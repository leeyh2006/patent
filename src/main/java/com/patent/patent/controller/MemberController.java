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
    //회원 Id와 Pw을 입력받아 새로운 Member를 생성하고 그 결과를 반환
    public Member create(@RequestParam String memId, String memPw, String memNm, Long memTp, Long phoneNum, Long telNum ){
        return memberService.add(memId, memPw, memNm, memTp, phoneNum, telNum);
    }

    @PostMapping(value = "/me")
    public Member getMe(@RequestAttribute Member member){
        return member;
    }

    /*
    @ApiOperation(value = "join member")
    @PostMapping(value = "/join")
    public Response<Member> joinMember(@RequestBody(required = true) Member member) {
        return memberService.add(member);
    }*/

}
