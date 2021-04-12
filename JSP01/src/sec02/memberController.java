package sec02;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class memberController
 */
@WebServlet("/memberList")
public class memberController extends HttpServlet {
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
		// DAO의 listMembers() 호출해서 ArrayList로 받음
		MemberDAO dao = MemberDAO.getInstance();
		List memberList = dao.listMembers();
		
		// request.setAttribute() 바인딩
		request.setAttribute("memberList", memberList);
		
		// 포워딩 (memberList.jsp로)
		RequestDispatcher dispatch = request.getRequestDispatcher("sec04/memberList.jsp");
		dispatch.forward(request, response);
	}

}
