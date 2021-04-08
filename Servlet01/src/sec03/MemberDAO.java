package sec03;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {
	// 싱글톤으로 할 경우
	// (1) static 객체(인스턴스 생성)
	private static MemberDAO instance = new MemberDAO();
	
	// (2) 생성자는 private으로 막음(new 연산자로 객체 생성하지 못하도록)
	private MemberDAO() { }
	
	// (3) 외부에서 호출해서 사용할 수 있는 메소드를 생성해서, 생성된 1개의 객체 반환
	public static MemberDAO getInstance() {
		return instance;
	}
	
	// DB 연결 메소드
	private Connection connDB(){
		Connection con = null;
		
		// driver, url, user, pwd 문자열 지정
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "newUser";
		String pwd = "1234";
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, pwd);
			System.out.println("DB 연결 성공");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return con; // Connection 객체 반환
	}
	
	// select 처리할 메소드
	public List listMembers() {
		// Connection 객체 받아올 변수
		// 쿼리 수행할 변수 : PreparedStatement
		// 결과 받아올 변수 : ResultSet
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		// 여러 행의 데이터 저장할 변수
		// List 인터페이스 / ArrayList 클래스
		List list = new ArrayList();
		
		
		try {
			con = connDB(); // DB 연결 객체 받아옴 : DB 연결
			
			// 쿼리문 작성
			String sql = "select * from member";
			// 쿼리문 수행할 pstmt
			pstmt = con.prepareStatement(sql);
			// 쿼리 실행
			rs = pstmt.executeQuery();
			
			// ResultSet의 next() 사용해서 한 행씩 데이터 가져오기
			while(rs.next()) {
				String id = rs.getString("id");
				String pwd = rs.getString("pwd");
				String name = rs.getString("name");
				String email = rs.getString("email");
				Date joinDate = rs.getDate("joinDate");
				
				// (1) 변수값을 VO에 Set (1행이 VO 1개에 해당)
				MemberVO vo = new MemberVO();
				vo.setId(id);
				vo.setPwd(pwd);
				vo.setName(name);
				vo.setEmail(email);
				vo.setJoinDate(joinDate);
				
				// (2) list에 추가 : (여러 행인 경우 VO 여러 개 추가)
				list.add(vo);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) {
					rs.close();
					rs = null;
				}
				
				pstmt.close();
				con.close();
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return list;
		
	}
}
