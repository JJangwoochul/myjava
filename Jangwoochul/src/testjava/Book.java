package testjava;


//20260422
public class Book {
    // 필드는 private선언 후 , getter/setter 로 접근
    private int id;         //책번호
    private String title;   //책제목
    private String author;  //책저자

    // 생성자
    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    // 필드 private -> getter/setter로 접근
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    // 저장 시 사용할 CSV 포맷 문자열 반환 메서드
    public String toFileString() {
        return id + "," + title + "," + author;
    }
}
