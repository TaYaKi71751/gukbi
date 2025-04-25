# supabase
## RLS policy
### [ChatGPT Explain](https://chatgpt.com/share/6809f4a0-3748-8006-8fb1-5640c2d656c4)
### role
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