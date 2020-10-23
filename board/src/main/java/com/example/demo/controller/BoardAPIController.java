package com.example.demo.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
	
	@PostMapping("/insertProc")
	private Boolean boardInsertProc(HttpServletRequest request) throws Exception {
		BoardVO board = new BoardVO();
		Date now = new Date();

		board.setTitle(request.getParameter("title"));
		board.setWriter(request.getParameter("writer"));
		board.setContents(request.getParameter("contents"));
		board.setCreated_at(now);

		try {
			mBoardService.boardInsertService(board);
			return true;
		} catch(Exception e) {
			System.out.println(e);
			return false;
		}
	}
	
	@PostMapping("/delete/{id}")
	private int boardDelete(@PathVariable int id) throws Exception {
		return mBoardService.boardDeleteService(id);
	}
}
