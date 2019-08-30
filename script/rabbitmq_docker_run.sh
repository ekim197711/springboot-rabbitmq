#!/bin/bash
container=rabbitmq
docker rm -f "$rabbitmq"

docker run \
-p 15672:15672 -p 5672:5672 \
-d --hostname myrabbit \
--name "$container" \
rabbitmq:3-management