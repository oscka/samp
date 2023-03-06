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

# MySQL Docker 컨테이너 중지
$ docker stop mysql-container

# MySQL Docker 컨테이너 시작
$ docker start mysql-container

# MySQL Docker 컨테이너 재시작
$ docker restart mysql-container
```

## MySql Docker 컨테이너 접속
```
docker exec -it mysql-container bash

mysql -u root -p

show databases;
```

## docker compose 설치 방법
* docker-compose.yaml
```
version: '3'
services:
  mysql:
    image: mysql:8.0
    container_name: mysql
    ports:
      - 3306:3306 # HOST:CONTAINER
    environment:
      MYSQL_ROOT_PASSWORD: admin
    command:
      - --character-set-server=utf8mb4
      - --collation-server=utf8mb4_unicode_ci
    volumes:
      - D:/mysql/data:/var/lib/mysql
```
* docker 실행 및 container 접속
```
# 컨테이너 생성 및 실행
docker-compose -f docker-compose.yaml up -d

# 컨테이너만 조회
docker ps -a
```
* docker 컨테이너 접속
```
docker exec -it mysql /bin/bash

mysql -u root -p
```

