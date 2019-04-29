package com.patent.patent.dto.member;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "member")
@Data
@AllArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name =  "mem_no")
    private Long memNo;

    @Column(name = "mem_id", nullable = false)
    private String memId;

    @Column(name = "mem_pw", nullable = false)
    private String memPw;

    @Column(name = "mem_nm", nullable = false)
    private String memNm;

    @Column(name = "mem_tp", nullable = false)
    private Long memTp;

    @Column(name = "phone_num", nullable = true)
    private Long phoneNum;

    @Column(name = "tel_num", nullable = true)
    private Long telNum;

    protected Member(){}

    public Member(String memId, String memPw, String memNm, Long memTp, Long phoneNum, Long telNum){
        this.memId = memId;
        this.memPw = memPw;
        this.memNm = memNm;
        this.memTp = memTp;
        this.phoneNum = phoneNum;
        this.telNum = telNum;

    }

    @Override
    public String toString() {
        return String.format("Member[memId='%d', memPw='%s']", memId, memPw);
    }


}
