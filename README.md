# iBATIS

- apache가 만든 오픈소스 프레임워크  
- DAO 클래스의 SQL을 XML 파일에 분리  
- 디비 연동 한줄로 처리 (Data Mapper  =  디비에서 받은 select의 검색결과(result set)을 VO객체의 각 변수에 저장)

<br>

<board-mapping(ibatis).xml>  
1. DAO 의 sql 분리 (SQL과 parameter 객체, result 객체 매핑)  
- parameterClass : 디비에 sql 날릴때 세팅할 객체  
- resultClass : 디비에서 받은 결과 담을 객체 
- resultMap : 매핑 하기 전 반환 받을 객체 선언  
=> resultClass는 선언 안해도 자동으로 매핑해주지만 컬럼 이름과 변수의 이름이 동일하지 않은 경우 필요함  
(SQL에서 as 로 컬럼값 변경 가능, 언더바 안되고 대소문자는 상관없음)  
- <![CDATA[]]>  :  SQL에 작다, 크다 연산자 있을때 여기에 넣어야함 (문법)  

<br>

<BoardDAO.java>  
2. iBATIS 컨테이너 획득 (SqlMapClient)  

3. SqlMapClientFactoryBean(공장)로부터 iBATIS 컨테이너 획득  
- 우리가 안만들지만 이해를 위해 만들어봄  
- sql-map-config.xml 로딩  
- board-mapping(ibatis).xml  : iBATIS 컨테이너가 로딩하는 XML에 등록된 XML  
 =>  태그 하나 당 Mapped Statement 라는 객체가 메모리에 하나씩 뜸 -> id로 식별  

4. 디비 소통 한줄로 처리 (ibatis.insert/update/delete/queryForObject/queryForList

## iBATIS, Spring 연동 (SpringProject 소스 수정)  
<business-layer.java>  
- iBATIS 컨테이너를 위한 공장(스프링이 제공) 빈등록  
- XML, dataSource 세터 인젝션  
- 컨테이너 공장 세터인젝션으로 sqlMapClient 템플릿 클래스 빈등록  
<BoardDAOIBATIS.java>  
- sqlMapClient 템플릿 타입 인젝션  
- 의존성 주입한 템플릿의 메서드로 디비연동 한줄로 처리 ( insert/update/delete/queryForObject/queryForList() )  
<board-mapping(ibatis).xml>  
- 조건 검색 기능 추가  (다이나믹 SQL : id가 getBoardList인 하나의 SQL을 동적으로 변형시켜 검색 처리)  
isEqual : property가 compareValue와 같으면 and title/content like
