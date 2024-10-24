package Lv4;


import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import static Lv4.DigitNumberLength.setDigitNumberLength;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BaseballGameDisplay display = new BaseballGameDisplay();
        List<Integer> gameRecords = new ArrayList<>();

        int menuNumber;

        while (true){
            System.out.println();
            System.out.println("숫자 야구 게임에 오신 걸 환영합니다!");
            System.out.println("원하시는 번호를 입력해주세요");
            System.out.println("0. 자리수 설정 1. 게임 시작하기 2. 게임 기록 보기 3. 종료하기");

            try {
                menuNumber = sc.nextInt();
                sc.nextLine();
            }
            catch (InputMismatchException e) {
                System.out.println("숫자가 아닌 값을 입력하셨습니다.");
                continue;
            }

            switch (menuNumber){
                case 0:
                    System.out.println("설정하고자 하는 자리수를 입력하세요.");
                    try {
                        setDigitNumberLength(sc.nextInt());
                        sc.nextLine();
                    } catch (IllegalArgumentException e) {
                        System.out.println("3, 4, 5 자리 숫자 중에 선택해주세요.");
                        continue;
                    }
                    catch (InputMismatchException e) {
                        System.out.println("숫자가 아닌 값을 입력하셨습니다.");
                        continue;
                    }

                case 1:
                    System.out.println();
                    System.out.println("< 게임을 시작합니다 >");

                    BaseballGame game = new BaseballGame();     // 숫자 야구 게임 객체 생성
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
                    sc.close();
                    return;

                default:
                    System.out.println("올바른 숫자를 입력해 주세요!");
            }
        }
    }
}

