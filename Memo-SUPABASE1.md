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
## Storage
```javascript
const { data:{session} } = supabase.auth.getSession();
const currentUser = session?.user;
if(!currentUser) return;
const { data, error } = await supabase.storage
    .from('fileupload')
    .list(supabase.auth.getSession().data.session?.user?.id ?? '', {
        limit: 100,
        sortBy: { column: 'name', order: 'asc' }
    });

for (const file of data) {
    const publicUrl = `${supabaseUrl}/storage/v1/object/public/fileupload/${currentUser.id}/${file.name}`;
    console.log(publicUrl);
}
```
## Examples
### [Supabase](./pdf/supabase.pdf)
#### [Example 1 (CRUD)](https://tayaki71751.github.io/gukbi/supabase/supabase01.html)
#### [Example 2 (GitHub Login, Email Login)](https://tayaki71751.github.io/gukbi/supabase/supabase02.html)
#### [Example 3 (Email Login)](https://tayaki71751.github.io/gukbi/supabase/supabase03.html)
#### [Example 4 (REST API)](https://tayaki71751.github.io/gukbi/supabase/supabase04.html)
#### [Example 5 (Realtime)](https://tayaki71751.github.io/gukbi/supabase/supabase05.html)
### [Storage](./pdf/supabase-storage.pdf)
#### [Example 6 (Storage Upload)](https://tayaki71751.github.io/gukbi/supabase/supabase06.html)
#### [Example 7 (Storage Upload, Delete)](https://tayaki71751.github.io/gukbi/supabase/supabase07.html)
#### [Example 8 (Storage Upload with extension, Delete)](https://tayaki71751.github.io/gukbi/supabase/supabase08.html)
#### [Example 9 (Storage Upload with extension, Delete, Download)](https://tayaki71751.github.io/gukbi/supabase/supabase09.html)
### [Edge Functions](./pdf/supabase-edge.pdf)
#### [Example 10 (Edge Functions)](https://tayaki71751.github.io/gukbi/supabase/supabase10.html)
```javascript
// Setup type definitions for built-in Supabase Runtime APIs
import "jsr:@supabase/functions-js/edge-runtime.d.ts";
console.info('server started');
Deno.serve(async (req)=>{
  // CORS preflight 요청 처리
  if (req.method === 'OPTIONS') {
    return new Response(null, {
      headers: {
        'Access-Control-Allow-Origin': '*',
        'Access-Control-Allow-Methods': 'POST, OPTIONS',
        'Access-Control-Allow-Headers': 'Content-Type, Authorization',
        'Access-Control-Max-Age': '86400'
      }
    });
  }
  // 실제 POST 요청 처리
  const { name } = await req.json();
  const data = {
    message: `Hello ${name}!`
  };
  return new Response(JSON.stringify(data), {
    headers: {
      'Content-Type': 'application/json',
      'Connection': 'keep-alive',
      'Access-Control-Allow-Origin': '*'
    }
  });
});
```
#### [Example 11 (Edge Functions, CRUD)](https://tayaki71751.github.io/gukbi/supabase/supabase11.html)
```javascript
import "jsr:@supabase/functions-js/edge-runtime.d.ts";
import { createClient } from 'jsr:@supabase/supabase-js@2';
// ✅ 환경 변수에서 Supabase 설정 가져오기
const supabaseUrl = Deno.env.get('SUPABASE_URL') ?? '';
const supabaseAnonKey = Deno.env.get('SUPABASE_ANON_KEY') ?? '';
const TABLE_NAME = 'humans';
// 공통 CORS 헤더
const corsHeaders = {
  'Content-Type': 'application/json',
  'Access-Control-Allow-Origin': '*',
  'Access-Control-Allow-Methods': 'GET, POST, PUT, DELETE, OPTIONS',
  'Access-Control-Allow-Headers': 'Content-Type, Authorization'
};
Deno.serve(async (req)=>{
  try {
    if (req.method === 'OPTIONS') {
      return new Response(null, {
        headers: corsHeaders,
        status: 204
      });
    }
    // ✅ 클라이언트에서 보낸 Authorization 헤더 받기
    const authHeader = req.headers.get('Authorization');
    // ✅ Supabase 클라이언트 생성 시 Authorization 헤더 설정
    const supabase = createClient(supabaseUrl, supabaseAnonKey, {
      global: {
        headers: {
          Authorization: authHeader
        }
      }
    });
    const { method } = req;
    if (method === 'GET') {
      const { data, error } = await supabase.from(TABLE_NAME).select('*');
      if (error) throw error;
      return new Response(JSON.stringify({
        data
      }), {
        headers: corsHeaders,
        status: 200
      });
    }
    if (method === 'POST') {
      const { name, age } = await req.json();
      const { data, error } = await supabase.from(TABLE_NAME).insert([
        {
          name,
          age
        }
      ]);
      if (error) throw error;
      return new Response(JSON.stringify({
        message: '데이터가 추가되었습니다.',
        data
      }), {
        headers: corsHeaders,
        status: 201
      });
    }
    if (method === 'PUT') {
      const { id, name, age } = await req.json();
      const { data, error } = await supabase.from(TABLE_NAME).update({
        name,
        age
      }).eq('id', id);
      if (error) throw error;
      return new Response(JSON.stringify({
        message: '데이터가 업데이트되었습니다.',
        data
      }), {
        headers: corsHeaders,
        status: 200
      });
    }
    if (method === 'DELETE') {
      const { id } = await req.json();
      const { data, error } = await supabase.from(TABLE_NAME).delete().eq('id', id);
      if (error) throw error;
      return new Response(JSON.stringify({
        message: '데이터가 삭제되었습니다.',
        data
      }), {
        headers: corsHeaders,
        status: 200
      });
    }
    return new Response(JSON.stringify({
      message: '지원하지 않는 메소드입니다.'
    }), {
      headers: corsHeaders,
      status: 405
    });
  } catch (err) {
    return new Response(JSON.stringify({
      message: err?.message ?? String(err)
    }), {
      headers: corsHeaders,
      status: 500
    });
  }
});

```

#### [Example 12 (Edge Functions, Resend(Email))](https://tayaki71751.github.io/gukbi/supabase/supabase12.html)
```javascript
// File: send-email.ts
import { serve } from "https://deno.land/std@0.168.0/http/server.ts";
const RESEND_API_KEY = Deno.env.get('RESEND_API_KEY') || 'RESEND_API_KEY'; // 환경변수에서 API 키 가져오기
serve(async (req)=>{
  // CORS 설정
  const corsHeaders = {
    'Access-Control-Allow-Origin': '*',
    'Access-Control-Allow-Methods': 'POST, OPTIONS',
    'Access-Control-Allow-Headers': 'Content-Type, Authorization'
  };
  // Preflight 요청 처리
  if (req.method === 'OPTIONS') {
    return new Response(null, {
      headers: corsHeaders,
      status: 204
    });
  }
  // 인증 헤더 확인
  const authHeader = req.headers.get('Authorization');
  if (!authHeader) {
    return new Response(JSON.stringify({
      code: 401,
      message: 'Missing authorization header'
    }), {
      status: 401,
      headers: {
        ...corsHeaders,
        'Content-Type': 'application/json'
      }
    });
  }
  // 요청 처리
  try {
    const { to, subject, html } = await req.json();
    // 입력 검증
    if (!to || !subject || !html) {
      return new Response(JSON.stringify({
        code: 400,
        message: 'All fields are required'
      }), {
        status: 400,
        headers: {
          ...corsHeaders,
          'Content-Type': 'application/json'
        }
      });
    }
    // Resend API로 이메일 전송
    const resendResponse = await fetch('https://api.resend.com/emails', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
        'Authorization': `Bearer ${RESEND_API_KEY}`
      },
      body: JSON.stringify({
        from: 'onboarding@resend.dev',
        to,
        subject,
        html
      })
    });
    const data = await resendResponse.json();
    if (!resendResponse.ok) {
      throw new Error(data.message || 'Failed to send email');
    }
    return new Response(JSON.stringify(data), {
      status: 200,
      headers: {
        ...corsHeaders,
        'Content-Type': 'application/json'
      }
    });
  } catch (error) {
    return new Response(JSON.stringify({
      code: 500,
      message: error.message || 'Internal server error'
    }), {
      status: 500,
      headers: {
        ...corsHeaders,
        'Content-Type': 'application/json'
      }
    });
  }
});
```