package com.patent.patent.repository;

import com.patent.patent.dto.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    Member findByMemId(String memId);
    Member findByMemIdAndMemPw(String memId, String memPw);
}
