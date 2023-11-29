package com.edutech.controller;

import com.edutech.dto.BoardDTO;
import com.edutech.service.BoardService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/board/list")
    @ResponseBody
    public List<BoardDTO> listAll(){
        List<BoardDTO> boardList = boardService.findAll();
        return boardList;
    }

    @GetMapping("/board/read")
    @ResponseBody
    public BoardDTO findByBno(Long bno){
        BoardDTO board = boardService.findByBno(bno);
        return board;
    }

    @GetMapping("/board/write")
    public String boardForm(){
        return "board/write";
    }

    @PostMapping
    @ResponseBody
    public Long boardWrite(@Valid BoardDTO boardDTO){
        return boardService.register(boardDTO);
    }
}