package com.example.demo.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.example.demo.domain.BoardVO;
import com.example.demo.domain.PagingVO;
import com.example.demo.mapper.BoardMapper;

import lombok.RequiredArgsConstructor;

@Service("com.example.demo.service.BoardService")
@RequiredArgsConstructor
public class BoardService {

	private final BoardMapper mBoardMapper;

	public PagingVO<BoardVO> boardListService(int nowPage) throws Exception {
		int total = mBoardMapper.boardCount();
		PagingVO<BoardVO> page = new PagingVO<BoardVO>(nowPage, total);
		page.setList(mBoardMapper.boardList(page));
		return page;
	}

	public BoardVO boardDetailService(int idx) throws Exception {
		return mBoardMapper.boardDetail(idx);
	}

	public int boardInsertService(BoardVO board) throws Exception {
		return mBoardMapper.boardInsert(board);
	}

	public int boardUpdateService(BoardVO board) throws Exception {
		return mBoardMapper.boardUpdate(board);
	}

	public int boardDeleteService(int idx) throws Exception {
		return mBoardMapper.boardDelete(idx);
	}
}
