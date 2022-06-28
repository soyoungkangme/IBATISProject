package com.ssamz.biz.board;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.ssamz.biz.util.SqlMapClientFactoryBean;

public class BoardDAO {

	
	private SqlMapClient ibatis;   // SqlMapClient = iBAITS 컨테이너 
	public BoardDAO() {
		ibatis = SqlMapClientFactoryBean.getSqlMapClientInstance();   // SqlMapClientFactoryBean(공장)로부터 SqlMapClient 획득 
	}
	
	
	// SQL 명령어 없음 -> XML에 분리 (수정시 컴파일 필요 없음) 
	
	
	 // 자바 코드 한줄로 디비 연동 처리 (SQL, parameter)   // parameter = VO : 사용자 입력값 받은 후 추출해서 SQL 물음표에 세팅하여 디비 보냄, 디비로부터 결과 받음 
	public void insertBoard(BoardVO vo) throws SQLException {
		ibatis.insert("insertBoard", vo);   
	}
	public void updateBoard(BoardVO vo) throws SQLException { 
		ibatis.update("updateBoard", vo);
	}
	public void deleteBoard(BoardVO vo) throws SQLException {
		ibatis.delete("deleteBoard", vo);
	}
	 
	// 스프링처럼 RowMappers 안만들어도 데이터 매핑 자동 (VO 객체의 변수와 rs 컬럼 매핑)
	public BoardVO getBoard(BoardVO vo) throws SQLException {      
		return (BoardVO) ibatis.queryForObject("getBoard", vo);   
	}
	public List<BoardVO> getBoardList(BoardVO vo) throws SQLException {
		return ibatis.queryForList("getBoardList");
	}
}
