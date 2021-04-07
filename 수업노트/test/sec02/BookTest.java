package test.sec02;

import com.scsa.java.sixth.Book;
import com.scsa.java.sixth.Magazine;

// (2) Book, Magazine 클래스 생성
// 생성자 사용
// Encapsulation 적용 : 데이터 은닉(보호)
// 필드와 메소드를 함께 묶음 / 필드를 private으로 선언하고 / 접근은 멤버인 Getter와 Setter만 접근 허용
// 외부에서는 필드 직접 접근 불가

public class BookTest {

	public static void main(String[] args) {
		Book bk1 = new Book("21424", "Java Basic", "김하나", "Jaen.kr", 15000, "Java 기본 문법");
		Book bk2 = new Book("33455", "JDBC Pro", "김철수", "Jaen.kr", 23000, "");
		Book bk3= new Book("55355", "Servlet/JSP", "박자바", "Jaen.kr", 41000, "Model2 기반");
		Book bk4 = new Book("35332", "Android App", "홍길동", "Jaen.kr", 25000, "Lightweight Framework");
		Book bk5 = new Book("35355", "OOAD 분석, 설계", "소나무", "Jaen.kr", 30000, "");

		
		Magazine mg1 = new Magazine("35535", "Java world", "편집부", "Jaen.kr", 7000, " ", "2013", "2");
		Magazine mg2 = new Magazine("33434", "Moblie World", "편집부", "Jaen.kr", 8000, " ", "2013", "8");
		Magazine mg3 = new Magazine("75342", "Next web", "편집부", "Jaen.kr", 10000, "AJAX 소개", "2012", "10");
		Magazine mg4 = new Magazine("76543", "Arichitecture", "편집부", "Jaen.kr", 5000, "java 시스템", "2013", "2");
		Magazine mg5 = new Magazine("76534", "Data Modeling", "편집부", "Jaen.kr", 14000, " ", "2012", "12");
		
		System.out.println("***************************도서 목록***************************");
		System.out.println(bk1);
		System.out.println(bk2);
		System.out.println(bk3);
		System.out.println(bk4);
		System.out.println(bk5);
		
		System.out.println("***************************잡지 목록***************************");
		System.out.println(mg1);
		System.out.println(mg2);
		System.out.println(mg3);
		System.out.println(mg4);
		System.out.println(mg5);
		
	}

}
