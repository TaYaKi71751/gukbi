# JSON Server
## Install
```powershell
# Windows
npm i -g json-server
```
```bash
# macOS / Linux
sudo npm i -g json-server
```
## Run
```bash
# Example 
json-server --watch ./src/db/data.json --port 3010
```
## Usage
### GET Search
```http
### This search which day is 1 in words
GET http://localhost:3010/words?day=1
```
### PUT Edit
```http
### This edits which id is 3 in words
PUT http://localhost:3010/words/3

{
    "id": "3",
    "day": 1,
    "eng": "example",
    "kor": "예제",
    "isDone": true
}
```
### POST Create
```http
### This creates new word as body
POST http://localhost:3010/words

{
    "id": "7",
    "day": 1,
    "eng": "exampleBook1",
    "kor": "예제책1",
    "isDone": true
}
```
