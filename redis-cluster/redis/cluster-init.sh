#!/usr/bin bash

## 1번 redis master 노드에서 실행
# redis-cli -c -h 127.0.0.1 -p 7000

### 1, 2, 3번 노드끼리 먼저 클러스터를 생성한다.
redis-cli --cluster create 127.0.0.1:7000 127.0.0.1:7001 127.0.0.1:7002

### redis 4번 노드는 1번 노드의 Slave 이다
redis-cli -h 127.0.0.1 -p 7000 cluster meet 127.0.0.1 7003
redis-cli -h 127.0.0.1 -p 7003 cluster replicate c4f4306ef77f1a4c6d2d654e63d8dfa4acde1121

### redis 5번 노드는 2번 노드의 Slave 이다
redis-cli -h 127.0.0.1 -p 7000 cluster meet 127.0.0.1 7004
redis-cli -h 127.0.0.1 -p 7004 cluster replicate baaeac1ebba3bf7dd69d35e879b82965b1ac78da

### redis 6번 노드는 3번 노드의 Slave 이다
redis-cli -h 127.0.0.1 -p 7000 cluster meet 127.0.0.1 7005
redis-cli -h 127.0.0.1 -p 7005 cluster replicate a4494974b405f22e00728c12f1ba686544593cc8