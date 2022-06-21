package com.ssamz.biz.util;

import java.io.IOException;
import java.io.Reader;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class SqlMapClientFactoryBean {
	
	private static SqlMapClient sqlMapClient = null;
	
	static {   // static 블럭은 가장 먼저 무조건 실행 
		
		Reader reader = null;   // 문자 입력 스트림 
		
		try {
			if (sqlMapClient == null) {
				reader = Resources.getResourceAsReader("sql-map-config(ibatis).xml");  // xml 로부터 문자 읽어들이는 입력 스트림 만들어짐 
				sqlMapClient = SqlMapClientBuilder.buildSqlMapClient(reader);   // xml 문자 읽어서 컨테이너 만들어짐 
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {   // 클로즈 
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static SqlMapClient getSqlMapClientInstance() {   // static 이므로 클래스 이름으로 호출 가능 
		return sqlMapClient;
	}
}

// 서블릿 컨테이너 : web.xml 로딩 
// 스프링 컨테이너 : business-layer.xml, presentation-layer.xml 로딩 
// ibatis 컨테이너 : sql-map-config.xml 로딩 
