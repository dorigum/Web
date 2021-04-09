package sec08;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginUrlSecondServlet
 */
@WebServlet("/secondUrl")
public class LoginUrlSecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doHandle(request, response);
	}
	
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		String user_address = request.getParameter("user_address");
		
		out.println("<html><head></head><body>");
		if(user_id != null && user_id.length() != 0) {
			out.println("이미 로그인 상태입니다.<br><br>");
			out.println("첫번째 서블릿에서 넘겨준 아이디 : " + user_id + "<br>");
			out.println("첫번째 서블릿에서 넘겨준 비밀번호 : " + user_pw + "<br>");
			out.println("첫번째 서블릿에서 넘겨준 주소 : " + user_address + "<br>");
			
		} else {
			out.println("로그인 하지 않았습니다.<br><br>");
			out.println("다시 로그인하세요.<br><br>");
			out.println("<a href='/Servlet01/login_url.html'>로그인 폼으로 이동하기</a>");
		}

	}

}
