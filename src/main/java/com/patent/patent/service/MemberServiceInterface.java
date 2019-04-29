package com.patent.patent.service;

import com.patent.patent.dto.member.Member;

public interface MemberServiceInterface {
    //회원가입
    Member add(String memId, String memPw, String memNm, Long memTp, Long phoneNum, Long telNum);
}
