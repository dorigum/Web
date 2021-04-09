package sec07;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstServlet05
 */
@WebServlet("/first05")
public class FirstServlet05 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	
	// dispatch 방법 : 클라이언트를 거치지 않고 서블릿에서 바로 다른 서블릿에게 요청하는 방법
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		
		RequestDispatcher dispatch = request.getRequestDispatcher("second05?name=lee");
		dispatch.forward(request, response);
	}

}
