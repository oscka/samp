# samp
MSA 레퍼런스 아키텍처

## 개발 환경
* 라이트한 공통 코드 common 패키지로 구성
  * Srping boot 3.0.0
* CQRS 샘플 API 개발
## 샘플 마이크로 서비스
* 공통 모듈 적용
* RestAPI Service
* Spring JDBC + Spring Data JDBC 이용한 CQRS
* OpenFeign 연동
* 문서화(OpenAPI)

## OpenAPI Swagger UI
* http://localhost:8080/swagger-ui/index.html

## Docker mysql 설치
```
docker pull mysql:8.0
docker run --name mysql-container -e MYSQL_ROOT_PASSWORD=1234 -d -p 3306:3306 mysql:8.0
```

