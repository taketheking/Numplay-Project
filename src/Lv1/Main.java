package Lv1;

public class Main {
    public static void main(String[] args) {
        BaseballGame game = new BaseballGame();     // 숫자 야구 게임 객체 생성

        System.out.println(" < 게임을 시작합니다 > ");
        // 게임 시작 및 결과값 출력
        System.out.println("정답입니다! " + game.play() + "번의 시도만에 맞추셨습니다!");
    }
}

