package com.example.demo.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.domain.BoardVO;
import com.example.demo.domain.PagingVO;

@Repository("com.example.demo.mapper.BoardMapper")
public interface BoardMapper {
	//게시글 갯수
	public int boardCount() throws Exception;
	
	//게시글 목록
	public List<BoardVO> boardList(PagingVO<BoardVO> vo) throws Exception;
	
	//게시글 상세
	public BoardVO boardDetail(int id) throws Exception;
	
	//게시글 작성
	public int boardInsert(BoardVO board) throws Exception;
	
	//게시글 수정
	public int boardUpdate(BoardVO board) throws Exception;
	
	//게시글 삭제
	public int boardDelete(int id) throws Exception;
}
