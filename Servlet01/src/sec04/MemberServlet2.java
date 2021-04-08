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

import sec03.MemberDAO;
import sec03.MemberVO;

/**
 * Servlet implementation class MemberServlet2
 */
@WebServlet("/member2")
public class MemberServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
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
		// MemberDAO의 listMembers() 메소드 호출해서
		// 반환된 데이터를 클라이언트에게 전송 : List 반환
		// 테이블로 출력
		
		//MemberDAO dao = new MemberDAO();
		// 싱글톤으로 할 경우
		MemberDAO dao = MemberDAO.getInstance();
		
		
		List list = dao.listMembers();
		
		// 전송된 데이터의 한글 인코딩
		response.setContentType("text/html; charset=utf-8");
		
		// List로 반환된 데이터를 클라이언트에게 출력
		// 출력 : PrintWriter 사용
		// 테이블 형태로 1행씩 출력 : for문 사용해서 1행씩 추출
		PrintWriter out = response.getWriter();
		
		out.println("<html><head></head><body>");
		out.println("<table border='1'>");
		out.println("<tr align='center' bgcolor='lightgreen'>");
		out.println("<td>아이디</td><td>비밀번호</td><td>이름</td>"
					+ "<td>이메일</td><td>가입일</td><td>삭제</td></tr>");
		
		// 한 행씩 데이터 출력
		for(int i=0; i<list.size(); i++) {
			MemberVO vo = (MemberVO) list.get(i);
			String id = vo.getId();
			String pwd = vo.getPwd();
			String name = vo.getName();
			String email = vo.getEmail();
			Date joinDate = vo.getJoinDate();
			
			// 클라이언트에게 출력
			out.println("<tr><td>" + id + "</td><td>" +
									pwd + "</td><td>" +
									name + "</td><td>" +
									email + "</td><td>" +
									joinDate + "</td><td>" +
									"<a href='/Servlet01/member3?command=del&id=" + id +
									"'>삭제</a></td></tr>");

		} // for문 종료
				
		out.println("</table></body></html>");
		
	}

}
