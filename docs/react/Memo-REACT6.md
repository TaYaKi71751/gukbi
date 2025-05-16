# React
## useState
### Checkbox Example
#### [App.js](https://github.com/TaYaKi71751/react-01/blob/cdedab9f1faf1e7707996254007b76ee79cd5dc4/src/App.js)
## [useReducer](https://react.dev/reference/react/useReducer)
### Counter Example
#### [App.js](https://github.com/TaYaKi71751/react-01/blob/693c7d05f5fe872f6beaa2b86dffd27b9b1cedd2/src/App.js)
### Usage
`const [state, dispatch] = useReducer(reducer, initialState);`에서

state는 현재 상태를 나타내는 변수입니다.

dispatch는 상태를 업데이트하기 위해 액션을 보내는 함수입니다.

- useReducer에서 사용할 로직들을 구현한다.
- 값변경시 화면에 변경된 값을 바로바로 표현해줄 변수를 생성한다.
- 로직과 변수로 userReducer메소드를 이용해서 state와dispatch를 얻는다.
- 변경된 데이터를 그때그때 보여줄 state변수 기술 디스패치 함수를 사용하여 액션을 보냄 
## Running old react
```bash
npm install
export NODE_OPTIONS=--openssl-legacy-provider
npm install react-scripts@latest
npm start
```
### Fix npm permission
```bash
sudo chown -R 501:20 "${HOME}/.npm"
```
## React setups
```bash
# For react router
npm install react-router-dom
# For material ui
npm install @mui/material 
# For style
npm install @emotion/react @emotion/styled
# For icons
npm install @mui/icons-material
# For animated effects
npm install framer-motion@12.6.2
```
## Directory structure
[machadop1407/react-website-tutorial](https://github.com/machadop1407/react-website-tutorial)
- [src](https://github.com/machadop1407/react-website-tutorial/tree/main/src)
> - [assets](https://github.com/machadop1407/react-website-tutorial/tree/main/src/assets)
> - [components](https://github.com/machadop1407/react-website-tutorial/tree/main/src/components)
> - [helpers](https://github.com/machadop1407/react-website-tutorial/tree/main/src/helpers)
> - [pages](https://github.com/machadop1407/react-website-tutorial/tree/main/src/pages)
> - [styles](https://github.com/machadop1407/react-website-tutorial/tree/main/src/styles)
