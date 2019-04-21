package com.patent.patent.controller;

import com.patent.patent.dto.Response;
import com.patent.patent.service.MemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.patent.patent.dto.member.Member;

@Api(value = "Member Controller", produces = "application/json")
@RestController
@RequestMapping(value = "/api/member")
public class MemberController {

    private MemberService memberService;

    @ApiOperation(value = "join member")
    @PostMapping(value = "/add")
    public Response<Member> joinMember(@RequestBody(required = true) Member member) {
        return memberService.add(member);
    }
}
