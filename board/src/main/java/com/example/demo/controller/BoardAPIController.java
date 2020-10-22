package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.BoardVO;
import com.example.demo.domain.PagingVO;
import com.example.demo.service.BoardService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class BoardAPIController {
	private final BoardService mBoardService;
	
	@GetMapping("/list")
	public PagingVO<BoardVO> boardMain(@RequestParam(value="nowPage", required=false)int nowPage) throws Exception {
		return mBoardService.boardListService(nowPage);
	}
	
	@GetMapping("/detail/{id}")
	private BoardVO boardDetail(@PathVariable int id) throws Exception {
		return mBoardService.boardDetailService(id);
	}
}
