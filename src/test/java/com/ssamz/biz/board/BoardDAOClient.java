package com.ssamz.biz.board;

import java.util.List;

public class BoardDAOClient {
	
	public static void main(String[] args) throws Exception {
		
		// 사용자 입력정보 추출하여 세팅
		BoardVO vo = new BoardVO();
		vo.setTitle("iBATIS 테스트");
		vo.setWriter("테스터");
		vo.setContent("iBATIS 테스트중입니다.");    
		
		
		// DAO 매서드 테스트
		BoardDAO boardDAO = new BoardDAO();
		boardDAO.insertBoard(vo);                
		
		List<BoardVO> boardList = boardDAO.getBoardList(vo);
		for (BoardVO board : boardList) {
			System.out.println("---> " + board.toString());  // 재정의하면 값 출력, 안하면 주소 출력 
		}
	}

}
