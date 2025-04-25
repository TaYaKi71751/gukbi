# supabase
## RLS policy
### [ChatGPT Explain](https://chatgpt.com/share/6809f4a0-3748-8006-8fb1-5640c2d656c4)
### humans
```sql
-- RLS를 활성화해야 합니다.
ALTER TABLE public.humans ENABLE ROW LEVEL SECURITY;
```
#### select
```sql
CREATE POLICY policy_humans_select
ON public.humans
FOR SELECT
TO authenticated
USING (true); -- 조건 없이 로그인된 사용자 모두 조회 
```
#### insert
```sql
CREATE POLICY policy_humans_insert
ON public.humans
FOR INSERT
TO authenticated
WITH CHECK (true); -- 조건 없이 로그인된 사용자 모두 삽입 가능
```
#### update
```sql
CREATE POLICY policy_humans_update
ON public.humans
FOR UPDATE
TO authenticated
USING (true)
WITH CHECK (true);
```
#### delete
```sql
CREATE POLICY policy_humans_delete
ON public.humans
FOR DELETE
TO authenticated
USING (true);
```
### users
```sql
CREATE POLICY "users_policy_delete"
ON public.users
FOR DELETE
TO authenticated
USING (
EXISTS (
SELECT 1 FROM users WHERE id = auth.uid() AND role = 'supaadmin'
)
);
```
```sql
CREATE POLICY "users_policy_select"
ON public.users
FOR SELECT
TO authenticated
USING (
    id = auth.uid()
);
```
```sql
CREATE POLICY "users_policy_insert"
ON public.users
FOR INSERT
TO authenticated
USING (
EXISTS (
SELECT 1 FROM users WHERE id = auth.uid() AND role = 'supaadmin'
)
);
```
```sql
CREATE POLICY "users_policy_update"
ON public.users
FOR UPDATE
TO authenticated
USING (
EXISTS (
SELECT 1 FROM users WHERE id = auth.uid() AND role = 'supaadmin'
)
);
```
## Examples
### [Example 1 (CRUD)](https://tayaki71751.github.io/gukbi/supabase/supabase01.html)
### [Example 2 (GitHub Login, Email Login)](https://tayaki71751.github.io/gukbi/supabase/supabase02.html)
### [Example 3 (Email Login)](https://tayaki71751.github.io/gukbi/supabase/supabase03.html)
### [Example 4 (REST API)](https://tayaki71751.github.io/gukbi/supabase/supabase04.html)