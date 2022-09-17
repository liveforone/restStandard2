# restStandard2 - 다중파일 업로드 가능한 표준 REST SERVER

## 설명 및 특징
* 파일 업로드가 가능하다.
* 파일있는 업로드와 파일 없이 업로드 둘다 모두 가능하다.

## json body
#### users - signup & login
<pre>
{
    "email" : "yc4852@gmail.com",
    "password" : "1234"
}

{
    "email" : "admin@restStandard.com",
    "password" : "1234"
}
</pre>
#### board - post(form-data 형식)
<pre>
boardDto
{
    "content" : "first text",
    "good" : 1,
    "title" : "test1"
}
application/json

uploadFile
파일선택
</pre>
* 주의 할점은 항상 dto가 먼저오고 그 다음에 파일이 와야한다.
* 또한 dto는 반드시 파일 형식을 지정해주어야한다.
* 파일없이 저장가능하며, null로 표시됨

#### board - 수정
<pre>
boardDto
{
"content" : "updated text",
"good" : 2,
"title" : "test1"
}
application/json
</pre>
* 파일은 수정 불가능

#### comment
<pre>
{
    "content" : "댓글",
    "user" : "chan",
    "boardId" : 1
}
</pre>
