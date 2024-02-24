package codingon.codingonspringbootmybatis.service;

import codingon.codingonspringbootmybatis.dto.BoardDTO;
import codingon.codingonspringbootmybatis.domain.Board;
import codingon.codingonspringbootmybatis.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BoardService {
    @Autowired
    BoardMapper boardMapper;

    public List<BoardDTO> getBoardList() {
        List<Board> boards = boardMapper.retrieveAll();
        List<BoardDTO> result = new ArrayList<>();

        for (Board board: boards) {
            BoardDTO boardDTO = BoardDTO.builder()
                    .id(board.getId())
                    .title(board.getTitle())
                    .content(board.getContent())
                    .writer(board.getWriter())
                    .registered(board.getRegistered())
                    .build();

            result.add(boardDTO);
        }
        return result;
    }

    public Board findBoard(String title) {
        return boardMapper.findBoard(title);
    }

    public void insertBoard(Board board) {
        boardMapper.insertBoard(board);
    }

    public void updateBoard(Board board) {
        boardMapper.updateBoard(board);
    }

    public void deleteBoard(Board board) {
        boardMapper.deleteBoard(board);
    }
}
