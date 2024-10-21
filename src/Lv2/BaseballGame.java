package Lv2;

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

public class BaseballGame {

    static final int  DigitNumberLength = 3;

    int randomNumber;

    // 객체 생성시 정답을 만들도록 함
    public BaseballGame() {
        do {
            randomNumber = getRandomThreeNumber();

        } while (isDuplicate(randomNumber) || isZeroIn(randomNumber));
    }

    public int play(Scanner scanner) {
        int countGameNumber = 0;
        int countStrike;
        int countBall;

        BaseballGameDisplay display = new BaseballGameDisplay();

        while (true) {
            System.out.println("숫자를 입력하세요");
            String inputNumber = scanner.next(); // 1. 유저에게 입력값을 받음
            scanner.nextLine();

            // 2. 올바른 입력값을 받았는지 검증
            if(validateInput(inputNumber.trim())) {
                continue;
            }

            countGameNumber++;  // 3. 게임 진행횟수 증가

            countStrike = countStrike(inputNumber);   // 4. 스트라이크 개수 계산

            // 5. 정답여부 확인, 만약 정답이면 break 를 이용해 반복문 탈출
            if (countStrike == DigitNumberLength){
                break;
            }

            countBall = countBall(inputNumber);     // 6. 볼 개수 계산

            // 7. 힌트 출력
            if(countBall == DigitNumberLength){
                System.out.println("아웃");
            }
            else {
                display.displayHint(countStrike, countBall);
            }

        }

        // 게임 진행횟수 반환
        return countGameNumber;
    }

    // 올바른 입력값을 받았는지 검증
    protected boolean validateInput(String input) {
        try{
            int number = isNumber(input);         // 숫자 확인
            isThreeNumber(input);    // 세자리 확인
            // 중복 숫자 확인
            if(isDuplicate(number)){
                throw new RuntimeException();
            }
            return false;
        }catch (Exception e){
            System.out.println("올바르지 않은 입력값입니다.");
            return true;
        }
    }

    // 숫자인지 확인
    Integer isNumber(String input) throws NumberFormatException {
        return Integer.parseInt(input);
    }

    // 0이 있는지 체크
    public boolean isZeroIn(int number) {
        return String.valueOf(number).contains("0");
    }

    // 3자리 수 확인
    void isThreeNumber(String number) throws Exception {
        if(number.length() != DigitNumberLength){
            throw new Exception();
        }
    }

    // 자기 자신 중복 확인
    public boolean isDuplicate(int number) {
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < DigitNumberLength; i++) {
            set.add(number%10);
            number /= 10;
        }
        return set.size() != DigitNumberLength;
    }


    // 정답과 중복 확인
    public int getDuplicateCount(int number, int randomNumber) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < DigitNumberLength; i++) {
            set.add(number%10);
            number /= 10;
        }

        int duplicateCount = 0;
        for (int i = 0; i < DigitNumberLength; i++) {
            if (set.contains(randomNumber%10)) {
                duplicateCount++;
            }
            randomNumber /= 10;
        }

        return duplicateCount;
    }

    // 3자리 랜덤 숫자 가져오기
    public int getRandomThreeNumber() {
        Random random = new Random();
        random.setSeed(System.currentTimeMillis());

        return random.nextInt(900) + 100;      // 범위 0~899 -> 100~999 변경
    }


    private int countStrike(String input) {
        return getDuplicateCount(Integer.parseInt(input), this.randomNumber);
    }

    private int countBall(String input) {
        return DigitNumberLength - getDuplicateCount(Integer.parseInt(input), this.randomNumber);
    }
}
