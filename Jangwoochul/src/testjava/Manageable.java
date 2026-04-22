package testjava;

public interface Manageable {
    //구현 기능 4개
    void addItem(Book book);    // 데이터 추가
    void displayAll();          // 전체 목록 출력
    void saveToFile();          // 파일로 데이터 저장
    void loadFromFile();        // 파일에서 데이터 로드
}
