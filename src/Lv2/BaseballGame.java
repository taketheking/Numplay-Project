package Lv2;

import java.util.*;

public class BaseballGame {

    static final int  DigitNumberLength = 3;

    List<Integer> randomNumber;

    // 객체 생성시 정답을 만들도록 함
    public BaseballGame() {
        randomNumber = getRandomThreeNumber();
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

            countStrike = countStrike(Integer.parseInt(inputNumber), this.randomNumber);   // 4. 스트라이크 개수 계산

            // 5. 정답여부 확인, 만약 정답이면 break 를 이용해 반복문 탈출
            if (countStrike == DigitNumberLength){
                break;
            }

            countBall = countBall(Integer.parseInt(inputNumber), this.randomNumber);     // 6. 볼 개수 계산

            // 7. 힌트 출력
            if(countBall == 0 && countStrike == 0) {
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
            isThreeDigitNumber(input);            // 세자리 확인
            int number = isNumber(input);         // 숫자 확인
            isDuplicate(number);                  // 중복 숫자 확인
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

    // 3자리 수 확인
    void isThreeDigitNumber(String number) throws Exception {
        if(number.length() != DigitNumberLength){
            throw new Exception();
        }
    }

    // 자기 자신 중복 확인
    void isDuplicate(Integer number) throws RuntimeException {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < DigitNumberLength; i++) {
            set.add(number%10);
            number /= 10;
        }
        if(set.size() != DigitNumberLength){
            throw new RuntimeException();
        }
    }


    // 3자리 랜덤 숫자 가져오기
    public List<Integer> getRandomThreeNumber() {
        Random random = new Random();
        List<Integer> list = new ArrayList<>();

        while (list.size() != DigitNumberLength) {
            random.setSeed(System.currentTimeMillis());
            int randomNumber = random.nextInt(9) + 1;
            if(list.contains(randomNumber)){
                continue;
            }
            list.add(randomNumber);
        }
        return list;
    }


    // 스트라이크 계산
    private int countStrike(int inputNumber, List<Integer> randomNumber) {
        int duplicateCount = 0;

        for (int i = 0; i < DigitNumberLength; i++) {
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

        for (int i = 0; i < DigitNumberLength; i++) {
            int digitNumber = inputNumber%10;
            if (randomNumber.contains(digitNumber) && randomNumber.get(i) != digitNumber) {
                duplicateCount++;
            }
            inputNumber /= 10;
        }

        return duplicateCount;
    }
}
