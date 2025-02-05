![image](./images/image39.png)
![image](./images/image40.png)
문제 2) 이미지와 같은 형태의 구구단을 출력할 수 있는 코드를 만들어 보자.
```
for(int i = 1;i < 10;i++){
    for(int j = 1;j < 10;j++){
        System.out.print(i + "*" + j + "=" + (i * j) + "\t");
    }
    System.out.println();
}
```
```
for(int i = 1;i < 10;i++){
    System.out.println(i + "단");
    for(int j = 1;j < 10;j++){
        System.out.println(i + "*" + j + "=" + (i * j));
    }
}
```
```
for(int i = 1;(i + 2) < 10;i+=3){
    for(int j = 1;j < 10;j++){
        System.out.println(i + "*" + j + "=" + (i * j) + "\t" + (i + 1) + "*" + j + "=" + ((i + 1) * j) + "\t" + (i + 2) + "*" + j + "=" + ((i + 2) * j) + "\t");
    }
    System.out.println();
}
```
