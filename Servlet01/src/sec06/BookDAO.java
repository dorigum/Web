package sec06;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


public class BookDAO {
	private Connection con = null;
	DataSource dataSource = null;
	
	// 싱글톤
	private static BookDAO instance = new BookDAO();
	
	// 생성자에서 커넥션 풀 이용 DB 연결
	private BookDAO() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/oracle");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static BookDAO getInstance() {
		return instance;
	}
	
	
	
	// select
	public List selectBook() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List list = new ArrayList();
		
		
		
		try {
			con = dataSource.getConnection();
			String sql = "select * from book";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String bookNo = rs.getString("bookNo");
				String bookName = rs.getString("bookName");
				String bookAuthor = rs.getString("bookAuthor");
				int bookPrice = rs.getInt("bookPrice");
				Date bookDate = rs.getDate("bookDate");
				int bookStock = rs.getInt("bookStock");
				String pubNo = rs.getString("pubNo");
			
			
				BookVO vo = new BookVO();
				vo.setBookNo(bookNo);
				vo.setBookName(bookName);
				vo.setBookAuthor(bookAuthor);
				vo.setBookPrice(bookPrice);
				vo.setBookDate(bookDate);
				vo.setBookStock(bookStock);
				vo.setPubNo(pubNo);
				
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
		
		return list;
}
	
	
	
	// insert
	public void insertBook(BookVO vo) {
		PreparedStatement pstmt = null;
		
		try {
			con = dataSource.getConnection();
			
			String sql = "insert into book values(?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, vo.getBookNo());
			pstmt.setString(2, vo.getBookName());
			pstmt.setString(3, vo.getBookAuthor());
			pstmt.setInt(4, vo.getBookPrice());
			
			pstmt.setDate(5, new java.sql.Date(vo.getBookDate().getTime()));
			
			pstmt.setInt(6, vo.getBookStock());
			pstmt.setString(7, vo.getPubNo());
			
			int result = pstmt.executeUpdate();
			if(result > 0) {
				System.out.println("도서 정보 등록 성공!");
			}
			
		} catch (Exception e) {
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
		}	catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		}
	}
	
	
	
	// delete
	public void deleteBook(String bookNo) {
		PreparedStatement pstmt = null;
		
		try {
			con = dataSource.getConnection();
			
			String sql = "delete from book where bookNo =?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bookNo);
			
			int result = pstmt.executeUpdate();
			if(result > 0) {
				System.out.println("도서 정보 삭제 성공");
			}
			
		} catch (Exception e) {
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
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
