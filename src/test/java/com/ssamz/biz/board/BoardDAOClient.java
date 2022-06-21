package com.ssamz.biz.board;

import java.util.List;

public class BoardDAOClient {
	
	public static void main(String[] args) throws Exception {
		BoardVO vo = new BoardVO();
		vo.setTitle("iBATIS 테스트");
		vo.setWriter("테스터");
		vo.setContent("iBATIS 테스트중입니다.");
		
		BoardDAO boardDAO = new BoardDAO();
		boardDAO.insertBoard(vo);
		
		List<BoardVO> boardList = boardDAO.getBoardList(vo);
		for (BoardVO board : boardList) {
			System.out.println("---> " + board.toString());
		}
	}

}
