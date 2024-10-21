package Lv4;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        BaseballGame game = new BaseballGame();     // 숫자 야구 게임 객체 생성
        BaseballGameDisplay display = new BaseballGameDisplay();

        List<Integer> gameRecords = new ArrayList<>();

        int menuNumber;

        while (true){
            System.out.println();
            System.out.println("숫자 야구 게임에 오신 걸 환영합니다!");
            System.out.println("원하시는 번호를 입력해주세요");
            System.out.println("1. 게임 시작하기 2. 게임 기록 보기 3. 종료하기");

            try {
                menuNumber = sc.nextInt();
            }
            catch (Exception e) {
                System.out.println("숫자가 아닌 값을 입력하셨습니다.");
                continue;
            }
            finally {
                sc.nextLine();
            }


            switch (menuNumber){
                case 1:
                    System.out.println();
                    System.out.println("< 게임을 시작합니다 >");

                    // 게임 시작 및 결과값 출력
                    gameRecords.add(game.play(sc, display));
                    System.out.println("정답입니다!");
                    break;

                case 2:
                    display.displayRecords(gameRecords);
                    break;

                case 3:
                    System.out.println();
                    System.out.println("< 숫자 야구 게임을 종료합니다 >");
                    return;

                default:
                    System.out.println("올바른 숫자를 입력해 주세요!");
            }

        }
       }
}

