package com.edutech.service;

import com.edutech.dto.BoardDTO;
import com.edutech.entity.Board;
import com.edutech.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;
    private final ModelMapper modelMapper;

    @Override
    public BoardDTO findByBno(Long bno) {
        Optional<Board> result = boardRepository.findById(bno);
        BoardDTO boardDTO = modelMapper.map(result, BoardDTO.class);
        return boardDTO;
    }

    @Override
    public List<BoardDTO> findAll() { // 람다식 써라
        List<Board> result = boardRepository.findAll();
        List<BoardDTO> boardList = result.stream().map(board ->
                modelMapper.map(board, BoardDTO.class))
                .collect(Collectors.toList());
        return boardList;
    }

    @Override
    public Long register(BoardDTO boardDTO) {
        Board board = modelMapper.map(boardDTO, Board.class);
        Long bno = boardRepository.save(board).getBno();
        return bno;
    }
}
