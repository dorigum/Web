package test.sec01;

public class Book {
	String isbn;
	String title;
	String author;
	String publisher;
	int price;
	String desc;

	// 생성자 사용하지 않음
	// 필드에 값을 설정할 수 있는 메소드 필요
	public void setBook(String isbn, String title, String author, String publisher, int price, String desc) {
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.price = price;
		this.desc = desc;
	}

	// toString() 오버라이딩
	@Override
	public String toString() {
		return isbn + "|" + title + "|" + author + "|" + publisher + "|" + price + "|" + desc;
	}

}