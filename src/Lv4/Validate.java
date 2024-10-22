package Lv4;

import java.util.HashSet;

import static Lv4.DigitNumberLength.getDigitNumberLength;

public class Validate {


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


    // 0이 있는지 체크
    public boolean isZeroIn(int number) {
        return String.valueOf(number).contains("0");
    }


    // 3자리 수 확인
    void isThreeNumber(String number) throws Exception {
        if(number.length() != getDigitNumberLength()){
            throw new Exception();
        }
    }

    // 숫자인지 확인
    Integer isNumber(String input) throws NumberFormatException {
        return Integer.parseInt(input);
    }


    // 자기 자신 중복 확인
    public boolean isDuplicate(int number) {
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < getDigitNumberLength(); i++) {
            set.add(number%10);
            number /= 10;
        }
        return set.size() != getDigitNumberLength();
    }


    // 정답과 중복 확인
    public int getDuplicateCount(int number, int randomNumber) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < getDigitNumberLength(); i++) {
            set.add(number%10);
            number /= 10;
        }

        int duplicateCount = 0;
        for (int i = 0; i < getDigitNumberLength(); i++) {
            if (set.contains(randomNumber%10)) {
                duplicateCount++;
            }
            randomNumber /= 10;
        }

        return duplicateCount;
    }
}
