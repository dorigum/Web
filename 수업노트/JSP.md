# JSP (Java Server Page)

> Java 기반으로 HTML 문서 내에 자바코드를 삽입해서 웹 서버에서 동적으로 웹 페이지를 생성해서 클라이언트(웹 브라우저)에게 반환해주는 서버 사이트 스크립트 언어

* JSP를 통해 HTML과 동적으로 생성된 컨텐츠를 혼합해서 사용 가능
* Servlet을 보완한 스크립트 방식 표준
* Servlet 기능 + 추가 기능
* JSP는 실행되면서 Servlet(`.java`) 으로 변환되어 컴파일 되서 `.class` 파일로 만들어져 실행
* View를 담당하는 페이지로 사용



### JSP와 서블릿 차이점

* `JSP` : `HTML` 내부에 `Java` 소스코드가 들어 있는 형식 : 사용하기 편리
* `Servlet` : `Java` 코드 내에 `HTML` 코드가 있어서 읽고 쓰기 불편



### JSP 페이지 구조

* 정적 페이지 + 동적 페이지 = `JSP`
* 동적 페이지 구현
  * `<%@ %>`
  * `<% %>`
  * `<%! %>`
  * `<%= %>`



### JSP 인코딩 설정

* `'<%'로 시작하고 '%>' 로 종료`
* `@, !, -, --` 문자를 추가하여 태그의 의미 부여

```
구분			태그 표기법					설명

지시어			<%@	%>			JSP 페이지의 속성 지정
선언부			<%@	%>			변수 선언 및 메소드 정의
표현식			<%=	%>			계산식, 함수 호출 결과, 변수 값 등 출력
스크립트 릿		<%	%>		   자바 코드 기술 (자유롭게 기술)
주석			<%--   --%>		 JSP 페이지 주석
액션 태그		<jsp:액션>	  자바 빈, include / forward / param 등
		      </jsp:액션>
```



### JSP 페이지 기본 구성 요소

* JSP 페이지 내용 : HTML 문서 내용 (태그/내용) / JSP 태그 / 자바 코드



### JSP 페이지 구성

* 지시어 : `page`, `include`, `taglib`
* 스크립트 요소 : 선언문 / 표현식 / 스크립트 릿
* 액션 태그



### 지시어

* JSP 페이지의 전체적인 속성을 지정할 때 사용
* JSP 컨테이너에게 전달하는 JSP 페이지 관련 메시지
* `<%@ 지시어 속성1=값, 속성2=값, ..., %>`
* `page`, `include`, `taglib`
* JSP 페이지에 대한 속성 설정

```jsp
language="java"
contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"
```



### include 지시어

* `<%@ include file = "포함될 파일의 url" %>`
* 공통적으로 포함될 내용을 가진 파일을 해당 JSP 페이지 내에 삽입하는 기능을 제공



* 변수는 선언부 또는 스크립트 릿 영역에서 자유롭게 선언 가능
* 메소드는 선언부에서만 선언이 가능



### JSP 내장 객체

* 클라이언트에서 웹 서버에 JSP 페이지 요청하면 자동으로 생성
* 객체를 별도로 생성하는 과정없이 바로 사용 가능



### 내장 객체 종류

* 입출력 객체 : `request / response / out`
* 서블릿 : `page/ config`
* 컨텍스트: `session / application / pageContext`
* 예외 처리 : `exception`
* 



### request 객체

* 사용자의 요청을 받을 때 사용하는 객체
* `getParameter()` : 1개의 값을 받을 때
* `getParameterValues()` : 동일한 이름으로 여러 개의 값으로 받을 때 (배열로 받음)
* `getParameterNames()` : name 속성 모를 때 사용



### response 객체

* 서버로부터 사용자에게 응답할 때 사용하는 객체
* JSP 처리 결과를 웹 브라우저에 전송
* `addCookie()` : 쿠키 설정
* `setContentType()` : 페이지의 contentType (text / html)
* `sendRedirect()` : 페이지 이동 (페이지 포워딩)



### out 객체

* 웹 서버에서 웹 브라우저에게 출력 스트림으로 응답할 때 사용
* `out.println("출력 문자열");`



### 전송되는 데이터 타입

* 클라이언트에 폼을 통해 전송되는 데이터는 문자열
* 숫자 연산을 할 경우 숫자형을 형변환 필요



### JSP 제어문

* if 문
* for 문
* while 문



for문 연습문제

* forForm.jsp : 구구단 입력 : 7
* forResult.jsp 에서 입력받은 단 출력
  * 테이블 한 행씩 출력 `<td>` 한개
  * 7단
    7 * 1 = 7 ...
    7 * 2 = 14 ...



-------

### 액션 태그

* JSP 페이지 내에서 어떤 동작을 지시하는 태그
* 어떤 동작(액션)이 일어나는 시점에서 페이지와 페이지 사이에서 제어 이동 기능을 제공하거나
* 다른 페이지의 실행 결과를 현재 페이지에 포함하는 기능 제공



#### 액션 태그의 종류

* `include`
* `forward`
* `useBean`
* `setProperty`
* `getProperty`
* `plug-in`



#### `include` 액션 태그 : `<jsp:include>`

* 다른 페이지의 실행 결과를 현재 페이지에 포함시킬 때 사용



#### `forward` 액션 태그 : `<jsp:forward>`

* 현재 페이지에서 다른 특정 페이지로 전환
* 웹 페이지 간의 제어를 이동할 때 사용



#### `param` 액션 태그 : `<jsp:param>`

* 이동하는 페이지에 파라미터 값을 전달할 때 사용



#### `useBean` 액션 태그 : `<jsp:useBean>`

* 자바빈을 JSP 페이지에서 사용할 때



#### `setProperty` 액션 태그 : <`jsp:setProperty>

* 프로퍼티 값을 설정할 때 사용



#### `getProperty` 액션 태그 : `<jsp:getProperty>`

* 프로퍼티 값을 얻어낼 때 사용



#### `include` 액션 태그 : `<jsp:include>`

* 다른 페이지의 실행 결과를 현재 페이지에 포함시킬 때 사용
* 페이지를 모듈화 할 때 사용



#### `include` 지시어와 차이점

```
구분				<jsp:include> 액션 태그						include 지시어
형식				<jsp:include page=""/>					   <%@ include file=""%>
처리 시점			실행 시									자바 소스로 변환 시
기능				 별도의 파일로 처리									현재 파일에 삽입(합쳐서 하나의 java 파일 생성)
				  제어권이 이동했다가 다시 돌아옴
데이터 구성		   동적 데이터로 구성							정적 데이터로 구성
용도				 화면 레이아웃 모듈화 할 때
				(top / bottom 페이지 포함시킬 때)			   여러 페이지에서 사용하는 변수를 지정하고 포함시킬 때
```



#### 처리 시점 확인

* `include` 지시어

include1.jsp		←		include2.jsp

​		↓

include1.java

​		↓

include1.class



=> include2.jsp 가 변경되면

include1.jsp 다시 컴파일 (낭비)

따라서 자주 변경되지 않는 정적 데이터로 구성



* <`jsp:include>` 액션 태그

include1.jsp				include2.jsp

​		↓								↓

include1.java				include2.java

​		↓										↓

include1.class		→		include2.class



=> include2.jsp 변경되면

include2.jsp만 다시 컴파일

따라서 변경되어도 영향 없는 동적 데이터로 구성



-------

#### `<jsp:param>`

* forward 및 include 액션 태그에서 데이터를 전달하기 위해 사용
* name과 value로 구성
* <jsp:param name = "id" value = "abce" />
* param 액션 태그로 전달된 값을 받을 때
* `request.getParameter("id")`



---

### 자바 빈 (JavaBeans)

* DTO / VO와 같은 개념
* 데이터를 다루기 위해서 자바로 작성되는 소프트웨어 컴포넌트로 재사용 가능
* 입력 폼의 데이터와 데이터베이스의 데이터 처리 부분에서 활용
* 클래스로 만들어짐
  * 멤버 필드로 속성(Property)이 있고
  * 멤버 메소드로 `Getters / Setters` 메소드 포함
  * `setXXXX()` : 프로퍼티에 값 저장
  * `getXXXX()` : 프로퍼티 값 반환
* 액션 태그를 이용해서 빈 사용
* 속성 접근 제어자 : `private`
* `Getters / Setters` : `public`



#### 자바 빈 관련 액션 태그

* `useBean` 액션 태그 : `<jsp:useBean`>
  * 자바 빈을 JSP 페이지에서 사용할 때 사용
  * `<jsp:useBean id="자바빈 이름" class="패키지명을 포함한 클래스명" scope=""/>`
* `setProperty` 액션 태그 : `<jsp:setProperty>`
  * 프로퍼티의 값을 설정할 때 사용 (데이터 설정)
* `getProperty` 액션 태그 : `<jsp:getProperty>`
  * 프로퍼티의 값을 얻어낼 때 사용



* `scope` : 자바 빈의 유효 범위
  * `page / request / session / application`



-------

## 표현 언어 : EL (Expression Language)

### JSP 발전 과정

* 초기 : HTML 태그를 중심으로 자바를 이용해 화면 구현
* 화면 요구사항이 복잡해지면서 자바코드를 대체하는 액션 태그 등장
* 복잡한 자바 코드를 제거하는 방향으로 발전
  * 복잡한 자바 코드로 인해 화면 작업 어려움
* 현재 JSP 페이지 스크립트 요소보다 EL이나 JSTL을 사용 화면 구현

### EL (Expression Language)

* 표현 언어
* 자바 코드가 들어가는 표현식을 좀 더 편리하게 사용하기 위해서 JSP2.0부터 도입된 데이터 출력 가능
* 표현식 또는 액션 태그 대신 값을 표현
* `<%= 값%>` ---> `${값}`
* attribute 또는 parameter 등을 JSP 파일에서 출력할 용도로 사용
* `attribute` : `${attribute 이름}`
* `parameter` : `${param.이름}` 또는 `${paramValue[인덱스]}`



### EL 연산자

* 산술 연산자 : `+, -, *, /, %, (div, mod)`
* 관계 연산자 : `>, >=, ...`
  * `(gt, ge, lt, le, eq, ne)`
* 논리 연산자 : `&&, ||, !, (and, or, not)`
* 조건 연산자 : `수식 ? 참일 때 값 : 거짓일 때 값`
* empty 연산자
  * 값이 null이거나 길이가 0이면 true
  * `${empty 변수}` : 변수가 null이거나 0이면 true



* `${3.14 }` : `<%= 3.14%>` 와 동일



### EL 내장 객체

* scope : pageScope / requestScope / sesstionScope / applicationScope
* 요청 파라미터 : param / paramValues
* 쿠키 값 참조 : Cookies
* JSP 내용 : pageContext : (페이지 정보를 나타내는 컨텍스트 페이지 참조)
* 초기 파라미터 : iniParam (web.xml에 context 초기화 파라미터 참조)



### param 객체

* `${param.id }`



### pageContext 내장 객체

* 컨텍스트 이름 (프로젝트 명) 가져올 때 사용
* `http://localhost:8080/JSP01/패키지 파일`
* `<a href = "http://localhost:8080/JSP01/login.jsp"> 로그인 </a>`
* `<a href = "/JSP01/login.jsp"> 로그인 </a>`
* `<a href = "<%=request.getContextPath()%"> 로그인 </a>`
* `<a href = "<pageContext.request.contextPath>/sec01/login.jsp"> 로그인 </a>`



### EL을 이용해서 바인딩 속성 출력

* request, session, application 내장 객체에 속성을 바인딩한 후
* 다른 서블릿이나 JSP 전달 가능
* 자바 코드 사용하지 않고 바인딩된 속성 이름으로 값 출력 가능



### 스코프(scope) 우선 순위

* pageScope : 현재 페이지 영역의 변수
* requestScope : 이전 페이지에서 전달된 영역의 변수
* sessionScope : 세션 영역의 변수
* applicationScope : 애플리케이션 영역의 변수



* 각 내장 객체에서 바인딩하는 속성 이름이 같은 경우
* 각 내장 객체에 지정된 출력 우선순위에 따라 순서대로 속성에 접근
* (높음) page < request < session < application (낮음)



-----

## JSTL(JSP Standard Tag Library)

* JSP 표준 태그 라이브러리
* JSP와 HTML을 같이 사용함으로써 가독성이 떨어지는 것을 보완하고자 만들어진 태그 라이브러리
* JSP 페이지에서 자바 코드를 사용하지 않고 태그 사용
* JSP 페이지의 로직을 담당하는 부분인 제어문 및 데이터베이스 처리 등을 표준 라이브러리 태그로 제공
* 사용하기 위해서는 라이브러리 별도로 설치 (다운로드해서 저장)
* `<%@ taglib uri = "" prefix="">`



https://tomcat.apache.org/

* Download / Taglibs : 4개 jar 파일 다운로드
* C:\apache-tomcat-9.0.44\lib에 저장
* 이클립스 닫았다가 새로 열기



----------------------

### JSTL 라이브러리 : 5개의 라이브러리로 구성

* core : c : 변수, 제어문, url 등 처리
* format : fmt : 숫자/날짜/시간 지정, 국제어, 다국어 처리
* database : sql : 데이터베이스 작업 처리
* xml : x : XML 문서 처리
* function : fn : 함수 기능



#### Core(코더)

* URI : http://java.sun.com/jsp/jstl/core
* Prefix : c
* 제공 기능
  * 변수의 선언 및 삭제 등 변수와 관련된 작업
  * if, for 문 등 제어문 처리
  * url 처리 및 기타 예외처리, 화면 출력 기능



### Core 태그 리스트

* **변수 지원**
  * `<c:set>` : 변수 설정
  * ``<c:remove>` : 설정된 변수 제거
* **흐름 제어**
  * `<c:if>` : 조건문
  * `<c:choose>` : 선택 (자바의 switch문)
  * 서브 태그로 : `<when>` / `<otherwise>`
  * `<c:forEach>` : 반복문
  * `<c:forTokens>` : 구분자로 분리된 각 토큰을 처리할 때 사용
* **URL 처리** : `${pageContext.request.contextPath }` 를 기본으로 설정
  * `<c:import>` : url을 이용해서 다른 자원 추가
  * `<c:redirect>` : `request.sendRedirect()` 기능 수행
  * `<c:url>` : 요청 매개변수로부터 URL 생성
* **기타 태그**
  * `<c:out>` : JspWriter에 내용을 처리한 후 출력
  * `<c:catch>` : 예외 처리



#### `<c:if>` : 조건문

* `<c:if test="${조건식}" var = "변수명" [scope]/>`



#### `<c:choose>` : 선택 (자바의 switch문)

* 서브 태그로 : `<when>` / `<otherwise>`
* 서브 태그로 : `<when>` / `<otherwise>`

```
<c:choose>
	<c:when test="조건식1">본문 내용1</c:when>
	<c:when test="조건식2">본문 내용2</c:when>
	<c:otherwise>본문 내용</c:otherwise>
</c:choose>
```



#### `<c:forEach>` : 반복문

```jsp
<c:forEach var = "변수명" items = "반복할 객체명" begin = "시작값" end = "마지막값" step = "증가값">
</c:forEach>
```



-----

### 포매팅 태그 라이브러리

* 숫자 및 날짜 관련된 포매팅 태그 라이브러리
* fmt
  * `<fmt:formatNumber>`
  * `<fmt:formatDate>`



### 문자열 처리 함수

* JSTL에서 제공하는 함수를 이용해서 JSP에서 사용 가능
* `fn` : `toLower()`, ....



-----

### 회원 정보 출력

* member_menu.jsp (회원 정보 조회) : `${contextPath }/memberList"`
* memberController (서블릿) : `doHandle()`
  * DAO의 listMembers() 호출해서 ArrayList로 받음
  * request.setAttribute() 바인딩
  * 포워딩 (memberList.jsp로)
* MemberVO / MemberDAO
* memberList.jsp (뷰) : EL / JSTL 사용해서 출력



연습문제

* Book : 도서 정보 조회
* book_menu.jsp (도서 정보 조회) : `${contextPath }/memberList"`
* bookController (서블릿) : `doHandle()`
  * DAO의 selectBook() 호출해서 ArrayList로 받음
  * request.setAttribute() 바인딩
  * 포워딩 (bookList.jsp로)
* BookVO / BookDAO
* bookList.jsp (뷰) : EL / JSTL 사용해서 출력



------------

## MVC 패턴

### 애플리케이션 개발

* 화면 : 프론트엔드 디자이너 담당
* 비즈니스 로직 : 백엔드 프로그래머 담당
* 처음부터 새로 개발하는 것이 아니라, 기존의 웹 애플리케이션 개발 방법에 따라 개발
* 많이 사용하는 표준화 소스 구조를 만들어 개발 진행



### 웹 애플리케이션 모델

* 표준화 소스 구조
* 모델1 방식
* 모델2 방식



### 모델1 방식

* 모든 클라이언트 요청과 비즈니스 로직을 JSP가 담당
* 클라이언트 요청 -> JSP(화면/로직 처리) -> DAO -> 데이터베이스
  							<-
* 기능 구현이 쉽고 편리
* 웹 사이트 화면 기능이 복잡해지고 화면 기능과 비즈니스 로직 기능이 섞이면서 유지보수에 문제 발생
* 코드 재사용도 떨어짐



### 모델2 방식 (MVC 패턴)

* 모델1 방식의 단점 보안
* 웹 애플리케이션의 각 기능을 분리해서 구현
  * 클라이언트 요청 처리 담당
  * 응답 담당
  * 비즈니스 로직 담당
* 각 기능이 분리되어 모듈화되어 있으므로 모듈별 개발이 가능
* 모듈을 비슷한 프로그램 개발에 사용할 수 있어서 재사용성이 높아짐
* 응용프로그램 확장성 및 이식성이 좋아짐
* 개발 후 서비스 제공 시 유지보수 편리
* 현재 모든 웹 프로그램은 모델2 방식으로 개발



### MVC 패턴

* M : `model` (DTO / DAO)
* V : `View` (JSP페이지)
* C : `Controller` (서블릿)



#### V : View (JSP페이지)

* 애플리케이션에서 "window" 역할 (사용자와의 인터페이스 담당 : 클라이언트로부터 요청받는 페이지 / 결과를 응답하는 페이지)
* HTML 문서 내용 포함 (HTML 문서 만듦)
* Model로부터 데이터 가져오고
* Model로부터 변경된 자료를 가져올 수 있다.



#### C : Controller (서블릿)

* Model에 있는 데이터 갱신
* `HTTP request`로부터 들어온 데이터 검수



### 서블릿 실행 구조

1. **url-pattern**
   * 디렉터리 패턴
     * 디렉터리 행태로 서버에 해당 서블릿을 찾아서 실행하는 구조
     * `http://localhost:8080/JSP01/selectMember`
   * 확장자 패턴
     * 확장자 형태로 서버의 해당 서블릿을 찾아서 실행하는 구조
     * `http://localhost:8080/JSP01/selectMember.do`
     * `http://localhost:8080/JSP01/insertMember.do`
     * `*.do` 서블릿 (`*.do`로 매핑되어 있는 서블릿으로 이동)



2. **Front Controller 패턴**

   * 모든 클라이언트 요청을 한 곳에서 처리하도록 하나의 대표 컨트롤러 사용
   * 별도의 클래스를 추가하지 않고 Front Controller가 다 처리
   * Front Controller 내용이 길고 복잡해짐
   * 클라이언트 요청을 한 곳으로 집중시켜서 효율적으로 개발 및 유지보수 가능

   selectMember.do    ->         Front Controller (하나의 서블릿이 모든 `*do` 처리)       -> DAO       -> DB

   insertMember.do    ->

   deleteMember.do   ->



3. Command 패턴
   * Front Controller (서블릿)가 모든 클라이언트 요청을 직접 처리하지 않고
   * 담당 클래스가 처리
   * Front Controller가 수행하던 작업을 각 클래스로 분산 처리
   * 각 클래스는 통일된 형식(규격)으로 처리하도록 interface로 구현