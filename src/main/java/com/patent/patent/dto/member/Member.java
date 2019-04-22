package com.patent.patent.dto.member;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Member {

    @Id
    @GeneratedValue
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


}
