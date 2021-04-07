package test.sec01;

// (1) Book, Magazine 클래스 생성
// 데이터 출력
// toString() 사용해서 출력

public class BookTest {

	public static void main(String[] args) {
		Book bk1 = new Book();
		Book bk2 = new Book();

		bk1.setBook("21424", "Java Pro", "김하나", "Jean.kr", 15000, "기본문법");
		bk2.setBook("35355", "OOAD 분석, 설계", "소나무", "Jean.kr", 30000, "");
	
		
		Magazine mg = new Magazine();
		
		mg.setMagazine("35355", "Java World", "편집부", "androidjava.com", 7000, 2021, 3, "");
		
		System.out.println("***************************도서 목록***************************");
		System.out.println(bk1);
		System.out.println(bk2);
		System.out.println(mg);
	}

}
