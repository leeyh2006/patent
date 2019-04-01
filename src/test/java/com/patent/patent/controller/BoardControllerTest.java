package com.patent.patent.controller;

import com.patent.patent.dto.board.Board;
import com.patent.patent.service.BoardService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(value = BoardController.class)
public class BoardControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BoardService boardService;

    @Test
    public void Board_테스트() throws Exception {
        Board board = Board
                .builder()
                .num(0)
                .register("sungmin")
                .content("content")
                .viewCount(10)
                .build();

        given(boardService.getBoards(0))
                .willReturn(Collections.singletonList(board));


        mockMvc.perform(get("/api/boards/default"))
                .andExpect(status().isOk());
    }
}