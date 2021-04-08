package sec02;

import java.io.IOException;
import java.io.PrintWriter;

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
		doProcess(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// (1) request 처리
		// 전송된 데이터의 한글 인코딩
		request.setCharacterEncoding("utf-8");
		
		// 폼에 입력한 값 받아오기
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String hp1 = request.getParameter("hp1");
		String hp2 = request.getParameter("hp2");
		String hp3 = request.getParameter("hp3");
		String year = request.getParameter("year"); // 라디오 버튼 : year 이름으로 4개 값 중 1개가 전달
		String[] interest = request.getParameterValues("interest"); // 체크박스 : 동일한 이름 interest로 4개 전달(배열로 받음)
		String department = request.getParameter("department"); // select : select 태그의 이름으로 여러 option 중 1개 값 받아옴
		
		// 데이터 전처리
		// 전화번호 : hp1 hp2 hp3 -> 010-1234-1234
		String hp = hp1 + "-" + hp2 + "-" + hp3;
		// 체크박스를 받은 배열 처리 : 배열에서 각 원소의 값 추출해서 하나의 문자열로 연결
		String interest_list = "";
		
		for(String elm : interest) {
			interest_list += elm + " ";
		}
		
		// (2) response 처리
		// 출력 한글 인코딩
		response.setContentType("text/html; charset=utf-8");
		
		// 클라이언트 페이지에 출력하기 위해 I/O 사용
		PrintWriter out = response.getWriter();
		
		out.println("<html><head></head><body>");
		out.println("<h3>회원 가입 내용</h3>");
		out.println("성명 : " + name + "<br>");
		out.println("ID : " + id + "<br>");
		out.println("비밀번호 : " + pwd + "<br>");
		out.println("휴대폰 번호 : " + hp + "<br>");
		out.println("학년 : " + year + "<br>");
		out.println("관심분야 : " + interest_list + "<br>");
		out.println("학과 : " + department + "<br>");
		out.println("</body></html>");
		
	}

}
