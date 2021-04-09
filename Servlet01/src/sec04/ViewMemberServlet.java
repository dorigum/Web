package sec04;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ViewMemberServlet
 */
@WebServlet("/viewMembers")
public class ViewMemberServlet extends HttpServlet {
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
		
		// 바인딩된 데이터 가져오기
		List memberList = (List) request.getAttribute("memberList");
		
		out.println("<html><head></head><body>");
		out.println("<table border='1'>");
		out.println("<tr align='center' bgcolor='lightgreen'>");
		out.println("<td>아이디</td><td>비밀번호</td><td>이름</td>"
					+ "<td>이메일</td><td>가입일</td></tr>");
	
	for(int i=0; i<memberList.size(); i++) {
		MemberVO vo = (MemberVO) memberList.get(i);
		String id = vo.getId();
		String pwd = vo.getPwd();
		String name = vo.getName();
		String email = vo.getEmail();
		Date joinDate = vo.getJoinDate();
		
		out.println("<tr><td>" + id + "</td><td>" +
				pwd + "</td><td>" +
				name + "</td><td>" +
				email + "</td><td>" +
				joinDate + "</td></tr>");
	}
	
	out.println("</table></body></html>");
	
	}
}