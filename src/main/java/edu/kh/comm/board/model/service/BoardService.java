package edu.kh.comm.board.model.service;

import java.util.List;
import java.util.Map;

import edu.kh.comm.board.model.vo.BoardType;

public interface BoardService {

	// 게시판 코드, 이름 조회
	List<BoardType> selectBoardType();

	// 게시글 목록 조회 서비스
	Map<String, Object> selectBoardList(int cp, int boardCode);

 
}
