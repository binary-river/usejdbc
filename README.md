<h1 align="center">JDBC 사용 기초 템플릿 👋</h1>

<p>
  <a href="/" target="_blank">
    <img alt="Static Badge" src="https://img.shields.io/badge/License-ASLv2-yellow" />
  </a>
</p>


> JdbcTemplate을 이용해 Database에 접속하고, 쿼리를 실행해봅니다! <br>
> 먼저 In-Memory H2 Database를 사용하기 위해, SpringBoot Dependency에 JDBC 와 H2 Database를 추가해줘요!
> 
> JdbcTemplate 에 @Autowired 어노테이션을 사용해 커넥션을 가져와요!
> 프로그램 실행 시 자동으로 실행되는 메서드를 만들기 위해 CommandLineRunner의 Run 메서드를 구현해요! <br>
> Run 메서드에 JdbcTemplate을 이용해 쿼리를 실행해봅니다! <br>
> 이 템플릿은 Java 21, Gradle 기준으로 작성됐어요!
> 

<br>


![image](https://github.com/binary-river/usejdbc/assets/66468384/114375ee-bddb-41ac-814f-e9c5f9f5df88)
<br>
실행 시 위와 같이 나오면 정상적으로 연결된거예요!
