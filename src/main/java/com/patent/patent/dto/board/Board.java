package com.patent.patent.dto.board;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString
public class Board {
    private int num;
    private String register;
    private String content;
    private LocalDate createdAt = LocalDate.now();
    private LocalDate modifiedAt = LocalDate.now();;
    private int viewCount;
}
