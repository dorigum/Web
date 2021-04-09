package sec10;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionTestServlet
 */
@WebServlet("/session")
public class SessionTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		// getSession() : 최초 요청 시 세션 객체를 새로 생성하거나
		// 기존 세션을 반환
		HttpSession session = request.getSession();
		
		// getId() : 생성된 세션 객체의 id 반환
		out.println("세션 아이디 : " + session.getId() + "<br>");
		// getCreationTime() : 최초 세션 객체 생성 시간 반환
		out.println("최초 세션 생성 시간 : " + new Date(session.getCreationTime()) + "<br>");
		// getLastAccessedTime() : 세션 객체에 최근에 접근한 시간 반환
		out.println("최근 세션 생성 시간 : " + new Date(session.getLastAccessedTime()) + "<br>");
		// getMaxInactiveInterval() : 세션 객체의 유효 시간 반환
		out.println("세션 유효 시간 : " + session.getMaxInactiveInterval() + "<br>");
		
		// 새로 생성된 세션인지 확인
		if(session.isNew()) {
			out.println("새 세션이 만들어졌습니다.");
		}
	}

}
