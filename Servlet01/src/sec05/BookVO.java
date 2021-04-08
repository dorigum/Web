package sec05;

import java.util.Date;

public class BookVO {
	private int bookNo;
	private String bookName;
	private String bookAuthor;
	private int bookPrice;
	private Date bookDate;
	private int bookStock;
	private int pubNo;
	
	public BookVO() { }

	public BookVO(int bookNo, String bookName, String bookAuthor, int bookPrice, Date bookDate, int bookStock,
			int pubNo) {
		this.bookNo = bookNo;
		this.bookName = bookName;
		this.bookAuthor = bookAuthor;
		this.bookPrice = bookPrice;
		this.bookDate = bookDate;
		this.bookStock = bookStock;
		this.pubNo = pubNo;
	}

	public int getBookNo() {
		return bookNo;
	}

	public void setBookNo(int bookNo) {
		this.bookNo = bookNo;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public int getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(int bookPrice) {
		this.bookPrice = bookPrice;
	}

	public Date getBookDate() {
		return bookDate;
	}

	public void setBookDate(Date bookDate) {
		this.bookDate = bookDate;
	}

	public int getBookStock() {
		return bookStock;
	}

	public void setBookStock(int bookStock) {
		this.bookStock = bookStock;
	}

	public int getPubNo() {
		return pubNo;
	}

	public void setPubNo(int pubNo) {
		this.pubNo = pubNo;
	}
	
}
