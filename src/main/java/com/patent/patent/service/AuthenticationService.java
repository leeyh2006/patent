package com.patent.patent.service;

import com.patent.patent.dto.member.Member;
import com.patent.patent.exception.UnauthorizedException;
import com.patent.patent.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Base64Utils;

public class AuthenticationService implements AuthenticationServiceInterface{
    private final MemberRepository memberRepository;

    @Autowired
    public AuthenticationService(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    @Override
    public Member authenticate(String token){
        try{
            String[] split = token.split(" ");

            String type = split[0];
            String credential = split[1];
            if("Basic".equalsIgnoreCase(type)){
                //credental을 디코딩하여 username와 password를 분리
                String decoded = new String(Base64Utils.decodeFromString(credential));
                String[] memIdAndmemPw = decoded.split(":");

                Member mem = memberRepository.findByMemIdAndMemPw(memIdAndmemPw[0],memIdAndmemPw[1]);
                if(mem ==null){
                    throw new UnauthorizedException("Invalid credentials");
                }else{
                    return mem;
                }
            }else {
                throw new UnauthorizedException("Unsupported type: " + type);
            }
        }catch (IllegalArgumentException | ArrayIndexOutOfBoundsException ex){
            throw new UnauthorizedException("Invalid credentials");
        }
    }
}
