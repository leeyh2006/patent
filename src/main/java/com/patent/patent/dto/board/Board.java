package com.patent.patent.dto.board;

import lombok.*;

import java.time.LocalDate;

@Data
@Builder(toBuilder = true)
public class Board {
    private int num;
    private String register;
    private String content;
    private LocalDate createdAt = LocalDate.now();
    private LocalDate modifiedAt = LocalDate.now();;
    private int viewCount;
}
