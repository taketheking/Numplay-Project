package Lv4;

import java.util.HashSet;

import static Lv4.DigitNumberLength.getDigitNumberLength;

public class Validate {

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
        if(number.length() != getDigitNumberLength()){
            throw new Exception();
        }
    }

    // 자기 자신 중복 확인
    void isDuplicate(Integer number) throws RuntimeException {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < getDigitNumberLength(); i++) {
            set.add(number%10);
            number /= 10;
        }
        if(set.size() != getDigitNumberLength()){
            throw new RuntimeException();
        }
    }
}
