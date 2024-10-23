package Lv4;

import java.util.List;

public class BaseballGameDisplay {
    public void displayHint(int strike, int ball) {
        System.out.println(strike + "스트라이크 " + ball+ "볼");
    }

    public void displayRecords(List<Integer> list) {
        System.out.println("< 게임 기록 보기 >");
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i+1) + "번째 게임 : 시도 횟수 - " + list.get(i));
        }
    }

    public void displayRecords2(List<Integer> list) {
        System.out.println("< 게임 기록 보기 >");
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i+1) + "번째 게임 : 시도 횟수 - " + list.get(i));
        }
    }
}