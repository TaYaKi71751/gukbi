# Vite
## React
### [IntersectionObserver](https://developer.mozilla.org/ko/docs/Web/API/IntersectionObserver)
### Redux
```
Redux는 애플리케이션의 상태를 관리하는 라이브러리입니다
```
```
Redux Persist는 Redux의 상태(state)를 브라우저의 로컬 스토리지(localStorage) 또는 세션 스토리지(sessionStorage) 에 저장하는 라이브러리입니다.
```
#### Redux란?
- 애플리케이션의 상태(state)를 전역에서 관리할 수 있게 도와주는 자바스크립트 라이브러리입니다. 
- 컴포넌트 간 공통된 데이터를 효율적으로 공유할 수 있음
- state를 중앙 저장소(store)에 모아놓고 사용
- dispatch(함수호출)로 액션을 보내고, reducer(함수정의)가 그에 따라 상태를 변경함
- React 외의 다른 라이브러리/프레임워크에서도 사용 가능
#### Redux Persist란?
- Redux의 상태를 브라우저의 localStorage 또는 sessionStorage에 자동으로 저장/복원해주는 라이브러리입니다.
- 새로고침하거나 앱을 껐다 켜도 상태가 유지됨
- 사용자가 로그인한 상태나 장바구니 같은 데이터를 유지할 수 있음
#### Install
```bash
# For JavaScript
npm install @reduxjs/toolkit react-redux
# Required additional package for TypeScript
npm install --save-dev @types/react-redux
```
#### [Redux Counter Example](https://github.com/TaYaKi71751/vite-react-ts-redux-01)
### Redux Persist
#### Install
```bash
npm install redux-persist @types/redux-persist
```
#### [Redux Persist Counter Example](https://github.com/TaYaKi71751/vite-react-ts-redux-02)

