# Redis Project 설정
## Redis 연동 방법
> Spring을 통해 Global Cache을 외부에 설치하여 다양한 서비스에서 캐싱하여 사용할 수 있다.
> 이 문서에서는 별도 설치된 Redis를 Spring Data Redis를 통행 Global Cache로 설정하고 RedisOperator 라는 공통기능을 이용하여 접근하고 사용하는 방법에 대하여 설명한다.
1. 로컬 설치
> Redis 설치 방법은 여러 설치 방법이 있다. 각자의 로컬 환경에 맞게 설치 한다.

1-1. Docker Redis 설치
```
docker pull redis:7.0.8-alpine 
docker images
docker run -d -p 6379:6379 redis:7.0.8-alpine
docker ps
```
* docker pull로 내려 받는다.
* docker images 확인
* docker run 으로 redis 실행한다.
* docker ps redis 컨테이터 상태를 확인 한다.

2. pom.xml 설정
```
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-redis</artifactId>
        </dependency>
```
* pox.xml redis dependency 추가 한다.

3. application.yaml에 접속 정보를 추가 한다.
```
spring:
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://localhost:3306/samp?autoReconnect=true&useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Seoul&useUnicode
    username: root
    password: 1234
    hikari:
      pool-name: hikari-cp
      maximum-pool-size: 30
      minimum-idle: 2
      data-source-properties:
        cachePrepStmts: true
        prepStmtCacheSize: 250
        prepStmtCacheSqlLimit: 2048
        useServerPrepStmts: true
  redis:
    host: localhost
    port: 6379
    timeout: 3000
```
* host, posrt 정보를 입력한다.
