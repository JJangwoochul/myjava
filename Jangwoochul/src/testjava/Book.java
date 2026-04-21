package testjava;

public class Book {
    private int id;         //도서 식별 번호
    private String title;   //도서 제목
    private String author;  //저자명

    public Book(int id,String title,String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }
    public int getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setAuthor(String author) {
        this.author = author;
    }

    //저장 시 사용할 CSV 포맷 문자열 반환 메서드
    String toFileString() {
    //출력방식
        return id + " , " + title + " , " + author;
    }
}
