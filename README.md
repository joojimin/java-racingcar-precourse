# 자동차 경주 게임
## 진행 방법
* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)


##  기능 요구 사항
1.  자동차 경주 게임
2.  주어진 횟수 동안 n대의 자동차는 전진, 또는 멈출 수 있다.
3.  각 자동차는 이름을 가지고 있다.
4.  전진하는 동안 자동차이름을 같이 출력한다.
5.  자동차 이름은 ,를 기준으로 구분
6.  이름은 5자 이하만 가능
7.  사용자는 몇 번의 이동을 할 것 인지 입력할 수 있어야 한다.
8.  전진하는 조건은 0~9사이에서 랜덤값을 구하고, 랜덤값이 4이상일 경우 전진, 3이하의 값이면 멈춘다.
9.  완료후 누가 우승했는지 알려준다. 우승자는 한명이상 가능


##  기능 목록
1.  주어진 횟수를 입력 받는 기능
    *   1이상의 횟수
2.  레이싱할 자동차 입력 받기
    *   0~5자 사이의 이름만 가능
    *   ,를 이용해 자동차 이름을 구분
3.  이름이 있는 각 자동차를 관리하는 기능
4.  전진 혹은 멈추는 조건의 랜덤 숫자 만들기
    *   조건 0~9 사이의 숫자
5.  자동차가 전진하는 기능
6.  자동차의 전진 조건을 판단하는 기능 
7.  String Util 기능
    *   ','를 이용해 String을 List로 split하는 기능
    *   size 판별 기능
8.  우승자 출력 기능
9.  콘솔로 사용자의 데이터를 입력 받는 기능
