##spring boot 정리

----

>####의존성 관리
 - parent에서 버전을 관리하고 있는 library의 경우, <dependencies> 버전 명시를 해 줄 필요가 없음.
 - 의존성을 대신 관리해주므로 버전 호환이 좋다. (parent를 F3으로 따라 들어가면 기본 설정을 확인 할 수 있음)
 - *spring-boot-starter-parent : properties, resource, plug-in 설정
 - *spring-boot-dependencies : dependency & 버전 관리
 - parent에서 관리하는 library의 버전을 변경할 경우, <properties> 태그 안에서 override 할 수 있다
 
>####자동 설정 이해
 - 스프링부트의 핵심이 되는 @SpringBootApplication Annotation은 
    **@ComponentScan**, **@EnableAutoConfiguration**, **@Configuration** 3가지로 어노테이션으로 대체 가능하다.
 - @SpringBootApplication은 Bean을 두 번 등록한다. ComponentScan으로 처음 등록하고 EnableAutoConfiguration로 다시 찾아 등록한다.
    (만약 ComponentScan으로 먼저 Bean을 등록했는데 EnableAutoConfiguration으로 같은 객체를 발견했다면 override 된다.)
 
>######@ComponentScan 
 - 어노테이션이 달려있는 class의 패키지부터 그 하위 패키지를 모두 뒤져 @Component 어노테이션이 달린 class를 찾고 Bean으로 등록해주는 역할.
 - @Configuration, @Repository, @Service, @Controller, @RestController 모두 다 @Component를 상속 받은것이기 때문에 
@ComponentScan 의 검색 대상이 된다.

>######@EnableAutoConfiguration
 - spring-boot의 default 자동설정 모음.
 - org.springframework.boot.autoconfigure.EnableAutoConfigu -> spring.factories 파일 -> EnableAutoConfiguration 
 - 해당하는 모든 class는 @Configuration이 붙어있다. (그렇다고 모두 Bean 등록이 되는 것은 아니다. 해당 클래스의 @ConditionalOn.. 옵션에 따라 등록하느냐 마느냐 또 결정해야 하므로.. 복잡.. 조건에 따라 다르당..)
 
>####내장 서버 이해
 - spring boot를 동작시키면 tomcat에 의해 웹 서버가 바로 동작하지만 spring boot가 서버인 것은 아니다.
 - spring boot 어플리케이션이 실행되면 내장된 tomcat이 동작하고 servlet이 추가가 되는 것이다.
    (내장 서버 tomcat도 자동 설정의 일부, 내장 servlet container가 생성)
 - ServletWebServerFactoryConfiguration : sevlet 웹서버를 자동설정하는 부분 (tomcat 생성 & 관리)
 - tomcat 외에도 undertow, jetty 등 설정으로 dependency 추가 가능
 
>####SpringApplication
 - banner
 - ApplicationListener<ApplicationStartingEvent>
    * 애플리케이션 컨텍스트가 만들어지기 전에 발생
    * SpringApplication 통해 강제로 리스너를 생성
 - ApplicationListener<ApplicationStartedEvent>
    * 애플리케이션 컨텍스트가 만들어지고 난 뒤 발생
 - ApplicationArguments 
    * program args 를 인식함(jvm 아규먼트 무시)
    * ApplicationRunner를 implements하면 손쉽게 구현 가능
 
>####외부설정
 - application.properties 파일
 - src/main/resources 안에 기본적으로 생성되어 있음.
 - 스프링부트가 애플리케이션을 구동할 때, 자동으로 로딩하는 설정파일.
 - key : value 형태로 정의해서 사용 가능.
 - 설정파일간 우선순위가 존재함.

|우선순위|	properties|
|1|	유저 홈 디렉토리에 있는 spring-boot-dev-tools.properties| 
|2|	테스트에 있는 @TestPropertySource|
|3|	@SpringBootTest 애노테이션의 properties 애트리뷰트| 
|4|	커맨드 라인 아규먼트| 
|5|	SPRING_APPLICATION_JSON (환경 변수 또는 시스템 프로티) 에 들어있는 프로퍼티| 
|6|	ServletConfig 파라미터| 
|7|	ServletContext 파라미터| 
|8|	java:comp/env JNDI 애트리뷰트| 
|9|	System.getProperties() 자바 시스템 프로퍼티|
|10	|OS 환경 변수|
|11	|RandomValuePropertySource|
|12	|JAR 밖에 있는 특정 프로파일용 application properties = file:./config| 
|13	|JAR 안에 있는 특정 프로파일용 application properties = file:./| 
|14	|JAR 밖에 있는 application properties =  classpath:/config/|
|15	|JAR 안에 있는 application properties(기본세팅) = classpath:/| 
|16	|@PropertySource|
|17	|기본 프로퍼티 (SpringApplication.setDefaultProperties)|

 
 - properties 설정을 묶어서 하나의 Bean으로 만들어 사용할 수 있음.
 - properties 값을 class로 바인딩해서 사용하면 타입-세이프.
 - 자바 빈 스펙을 따라서 바인딩 해주기 때문에 getter, setter 를 사용해야함.
 - 바인딩 class는 @Component를 통해 Bean 등록
 - 바인딩 class는 @ConfigurationProperties 를 사용하고 설정의 prefix 값을 넣어준다.
 - 바인딩된 class를 @Autowired를 통해 D.I 하고 꺼내서 설정을 꺼내 사용하면 된다.

  
  
