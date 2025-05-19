### [Github Actions for Github Pages](https://github.com/sitek94/vite-deploy-demo)
1. Add `https://<USERNAME>.github.io/<REPOSITORY>` to `homepage` in `package.json`
2. Go to repository settings, then click Actions tab in settings, then click General in Actions
3. Scroll down to `Workflow permissions`, then select `Read and write permissions`, then click Save below them 
4. Add below code to .github/workflows/Deploy.yml
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
            const notFoundPath = path.join(`${process.env.PWD}`, 'dist', '404.html');
            const indexContent = fs.readFileSync(indexPath, 'utf8');
            const updatedContent = indexContent.replaceAll(`"/assets`, `"${packageJson.homepage}/assets`);
            fs.writeFileSync(indexPath, updatedContent);
            fs.writeFileSync(notFoundPath, updatedContent);
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
5. When Actions completed, go to repository settings, then click Pages in settings
6. In `Branch` section, click `None` then select `gh-pages`
7. Click `Save` button in `Branch` section
