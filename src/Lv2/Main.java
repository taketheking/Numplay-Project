package Lv2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int menuNumber = 1;

        System.out.println("숫자 야구 게임에 오신 걸 환영합니다!");
        while (true){
            System.out.println("원하시는 번호를 입력해주세요");
            System.out.println("1. 게임 시작하기 2. 게임 기록 보기 3. 종료하기");

            try {
                menuNumber = sc.nextInt();
            }
            catch (Exception e) {
                System.out.println("숫자가 아닌 값을 입력하셨습니다.");
            }
            finally {
                sc.nextLine();
            }

            if(menuNumber == 1){
                System.out.println();
                System.out.println("< 게임을 시작합니다 >");

                BaseballGame game = new BaseballGame();     // 숫자 야구 게임 객체 생성
                // 게임 시작 및 결과값 출력
                System.out.println("정답입니다! " + game.play(sc) + "번의 시도만에 맞추셨습니다!");
            }
            else if(menuNumber == 3){
                return;
            }
            else{
                System.out.println("올바르지 않는 번호를 입력하셨습니다.");
            }

        }
       }
}

