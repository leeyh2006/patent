package com.patent.patent.interceptor;

import com.patent.patent.dto.member.Member;
import com.patent.patent.service.AuthenticationService;
import com.patent.patent.service.AuthenticationServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class AuthenticationInterceptor extends HandlerInterceptorAdapter {


    /*private AuthenticationServiceInterface authenticationService;

    @Autowired
    public AuthenticationInterceptor(AuthenticationServiceInterface authenticationService) {
        this.authenticationService = authenticationService;
    }


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String token = request.getHeader(HttpHeaders.AUTHORIZATION);
        Member mem = authenticationServiceInterface.authenticate(token);
        request.setAttribute("mem", mem);

        return super.preHandle(request, response, handler);
    }
*/


}
