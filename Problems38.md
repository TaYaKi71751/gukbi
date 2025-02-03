문제 1) 아래처럼 출력될 수 있도록 기찻길을 만들고 순서도를 만든 다음 코드를 작성해보자. 
구현이 어려우면 기찻길을 그려보고 하자. 그래도 어려우면 순서도를 그려보고 하자.
1. 
```
1**********************1
```
```
System.out.print(1);
for(int i = 0;i < 22;i++){
    System.out.print("*");
}
System.out.print(1);
```
2. 
```
*****1*****1*****1*****1
```
```
for(int i = 0;i < 4;i++){
    for(int j = 0;j < 5;j++){
        System.out.print("*");
    }
    System.out.print(1);
}
```
3. 
```
2*****2*****2*****2*****
```
```
for(int i = 0;i < 4;i++){
    System.out.print(2);
    for(int j = 0;j < 5;j++){
        System.out.print("*");
    }
}
```
4. 
```
21**********************1
```
```
System.out.print(2);
System.out.print(1);
for(int i = 0;i < 22;i++){
    System.out.print("*");
}
System.out.print(1);
```
5. 
```
1****21****21****21****2
```
```
for(int i = 0;i < 4;i++){
    for(int j = 0;j < 2;j++){
        System.out.print(j + 1);
        if(j == 0){
            for(int l = 0;l < 4;l++){
                System.out.print("*");
            }
        }
    }
}
```
6. 
```
1111****21111****21111****21111****2
```
```
char arr[] = {'1','*'};
for(int i = 0;i < 4;i++){
    for(int l = 0;l < arr.length;l++){
        for(int j = 0;j < 4;j++){
            System.out.print(arr[l]);
        }
    }
    System.out.print(2);
}
```
7. 
```
1111****22221111****22221111****2222
```
```
char arr[] = {'1','*','2'};
for(int i = 0;i < arr.length;i++){
    for(int j = 0;j < 4;j++){
        System.out.print(arr[i]);
    }
}
```
8. 
```
111122223333444411112222333344441111222233334444
```
```
for(int i = 0;i < 3;i++){
    for(int j = 0;j < 4;j++){
        for(int l = 0;l < 4;l++){
            System.out.print(j);
        }
    }
}
```
