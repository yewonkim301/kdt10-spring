package codingon.condingonspringbootjpa.controller;

import codingon.condingonspringbootjpa.dto.BoardDTO;
import codingon.condingonspringbootjpa.entity.BoardEntity;
import codingon.condingonspringbootjpa.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/board")
public class BoardController {
    @Autowired
    BoardService boardService;

    @GetMapping("")
    public String getBoards(Model model) {
        List<BoardDTO> boards = boardService.getBoardList();
        model.addAttribute("list", boards);
        return "board";
    }

    @GetMapping("/search")
    public String searchBoard(@RequestParam String title, Model model) {
        List<BoardDTO> boards = boardService.searchBoardList(title);
        model.addAttribute("list", boards);
        return "board";
    }

    @PostMapping("")
    @ResponseBody
    public String insertBoard(@RequestBody BoardEntity board) {
        String newBoard = String.valueOf(boardService.insertBoard(board));
        return "new board success";
    }

    @DeleteMapping("")
    public String boardDelete(@RequestParam int id) {
        String board = boardService.deleteBoard(id);

        return "board delete success";
    }

    @PatchMapping("")
    public void boardUpdate(@RequestBody BoardDTO boardDTO) {
        boardService.updateBoard(boardDTO);
    }
}
