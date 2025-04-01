# 📝 스터디 메모 플랫폼

스프링 부트 교육 프로젝트입니다.  
**메모 → 사용자 → 댓글** 순으로 단계별로 기능을 구현하며, CRUD의 기본적인 흐름을 이해할 수 있습니다.

---

## 📌 프로젝트 목적

- Spring Boot 기반 실습
- RESTful API 설계 연습
- JPA와 관계 매핑 이해
- JWT 기반 로그인 인증 흐름 학습

---

## 🛠️ 기술 스택

| 기술    | 설명                 |
|-------|----------------------|
| Spring Boot | 애플리케이션 프레임워크 |
| Spring Data JPA | 데이터베이스 ORM |
| JWT   | 로그인 인증 방식      |
| Bcrypt | 비밀번호 암호화      |
| MySQL | 개발 및 테스트용 DB  |

---

## 📂 기능 구현 순서

### ✅ 1단계: 메모 기능 (JPA 기본 CRUD)
> ⚠️ 이 단계에서는 사용자 없이 구현 합니다.

- 메모 작성 (제목, 내용)
- 메모 목록 조회 (최신순 정렬)
- 메모 상세 조회
- 메모 수정 (작성자 본인만 가능)
- 메모 삭제 (작성자 본인만 가능)

---

### ✅ 2단계: 사용자 기능 (JWT 인증)

#### 회원가입
- 이메일 형식만 허용 (중복 불가)
- 비밀번호는 8자 이상 + 영문 + 숫자 포함
- 비밀번호는 Bcrypt로 암호화 저장

#### 로그인
- 이메일 + 비밀번호 입력 → JWT 발급
- JWT는 Authorization 헤더에 담아 전송

#### 사용자 인증 처리
- JWT가 유효한 경우에만 메모 수정/삭제 가능
- JWT 인증 후 내 정보 조회 가능

#### 선택 구현:
- 비밀번호 변경 (현재 비밀번호 확인 필요)

> 관계 매핑: `User (1) : Memo (N)`

---

### ✅ 3단계: 댓글 기능 (JPA 관계 매핑 연습)

- 댓글 작성 (메모에 달기)
- 댓글 목록 조회 (메모 상세조회 시 함께 표시)
- 댓글 수정/삭제 (작성자 본인만 가능)

> 관계 매핑:
> - `User (1) : Comment (N)`
> - `Memo (1) : Comment (N)`

---

## 📡 API 명세서

> 기본 URL: `http://localhost:8080`

### 🔐 사용자 인증

| 메서드 | 경로 | 설명 | 요청 예시 | 응답 |
|--------|------|------|-----------|------|
| POST | `/api/signup` | 회원가입 | `{ "email": "test@example.com", "password": "Abc12345!" }` | 201 Created |
| POST | `/api/login` | 로그인 | `{ "email": "test@example.com", "password": "Abc12345!" }` | JWT 토큰 반환 |
| GET | `/api/users/me` | 내 정보 조회 | JWT 필요 | 내 정보 JSON |
| PUT | `/api/users/password` | 비밀번호 변경 | `{ "currentPassword": "Abc12345!", "newPassword": "Xyz98765!" }` | 200 OK |
| DELETE | `/api/users` | 회원 탈퇴 | `{ "password": "Abc12345!" }` | 204 No Content |

### 📝 메모 기능

| 메서드 | 경로 | 설명 | 요청 예시 | 응답 |
|--------|------|------|-----------|------|
| POST | `/api/memos` | 메모 작성 | `{ "title": "JPA 공부", "content": "영속성 컨텍스트 정리" }` | 201 Created |
| GET | `/api/memos` | 메모 목록 조회 | - | 메모 리스트 |
| GET | `/api/memos/{id}` | 메모 상세 조회 | - | 메모 상세 |
| PUT | `/api/memos/{id}` | 메모 수정 | `{ "title": "JPA 정리", "content": "flush 설명 추가" }` | 200 OK |
| DELETE | `/api/memos/{id}` | 메모 삭제 | - | 204 No Content |

### 💬 댓글 기능

| 메서드 | 경로 | 설명 | 요청 예시 | 응답 |
|--------|------|------|-----------|------|
| POST | `/api/memos/{memoId}/comments` | 댓글 작성 | `{ "content": "좋은 정리 감사합니다!" }` | 201 Created |
| GET | `/api/memos/{memoId}/comments` | 댓글 목록 조회 | - | 댓글 리스트 |
| PUT | `/api/comments/{commentId}` | 댓글 수정 | `{ "content": "내용 수정합니다." }` | 200 OK |
| DELETE | `/api/comments/{commentId}` | 댓글 삭제 | - | 204 No Content |

---

## 🧭 ERD 다이어그램

### 관계 요약
- User (1) ↔ Memo (N)
- User (1) ↔ Comment (N)
- Memo (1) ↔ Comment (N)

