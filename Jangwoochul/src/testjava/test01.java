package testjava;

public class test01 {
    public static void main(String[] args) {
        // 더블 타입의 배열 scores[10] , 안에 각각의 점수들
        double[] scores = { 10, 40, 30, 20, 50, 90, 100, 80, 60, 70 };
        // for문으로 각각의 점수 출력
        for (int i = 0; i < scores.length; i++) {
            System.out.println(scores[i]);
        }
        // 새로운 for문으로 점수의 총 합 , 평균 계산(doubel 타입)
        double sum = 0;
        for (int i = 0; i < scores.length; i++) {
            sum += scores[i];
        }
        System.out.println("점수 총 합 : " + sum);
        double avg = sum / 10;
        System.out.println("평균 : " + avg);
        // 최댓값 탐색
        double max = scores[6];
        System.out.println(max);
    }
}
