package com.example.demo.controller;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.BoardVO;
import com.example.demo.service.BoardService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BoardController {

	@Resource(name = "com.example.demo.service.BoardService")
	BoardService mBoardService;

	@GetMapping("/")
	public String boardMain(Model model) throws Exception {
		model.addAttribute("list", mBoardService.boardListService());
		return "main";
	}

	@RequestMapping("/detail/{id}")
	private String boardDetail(@PathVariable int id, Model model) throws Exception {
		model.addAttribute("detail", mBoardService.boardDetailService(id));

		return "detail";
	}

	@RequestMapping("/insert")
	private String boardInsertForm() {
		return "insert";
	}

	
	@RequestMapping("/insertProc")
	private String boardInsertProc(HttpServletRequest request) throws Exception {
		private final BoardVO board;
		Date now = new Date();
		
//		public InsertData(BoardVO board) {
//			this.board
//		}

		
		board.setCreated_at(now);

		mBoardService.boardInsertService(board);

		return "redirect:/";
	}

	@RequestMapping("/update/{id}")
	private String boardUpdateForm(@PathVariable int id, Model model) throws Exception {

		model.addAttribute("detail", mBoardService.boardDetailService(id));

		return "update";
	}

	@RequestMapping("/updateProc")
	private String boardUpdateProc(HttpServletRequest request) throws Exception {
		BoardVO board = new BoardVO();
		Date now = new Date();

		board.setId(Integer.parseInt(request.getParameter("id")));
		board.setTitle(request.getParameter("title"));
		board.setWriter(request.getParameter("writer"));
		board.setContents(request.getParameter("contents"));
		board.setUpdated_at(now);
		
		System.out.println(board);
		
		mBoardService.boardUpdateService(board);

		return "redirect:/detail/"+request.getParameter("id");
	}

	@RequestMapping("/delete/{id}")
	private String boardDelete(@PathVariable int id) throws Exception {
		mBoardService.boardDeleteService(id);
		return "redirect:/";
	}
}
