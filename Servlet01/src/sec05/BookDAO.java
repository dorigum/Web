package sec05;

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


public class BookDAO {
	private Connection con = null;
	DataSource dataSource = null;
	
	private static BookDAO instance = new BookDAO();
	
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
	public List listBooks() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List list = new ArrayList();
		
		
		
		try {
			con = dataSource.getConnection();
			String sql = "select * from book";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int bookNo = rs.getInt("bookNo");
				String bookName = rs.getString("bookName");
				String bookAuthor = rs.getString("bookAuthor");
				int bookPrice = rs.getInt("bookPrice");
				Date bookDate = rs.getDate("bookDate");
				int bookStock = rs.getInt("bookStock");
				int pubNo = rs.getInt("pubNo");
			
			
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
				
				pstmt.close();
				con.close();
				
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
			
			String sql = "insert into Book(bookNo, bookName, bookAuthor, bookPrice, bookDate, bookStock, pubNo) values(?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, vo.getBookNo());
			pstmt.setString(2, vo.getBookName());
			pstmt.setString(3, vo.getBookAuthor());
			pstmt.setInt(4, vo.getBookPrice());
			pstmt.setDate(5, vo.getBookDate());
			pstmt.setInt(6, vo.getBookStock());
			pstmt.setInt(7, vo.getPubNo());
			
			int result = pstmt.executeUpdate();
			if(result > 0) {
				System.out.println("도서 정보 등록 성공!");
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
		}	catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		}
	}
	
	
	
	// delete
	public void deleteBook(int bookNo) {
		PreparedStatement pstmt = null;
		
		try {
			con = dataSource.getConnection();
			
			String sql = "delete from book where id =?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bookNo);
			
			int result = pstmt.executeUpdate();
			if(result > 0) {
				System.out.println("도서 정보 삭제 성공");
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
