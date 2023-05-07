package edu.kh.comm.board.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.kh.comm.board.model.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardService service;
	
	// 게시글 목록 조회
	//@RequestParam(value = "cp", required = false, defaultValue = "1") int cp // url만지는작업
	@GetMapping("/list/{boardCode}")
	public String boardList(@PathVariable("boardCode") int boardCode,
					@RequestParam(value = "cp", required = false, defaultValue = "1") int cp,
					Model model
			) {
	
		Map<String, Object> map = null;
		map = service.selectBoardList(cp, boardCode);
		
		model.addAttribute("map", map);
		
		return "board/boardList";
	}
	
	
	
	
	
	
	
}
