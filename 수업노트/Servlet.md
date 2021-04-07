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