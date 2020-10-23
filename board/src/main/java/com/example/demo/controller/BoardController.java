package com.example.demo.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.BoardVO;
import com.example.demo.service.BoardService;

import lombok.RequiredArgsConstructor;

@Controller()
@RequiredArgsConstructor
public class BoardController {
	private final BoardService mBoardService;

	@GetMapping("/")
	public String boardMain(Model model) throws Exception {
		return "main";
	}

	@RequestMapping("/detail")
	private String boardDetail() throws Exception {
		return "detail";
	}

	@GetMapping("/insert")
	private String boardInsertForm() {
		return "insert";
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

		mBoardService.boardUpdateService(board);
		return "redirect:/detail?id=" + request.getParameter("id");
	}
}
