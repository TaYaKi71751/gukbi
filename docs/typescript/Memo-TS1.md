# TypeScript
## Compile & Run
### Install
```bash
npm i typescript @types/node
```
### Init
```bash
npx tsc --init
```
### Code
```typescript
// app.ts
function greet(name:string):string {
    return `Hello, ${name}!`;
}
console.log(greet("TypeScript"));
```
### Compile
```bash
npx tsc app.ts
```
### Run
```bash
node app.js
```
## Just Run
### Install
```bash
npm i ts-node typescript @types/node
```
### Init
```bash
npx tsc --init
```
### Code
```typescript
// app.ts
function greet(name:string):string {
    return `Hello, ${name}!`;
}
console.log(greet("TypeScript"));
```
### Run
```
npx ts-node app.ts
```
