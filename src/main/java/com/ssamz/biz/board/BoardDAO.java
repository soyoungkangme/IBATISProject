package com.ssamz.biz.board;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.ssamz.biz.util.SqlMapClientFactoryBean;

public class BoardDAO {
	
	private SqlMapClient ibatis;   // SqlMapClient =iBAITS 컨테이너 
	
	public BoardDAO() {
		ibatis = SqlMapClientFactoryBean.getSqlMapClientInstance();   // SqlMapClient를 SqlMapClientFactoryBean(공장)로부터 획득 
	}
	
	// SQL 명령어 없음 -> XML에 분리 
	
	public void insertBoard(BoardVO vo) throws SQLException {
		ibatis.insert("insertBoard", vo);   // 자바 코드 한줄로 디비 연동 처리 
	}
	
	public void updateBoard(BoardVO vo) throws SQLException {
		ibatis.update("updateBoard", vo);
	}
	
	public void deleteBoard(BoardVO vo) throws SQLException {
		ibatis.delete("deleteBoard", vo);
	}
	
	public BoardVO getBoard(BoardVO vo) throws SQLException {     // 스프링처럼 RowMappers 안만들어도됨 
		return (BoardVO) ibatis.queryForObject("getBoard", vo);   
	}
	
	public List<BoardVO> getBoardList(BoardVO vo) throws SQLException {
		return ibatis.queryForList("getBoardList");
	}
}
