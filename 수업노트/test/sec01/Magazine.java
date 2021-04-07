package test.sec01;

public class Magazine {
	String isbn;
	String title;
	String author;
	String publisher;
	int year;
	int month;
	int price;
	String desc;
	
	public void setMagazine(String isbn, String title, String author, String publisher, int price,  int year, int month, String desc) {
		
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.year = year;
		this.month = month;
		this.price = price;
		this.desc = desc;
	}

	@Override
	public String toString() {
		return isbn + "|" + title + "|"+ author + "|" + publisher +
				"|" + price + "|" + year + "." + month + "|" + desc;
	}
	
	
}
