# TypeScript
## Use enum as type
```typescript
enum Direction {
  Up = "UP",
  Down = "DOWN",
  Left = "LEFT",
  Right = "RIGHT"
}

let move: Direction = Direction.Up;
```
## Module export
```typescript
// math.ts
export const add = (a: number, b: number): number => {
  return a + b;
};
export const subtract = (a: number, b: number): number => {
  return a - b;
};
```
### export default
```typescript
// calculator.ts
export default class Calculator {
  add(a: number, b: number): number {
    return a + b;
  }
}
```

## Module import
```typescript
// app.ts
import { add, subtract } from './math';

console.log(add(2, 3));  // 5
console.log(subtract(5, 3));  // 2
```
### import default
```typescript
// app.ts
import Calculator from './calculator';

const calc = new Calculator();
console.log(calc.add(10, 20));  // 30
```
## Promise
```typescript
const promise:Promise<string> = new Promise((resolve, reject) => {
  // 비동기 작업
  let success = true; // 작업 성공 여부

  if (success) {
    resolve("작업 성공"); // 성공 시 resolve
  } else {
    reject("작업 실패"); // 실패 시 reject
  }
});


promise
  .then(result => {
    console.log(result);  // "작업 성공"
  })
  .catch(error => {
    console.log(error);   // "작업 실패"
  });
```
