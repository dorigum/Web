package sec02;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InputServlet2
 */
@WebServlet("/input2")
public class InputServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 클라이언트에서 서버로 전송되는 데이터 인코딩
		request.setCharacterEncoding("utf-8");
		
		// name 값을 모를 때 사용
		Enumeration enu = request.getParameterNames();
		
		// 요소가 들어 있으면 계속 반복
		while(enu.hasMoreElements()) {
			// 요소 하나씩 확인해서 name 추출
			String name = (String) enu.nextElement();
			// 알아낸 name으로 value 받아옴
			String[] values = request.getParameterValues(name);
			
			// 배열에 각 원소 출력
			for(String value : values) {
				System.out.println("name : " + name + ", value : " + value);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
