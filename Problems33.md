# 문제
1. 1부터 차례대로 더한 총합이 최초 100을 넘기 직전까지 누적한 결과값을 순서대로 출력하시오. 
```
1:1 2:3 3:6 4:10 5:15 6:21 … 100이전의 총합들을 다음과 같이 출력되면 된다. 
힌트 : 조건식에 복잡한 수식이 들어 갈수 도 있다.
```
```
int sum = 0;
for(int i = 1;i < 101;i++){
    sum += i;
    System.out.print(i+":" +sum + " ");
}
```
2. 문자열과 숫자를 입력받아 입력받은 문자열을 입력받은 숫자만큼 출력하는 프로그램을 만들어 보자.
```
java.util.Scanner sc = new java.util.Scanner(System.in);
String str = sc.nextLine();
int repeat = Integer.parseInt(sc.nextLine());
for(int i = 0;i < repeat;i++){
    System.out.println(str);
}
```
3. 입력 받은 두수 사이의 숫자들의 합을 구하는 프로그램을 만들어 보자.
```
java.util.Scanner sc = new java.util.Scanner(System.in);
int a = Integer.parseInt(sc.nextLine());
int b = Integer.parseInt(sc.nextLine());
int sum = 0;
for(int i = a;i <= b;i++){
    sum += i;
}
System.out.println(sum);
```
4. 두 수를 입력 받아 첫 번째수 부터 시작하여 하나씩 카운트하여 두번째수 만큼 화면에 출력 하는 프로그램을 만든다. 
```
5 6를 입력 받으면 5부터 6개 5 6 7 8 9 10 이 화면에 출력 된다.
```
```
java.util.Scanner sc = new java.util.Scanner(System.in);
int a = Integer.parseInt(sc.nextLine());
int b = Integer.parseInt(sc.nextLine());
for(int i = a;i < (a + b);i++){
    System.out.print(i + " ");
}
```
5. 사용자가 “종료”를 입력할때 까지 무한 반복하는 프로그램을 3가지 방법으로 구현하시오.
```
java.util.Scanner sc = new java.util.Scanner(System.in);
String input = "";
while(true){
    intput = sc.nextLine();
    if(input.equals("종료")){
        break;
    }
}
```
6. 100의 모든 약수를 구하시오. 
```
힌트) 0으로 나눌수 없듯이 0의 나머지는 구할수 없다.
ex) 어떤 수에 대해서 나누어 떨어지는 수를 약수라고 한다. 
100을 2로 나눈 나머지는 0이 된다. 
100은 2로 나누어 떨어 지므로, 2는 100의 약수이다. 
3은 100으로 나눠 떨어지지 않으므로 약수가 아니다. 
100의 모든 약수를 구하려면 100보다 크면 더 이상 나눌 수 없으므로 1~100사이의 수들로 하나씩 100을 나눠서 나누어 떨어 지는지 판별하여 나누어 떨어지는 수들이 100의 약수가 된다. 
1,2,4,5,..100 이 100의 약수에 해당한다.
```
```
int target = 100;
for(int i = 1;i < target;i++){
    if(target % i == 0){
        System.out.print(i + " ");
    }
}
```
8. 두 수를 입력받아 두수의 공통된 약수를 모두 출력해 보자. 
```
java.util.Scanner sc = new java.util.Scanner(System.in);
int a = Integer.parseInt(sc.nextLine());
int b = Integer.parseInt(sc.nextLine());
java.util.ArrayList<Integer> aFactors = new ArrayList<Integer>();
java.util.ArrayList<Integer> bFactors = new ArrayList<Integer>();
java.util.ArrayList<Integer> commonFactors = new ArrayList<Integer>();
for(int i = 1;i <= a;i++){
    if(a % i == 0){
        aFactors.add(i);
    }
}
for(int i = 1;i <= b;i++){
    if(b % i == 0){
        bFactors.add(i);
    }
}
for(int i = 0;i < aFactors.toArray().length;i++){
    for(int j = 0;j < bFactors.toArray().length;j++){
        if(aFactors.toArray()[i] == bFactors.toArray()[j]){
            commonFactors.add(aFactors.toArray()[i]);
        }
    }
}
for(int i = 0;i < commonFactors.toArray().length;i++){
    System.out.println(commonFactors.toArray()[i] + " ");
}
```
9. 두수를 입력받아 두수의 최대 공약수를 구하는 프로그램을 만들어 보자.
```
0부터 하나씩 증가시키며 두수 모두 나눠지는 수를 출력하면 된다. 
출력된 수중에서 가장 큰수를 입력받은 두수의 최대공약수라고 한다.
```
```
java.util.Scanner sc = new java.util.Scanner(System.in);
int a = Integer.parseInt(sc.nextLine());
int b = Integer.parseInt(sc.nextLine());
java.util.ArrayList<Integer> aFactors = new ArrayList<Integer>();
java.util.ArrayList<Integer> bFactors = new ArrayList<Integer>();
int commonFactor = 0;
for(int i = 1;i <= a;i++){
    if(a % i == 0){
        aFactors.add(i);
    }
}
for(int i = 1;i <= b;i++){
    if(b % i == 0){
        bFactors.add(i);
    }
}
for(int i = 0;i < aFactors.toArray().length;i++){
    for(int j = 0;j < bFactors.toArray().length;j++){
        if(aFactors.toArray()[i] == bFactors.toArray()[j]){
            commonFactor = aFactors.toArray()[i];
        }
    }
}
System.out.println(commonFactor);
```
10. 사용자에게 숫자를 하나 입력받아 입력한 숫자들의 합이 100이 될때까지 계속입력을 받다가 100이 넘으면 최종 합산한 값을 출력하는 프로그램을 구현해 보자.
```
java.util.Scanner sc = new java.util.Scanner(System.in);
int sum = 0;
int a = 0;
while(sum <= 100){
    a = Integer.parseInt(sc.nextLine());
    sum += a;
}
System.out.println(sum);
```
11. 사용자에게 계속해서 숫자를 입력받아 1~10사이의 숫자를 3번 입력 할 때 까지 반복한다. 
```
입력이 끝나면 잘못 입력한 횟수와 제대로 입력한 횟수를 출력하고 
사용자가 제대로 입력한 총합을 출력하는 프로그램을 만들어 보자.
```
```
java.util.Scanner sc = new java.util.Scanner(System.in);
int fail = 0;
int success = 0;
int input = 0;
int sum = 0;
while(success != 3){
    try {
        input = Integer.parseInt(sc.nextLine());
    } catch(Exception e){
        fail++;
        continue;
    }
    if(input > 0 && input < 11){
        sum += input;
        success++;
    } else {
        fail++;
    }
}
```
12. 0부터 시작하는 4의 배수 10개를 출력하시오.
```
ex) 어떤수에 0,1,2,3,4.. 를 곱해서 나온 수를 어떤수의 배수라 한다.
```
13. 두수를 입력 받아 최소 공배수를 출력하는 프로그램을 만들어 보자.
```
ex)2의 배수도 되고 3의 배수도 되는 공배수는 6,12,18,24 등이 있다. 
이중에서 가장 작은 수 6를 최소 공배수 라고 한다. 
2에 어떤수를 곱해서 나온 결과가 2의 배수 이므로 어떤 수를 2로 나누어 0이 되면 2의 배수이다.
1 부터 하나씩 증가시켜 입력 받은 두 수가 모두 0으로 나누어 떨어지는 수들은 공배수 이고 이중 가장 먼저 찾은 수가 가장 작은 수이므로 처음 찾은수가 최소 공배수이다. 
2와 3의 최소 공배수는 6이다.
```
14. 3개의 수를 입력 받아 가장 작은 수와 가장 큰수를 출력하는 프로그램을 만들어 보자.
15. 100이하의 수학과목 점수를 5번 입력받아 60이하 점수가 몇 개인지 출력하는 프로그램을 구현해 보자.
16. 소수는 1과 자기 자신만으로 나눠지는 수이다. 
```
2,3,5같은 경우 1과 본인 자신만으로 나눠지므로 소수이다. 
수를 하나 입력받아 소수인지 아닌지 판별하는 프로그램을 구현하시오.
ex) 2부터 본인 보다 하나 작은 숫자를 차례대로 나눠서 나누어 떨어지는 수가 없으며 1과 자기 자신만 나눠지는 수이므로 소수에 해당한다.
```
17. 숫자를 하나 입력받아 1~1000사이에 입력받은 숫자의 배수가 몇 개인지 출력하는 프로그램을 만들어 보자.
18. 사용자에게 열의 데이터 개수을 입력받아 열에 맞춰서 1부터 100까지 순서대로 출력하는 프로그램을 구현해 보자.
```
ex) 3을 입력하면 한줄에 3개씩 출력 하면 된다.
```
19. 컴퓨터가 던진 동전이 앞면 인지 뒷면 인지 맞추는 프로그램을 구현해 보자. 
```
맞춘 횟수와 틀린 횟수를 기록해서 보여주고 3번 맞추면 프로그램이 종료되게 만들자.
```
20. 컴퓨터가 던진 주사위 수를 맞추는 프로그램을 구현해 보자. 
```
10회 입력받아 맞춘 회수와 틀린 회수를 기록해서 보여 주자.
```
