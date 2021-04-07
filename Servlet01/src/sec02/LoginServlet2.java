package sec02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet2
 */
@WebServlet("/login2")
public class LoginServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 클라이언트로부터 요청을 받고
		// 인코딩
		// 클라이언트에서 서버로 전송되는 데이터 인코딩
		request.setCharacterEncoding("utf-8");
		
		// ID와 비밀번호 값 받아옴
		// <input> 태그에 입력한 값을 받아와서 변수에 저장
		String id = request.getParameter("user_id");
		String pw = request.getParameter("user_pw");
		
		// 클라이언트로 요청 처리 결과를 응답
		// 클라이언트로 전송되는 데이터 유형 지정
		// 서버 -> 클라이언트 : Response 객체 사용
		response.setContentType("text/html; charset=utf-8");
		
		// 프린터 객체 생성
		PrintWriter out = response.getWriter();
		
		// 클라이언트로 보낼 문자열 생성 (HTML 태그 포함시킴)
		/* String data = "<html>";
		data += "<body>";
		data += "아이디 : " + id;
		data += "<br>";
		data += "비밀번호 : " + pw;
		data += "</body>";
		data += "</html>"; */
		
		// 프린터 객체로 출력 (클라이언트로 전송)
		//out.print(data);
		
		// 출력 방법2
		out.println("<html><head></head><body>");
		out.println("아이디 : " + id + "<br>");
		out.println("비밀번호 : " + pw + "<br>");
		out.println("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
