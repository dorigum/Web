package sec02;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NewMemberServlet
 */
@WebServlet("/newMember")
public class NewMemberServlet extends HttpServlet {
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
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String hp1 = request.getParameter("hp1");
		String hp2 = request.getParameter("hp2");
		String hp3 = request.getParameter("hp3");
		String year = request.getParameter("year");
		String department = request.getParameter("department");
		
	
		// 클라이언트에서 받아온 값을 콘솔에 출력
		System.out.println("성명 : " + name);
		System.out.println("ID : " + id);
		System.out.println("비밀번호 : " + pwd);
		System.out.println("휴대폰 번호 : " + hp1 + "-" + hp2 + "-" + hp3);
		System.out.println("학년 : " + year);
		System.out.println("학과 : " + department);
		
		
		// 체크박스
		String[] interest = request.getParameterValues("interest");
		
		for(String inte : interest) {
			System.out.print("관심분야 : " + inte); }

		
	}

}
