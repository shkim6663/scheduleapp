##  프로젝트 소개
간단한 일정 관리 애플리케이션입니다.  
사용자는 일정을 생성, 조회, 수정, 삭제(CRUD)할 수 있으며, 각 일정에 댓글을 작성하고 삭제할 수 있습니다.

---

##  주요 기능
1. 일정 관리

    - 일정 생성, 조회, 수정, 삭제

3. 댓글 관리

    - 일정에 댓글 작성, 조회, 삭제

---

## 실행 방법
1. 프로젝트 클론

\`\`\`bash
git clone https://github.com/shkim6663/scheduleapp.git
cd scheduleapp
\`\`\`


2. Postman에서 테스트

\`\`\`
# 일정

일정 생성 -POST   http://localhost:8080/schedules

일정조회 - GET    http://localhost:8080/schedules

선택 일정 조회 - GET    http://localhost:8080/schedules/{id}

일정 수정 - PUT    http://localhost:8080/schedules/{id}?password=1234

일정 삭제 - DELETE http://localhost:8080/schedules/{id}

# 댓글

POST   http://localhost:8080/schedules/{id}/comments

GET    http://localhost:8080/schedules/{id}/comments

DELETE http://localhost:8080/schedules/{scheduleId}/comments/{commentId}
\`\`\`

---

## 📁 프로젝트 구조

\`\`\`
src
 └─ main
     ├─ java
     │   └─ org.example
     │       ├─ controller
     │       ├─ dto
     │       ├─ model
     │       └─ service
     └─ resources
         └─ application.properties
\`\`\`


