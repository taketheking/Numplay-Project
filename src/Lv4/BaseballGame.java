package Lv4;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import static Lv4.DigitNumberLength.getDigitNumberLength;


class BaseballGame {

     Validate validate = new Validate();

    private final List<Integer> randomNumber;

    // 객체 생성시 정답을 만들도록 함
    BaseballGame() {
        randomNumber = getRandomNumbers();
    }

    int play(Scanner scanner, BaseballGameDisplay display) {
        int countTryNumber = 0;
        int countStrike;
        int countBall;

        while (true) {
            System.out.println("숫자를 입력하세요");
            String inputNumber = scanner.next().trim(); // 1. 유저에게 입력값을 받음
            scanner.nextLine();

            // 2. 올바른 입력값을 받았는지 검증
            if(validate.validateInput(inputNumber)) {
                continue;
            }

            countTryNumber++;  // 3. 게임 진행횟수 증가

            countStrike = countStrike(Integer.parseInt(inputNumber), this.randomNumber);   // 4. 스트라이크 개수 계산

            // 5. 정답여부 확인, 만약 정답이면 break 를 이용해 반복문 탈출
            if (countStrike == getDigitNumberLength()){
                break;
            }

            countBall = countBall(Integer.parseInt(inputNumber), this.randomNumber);     // 6. 볼 개수 계산

            // 7. 힌트 출력
            if(isOutNumbers(countStrike, countBall)) {
                System.out.println("아웃");
            }
            else {
                display.displayHint(countStrike, countBall);
            }

        }

        // 게임 진행횟수 반환
        return countTryNumber;
    }

    // 스트라이크 계산
    private int countStrike(int inputNumber, List<Integer> randomNumber) {
        int duplicateCount = 0;

        for (int i = 0; i < getDigitNumberLength(); i++) {
            if (randomNumber.get(i) == inputNumber%10) {
                duplicateCount++;
            }
            inputNumber /= 10;
        }

        return duplicateCount;
    }

    // 볼 계산
    private int countBall(int inputNumber, List<Integer> randomNumber) {
        int duplicateCount = 0;

        for (int i = 0; i < getDigitNumberLength(); i++) {
            int digitNumber = inputNumber%10;

            if (randomNumber.contains(digitNumber) && randomNumber.get(i) != digitNumber) {
                duplicateCount++;
            }
            inputNumber /= 10;
        }

        return duplicateCount;
    }

    // 3자리 랜덤 숫자 가져오기
    private List<Integer> getRandomNumbers() {
        Random random = new Random();
        List<Integer> randomlist = new ArrayList<>();

        while (randomlist.size() != getDigitNumberLength()) {
            random.setSeed(System.currentTimeMillis());
            int randomNumber = random.nextInt(9) + 1;

            if(randomlist.contains(randomNumber)){
                continue;
            }
            randomlist.add(randomNumber);
        }
        return randomlist;
    }

    private boolean isOutNumbers(int strike, int ball) {
        return strike == 0 && ball == 0;
    }

}
