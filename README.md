# 숫자 야구 게임 - 개인 프로젝트 과제


## 프로젝트 소개


컴퓨터가 랜덤으로 생성한 3개 또는 그 이상의 숫자를 플레이어가 각 자리의 수를 맞추면 되는 게임

예를 들어, 365 숫자가 랜덤으로 생성(보이지 않음)하면
사용자는 124(아웃), 312(1스트라이크 2볼), 365(3스트라이크 0볼)라는 숫자를 제시하면 힌트가 제공되고,
최종 3개 스트라이크를 맞춰야 게임에서 승리한다.

<img src="https://github.com/user-attachments/assets/064c0d8f-8663-4a6a-bb79-9989bbcf6bb0" height="600">

( Wordle Wordle - A daily word game)


## 목표

객체 지향 프로그램의 장점을 살려서 설계하고 프로젝트를 구현하라.

### 객체 지향 프로그래밍 특징
1. **모듈화** : 각 클래스가 특정 책임을 담당하므로 코드 유지보수가 용이합니다.
2. **재사용성** : 클래스와 메서드가 독립적으로 설계되어 재사용이 가능합니다.
3. **확장성** : 새로운 기능이나 요구 사항이 추가되더라도 기존 코드를 수정하지 않고 새로운 클래스를 추가하거나 기존 클래스를 수정할 수 있습니다.


### 객체 지향 프로그래밍 설계 흐름

1. 객체의 상태, 행위, 책임을 생각해서 객체간 협력하는 이미지를 그릴 줄 알아야 한다.
2. 클래스를 바로 만드는 것이 아닌 객체간 협력하는 과정을 먼저 완성해야 한다.
3. 코드의 흐름을 다른사람에게 설명하듯이 한글로 먼저 작성하고, 번역하듯 코드로 옮겨보자.



## 개발 환경


언어 : Java

IDE : Intellij IDEA 2024.2.3

JDK : Oracle OpenJDK 17.0.2


## 단계별 주제

Lv1. 기본 게임 구현
Lv2. 입력값 유효성 검사 및 출력 개선
Lv3. 게임 기록 통계 기능 추가 및 출력 개선
LV4. 게임 난이도 조절 기능 추가


## 중점 사항

Lv1. 요구사항에 맞게 기본 기능 구현
Lv2. 입력값 유효성 검사
Lv3. 게임 기록 통계 기능 구현 및 오류 메시지 출력
Lv4. 게임 난이도 조절 기능 구현
Lv4. 리팩토링 진행(객체 지향)

## 코드 설명 및 트러블 슈팅

[taketheking velog 숫자야구 게임 과제 트러블 슈팅](https://velog.io/@taketheking/숫자-야구-게임-과제에-대한-설명과-트러블슈팅)



## 대표 실행 화면

lv1

<img src="https://github.com/user-attachments/assets/9da7e546-6c2e-41a8-9e43-dfcb5aa821fa" height="400">

lv2

<img src="https://github.com/user-attachments/assets/63fcd295-69b1-4ac6-b313-bd5cbbdf2ca1" height="600">


lv3

<img src="https://github.com/user-attachments/assets/101166f2-83d3-48ae-a86e-3dd9215ad5db" height="600">


lv4

<img src="https://github.com/user-attachments/assets/8d580711-6a96-46e7-94dd-4faf9913e40b" height="700">


## 요구사항

### LV.1

#### 1. 정답 숫자 생성

1) 정답은 서로 다른 3자리 수
2) 각 자리는 1~9 사이의 숫자이고 0은 사용x
3) 숫자 중복 x

#### 2. 숫자 입력 받기

 1) 서로 다른 3자리 숫자 입력
 2) 숫자 중복x
  3) 문자 입력x -> 숫자만 입력o

#### 3. 결과값 출력 및 게임 로직 적용

##### 1) 정답과 입력값 비교 -> 볼, 스트라이크, 아웃 표시
    
    - 스트라이크 : 입력값과 정답을 비교해 같은 자리에 같은 숫자가 있는 경우
    - 볼 : 숫자는 같지만, 자리는 다른 경우
    - 아웃 : 숫자도, 자리도 다른 경우

##### 2) 입력한 3자리 숫자가 정답과 같으면 게임 종료
    
  - ‘3 스트라이크’라면, 정답에 해당합니다

##### 3) 올바르지 않은 입력값 확인 -> 오류 문구
   1. 문자 입력
    
   2. 중복되는값
      
   3. 3자리 숫자 외의 숫자
    
---

### Lv.2

#### 1. 입력값이 유효한지 검사

 1) 3자리 수인지 자릿수 검사
 2) 중복된 숫자가 없는지 중복 검사
 3) 입력값에 숫자만 포함되어 있는지 검사
 4) 유효하지 않은 값인 경우 "올바르지 않은 입력값입니다." 출력

#### 2. 출력개선
 아래의 문구 처럼 출력

 ```
// 예시
환영합니다! 원하시는 번호를 입력해주세요
1. 게임 시작하기 2. 게임 기록 보기 3. 종료하기
1 // 1번 게임 시작하기 입력

< 게임을 시작합니다 >
숫자를 입력하세요
.
.
.
```


---

### Lv.3

#### 1. 게임 기록 통계
 1) 사용자가 정답을 맞힐 때까지 "시도 횟수" 기록
 2) 게임 종료 시 총 시도 횟수 출력
 3) 아래와 같이 출력
 ```
    // 예시
환영합니다! 원하시는 번호를 입력해주세요
1. 게임 시작하기  2. 게임 기록 보기  3. 종료하기
2 // 2번 게임 기록 보기 입력

< 게임 기록 보기 >
1번째 게임 : 시도 횟수 - 14
2번째 게임 : 시도 횟수 - 9
3번째 게임 : 시도 횟수 - 12
.
.
.
```

#### 2. 출력 개선
 아래와 같이 안내문구 개선
```
// 예시
환영합니다! 원하시는 번호를 입력해주세요
1. 게임 시작하기  2. 게임 기록 보기  3. 종료하기
3 // 3번 종료하기 입력

< 숫자 야구 게임을 종료합니다 >

// 예시
환영합니다! 원하시는 번호를 입력해주세요
1. 게임 시작하기  2. 게임 기록 보기  3. 종료하기
4

올바른 숫자를 입력해주세요!

```

---

### Lv.4
#### 1. 게임 난이도 조절
 1) 사용자로부터 난이도 입력받고, 숫자 자릿수 조정
 2) 자리수는 3, 4, 5 만 가능 - 그 외는 예외 처리
 3) 자리수 입력 후 자동 게임 실행
```
// 예시
환영합니다! 원하시는 번호를 입력해주세요
0. 자리수 설정 1. 게임 시작하기  2. 게임 기록 보기  3. 종료하기
0 // 0번 자리수 설정 입력

설정하고자 하는 자리수를 입력하세요.
3
3자리수 난이도로 설정되었습니다.

< 게임을 시작합니다 >
숫자를 입력하세요
.
.
.
```
