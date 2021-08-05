#!/bin/sh

## 파이프 라인이 non-zero 값을 리턴하면 바로 exit
#set -e

### sed(stream editor): 원본 파일을 변경하지 않고 표준 출력만 조작해서 출력함
### 여기서는 redis.conf 의 표준 출력은 수정해서 사용 (원본은 변경 X)

### 호스트 설정
sed -i "s/bind 127.0.0.1/bind $CLIENTHOST 127.0.0.1/g" /usr/local/etc/redis/redis.conf

### 포트 설정
sed -i "s/port 6379/port $CLIENTPORT/g" /usr/local/etc/redis/redis.conf

### 비밀번호 설정
sed -i "s/# requirepass foobared/requirepass $REQUIREPASS/g" /usr/local/etc/redis/redis.conf

### masterauth에 비밀번호가 설정되어있으면, 슬레이브 추가시 인증요청을 강제함
sed -i "s/# masterauth <master-password>/masterauth $REQUIREPASS/g" /usr/local/etc/redis/redis.conf

### 마스터 포트의 값이 존재할 경우 = 처리
if [ "$MASTERPORT" != "" ]; then
  sed -i "s/# slaveof <masterip> <masterport>/slaveof $MASTERHOST $MASTERPORT/g" /usr/local/etc/redis/redis.conf
fi

## first arg is `-f` or `--some-option`
## or first arg is `something.conf`
#if [ "${1#-}" != "$1" ] || [ "${1%.conf}" != "$1" ]; then
#	set -- redis-server "$@"
#fi
#
## allow the container to be started with `--user`
#if [ "$1" = 'redis-server' -a "$(id -u)" = '0' ]; then
#	chown -R redis .
#	exec su-exec redis "$@"
#fi
#
#exec "$@"