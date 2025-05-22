### [Github Actions for Github Pages](https://github.com/sitek94/vite-deploy-demo)
### [Example Repository](https://github.com/TaYaKi71751/vite-react-02)
### [Example Page](https://tayaki71751.github.io/vite-react-02)
1. Edit `vite.config.ts` like below
```typescript
import { defineConfig } from 'vite'
import react from '@vitejs/plugin-react'

// https://vite.dev/config/
export default defineConfig({
  base: '/<REPOSITORY_NAME>',
  plugins: [react()],
})
```
2. Edit `BrowserRouter` like below
```tsx
export default function App(){
    return (
    <BrowserRouter basename={import.meta.env.BASE_URL}>
    </BrowserRouter>
    );
}
```
3. For html using href, Use `Link` from `react-router-dom` like `<Link to="/">Home</Link>`
4. For bootstrap using href, edit `<* href="/">Link</*>` to `<* as={Link} to="/">Link<*>`
```tsx
/* Example */
import { Nav,Navbar } from 'react-bootstrap';
import { Link } from 'react-router-dom';
function App(){
    return (
        <Navbar.Brand as={Link} to="/"><h1>BookStore</h1></Navbar.Brand>
        <Nav.Link as={Link} to="/">
            Home
        </Nav.Link>
    );
}
```
5. Append ` && cp dist/index.html dist/404.html` to `scripts.build` in `package.json`
6. For images on `public/`, use like below
```jsx
function Logo(){
    return (
        <img src={`${import.meta.env.BASE_URL}/images/logo.png`} />
    );
}
```
7. Fix `noUnusedLocals`, `noUnusedParameters` to false in `tsconfig.app.json`,`tsconfig.node.json`
8. Go to repository settings, then click Actions tab in settings, then click General in Actions
9. Scroll down to `Workflow permissions`, then select `Read and write permissions`, then click Save below them 
10. Add below code to .github/workflows/Deploy.yml
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
11. When Actions completed, go to repository settings, then click Pages in settings
12. In `Branch` section, click `None` then select `gh-pages`
13. Click `Save` button in `Branch` section
