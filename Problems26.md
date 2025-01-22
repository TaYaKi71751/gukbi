# 다음 입력 부분의 코드를 메인에 넣고 실행 시켰을때 출력 부분이 출력되는지 확인해 보자.
1.입력
```
if(5>3){
    System.out.println(true);
}
```
출력 : 
```
true
```
2.입력
```
if(5<3){
    System.out.println(true);
}
```
출력 : 출력 없음
3.입력
```
System.out.println(1);
if(5<3){
    System.out.println(true);
}
System.out.println(2);
```
출력
```
1
2
```
4.입력
```
if(5>3){
    System.out.println(true);
}else{
    System.out.println(false);
}
```
출력 : 
```
true
```
5.입력
```
if(5==3){
    System.out.println(true);
}else{
    System.out.println(false);
}
```
출력 : 
```
false
```
6.입력
```
System.out.println(1);
if(5>3){
    System.out.println(true);
}else{
    System.out.println(false);
}
System.out.println(2);
```
출력 : 
```
true
```
7.입력
```
int a=10;
int b=5;
if(a<b){
    System.out.println(true);
}
```
출력 : 출력 없음
8.입력
```
int a=10;
int b=5;
if(a>b){
    System.out.println(true);
}else{
    System.out.println(false);
}
```
출력
```
true
```
9.입력
```
Scanner scanner = new Scanner(System.in);
System.out.print("문자열을 입력하세요: ");
String string = scanner.nextLine();
if (string.contains("java")) {//java문자열이 들어 있으면 true
    System.out.println("java가 포함되어 있습니다.");
} else {
    System.out.println("java가 포함되어 있지 않습니다.");
}
```
출력
```
문자열을 입력하세요: 
java가 포함되어 있습니다.
```
