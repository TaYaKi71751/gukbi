# Vite
## React
### Create Project
```bash
pnpm create vite@latest vite-react-01
```
### Setup
```bash
pnpm i
pnpm i react-bootstrap bootstrap bootstrap-icons
```
### Run
```bash
pnpm dev
```
### [Bootstrap](https://react-bootstrap.netlify.app/)
```tsx
import React, { useState } from 'react';
import {Button,Container,Row,Col,Form} from 'react-bootstrap';
```
```tsx
/** Modal Example **/
import {Button, Modal} from 'react-bootstrap';
type Todo = {
    id : number;
    text : string;
    isChecked : boolean;
};

type TodoModalProps = {
    show : boolean;
    handleClose : () => void;
    todo : Todo | null;
}

/** You can set type of props like this **/
const TodoModal:React.FC<TodoModalProps> = ({show, handleClose, todo})=>{

    return(
        <Modal show={show} onHide = {()=>{handleClose()}} centered>
            <Modal.Header closeButton>
                <Modal.Title>상세정보</Modal.Title>
            </Modal.Header>
            <Modal.Body>
                {todo?.text}의 자세한 정보를 출력합니다.
                <p>현재날짜 : {new Date().toLocaleDateString()}</p>
            </Modal.Body>
        </Modal>
    )
}
```
