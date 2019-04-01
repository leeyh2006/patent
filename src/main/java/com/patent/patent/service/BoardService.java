package com.patent.patent.service;

import com.patent.patent.dto.Response;
import com.patent.patent.dto.board.Board;
import com.patent.patent.repository.BoardRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;

@Slf4j
@Service
public class BoardService {
    private final BoardRepository boardRepository;

    BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    /**
     * @implNote index가 0인 경우는 메인 화면에서 5개의 게시물만 가져오는 경우.
     * @implNote index가 0이 아닌 경우는 페이지네이션에 사용되는 숫자.
     *
     * @param index => pagination에 사용되는 숫자.
     *
     * @return List<Board>
     */
    public List<Board> getBoards(int index) {
        return (index == 0) ?
                null : null;
    }

    // transaction 처리
    @SuppressWarnings("unchecked")
    public Response<Board> add(@NotNull Board board) {
        try {
            //
        } catch (Exception e) {
            log.error("Cannot add board => [{}]", board, e);
            return Response.fail(board, HttpStatus.INTERNAL_SERVER_ERROR, e.getLocalizedMessage());
        }
        return Response.success(board, HttpStatus.OK);
    }

    // transaction 처리
    @SuppressWarnings("unchecked")
    public Response update(@NotNull Board board) {
        try {

        } catch (Exception e) {
            log.error("Cannot add update => [{}]", board, e);
            return Response.fail(board, HttpStatus.INTERNAL_SERVER_ERROR, e.getLocalizedMessage());
        }
        return Response.success(board, HttpStatus.OK);
    }

    // transaction 처리
    @SuppressWarnings("unchecked")
    public Response delete(Integer num) {
        try {

        } catch (Exception e) {
            log.error("Cannot remove update => [{}]", num, e);
            return Response.fail(num, HttpStatus.INTERNAL_SERVER_ERROR, e.getLocalizedMessage());
        }
        return Response.success(num, HttpStatus.OK);
    }
}
