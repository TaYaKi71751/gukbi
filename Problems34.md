# 다음 문제를 반복문으로 구현해 보자.
문제 1) 배열 a에 1,2,3 을 넣은 후 배열 내의 모든 값에 2를 더한 값인 3,4,5로 변경한 다음에 배열의 내용을 화면에 출력하는 코드를 구현하여 보자.
```
int a[] = new int[3];
a[0] = 1;
a[1] = 2;
a[2] = 3;
for(int i = 0;i < a.length;i++){
    a[i] += 2;
    System.out.println(a[i]);
}
```
문제 2) 길이가 10인 배열 a에 3의 배수를 넣은 다음에 배열의 내용을 출력하는 코드를 만들어 보자.
```
int a[] = new int[10];
for(int i = 0;i < a.length;i++){
    a[i] = i * 3;
    System.out.println(a[i]);
}
```
문제 3) 길이가 100인 배열 a에 1부터 100까지의 숫자를 순서대로 넣은 다음 배열의 인덱스가 짝수인 배열에 들어 있는 값만 출력하는 코드를 만들어 보자.
```
int a[] = new int[100];
for(int i = 0;i < 100;i++){
    a[i] = i + 1;
    if(i % 2 == 0){
        System.out.println(a[i]);
    }
}
```
문제 4) 배열 a[]={12,1,5,3,6,8,5,3}를 만든 다음에 배열의 모든 내용을 더한 값을 sum에 저장하여 출력하는 코드를 만들어 보자.
```
int a[] = {12,1,5,3,6,8,5,3};
int sum = 0;
for(int i = 0;i < a.length;i++){
    sum += a[i];
}
System.out.println(sum);
```
문제 5) a[]={12,1,5,3,6,8,5,3}의 a배열에서 배열 안의 숫자가 짝수인 12,6,8 의 값을 더한 결과 값을 출력하는 프로그램을 작성해 보자.
```
int a[] = {12,1,5,3,6,8,5,3};
int sum = 0;
for(int i = 0;i < a.length;i++){
    if(a[i] % 2 == 0){
        sum += a[i];
    }
}
System.out.println(sum);
```
문제 6) a[]={12,1,51,3,6,8,5}의 a배열에서 가장 큰 값과 가장 작은 값을 더하는 프로그램을 작성해 보자.
```
{12,1,51,3,6,8,5}에서 가장 큰수를 찾으려면 일단 가장 큰수를 저장할 변수 max에 12를 넣는다. 
max에 12를 넣은 이유는 비교 대상 수중 하나를 사용하기 위해서이다. 
100과 같이 아무수나 입력하게 되면 제시한 수중에 100이 가장 큼으로 배열안에 가장 큰수를 찾는데 문제가 되어서 비교 대상중 하나의 숫자를 넣었다. 
그 다음 {12,1,51,3,6,8,5}에서 처음 부터 순서대로 비교해서 더 큰 숫자가 나오면 max값에 더 큰 값을 넣는다. 
첫번째 값 12는 현재 max값 12와 같으므로 패스한다. 
두 번째 값 1은 max값보다 작으므로 패스한다. 
세번째 값 51은 max값보다 크므로 max값에 51를 넣는다. 
네 번째 값 3은 max값 51 보다 작으므로 패스한다. 
다섯 번째 값 6은 max값 51 보다 작으므로 패스한다. 
여섯 번째 값 8은 max값 51 보다 작으므로 패스한다. 
일곱 번째 값 5는 max값 51 보다 작으므로 패스한다. 
이렇게 모든 숫자를 max 와 비교하는 작업이 끝나면 제시된 모든 숫자에서 max가 가장 큰 수가 된다. 
여기서는 max값 51이 모든 숫자들 중에 가장 큰 숫자이다 순서도로 상위 사항을 구현할 때 어떻게 해야 하는지 살펴보자. 
배열의 가장 큰 값을 변수 max에 찾아서 넣는 방법은 max를 선언한 다음 배열 안의 임의의 수를 배열에 넣고(max=a[0]) 배열을 인덱스 0부터 끝까지 순회 하면서 해당 인덱스의 배열 안의 수와 max를 비교해서 (a[i]>max) 배열[인덱스]의 값이 max보다 크면(a[i]>max 이 true이면) 배열[인덱스] 값이 max 값 보다 더 크다는 이야기 이므로 max에 더 큰수 a[i]를 넣어(max=a[i]) 기존 max 값보다 더 큰 수를 max에 넣는다. 
배열 안의 모든 수를 max값 보다 큰수가 나올 때마다 max에 넣으면 모든 배열의 데이터를 순회 하고 나면 max에는 배열안의 수중 가장 큰 수가 남게 된다.
```
```
int a[] = {12,1,51,3,6,8,5};
java.util.ArrayList arr = new java.util.ArrayList<Integer>(java.util.Arrays.asList(a));
Collections.sort(arr);
System.out.println(arr.toArray()[0] + arr.toArray()[arr.toArray().length - 1]);

```
7.배열에 5개의 숫자를 입력받아 넣은 다음 숫자 하나를 입력받아 해당 숫자가 몇번째 인덱스에 들어 있는지 출력하는 프로그램을 만들어 보자.
```
java.util.Scanner sc = new java.util.Scanner(System.in);
int arr[] = new int[5];
int input = 0;
for(int i = 0;i < arr.length;i++){
    arr[i] = Integer.parseInt(sc.nextLine());
}
input = Integer.parseInt(sc.nextLine());
for(int i = 0;i < arr.length;i++){
    if(arr[i] == input){
        System.out.println(i);
    }
}
```
8.배열에 5개의 문자열을 입력받아 넣은 다음 문자열 하나를 입력받아 해당 문자가 몇번째 인덱스에 들어 있는지 출력하는 프로그램을 만들어 보자.
```
java.util.Scanner sc = new java.util.Scanner(System.in);
String arr[] = new String[5];
String input = "";
for(int i = 0;i < arr.length;i++){
    arr[i] = sc.nextLine();
}
input = sc.nextLine();
for(int i = 0;i < arr.length;i++){
    if(arr[i].equals(input)){
        System.out.println(i);
    }
}
```
9.배열 크기를 입력 받아 배열 크기 만큼 1,2,3,1,2,3,1,2,3 … 숫자를 순서대로 배열안에 넣은 다음 배열의 내용을 출력해 보자.
```
int size = Integer.parseInt(sc.nextLine());
int arr[] = new int[size];
for(int i = 0;i < size;i++){
    arr[i] = (i + 1) % 3;
}
for(int i = 0;i < size;i++){
    System.out.println(arr[i]);
}
```
10.배열에 들어있는 내용을 정순과 역순으로 저장하는 새로운 배열을 만들어 출력해 보자.
```
ex)배열에 1,2,3이 들어 있으면 1,2,3,3,2,1 이 들어 있는 배열
ex)배열에 7,9,21,15,23 이 들어 있으면 23,15,21,9,7,7,9,21,15,23 이 들어 있는 배열
```
```
int a[] = {1,2,3};
java.util.ArrayList<Integer> sort = new ArrayList<Integer>(java.util.Arrays.asList(a));
java.util.ArrayList<Integer> reverse = new ArrayList<Integer>(java.util.Arrays.asList(a));
java.util.ArrayList<Integer> result = new ArrayList<Integer>(java.util.Arrays.asList(a));
Collections.sort(sort);
Collections.sort(reverse);
Collections.reverse(reverse);
result.addAll(sort);
result.addAll(reverse)
```
```
int a[] = {7,9,21,15,23};
java.util.ArrayList<Integer> sort = new ArrayList<Integer>(java.util.Arrays.asList(a));
java.util.ArrayList<Integer> reverse = new ArrayList<Integer>(java.util.Arrays.asList(a));
java.util.ArrayList<Integer> result = new ArrayList<Integer>(java.util.Arrays.asList(a));
Collections.sort(sort);
Collections.sort(reverse);
Collections.reverse(reverse);
result.addAll(reverse)
result.addAll(sort);
```
11. 컴퓨터에서 주사위 던지는 프로그램을 구현하였을때 던져서 나온수의 빈도(횟수)를 구하는 프로그램을 작성해 보자.
```
int diceSide = 0;
int frequency[] = new int[6];
Random random = new Random();
for(int i = 0;i < frequency.length;i++){
    diceSide = random.nextInt(6);
    frequency[diceSide]++;
    System.out.println(diceSide + 1 + "이 나왔습니다.");
}
for(int i = 0;i < frequency.length;i++){
    System.out.println(i + "는 " + frequency[i] + "번 나왔습니다.");
}
```
