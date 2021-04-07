package sec02;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet3
 */
@WebServlet("/login3")
public class LoginServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 클라이언트에서 서버로 전송되는 데이터 인코딩
		request.setCharacterEncoding("utf-8");
		
		// <input> 태그에 입력한 값을 받아와서 변수에 저장
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
	
		// 클라이언트에서 받아온 값을 콘솔에 출력
		System.out.println("아이디 : " + user_id);
		System.out.println("비밀번호 : " + user_pw);
	}

}
