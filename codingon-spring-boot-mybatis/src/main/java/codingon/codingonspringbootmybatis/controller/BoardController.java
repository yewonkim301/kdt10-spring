package codingon.codingonspringbootmybatis.controller;

import codingon.codingonspringbootmybatis.domain.Board;
import codingon.codingonspringbootmybatis.dto.BoardDTO;
import codingon.codingonspringbootmybatis.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// 공통적인 경로를 사용할 때는 가장 위에
// @RequestMapping("/공통경로") 적어주면 됨

@Controller
public class BoardController {
    @Autowired
    BoardService boardService;

    @GetMapping("/board")
    public String getBoards(Model model) {
        List<BoardDTO> boards = boardService.getBoardList();

        model.addAttribute("list", boards);
        return "board";
    }

    @GetMapping("/searchBoard")
    public String getBoard(@RequestParam String title, Model model) {
        Board board = boardService.findBoard(title);
        // boardService.findBoard(title);

        model.addAttribute("list", board);
        return "board";
    }

    @PostMapping("/postBoard")
    public String boardInsert(@RequestParam String title, @RequestParam String content, @RequestParam String writer){
        Board board = new Board();
        board.setTitle(title);
        board.setContent(content);
        board.setWriter(writer);

        boardService.insertBoard(board);

        // return "board";
        return "redirect:/board";
    }

    @PatchMapping("/updateBoard")
    public String boardUpdate(@RequestParam int id, @RequestParam String title, @RequestParam String content, @RequestParam String writer) {
        Board board = new Board();
        board.setId(id);
        board.setTitle(title);
        board.setContent(content);
        board.setWriter(writer);

        boardService.updateBoard(board);

        return "redirect:/board";
    }

    @DeleteMapping("/deleteBoard")
    public String boardDelete(@RequestParam int id) {
        Board board = new Board();
        board.setId(id);

        boardService.deleteBoard(board);

        return "redirect:/board";
    }
}
