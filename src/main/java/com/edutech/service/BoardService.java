package com.edutech.service;

import com.edutech.dto.BoardDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface BoardService {
    BoardDTO findByBno(Long bno);
    List<BoardDTO> findAll();
    Long register(BoardDTO boardDTO);
}
