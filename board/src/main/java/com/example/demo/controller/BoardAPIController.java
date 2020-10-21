package com.example.demo.controller;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.BoardVO;
import com.example.demo.service.BoardService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class BoardAPIController {
	private final BoardService mBoardService;
	
	@GetMapping("/list")
	public List<BoardVO> boardMain() throws Exception {
		return mBoardService.boardListService();
	}
}
