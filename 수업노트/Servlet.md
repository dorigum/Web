#  웹 개요

### 웹 서비스

> 인터넷을 기반으로 제공되는 서비스



## 웹 애플리케이션

> - 웹을 기반으로 작동되는 프로그램
> - 웹 프로그래밍을 통해 구현



## 웹 프로그래밍

* 정적인 페이지인 ``HTML``만으로 데이터가 실시간으로 변화하는 것을 처리하거나 저장할 수 없음
* 동적으로 변화하는 데이터를 처리하고 표시하기 위해서 개발된 언어들이 ``CGI, ASP, PHP, JSP, Servlet, ...``
* 웹 프로그래밍 기본적으로 클라이언트 / 서버 방식 (``Client / Server``)



### CGI (Common Gateway Interface)

* 공통 게이트웨이 인터페이스
* 웹 서버와 외부 프로그램 사이에서 정보를 주고 받는 방법 또는 규약



### CGI Scripts

* 웹 서버 상에서 동작하는 프로그램 통칭
* 웹 서버에 의해 제공되는 어떠한 프로그래밍 또는 스크립팅 언어로도 작성될 수 있음 (``C / C++ / JAVA`` 등)



### CGI Scripts 장점

* 서버에 있는 프로그램 코드 수행 가능
* 웹 서버에 의해 제공되는 어떠한 프로그래밍 또는 스크립팅 언어로도 작성될 수 있음



### CGI Scripts 단점

* 클라이언트 요청이 있을 때 마다  웹 서버가 프로세스 생성
* 동시 사용자가 많을 때 각 요청에 따른 작업량이 많아지고, 서버에 부하가 걸림
* 이런 문제점을 해결하기 위해서 ``Java`` 기반으로 만들어진 ``CGI``가 ``Servlet`` (요청 시 마다 스레드 생성)



### 웹 서비스 구성 요소

* 웹 브라우저 : 클라이언트, 사용자의 작업 창
* 웹 서버 : 웹 브라우저의 요청을 받아들이고 결과를 반환 (응답)
* 웹 애플리케이션 서버(WAS) : 요청된 페이지의 로직 및 데이터베이스와의 연동을 처리하는 부분
* Apache Tomcat
* 데이터베이스 : 데이터의 저장소



### 웹 서비스 처리 순서

* 요청 처리 과정
  * ``웹 클라이언트 (웹 브라우저) - > 웹 서버 -> 웹 애플리케이션(WAS : Tomcat) -> 데이터베이스``
* 응답 처리 과정
  * ``웹 클라이언트 (웹 브라우저) <- 웹 서버 <- 웹 애플리케이션(WAS : Tomcat) <- 데이터베이스``



### 웹 서버

* 웹에서 서버 기능을 수행하는 프로그램 (소프트웨어 (하드웨어))
* ``HTTP`` 프로토콜 기반
* 웹 클라이언트(웹 브라우저)로 부터 요청을 받아서 서비스하는 기능 담당
* 정적인 컨텐츠(``HTML``, ``CSS``...) 직접 처리
* 동적인 컨텐츠는 웹 컨테이너에게 보내고, 웹 컨테이너가 처리한 결과를 클라이언트에게 응답



### 웹 서버 종류

* ``Apache``
* ``IIS(Internet Information Server)`` : MS



## 웹 컨테이너 (Web Container)

* 웹 애플리케이션을 실행할 수 있는 컨테이너
* JSP와 Servlet을 실행시킬 수 있는 소프트웨어
* 서블릿 컨테이너 이라고도 함
  * 웹 서버가 서블릿 자체를 실행하지 못하므로 JVM을 내장한 컨테이너라는 서블릿 실행 환경이 필요 
  * 클라이언트에서 서블릿 요청이 들어오면 서버에서 서블릿 컨테이너를 만들고 스레드 생성
* 서블릿과 JSP에 대한 실행 환경 제공
* static page에 대한 요청도 처리 가능
* 웹 서버에서 JSP 요청이 들어오면 톰캣(웹 서버 + 컨테이너)에서 JSP 파일을 서블릿으로 변환해서 컴파일 수행
* 서블릿 수행 결과를 웹 서버에게 전달하면 웹 서버가 클라이언트에게 전달 (응답)
* 서블릿의 생명주기 관리
* 웹 애플리케이션 당 한 개의 ServletContext 객체 생성



### ★웹 컨테이너가 사용자의 요청에 응답하는 순서

1. 클라이언트가 ``HTTP request``를 ``HTTP service``(웹 서버에서 서비스 제공)에게 전송
2. ``HTTP service``(웹 서버)는 요청 데이터를 웹 컨테이너에게 전송
3. 웹 컨테이너는 ``HttpServletRequest`` 객체와 ``HttpServletResponse`` 객체를 생성
4. 웹 컨테이너는 요청된 ``Servlet service()`` 메소드를 호출해서 ``Servlet`` 활성화 시킴
5. 웹 컨테이너는 ``Servlet``에 의해 생성된 응답 데이터를 HTTP service에게 전송
6. ``HTTP service``는 ``HTTP response``를 클라이언트에게 전송



## ★웹 애플리케이션 서버(WAS)

* ``Web Application Server`` : `WAS`
* 웹 서버로부터 오는 동적인 요청을 처리하는 서버
* 웹 서버 기능 + 웹 컨테이너 기능
* `Apache Tomcat` (WAS이고 컨테이너)
* 기타 기능 : 트랜잭션, 보안, 트래픽 관리, DB 커넥션 풀, 사용자 관리 등 다양한 기능 제공



### JSP와 Servlet

* `JSP(Java Server Page)` : `HTML` 내에 `Java` 언어를 삽입한 문서 (확장자 : `.jsp`)
  * `view` 페이지로 이동
* `Servlet` (`Server` + `Applet`) : `Java` 언어로 이루어진 웹 프로그래밍 문서. `Java`에 의존적 (확장자 : `.java`)
  * `Controller` 역할
* 클라이언트로부터 요청이 웹 컨테이너에서
  `JSP 파일`을 `Java 파일`로 변환해서 컴파일해서 `.class` 생성 -> 실행



-------------

## 서블릿

* 서버 쪽에서 실행되면서 클라이언트의 요청에 따라 동적으로 서비스를 제공하는 자바 클래스
* 자바의 일반적인 특징 모두 포함
* 독자적으로 실행되지 못하고 톰캣(`JSP / Servlet 컨테이너`)에서 실행



* 자바 플랫폼에서 컴포넌트 기반의 웹 애플리케이션을 개발하는 핵심 기술 (동적 웹 애플리케이션 컴포넌트)
* 클라이언트 요청에 동적으로 작동
* `멀티 스레드` 기반
  * 같은 `Servlet class` 에 대한 요청을 처리하는 모든 `thread`는 같은 `Servlet` 객체를 공유
    * 동시성 문제가 발생
    * 동시성 문제를 해결하기 위해서 `로컬 변수`를 사용
    * `로컬 변수`는 각 요청 스레드마다 각각의 `스택 영역`에 저장되기 때문에 동시성 문제를 발생시키지 않음
* `JSP` 페이지처럼 화면에 내용을 표시할 목적으로 사용하는 것이 아니라, MVC 패턴에서 로직인 모델(`DAO / DTO`)과 화면에 결과를 표시하는 `View` 사이에서 제어를 하는 컨트롤러로 사용됨
* `Java` 파일이기 때문에 `Java Resources / src` 위치에 저장



### 서블릿의 라이프 사이클 (생명주기)

1. `Servlet` 객체 생성 (처음 한 번)
2. 초기화 : `init()` 호출 (처음 한 번)
3. 요청 작업 처리 : `service()` 메소드가 호출되고
   - 이후 request에 따라 `doGet() / doPost() / doPut() / doHead() / doDelete() / doTrace() / doOptions()`
   - 요청 시 마다 매번 수행 (재호출되는 메소드)
4. 자원 해제 : `destroy()` 메소드 호출 (마지막 한 번)
   - `Servlet` 수정 / 서버 재가동 등...



### Servlet을 많이 사용하는 이유

> 빠른 응답 속도 때문

* 서블릿은 최초 요청 시 객체가 만들어져 메모리에 로드되고
* 이후 요청 시에는 기존의 객체를 재활용
* 따라서 동작 속도가 빠름



### 서블릿의 장점

* `신뢰성 (Reliability)`
* `확장성 (Scalability)` : 기능 확장 용이
* 플랫폼과 서버에 독립적 (자바 기반)
  * 한 번 개발된 애플리케이션은 다양한 서버 환경에서 실행 가능
* `Java`에서 제공되는 다른 기술을 같이 사용 가능
  * 예 : `Servlet` + `JDBC` 연동



### 서블릿 클래스

* 서블릿 패키지
  * `javax.servlet.*` : 서블릿 작성을 위한 인터페이스와 클래스 제공
  * `javax.servlet.http.*` : HTTP 프로토콜을 이용한 서블릿 작성에 필요한 인터페이스 제공 (`GET / POST`)



#### 서블릿 클래스

* `Servlet` 인터페이스
* `GenericServlet` 추상 클래스
* `HTTPServlet` 클래스
* 서블릿을 만들 때 HTTPServlet 클래스를 상속 받아서 만듦



--------

### 서블릿 매핑

* 서블릿 경로 연결

* 서블릿 파일 경로 노출로 인한 보안 문제 없애고

* url을 간단하게 줄일 수 있음

  * 예 : http://111.111.111.111:80 / shop / member.getMemberInfo

* 서블릿 매핑 : 매핑 이름 변경

  * 예 : http://111.111.111.111:80 / shop / get

* 웹 브라우저에서 서블릿을 요청하기 위해서는 서블릿 매핑 필요

  * http://ip:포트 / 프로젝트이름 / 패키지 이름이 포함된 클래스 이름

    

#### 서블릿 매핑 방법

1. XML 기반 : web.xml 파일에 설정 (web.xml 파일은 내용을 수정하면 톰캣 서버 중단했다가 다시 실행해야함)
   - `<servlet-name>` : 임의의 이름 설정
   - `<servlet-class>` : 매핑할 클래스 파일명 입력 (패키지명 포함)
   - `<url-pattern>` : url에 사용할 임의의 입력 (`/` 로 시작) 
2. 어노테이션 기반 (이클립스에서 자동 지정) : 변경 가능



첫번째 서블릿

* 클래스 생성 : HTTPServlet 클래스를 상속 받음
* http://localhost:8080/Servlet01/first



연습문제

(1) SecondServlet 클래스 생성

(2) HTTPServlet  클래스 상속

(3) 메소드 오버라이딩 : `init() / doGet() / doPost() / destroy()`

(4) web.xml에서 서블릿 매핑 설정

	* `<servlet></servlet>`
	* `<servlet-mapping></servlet-mapping>`
	* 톰캣 서버 중단시켰다가 다시 실행

(5) 웹 브라우저 를 통해 서비스 요청 (.java 파일에 오른쪽 마우스 클릭 : Run As / Run on Server)

(6) 결과는 콘솔창에 출력



* 실행시켜서 결과 출력



----

* FirstServlet과 SecondServlet에 메소드는
* `init() / doGet() / doPost() / destroy()`
* `doGet()` : 디폴트 (get방식)



* 디폴트 get 방식으로 수행이 되는데
  * http://localhost:8080/Servlet01/second
* 클래스에 doGet() 메소드가 없으면 오류 발생
* destroy() 메소드 호출 : 서블릿이 소멸



-------

### 서블릿 매핑 방식

2. **어노테이션 이용** : 이클립스에서 자동 지정 (변경 가능)

* 클래스가 아닌 서블릿으로 생성
* @WebServlet 이용
* 어노테이션이 적용되는 클래스는 반드시 HttpServlet 클래스를 상속 받아야함



### 요청 / 응답 객체

```
doGet(HttpServletRequest request, HttpServletResponse response)
```

(1) 요청 처리 객체 : `HttpServletRequest request`

* 클라이언트의 요청 정보를 전달 받는 객체

	* 클라이언트에서 입력한 데이터가 request 객체에 담겨져서 서버로 전송
	* 클라이언트 -> 서버

(2) 응답 처리 객체 : `HttpServletResponse response`

* 요청 처리 결과를 클라이언트에게 전달할 때 사용하는 객체
* 서버 측에서 처리한 결과를 response 객체에 담아서 클라이언트로 전달
* 서버 -> 클라이언트



------

### Context Path (프로젝트 이름)

* WAS(웹 애플리케이션 서버)에서 웹 애플리케이션을 구분하기 위한 path

* 1개의 웹 애플리케이션 : 프로젝트 1개

* 이클립스에서 프로젝트 생성하면 자동으로 `server.xml`에 추가

  ```
  <Context docBase="Servlet01" path="/Servlet01" ...>
  ```



### `URL / URI / ContextPath / ServletPath`

1. URL : 전체 주소
   * `http://localhost:8080/Servlet01/third`
2. URI : `ContextPath` + `ServletPath`
   * `/Servlet01/third`
3. `ContextPath` : 프로젝트 명
   - `/Servlet01`
4. `ServletPath` : 패키지명 + 파일명
   - `/third`



* URL : 프로토콜			IP				포트번호			프로젝트명			패키지명 + 파일명

  ​			 http		  localhost:			8080			 	Servlet01						third

  ​																				   ContextPath 			  ServletPath 



------------

### `<form>` 태그를 이용해서 서블릿에 요청

* 로그인 폼 : ID와 비밀번호 값이 서버로 전송

  ```java
  <input type = "text" name = "id">입력한 값
  // name 속성의 value(입력한 값)으로 서버에 전송
  ```



* `request` 객체 사용
* `request` 객체의 `getParameter()` 메소드를 사용해서 전달되는 값을 받아옴
* `request.getParameter("태그의 name 속성 값");`
* 서버로 전송되는 데이터 유형은 `String`
* `getParameter()` : 1개의 값을 받을 때 사용
* `getParameterValues()` : 동일한 name으로 여러 개의 값을 받아올 때 사용 (결과 : 배열)
* `String[] 변수 = request.getParameterValues()`



* `<form>` 태그에서 method 지정하지 않아도 `doGet()` 디폴트 : `get` 방식이 기본



### `<form>` 태그로 전송된 데이터를 받아오는 메소드

1. `getParameter()` : 1개의 값을 받아올 때
2. `getParameterValues()` : 여러 개의 값을 받아올 때
3. `Enumeration getParameterNames()` : name 값을 모를 때 사용



-------

### 서블릿의 응답 처리 방법

* 클라이언트로부터 온 요청 처리 메소드 : `doGet()` 또는 `doPost()` 메소드 안에서 처리
* `HttpServletResponse` 객체를 이용
* `setContentType()` 메소드를 이용해서 클라이언트에게 전송되는 데이터 유형 지정 (`MIME-TYPE`)
  * HTML로 전송할 때 지정하는 타입 : `text/html`
  * 일반 텍스트로 전송 시 : `text/plain`
  * XML 데이터로 전송 시 : `application/xml`
* 클라이언트(웹 브라우저) 와 서블릿의 통신은 자바 I/O 스트림 이용 
  * `printWriter` 의 `print()` 또는 `println()` 메소드 이용해서 데이터 출력
  * `HTML` 태그 문자열을 웹 브라우저로 출력



----------

### `Get` 방식과 `Post` 방식

#### `Get` 방식

* 서버로 데이터 전송 시 데이터가 URL 뒤에 `name = value` 형태로 전송
* 여러 개의 값을 전송할 때는 `&` 로 구분해서 전송
* 데이터 노출 : 보안에 취약
* 전송할 수 있는 데이터는 최대 255자
* `doGet()` 이용해서 데이터를 처리
* 간단하고, 처리 방식이 `POST` 방식보다 빠름



#### `post` 방식

* 데이터를 `TCP/IP 프로토콜` 데이터의 `HEAD` 영역에 숨겨져서 전송
* 노출이 안되므로 보안에 유리
* 전송되는 데이터 용량 무제한
*  `GET` 방식보다 느림
* `doPost()` 메소드 처리



### `Get` 방식과 `Post` 방식 둘 다 처리하는 방법

* 새로운 메소드를 만들고

* `doPost()` 와 `doGet()` 이 메소드를 호출하게 하는 방법 사용

  ```java
  doPost(){
  	doProcess();
  }
  
  doGet(){
  	doProcess();
  }
  
  doProcess() {
  실제 여기 처리
  }
  ```

  

---------

연습문제

* newMember.html
* 폼에 입력한 값을 서버로 전송하고
* 서버에서 받은 값을 클라이언트로 출력



-------------

자바스크립트로 서블릿에 요청하기 (p206)

* 태그에서 이벤트 핸들러 속성 사용
* 자바스크립트에서 태그의 name 속성
* frmLogin.user_id.value
* method : "post"
* aciton : "login5"
* submit() : 폼 전송



---------

### 서블릿의 DB 연동

* 비즈니스 로직 처리
* 웹 프로그램이 클라이언트의 요청에 대해 비즈니스 처리 기능을 이용해
* 데이터 저장소에 데이터를 조회한 후
* 서블릿의 응답 기능을 이용해서
* 클라이언트에게 전송



* `VO(DTO)` : 데이터 저장 클래스
* `DAO` : 비즈니스 로직 처리 (DB에 저장하고 DB에서 데이터를 조회)
* `서블릿` : 컨트롤러 역할
  * 클라이언트 요청을 받아서 DAO에게 전송하고, 
  * DAO가 처리한 결과를 받아서
  * 클라이언트에게 전송
* `클라이언트` : 결과 값을 받아서 웹 브라우저에게 출력



#### DTO (Data Transfer Object)

> 데이터 저장을 담당하는 클래스

* `Transfer` 기능 수행
  * `Controller, Service, View` 등 계층 간에서 데이터를 교환하기 위해 사용되는 객체
  * 비즈니스 로직을 갖지 않는 순수한 데이터객체
* `Getters / Setters` 메소드만 포함 (`생성자, toString()`)
* 데이터 변경 (가변의 성격) 가능 : `Setters`



#### VO (Value Object)

> 데이터 저장을 담당하는 클래스

* `Transfer` 기능 수행하지 않음
* 값을 사용하는데 사용되는 객체 (변하지 않은 값을 사용)
* 불변의 성격 : `read only` 의 속성
* `Setters` 만 포함하고 `Getters` 기능은 없음
* `DTO`와 혼용해서 사용 (일반적으로 같다고 사용)



-----

MemberDAO를 Singleton 패턴으로 변경

```java
// 싱글톤으로 할 경우
// (1) static 객체(인스턴스 생성)
private static MemberDAO instance = new MemberDAO();

// (2) 생성자는 private으로 막음(new 연산자로 객체 생성하지 못하도록)
private MemberDAO() { }

// (3) 외부에서 호출해서 사용할 수 있는 메소드를 생성해서, 생성된 1개의 객체 반환
public static MemberDAO getInstance() {
	return instance;
}
```


---------

### 지금까지 사용한 데이터베이스 연동 방법

> 웹 애플리케이션이 필요할 때마다 데이터베이스에 연결하여 작업하는 방식

* 이 경우 문제 : 데이터베이스 연결 시간이 많이 걸린다는 것
* 동시 접속자 수가 수천명이 넘으면 DB 연결 시간이 너무 오래 걸려서 비효율적
* 이 문제를 해결하기 위해 웹 애플리케이션이 실행됨과 동시에 데이터베이스 연결을 미리 설정해 놓고
* 필요할 때마다 미리 연결해 놓은 상태로 이용하면
* 데이터베이스 연동 작업 시간이 줄어들 수 있음
* 이렇게 미리 데이터베이스에 연결시켜서 연결 상태를 유지하는 기술을 `커넥션 풀`이라고 함



### 커넥션 풀 (DBCP : DataBase Connection Pool)

* 이렇게 미리 데이터베이스에 연결시켜서 연결 상태를 유지하는 기술
* 일정 량의 DB Connection 객체를 Pool 저장해두고
* 클라이언트 요청이 있을 때 마다 가져다 사용하고 반환하는 방법
* 클라이언트에서 다수의 요청이 발생될 경우, 요청마다 DB Connection 객체를 생성하게 되면, 데이터베이스에 부하가 발생하기 때문에 커넥션 풀 기법 사용

```
클라이언트1		-> Thread1		=> Pool		=> DB
클라이언트2		-> Thread2
클라이언트3		-> Thread3
클라이언트4		-> Thread4
```



### 커넥션 풀의 장점

* 풀 속에 미리 커넥션이 생성되어 있기 때문에 커넥션 생성하는데 시간이 걸리지 않음
* 커넥션을 계속해서 사용하고 반환하기 때문에 재사용 가능하므로,  많은 수의 커넥션을 만들지 않아도 됨
* 매번 커넥션을 생성하고 해제하는데 시간이 소요되지 않으므로 애플리케이션 실행 속도 빨라짐
* 생성되는 커넥션 수를 제어하기 때문에 동시 접속자 수가 증가해도 애플리케이션이 쉽게 다운되지 않음
* 접속 시 사용할 커넥션이 없으면 대기 상태로 전환되고, 커넥션이 반환되면 대기 순서대로 커넥션 제공



### 커넥션 풀 사용법

* `Server`의 `context.xml`에 `<Resource>` 정보 추가
* `Tomcat` 컨테이너가 데이터베이스 인증 작업 수행



### JNDI (Java Naming and Directory Inteerface)

* 디렉터리 서비스에서 제공하는 데이터 또는 객체를 `discover`하고 `lookup`하기 위한 `API`
* 실제 웹 애플리케이션에서 커넥션 풀 객체를 구현할 때 Java SE에서 제공하는 `java.sql.DataSource` 클래스 이용
* 웹 애플리케이션 실행 시 톰캣이 만들어놓은 `ConnectionPool` 객체에 접근할 때 `JNDI`를 이용
* `context.lookup("java:comp/env/jdbc/oracle");`

```xml
<Resource
    	name = "jdbc/oracle" // DataSource에 대한 JNDI 이름
    	auth = "Container"	// 인증 주체
    	type = "javax.sql.DataSource"	데이터베이스 종류 : DataSource
    	driverClassName = "oracle.jdbc.OracleDriver"
    	url = "jdbc:oracle:thin:@localhost:1521:xe"
    	username = "newuser"
    	password = "1234"
    	maxActive = "50"	// 동시에 최대로 데이터베이스에 연결할 수 있는 Connection 수
    	maxWait = "1000"	// 새로운 연결이 생길 때까지 기다릴 수 있는 최대 시간(1000:1초). 음수이면 무한 대기
    	
    />
```



-------------------

연습문제 : 커넥션 풀 이용해서 데이터베이스 insert 기능 수행

* 패키지 새로 생성
* MemberVO 복사해서 사용
* MemberDAO insertMember() 추가
* 서블릿: MemberServlet3 : /member3
* 입력 폼 생성 (html) : MemberVO에 맞춰서 입력 태그 작성



-----------

연습문제

* sec05
* 기존의 Book 테이블 사용
* 커넥션 풀 (`<Resource>` 에 등록된 user 접속으로 Book 테이블 복사해 놓았음)
* 도서 정보 등록 / 도서 정보 조회 / 도서 정보 삭제
* BookVO
* BookDAO : selectBook() / insertBook() / deleteBook()
* BookSelectServlet : /bookSelect
* BookInsertServlet : /bookInsert
  * dao.insertBook() / dao.deleteBook()



----------

### 서블릿 포워딩 방법

1. `redirect` 방법 : 웹 브라우저에 재요청하는 방식

   - `HttpServletResponse` 객체의 `sendRedirect()` 메소드 이용
   - 형식 `sendRedirect("포워드할 서블릿 또는 JSP")`

2. `Refresh` 방법 : 웹 브라우저에게 재요청하는 방식

   - `HttpServletResponse` 객체의 `addHeader()` 메소드 이용
   - 형식 : `addHeader("Refresh", "경과시간(초); url = 요청할 서블릿 또는 JSP")`

3. `location` 방법 : 자바스크립트에서 재요청하는 방식

   1. 자바스크립트의 `location` 객체의 `href` 속성 이용
   2. 형식 : `location.href = "요청할 서블릿 또는 JSP";`

4. `dispatch` 방법 : 일반적으로 포워딩 기능 지칭

   1. 서블릿이 직접 요청하는 방법

   2. `Requestdispatcher()` 클래스의 `forward()` 메소드 이용

   3. 형식

      ```
      Requestdispatcher dis = request.getRequestDispatcher("포워드할 서블릿 또는 JSP")
      dis.forward(request, response);
      ```



#### 차이점

* `redirect` , `Refresh`, `location` 방법
  * 서블릿이 웹 브라우저를 거쳐서 다른 서블릿이나 JSP에게 요청하는 방법
* `dispatch` 방법
  * 클라이언트를 거치지 않고 서블릿에서 바로 다른 서블릿에게 요청하는 방법



### 바인딩

* 포워딩할 때 `setAttribute("바인딩이름", 데이터)` 메소드를 사용해서
* 바인딩 이름과 데이터를 묶어서 설정한 후
* 포워딩된 문서에서 `getAttribute("바인딩이름")` 메소드를 사용해서
* 바인딩된 데이터를 추출해서 사용하는 방법



연습문제

* sec05
* BookForwardServlet : 도서 정보 리스트를 ViewBookServlet에게 포워딩
  * 조회해온 도서 정보를 바인딩 시킴
* ViewBookServlet에서 데이터 출력
  * 바인딩 데이터를 추출해서 출력



--------------------

## 쿠키와 세션

> 클라이언트와 서버 간에 정보를 교환하는데, 클라이언트 PC나 서버의 메모리에 저장해두고 사용하면 프로그램 속도를 향상시킬 수 있음



* HTTP 프로토콜 : 서버-클라이언트 통신 시 stateless 방식으로 통신
* 브라우저에서 새 웹 페이지를 열면 기존의 웹 페이지나 서블릿에 관한 어떤 연결 정보도 유지되지 않아서
* 새로 열린 웹 페이지에서 어떤 정보도 알 수 없음
* 페이지가 서로 독립적이어서 서로의 상태를 알 수 없음



* 웹 페이지 사이에 또는 서블릿 간에 상태나 정보를 공유하려면
* 웹 페이지 연결 시켜주는 기능이 필요 : 세션 트래킹



### 웹 페이지를 연결하기 위한 방법 (페이지 간에 정보를 교환하거나 공유하기 위한 방법)

1. **`<input type = 'hidden'>` 태그 사용**

* `HTML`의 `<hidden>` 태그를 사용해서
* 현재 페이지에 데이터를 숨겨놓고
* 연결된 다음, 페이지로 데이터를 보내는 방법
* 두 웹 페이지가 데이터를 공유
* 페이지1에서 `<input type = "hidden">` 로 데이터 숨겨 놓음
* `페이지2.requestParameter()` 받아서 사용할 수 있음



2. **`URL Rewriting`**

* GET 방식으로 전송할 때 데이터가 URL 뒤에 붙어서 다음 페이지로 전송
* 다음 페이지에서 `requestParameter()` 받아서 사용할 수 있음



3. **쿠키**

> 클라이언트 PC의 Cookie 파일에 정보를 저장한 후 웹 페이지 공유



4. **세션**

>  서버 메모리에 정보를 저장한 후 웹 페이지 공유



### `hidden` 과 `URL Rewriting` 방식

* `GET` 방식으로 전송하기 때문에 브라우저에 노출되어 보안상 문제
* 전송하는 데이터 용량에 제한이 있음



### 쿠키(Cookie) 

> 클라이언트 PC의 Cookie 파일에 정보를 저장한 후 웹 페이지 공유
>
> 서버 측에서 클라이언트 측에 상태 정보를 저장하고 추출하기 위한 메커니즘

* 서버에서 생성해서 클라이언트 측에 저장됨
* 서버에 요청할 때 마다 쿠키의 속성 값을 참조하거나 변경
* 크기는 4KB로 용량 제한
  * 256문자 이하의 text 데이터로만 저장됨
* 클라이언트에 저장되기 떄문에 보안상 문제 발생
* 따라서 민감한 정보는 쿠키 내에 저장하지 않음
* 쿠키는 사용자가 거부할 수 있음



### 쿠키 생성 및 저장 과정

* 서버에서 쿠키 생성
  * Cookie 클래스로부터 쿠키 객체 생성
  * `Cookie cookie = new Cookie(이름, 값);`
* 속성 설정
  * `setter` 로 쿠키 객체의 유효기한 설정
  * `cookie.setMaxAge(초단위_유효기간);`
* 클라이언트에 전송되어 클라이언트 PC에 저장
  * `response` 내장 객체의 `addCookie()` 메소드로 전송
  * `response.addCookie(쿠키객체);`



### 클라이언트 / 서버 간 쿠키 동작 방식

1. 클라이언트가 서버에게 페이지 요청
2. 서버에서 쿠키 생성 / HTTP 헤더에 쿠키를 포함시켜서 응답
   - 브라우저가 종료되어도 쿠키 만료 기간이 남아있다면 클라이언트에서 보관하고 있음
3. 다시 서버에 요청을 할 경우 HTTP 헤더에 쿠키를 함께 보냄
   - 서버에서 쿠키를 읽어서 이전 상태 정보를 변경할 필요가 있으면
   - 쿠키를 업데이트하여 변경된 쿠키를 HTTP 헤더에 포함시켜 응답
4. 이후 요청받은 페이지 응답



### 쿠키 관련 주요 메소드

* `setMaxAge()` : 쿠키 유효 기간 설정
* `setValue()` : 쿠키의 값 설정
* `setVersion()` : 쿠키 버전 설정
* `setPath()` : 쿠키 사용의 유효 디렉터리 설정



* `getMaxAge()` : 쿠키 유효 기간 설정 반환
* `getValue()` : 쿠키의 값 설정 반환
* `setVersion()` : 쿠키 버전 설정 반환
* `setPath()` : 쿠키 사용의 유효 디렉터리 설정 반환



### 쿠키 제거

* `cookie.setMaxAge(0)` 으로 설정
* `response.addCookie(cookie)` : 다시 클라이언트에 전송되어 변경된 값으로 저장



## 세션 (Session)

* 클라이언트와 웹 서버 간의 네트워크로 연결이 지속적으로 유지되고 있는 상태
* 쿠키와 마찬가지로 서버와의 관계를 유지하기 위한 수단
* 쿠키와 달리 클라이언트에 저장되는 것이 아니라, 서버 상에 객체로 존재
* 따라서 세션은 서버에서만 접근이 가능하여 보안이 좋음
* 서버에서 사용자의 정보를 유지 관리
* 사용자 인증 후 여러 페이지에 걸쳐 정보를 공유해서 사용할 수 있게 해줌
* 객체형을 포함한 어떠한 형태의 데이터 저장도 가능 (저장할 수 있는 데이터 제한이 없음)
* Session은 서버 측에서만 설정이 가능
* 세션은 브라우저당 한 개씩 생성



### 세션 생성 및 사용 과정

* 클라이언트가 서버에 페이지 요청
* `Session` 자동 생성
* `Session` 속성 설정
  * `Session` 내부 객체의 메소드 사용



### Session ID

* 클라이언트가 처음 접속하면 서버(컨테이너)로부터 유일한 ID를 부여받게 되는데
* 이름 세션ID라고 함
* 클라이언트가 재접속했을 때 클라이언트를 구분하기 위한 수단으로 사용



### 세션 관련 주요 메소드

* `setAttribute(이름, 값)` : 세션 이름과 값 설정
* `getAttribute(이름)` : 이름에 해당되는 값 반환
* `getId()` : 세션 ID 반환
* `invalidate()` : 실행 중인 세션 종료. 모든 데이터 삭제됨



### 세션 값 설정

* `session.setAttribute("SID", "abcd");`
* `session` : 내장 객체 (생성하지 않고 사용)



### 세션 값 알아오기

* `Object obj = session.getAttribute("SID");`
* `Object` 타입 반환 (사용 시 형 변환)



### 세션 속성 제거

* `session.removeAttribute("SID");`



### 세션 종료

* `session.invalidate()`
* 또는 웹 브라우저 종료
* 또는 설정된 유효 기간이 만료되면 종료



### 세션 무효화

* `invalidate()` 메소드를 사용해서 바로 무효시킬 수 있음
* `web.xml` 파일에 `session-timeout` 설정해서 시간을 정할 수 있음
* `setMaxInactiveInterval()` 메소드를 사용해서 시간 지정할 수 있음
* `setMaxInactiveInterval(-1)` 로 설정으로 session 객체 소멸을 방지할 수는 있지만
* 기본 세션은 마지막 요청으로부터 30분 경과 후에 자동 소멸됨
* 세션 유효 시간을 따로 설정하지 않으면 톰캣에서 설정한 기본 유효 시간 30분이 적용