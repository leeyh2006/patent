package com.patent.patent.controller;

import com.patent.patent.dto.Response;
import com.patent.patent.dto.board.Board;
import com.patent.patent.service.BoardService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "Board Controller", produces = "application/json")
@RestController
@RequestMapping(value = "/api/boards")
public class BoardController {
    private static final int DEFAULT_INDEX = 0;

    private final BoardService boardService;

    BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @ApiOperation(value = "get default boards in main page, number = 5")
    @GetMapping(value = "/default")
    public List<Board> getDefaultBoards() {
        return boardService.getBoards(DEFAULT_INDEX);
    }

    @ApiOperation(value = "get boards by pagination")
    @GetMapping(value = "/page")
    public List<Board> getIndexedBoards(@RequestParam(value = "index", defaultValue = "1") int index) {
        return boardService.getBoards(index);
    }

    @ApiOperation(value = "add boards content")
    @PostMapping(value = "/add")
    public Response<Board> addBoards(@RequestBody(required = true) Board board) {
        return boardService.add(board);
    }

    @ApiOperation(value = "update boards content")
    @PutMapping(value = "/update")
    public Response updateBoards(@RequestBody(required = true) Board board) {
        return boardService.update(board);
    }

    @ApiOperation(value = "delete boards content")
    @DeleteMapping(value = "/delete")
    public Response deleteBoards(@RequestParam(value = "num") Integer num) {
        return boardService.delete(num);
    }
}
