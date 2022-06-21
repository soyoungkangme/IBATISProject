# iBATIS

- apache가 만든 오픈소스 프레임워크  
- DAO 클래스의 SQL을 XML 파일에 분리  
- 디비 연동 한줄로 처리 (Data Mapper  =  디비에서 받은 select의 검색결과(result set)을 VO객체의 각 변수에 저장)

<br>

<board-mapping(ibatis).xml>  
1. DAO 의 sql 분리  
- parameterClass : 디비에 sql 날릴때 세팅할 객체  
- resultClass : 디비에서 받은 결과 담을 객체 

<br>

<BoardDAO.java>  
2. iBATIS 컨테이너 획득 (SqlMapClient)  

3. SqlMapClientFactoryBean(공장)로부터 iBATIS 컨테이너 획득  
- 우리가 안만들지만 이해를 위해 만들어봄  
- sql-map-config.xml 로딩  
- board-mapping(ibatis).xml  : iBATIS 컨테이너가 로딩하는 XML에 등록된 XML  
 =>  태그 하나 당 Mapped Statement 라는 객체가 메모리에 하나씩 뜸 -> id로 식별  

4. 디비 소통 한줄로 처리 (ibatis.insert/update/delete/queryForObject/queryForList)
