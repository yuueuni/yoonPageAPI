# yoonPage API

## 개요
이 프로젝트는 [이커머스 서비스]로 개발되었으며, 상품과 주문 처리를 구현한 프로젝트 입니다.

## 기술 스택
- Java 17
- Spring Boot 3.x
- Gradle 8.4
- MySQL 8.3

## 실행 방법
1. [Java](https://www.oracle.com/java/technologies/javase-downloads.html)를 설치하세요.
2. [Gradle](https://gradle.org/install/)을 설치하세요.
3. 프로젝트를 클론합니다: `git clone https://github.com/yuueuni/yoonPageApi.git`
4. 프로젝트 폴더로 이동합니다: `cd yoonPageApi`
5. Docker를 실행합니다: `docker compose up -d`
6. 프로젝트를 빌드합니다: `gradle build`
7. 어플리케이션을 실행합니다: `java -jar build/libs/your-project.jar`

## 설정 방법
- DB 계정 정보 환경변수 등록이 필요합니다.
```env
DB_USERNAME={username}
DB_PASSWORD={password}
```

## 참고 자료
- [DB ERD](https://dbdiagram.io/d/commerce-6553ad837d8bbd64652df98f)
