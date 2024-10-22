package Lv4;

import java.util.Random;
import java.util.Scanner;

import static Lv4.DigitNumberLength.getDigitNumberLength;


public class BaseballGame {

     Validate validate = new Validate();

    // 랜덤 숫자
    int randomNumber;

    // 객체 생성시 정답을 만들도록 함
    public BaseballGame() {
        do {
            randomNumber = getRandomNumber();

        } while (validate.isDuplicate(randomNumber) || validate.isZeroIn(randomNumber));
    }

    public int play(Scanner scanner, BaseballGameDisplay display) {
        int countTryNumber = 0;
        int countStrike;
        int countBall;

        while (true) {
            System.out.println("숫자를 입력하세요");
            String inputNumber = scanner.next(); // 1. 유저에게 입력값을 받음
            scanner.nextLine();

            // 2. 올바른 입력값을 받았는지 검증
            if(validate.validateInput(inputNumber.trim())) {
                continue;
            }

            countTryNumber++;  // 3. 게임 진행횟수 증가

            countStrike = countStrike(inputNumber);   // 4. 스트라이크 개수 계산

            // 5. 정답여부 확인, 만약 정답이면 break 를 이용해 반복문 탈출
            if (countStrike == getDigitNumberLength()){
                break;
            }

            countBall = countBall(inputNumber);     // 6. 볼 개수 계산

            // 7. 힌트 출력
            if(countBall == getDigitNumberLength()){
                System.out.println("아웃");
            }
            else {
                display.displayHint(countStrike, countBall);
            }

        }

        // 게임 진행횟수 반환
        return countTryNumber;
    }

    private int countStrike(String input) {
        return validate.getDuplicateCount(Integer.parseInt(input), this.randomNumber);
    }

    private int countBall(String input) {
        return getDigitNumberLength() - validate.getDuplicateCount(Integer.parseInt(input), this.randomNumber);
    }

    // 3자리 랜덤 숫자 가져오기
    public int getRandomNumber() {
        Random random = new Random();
        random.setSeed(System.currentTimeMillis());

        return (int) (random.nextInt((int) (9 * Math.pow(10, getDigitNumberLength()-1))) + Math.pow(10, getDigitNumberLength()-1));      // 범위 0~899 -> 100~999 변경
    }


}
