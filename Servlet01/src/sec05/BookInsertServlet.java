package sec05;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BookInsertServlet
 */
@WebServlet("/bookInsert")
public class BookInsertServlet extends HttpServlet {
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
		
		int bookNo = request.getParameter("bookNo");
		String bookName = request.getParameter("bookName");
		String bookAuthor = request.getParameter("bookAuthor");
		int bookPrice = request.getParameter("bookPrice");
		Date bookDate = request.getParameter("bookDate");
		int bookStock = request.getParameter("bookStock");
		int pubNo = request.getParameter("pubNo");
		
		String command = request.getParameter("command");
		
		BookVO vo = new BookVO();
		vo.setBookNo(bookNo);
		vo.setBookName(bookName);
		vo.setBookAuthor(bookAuthor);
		vo.setBookPrice(bookPrice);
		vo.setBookDate(bookDate);
		vo.setBookStock(bookStock);
		vo.setPubNo(pubNo);
		
		BookDAO dao = BookDAO.getInstance();
		
		if(command != null && command.equals("del")) {
			dao.deleteBook(bookNo);
		} else {
			dao.insertBook(vo);
		
		}
	}
}
