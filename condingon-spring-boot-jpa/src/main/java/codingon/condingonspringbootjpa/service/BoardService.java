package codingon.condingonspringbootjpa.service;

import codingon.condingonspringbootjpa.dto.BoardDTO;
import codingon.condingonspringbootjpa.entity.BoardEntity;
import codingon.condingonspringbootjpa.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BoardService {
    @Autowired
    BoardRepository boardRepository;

    // SimpleDateFormat(형식).format(dateTime 데이터)
    public List<BoardDTO> getBoardList() {
        List<BoardEntity> boards = boardRepository.findAll();
        List<BoardDTO> result = new ArrayList<>();
        for (BoardEntity board: boards) {
            BoardDTO boardDTO = BoardDTO.builder()
                    .id(board.getId())
                    .title(board.getTitle())
                    .content(board.getContent())
                    .writer(board.getWriter())
                    .registered(String.valueOf(board.getRegistered()))
                    // .registered(new SimpleDateFormat("yyyy-mm-dd").format(board.getRegistered()))
                    .build();
           result.add(boardDTO);
        }
        return result;
    }

    public List<BoardDTO> searchBoardList(String title) {
        List<BoardEntity> boards = boardRepository.findByTitle(title);
        List<BoardDTO> result = new ArrayList<>();
        for (BoardEntity board: boards) {
            BoardDTO boardDTO = BoardDTO.builder()
                    .id(board.getId())
                    .title(board.getTitle())
                    .content(board.getContent())
                    .writer(board.getWriter())
                    .registered(String.valueOf(board.getRegistered()))
                    .build();
            result.add(boardDTO);
        }
        return result;
    }

    public BoardEntity insertBoard(BoardEntity board) {
        BoardEntity newBoard = boardRepository.save(board);

        return newBoard;
    }

    public String deleteBoard(int id) {
        Optional<BoardDTO> deleteBoard = boardRepository.deleteById(id);

        System.out.println(deleteBoard);

        return "success";
    }

//    public BoardEntity updateBoard(BoardEntity board) {
//        Optional<BoardEntity> findBoard = boardRepository.findById(board.getId());
//        findBoard.ifPresent(selectBoard -> {
//            selectBoard.setTitle(board.getTitle());
//            selectBoard.setContent(board.getContent());
//            selectBoard.setWriter(board.getWriter());
//
//            String board2 = String.valueOf(boardRepository.save(selectBoard));
//        });
//        return board;
//    }

    public void updateBoard(BoardDTO boardDTO) {
        BoardEntity board = boardRepository.findById(boardDTO.getId()).orElseThrow(() -> new RuntimeException("board patch: id is wrong"));
        BoardEntity modified = BoardEntity.builder()
                .id(board.getId())
                .title(boardDTO.getTitle())
                .content(boardDTO.getContent())
                .writer(boardDTO.getWriter())
                .registered(board.getRegistered())
                .build();
        boardRepository.save(modified);
    }
}
