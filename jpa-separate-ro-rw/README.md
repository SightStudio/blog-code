### 스프링에서 편리하게 Master / Slave 분기 처리하기

요구 사항

### 1. DB 작업   

``` sql  
-- 멀티 스키마이기 떄문에 컨테이너 생성 후 다음과 같이 DB 생성 master 노드에서 1회만 하면 복제됨   
create database board;  
create database user;   
```

```sql

-- 마지막 실행 쿼리 로그를 확인하기 위해 다음과 같이 설정 실행, 설정값은 replication이 안되므로 각 노드마다 해야함   

SET GLOBAL log_output = 'TABLE';  
SET GLOBAL general_log = 'ON';  
```
