package com.example.demo.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.example.demo.domain.BoardVO;
import com.example.demo.domain.PagingVO;
import com.example.demo.mapper.BoardMapper;

@Service("com.example.demo.service.BoardService")
public class BoardService {

	@Resource(name = "com.example.demo.mapper.BoardMapper")
	BoardMapper mBoardMapper;

	public PagingVO<BoardVO> boardListService(int nowPage) throws Exception {
		int total = this.mBoardMapper.boardCount();
		PagingVO<BoardVO> page = new PagingVO<BoardVO>(nowPage, total);
		page.setList(mBoardMapper.boardList(page));
		return page;
	}

	public BoardVO boardDetailService(int idx) throws Exception {
		return this.mBoardMapper.boardDetail(idx);
	}

	public int boardInsertService(BoardVO board) throws Exception {
		return this.mBoardMapper.boardInsert(board);
	}

	public int boardUpdateService(BoardVO board) throws Exception {
		return this.mBoardMapper.boardUpdate(board);
	}

	public int boardDeleteService(int idx) throws Exception {
		return this.mBoardMapper.boardDelete(idx);
	}
}
