package com.ssamz.biz.util;

import java.io.Reader;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;


// 스프링이 제공함(스프링과 iBATIS 연동), 이해를 위해 만들어봄 
public class SqlMapClientFactoryBean {
	
	
	private static SqlMapClient sqlMapClient = null;  
	
	
	static {   // static 블럭은 가장 먼저 무조건 실행 
		Reader reader = null;
		try {
			if (sqlMapClient == null) {  // 컨테이너가 획득되지 않았다면 
				reader = Resources.getResourceAsReader("sql-map-config(ibatis).xml");  // xml의 문자 데이터 읽는 입력 스트림 만들어짐 
				sqlMapClient = SqlMapClientBuilder.buildSqlMapClient(reader);   // xml 문자 읽어서 컨테이너 만들어짐 
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	
	public static SqlMapClient getSqlMapClientInstance() {   // static 이므로 클래스 이름으로 호출 가능 
		return sqlMapClient;   // = iBAITS 컨테이너 
	}
}

