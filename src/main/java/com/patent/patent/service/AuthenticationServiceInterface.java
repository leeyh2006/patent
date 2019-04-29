package com.patent.patent.service;

import com.patent.patent.dto.member.Member;

public interface AuthenticationServiceInterface {
    Member authenticate(String token);
}
