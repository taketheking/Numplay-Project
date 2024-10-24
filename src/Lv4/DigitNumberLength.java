package Lv4;

public class DigitNumberLength {
    // 자리수 길이
    private static int DigitNumberLength = 3;

    public static void setDigitNumberLength(int digitNumberLength) {
        if(digitNumberLength < 3 || digitNumberLength > 5){
            throw new IllegalArgumentException();
        }
        DigitNumberLength = digitNumberLength;
    }

    public static int getDigitNumberLength() {
        return DigitNumberLength;
    }

}
