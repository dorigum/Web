package sec09;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetCookieValueServlet
 */
@WebServlet("/get")
public class GetCookieValueServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		// getCookies() 사용해서 쿠키 정보 요청 후, 쿠키 정보를 배열로 가져옴
		Cookie[] allValues = request.getCookies();
		for(int i=0; i<allValues.length; i++) {
			// 저장할 때 사용한 쿠키 이름인 cookieTest로 검색해서 쿠키 값을 가져오기
			if(allValues[i].getName().equals("cookieTest")) {
				out.println("<h2>Cookie값 가져오기 : " + URLDecoder.decode(allValues[i].getValue(), "utf-8"));
				
			}
		}
	}
}
