FROM redis:6.2.5

RUN rm -rf /usr/local/bin/docker-entrypoint.sh
ADD redis.conf /usr/local/etc/redis/redis.conf
ADD docker-entrypoint.sh /usr/local/bin

## 권한 부여
RUN chmod 755 /usr/local/etc/redis/redis.conf
RUN chmod 755 /usr/local/bin/docker-entrypoint.sh

## 소유 변경
RUN chown redis:redis /usr/local/etc/redis/redis.conf
RUN chown redis:redis /usr/local/bin/docker-entrypoint.sh

EXPOSE $CLIENTPORT

ENTRYPOINT ["/usr/local/bin/docker-entrypoint.sh"]
CMD [ "redis-server", "/usr/local/etc/redis/redis.conf" ]