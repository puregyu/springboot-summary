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
 
 