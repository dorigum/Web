package sec02;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAO {
	private Connection con = null;
	DataSource dataSource = null;
	
	// 싱글톤으로 할 경우
	// (1) static 객체(인스턴스 생성)
	private static MemberDAO instance = new MemberDAO();

	// (2) 생성자는 private으로 막음(new 연산자로 객체 생성하지 못하도록)
	private MemberDAO() { 
	// 커넥션 풀 사용해서 데이터베이스 연결
		try {
		Context context = new InitialContext();
		dataSource = (DataSource) context.lookup("java:comp/env/jdbc/oracle");
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// (3) 외부에서 호출해서 사용할 수 있는 메소드를 생성해서, 생성된 1개의 객체 반환
	public static MemberDAO getInstance() {
		return instance;
	}
	
	//select 처리할 메소드
	public List listMembers() {
		// Connection 객체 받아올 변수
		// 쿼리 수행할 변수 : PreparedStatement
		// 결과 받아올 변수 : ResultSet
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		// 여러 행의 데이터 저장할 변수
		// List 인터페이스 / ArrayList 클래스
		List list = new ArrayList();
		
		
		try {
			//con = connDB(); // DB 연결 객체 받아옴 : DB 연결 
			//커넥션 풀 기법 사용
			con = dataSource.getConnection();
			
			// 쿼리문 작성
			String sql = "select * from member";
			// 쿼리문 수행할 pstmt 
			pstmt = con.prepareStatement(sql);
			// 쿼리 실행
			rs = pstmt.executeQuery();
			
			//ResultSet의 next() 사용해서 한 행씩 데이터 가져오기
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
				
				//(2) list에 추가 : (여러 행인 경우 VO 여러 개 추가)
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
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return list;
	}
	
	public void insertMember(MemberVO vo) {
		PreparedStatement pstmt = null;
		
		try {
			con = dataSource.getConnection();
			
			String sql = "insert into member(id, pwd, name, email) values(?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPwd());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getEmail());
			
			int result = pstmt.executeUpdate();
			if(result > 0) {
				System.out.println("회원 가입 성공");
			}
			
		} catch (SQLException e) {
			System.out.println("오류 발생");
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) {
					pstmt.close();
					pstmt = null;
				}
				if(con != null) {
					con.close();
					con = null;
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void deleteMember(String id) {
		PreparedStatement pstmt = null;
		
		try {
			con = dataSource.getConnection();
			
			String sql = "delete from member where id =?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			
			int result = pstmt.executeUpdate();
			if(result > 0) {
				System.out.println("회원 정보 삭제 성공");
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) {
					pstmt.close();
					pstmt = null;
				}
				if(con != null) {
					con.close();
					con = null;
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}