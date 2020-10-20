package com.example.demo.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.example.demo.domain.BoardVO;
import com.example.demo.mapper.BoardMapper;

import lombok.RequiredArgsConstructor;

@Service("com.example.demo.service.BoardService")
@RequiredArgsConstructor
public class BoardService {
	
	@Resource(name="com.example.demo.mapper.BoardMapper")
	BoardMapper mBoardMapper;
	
	public List<BoardVO> boardListService() throws Exception{
		return mBoardMapper.boardList();
	}
	
	public BoardVO boardDetailService(int idx) throws Exception {
		return mBoardMapper.boardDetail(idx);
	}
	
	public int boardInsertService(BoardVO board) throws Exception{
        
        return mBoardMapper.boardInsert(board);
    }
    
    public int boardUpdateService(BoardVO board) throws Exception{
        
        return mBoardMapper.boardUpdate(board);
    }
    
    public int boardDeleteService(int idx) throws Exception{
        
        return mBoardMapper.boardDelete(idx);
    }
}
