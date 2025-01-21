# 다음 문제를 풀어보자.
1. `배열`에 `53`,`6`,`85`,`3`,`5`를 넣은 다음 배열의 내용을 화면에 출력해 보자.
```
int a[] = {53,6,85,3,5};
for(int i = 0;i < a.length;i++){
    System.out.println(a[i]);
}
```
2. `배열 a`에 `1`,`2`,`3` 을 넣은 후 
배열 내의 모든 값에 `2`를 더한 값인 `3`,`4`,`5`로 변경한 다음에 
배열의 내용을 화면에 인덱스 순서대로 출력해 보고 인덱스 역순으로 출력해 보자.
```
int a[] = {1,2,3};
for(int i = 0;i < a.length;i++){
    a[i] += 2;
}
for(int i = 0;i < a.length;i++){
    System.out.println(a[i]);
}
for(int i = a.length - 1;i > -1;i--){
    System.out.println(a[i]);
}

```
3. `배열` `a[]={12,1,53,6,85,3}`를 만든 다음에 배열의 모든 내용을 더한 값을 
`sum`에 저장하여 출력하는 코드를 만들어 보자.
```
int a[] = {12,1,53,6,85,3};
int sum = 0;
for(int i = 0;i < a.length;i++){
    sum += a[i];
}
System.out.println(sum);
```
4. `a[]={12,1,53,6,85,3}`에서 `a`배열에 들어있는 값중 짝수만 화면에 출력하시오.
```
int a[] = {12,1,53,6,85,3};
for(int i = 0;i < a.length;i++){
    if(a[i] % 2 == 0){
        System.out.println(a[i]);
    }
}
```
5. `a[]={12,1,53,6,85,3}`에서 인덱스가 홀수인 배열의 값을 출력하시오.
```
int a[] = {12,1,53,6,85,3};
ArrayList<Integer> results = new ArrayList<Integer>();
for(int i = 0;i < a.length;i++){
    if(a[i] % 2 != 0){
        results.add(a[i]);
    }
}
System.out.println(Arrays.toString(results.toArray()));
```
6. `Tree`클래스를 배열로 선언하여 여러개의 데이터를 넣은후 출력해 보자.
```
package com.the.ex;

class Owner {
    String name = "홍길동";
    int age = 23;
    String contact = "010-1234-5678";
}
class Tree {
    String name = "";
    int price = 0;
    int growthDuration = 0;
    int exp = 0;
    int currentTrees = 0;
    int maximumTrees = 0;
    Owner owner = new Owner();
}

public class Example {
    public static void main(String[] args){
        Tree trees[] = new Tree[100];
        for(int i = 0;i < trees.length;i++) {
        	trees[i] = new Tree();
        }
        for(int i = 0;i < trees.length;i++) {
	        System.out.println(
	            "나무 이름:" + trees[i].name + "\n" + 
	            "나무 가격:" + trees[i].price + "\n" + 
	            "키우는데 걸리는 시간:" + trees[i].growthDuration + "\n" +
	            "경험치:" + trees[i].exp + "\n" +
	            "현재 심은 나무수:" + trees[i].currentTrees + "\n" +
	            "최대 심을 수 있는 나무수:" + trees[i].maximumTrees + "\n" +
	            "주인 이름:" + trees[i].owner.name + "\n" +
	            "주인 나이:" + trees[i].owner.age + "\n" +
	            "주인 연락처:" + trees[i].owner.contact + "\n"
	        );
        }
	}
}

```
