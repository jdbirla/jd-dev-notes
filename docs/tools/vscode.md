## Frontend IDE
- [Angela Web Development Course Resources List ](https://www.appbrewery.co/p/web-development-course-resources)


### Pesticide for Chrome
- This extension inserts the Pesticide CSS into the current page, outlining each element to better see placement on the page.
https://chrome.google.com/webstore/detail/pesticide-for-chrome/bakpbgckdnepkmkeaiomhmfcnejndkbi

### Atom Plugins
- https://github.com/jdbirla/JD_Front_End_Repo/blob/master/Angela/Angela_Yu_Tools_Required.md

###  Online IDE
https://replit.com/signup

### VS Code Extensions
#### Angela
- Live PreviewPreview
  - Hosts a local server in your workspace for you to preview your webpages on.
  - https://marketplace.visualstudio.com/items?itemName=ms-vscode.live-server
- Prettier - Code formatter
  - Prettier is an opinionated code formatter. It enforces a consistent style by parsing your code and re-printing it with its own rules that take the maximum line length into account, wrapping code when necessary.
  - https://marketplace.visualstudio.com/items?itemName=esbenp.prettier-vscode
- vscode-icons
  - Icons for Visual Studio Code
  - https://marketplace.visualstudio.com/items?itemName=vscode-icons-team.vscode-icons
- formulahendry.auto-close-tag
  - Automatically add HTML/XML close tag, same as Visual Studio IDE or Sublime Text
- hex-ci.stylelint-plus
  - Modern CSS/SCSS/Less linter for vscode, support auto fix on save.
  - https://marketplace.visualstudio.com/items?itemName=hex-ci.stylelint-plus
- ESLint
  - Integrates ESLint JavaScript into VS Code.
  - https://marketplace.visualstudio.com/items?itemName=dbaeumer.vscode-eslint
- naumovs.color-highlight
  - This extension styles css/web colors found in your document.
  - https://marketplace.visualstudio.com/items?itemName=naumovs.color-highlight
- Live Server
  - https://marketplace.visualstudio.com/items?itemName=ritwickdey.LiveServer
  - Launch a development local Server with live reload feature for static & dynamic pages
- file-icons
    - File-specific icons in VSCode for improved visual grepping.
    - https://marketplace.visualstudio.com/items?itemName=file-icons.file-icons
#### Jonas
- Prettier - Code formatter
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/c9f5ecbb-c242-4aee-b8c7-f215140e6509)
![](https://github.com/jdbirla/jd-dev-notes/blob/master/docs/tools/pics/Screenshot_1.png)
![](https://github.com/jdbirla/jd-dev-notes/blob/master/docs/tools/pics/Screenshot_2.png)
![](https://github.com/jdbirla/jd-dev-notes/blob/master/docs/tools/pics/Screenshot_3.png)
![](https://github.com/jdbirla/jd-dev-notes/blob/master/docs/tools/pics/Screenshot_4.png)
- One Monokai Theme
![](https://github.com/jdbirla/jd-dev-notes/blob/master/docs/tools/pics/Screenshot_5.png)
- image preview
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/928f39e2-d2e2-4642-889f-4e0c3958b987)
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/89d8f58e-367a-48de-a4bd-953c7b178376)
- live server
- user snipet configure
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/f17876c7-9e7a-42b5-b06e-3575c6f93849)
- Debuggin 
 ![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/dfc30a0d-abdb-4ff6-b77f-8048343cbf91)

- user snipet for react 
- got to user snipet and paset below config
```json
{
  "Print to console": {
    "prefix": "cl",
    "scope": "javascript,typescript,javascriptreact",
    "body": ["console.log($1)"],
    "description": "console.log"
  },
  "reactComponent": {
    "prefix": "rfc",
    "scope": "javascript,typescript,javascriptreact",
    "body": [
      "function ${1:${TM_FILENAME_BASE}}() {",
      "\treturn (",
      "\t\t<div>",
      "\t\t\t$0",
      "\t\t</div>",
      "\t)",
      "}",
      "",
      "export default ${1:${TM_FILENAME_BASE}}",
      ""
    ],
    "description": "React component"
  },
  "reactStyledComponent": {
    "prefix": "rsc",
    "scope": "javascript,typescript,javascriptreact",
    "body": [
      "import styled from 'styled-components'",
      "",
      "const Styled${TM_FILENAME_BASE} = styled.$0``",
      "",
      "function ${TM_FILENAME_BASE}() {",
      "\treturn (",
      "\t\t<Styled${TM_FILENAME_BASE}>",
      "\t\t\t${TM_FILENAME_BASE}",
      "\t\t</Styled${TM_FILENAME_BASE}>",
      "\t)",
      "}",
      "",
      "export default ${TM_FILENAME_BASE}",
      ""
    ],
    "description": "React styled component"
  }
}

```
- user setting json
```json
{
  "editor.fontSize": 15,
  "editor.tabSize": 2,
  "editor.multiCursorModifier": "ctrlCmd",
  "editor.wordWrap": "on",
  "editor.formatOnSave": true,
  "window.confirmBeforeClose": "always",
  "window.openFoldersInNewWindow": "on",
  "[html]": {
    "editor.defaultFormatter": "vscode.html-language-features"
  },
  "[javascript]": {
    "editor.defaultFormatter": "esbenp.prettier-vscode"
  },
  "yaml.schemas": {
    "kubernetes": "*.yaml"
  },
  "redhat.telemetry.enabled": true,
  "workbench.colorTheme": "Monokai Pro",
  "code-runner.showExecutionMessage": false,
  "code-runner.clearPreviousOutput": true,
  "editor.minimap.enabled": false,
  "javascript.updateImportsOnFileMove.enabled": "always",
  "code-runner.executorMap": {
    "typescript": "ts-node"
  },
  "editor.defaultFormatter": "esbenp.prettier-vscode",
  "workbench.iconTheme": "material-icon-theme",
  "eslint.run": "onSave"
}
```
- Quokka : a javascript run tool 
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/97bddc20-a71d-470b-b1ff-bfa7d4db8e96)
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/78a09977-1a6d-4af6-89ad-d21374546a59)

 - ESLint setup in vite project
 ![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/1ebeedc5-e492-4e5a-b1a1-2729d40862de)
 ![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/639fe8ea-e7be-4e7e-a9ce-86b25caf49e5)
![image](https://github.com/jdbirla/jd-dev-notes/assets/69948118/b52aa325-c1d5-470c-a3c8-2d8eb4bfc5c0)


