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
### [Github Actions for Github Pages](https://github.com/sitek94/vite-deploy-demo)
1. Add `https://<USERNAME>.github.io/<REPOSITORY>` to `homepage` in `package.json`
2. Append ` && cp dist/index.html dist/404.html` to last of `scripts.build` in package.json
3. Go to repository settings, then click Actions tab in settings, then click General in Actions
4. Scroll down to `Workflow permissions`, then select `Read and write permissions`, then click Save below them 
5. Add below code to .github/workflows/Deploy.yml
```yml
name: Deploy

on:
  push:
    branches:
      - main

jobs:
  build:
    name: Build
    runs-on: ubuntu-latest

    steps:
      - name: Checkout repo
        uses: actions/checkout@v4

      - name: Setup Node
        uses: actions/setup-node@v4

      - name: Install dependencies
        uses: bahmutov/npm-install@v1

      - name: Build project
        run: npm run build
        env:
          CI: false
      - name: Post-build cleanup
        run: |
          node << 'EOF'
            const fs = require('fs');
            const path = require('path');
            const packageJson = require('./package.json');
            const indexPath = path.join(`${process.env.PWD}`, 'dist', 'index.html');
            const indexContent = fs.readFileSync(indexPath, 'utf8');
            const updatedContent = indexContent.replaceAll(`"/assets`, `"${packageJson.homepage}/assets`);
            fs.writeFileSync(indexPath, updatedContent);
          EOF

      - name: Upload production-ready build files
        uses: actions/upload-artifact@v4
        with:
          name: production-files
          path: ./dist

  deploy:
    name: Deploy
    needs: build
    runs-on: ubuntu-latest
    if: github.ref == 'refs/heads/main'

    steps:
      - name: Download artifact
        uses: actions/download-artifact@v4
        with:
          name: production-files
          path: ./dist

      - name: Deploy to GitHub Pages
        uses: peaceiris/actions-gh-pages@v4
        with:
          github_token: ${{ secrets.GITHUB_TOKEN }}
          publish_dir: ./dist
```
6. When Actions completed, go to repository settings, then click Pages in settings
7. In `Branch` section, click `None` then select `gh-pages`
8. Click `Save` button in `Branch` section
