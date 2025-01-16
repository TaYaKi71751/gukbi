# 화면출력 - 기본문법 1 
1. 입력 
```
System.out.println(“1”); // 출력하고 줄바꿈 
System.out.println(“2”); 
System.out.println(“3”);
```
출력 
```
1
2 
3 
```

2. 입력 
```
System.out.print(“1”); // 출력하고 줄바꿈 하지 않음 
System.out.print(“2”); 
System.out.print(“3”); 
```
출력 
```
123 
```

3. 입력 
```
System.out.print(“hello”); 
System.out.println(“ World”); 
System.out.println(“ World”); 
System.out.print(“hello”); 
```
출력
```
hello World
 World
hello
```
4. 입력 
```
System.out.print(“12”); 
System.out.println(“34”); 
System.out.println(“56”); 
```
출력
```
1234
56
```


5. 입력
```
System.out.print("hello java") ;
```
출력
```
hello java 
```

6. 다음은 `System.out.print(“1”);`과 `System.out.print(“ ”);` `System.out.println(“”);` `System.out.print(“2”);` `System.out.print(“3”);` 만 사용해서 다음 출력을 완성해 보자. 

입력
```
System.out.print(" "); 
System.out.print(" ");
System.out.print("1");
System.out.println("");
System.out.print(" ");
System.out.print("1");
System.out.print("2");
System.out.println("");
System.out.print("1");
System.out.print("2");
System.out.print("3");
```
출력 
```
  1
 12 
123 
```

7. 다음은 `System.out.print(“*”);`과 `System.out.println(“”);` 만 사용해서 다음 출력을 완성해 보자. 

입력
```
System.out.print(“*”);
System.out.print(“*”);
System.out.print(“*”);
System.out.print(“*”);
System.out.println(“”);
System.out.print(“*”);
System.out.print(“*”);
System.out.print(“*”);
System.out.print(“*”);
System.out.println(“”);
System.out.print(“*”);
System.out.print(“*”);
System.out.print(“*”);
System.out.print(“*”);
System.out.println(“”);
System.out.print(“*”);
System.out.print(“*”);
System.out.print(“*”);
System.out.print(“*”);
```
출력 
```
****
**** 
**** 
****
```

8. 다음은 `System.out.print(“*”);`과 `System.out.println(“”);` 만 사용해서 다음 출력을 완성해 보자. 

입력
```
System.out.print(“*”);
System.out.println(“”);
System.out.print(“*”);
System.out.print(“*”);
System.out.println(“”);
System.out.print(“*”);
System.out.print(“*”);
System.out.print(“*”);
System.out.println(“”);
System.out.print(“*”);
System.out.print(“*”);
System.out.print(“*”);
System.out.print(“*”);
System.out.println(“”);
```
출력 
```
* 
** 
*** 
****
```

​

9. 다음은 `System.out.print(“*”);` `System.out.print(“ ”);` `System.out.println(“”);` 만 사용해서 다음 출력을 완성해 보자. 

입력 
```
System.out.print(“ ”);
System.out.print(“ ”);
System.out.print(“ ”);
System.out.print(“*”);
System.out.println(“”); 
System.out.print(“ ”);
System.out.print(“ ”);
System.out.print(“*”);
System.out.print(“*”);
System.out.println(“”); 
System.out.print(“ ”);
System.out.print(“*”);
System.out.print(“*”);
System.out.print(“*”);
System.out.println(“”); 
System.out.print(“*”);
System.out.print(“*”);
System.out.print(“*”);
System.out.print(“*”);
System.out.println(“”);
```
출력 
```
   * 
  ** 
 *** 
**** 
```
10. 다음은 `System.out.print(“*”);` `System.out.print(“ ”);` `System.out.println(“”);` 만 사용해서 다음 출력을 완성해 보자. 

입력
```
System.out.print(“ ”);
System.out.print(“ ”);
System.out.print(“*”);
System.out.println(“”);
System.out.print(“ ”);
System.out.print(“*”);
System.out.print(“*”);
System.out.print(“*”);
System.out.println(“”);
System.out.print(“*”);
System.out.print(“*”);
System.out.print(“*”);
System.out.print(“*”);
System.out.print(“*”);
System.out.println(“”);
System.out.print(“ ”);
System.out.print(“*”);
System.out.print(“*”);
System.out.print(“*”);
System.out.println(“”);
System.out.print(“ ”);
System.out.print(“ ”);
System.out.print(“*”);
System.out.println(“”);
```
출력 
```
  * 
 *** 
***** 
 *** 
  *
```
