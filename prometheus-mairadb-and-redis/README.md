### 프로메테우스 + 그라파나로 메트릭 지표 구성

대상   
- Mariadb  
- Mariadb/Galera Cluster  
- Redis Cluster  

redis-cluster의 경우 도커 이미지 별도로 사용  
Docker for Window 환경에서 실험했기 때문에 호스트를 ```host.docker.internal```로 잡음

```
docker run -e "IP=0.0.0.0" -p 7000-7005:7000-7005 grokzen/redis-cluster:latest
```

