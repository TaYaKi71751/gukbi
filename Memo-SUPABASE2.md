# Supabase
## Join
### Outer Join
#### N : 1
```javascript
const { data } = await supabase
  .from('posts')
  .select(`
    id,
    title,
    users(id, name)
  `);
```
```json
[
  {
    "id": "post1",
    "title": "첫 글",
    "users": { "id": "user1", "name": "김철수" } // 단일 객체
  },
  {
    "id": "post2",
    "title": "두번째",
    "users": { "id": "user1", "name": "김철수" }
  },
  {
    "id": "post3",
    "title": "공지",
    "users": { "id": "user2", "name": "박영희" }
  }
]
```
#### 1 : N
```javascript
const { data } = await supabase
  .from('users')
  .select(`
    id,
    name,
    posts(id, title)
  `);
```
```json
[
  {
    "id": "user1",
    "name": "김철수",
    "posts": [ // 배열로 반환 (1:N 관계)
      { "id": "post1", "title": "첫 글" },
      { "id": "post2", "title": "두번째" }
    ]
  },
  {
    "id": "user2",
    "name": "박영희",
    "posts": [
      { "id": "post3", "title": "공지" }
    ]
  }
]
```
### Inner Join
```javascript
const { data } = await supabase
  .from('users')
  .select(`
    id,
    name,
    posts!inner(id, title)
  `)
  .eq('name', '김철수');
```
```json
[
  {
    "id": "user1",
    "name": "김철수",
    "posts": [
      { "id": "post1", "title": "첫 글" },
      { "id": "post2", "title": "두번째" }
    ]
  }
]
```
## JSONB