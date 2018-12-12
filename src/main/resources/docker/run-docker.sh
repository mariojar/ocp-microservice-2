#!/bin/bash
PUBLIC_IP=$(curl -s 'http://169.254.169.254/latest/meta-data/public-ipv4')
HOST="$PUBLIC_IP"
echo "host: $PUBLIC_IP"

ACTIVE_PROFILE="$1"

if [ $# -lt 1 ];
then
        echo "ERROR:    Not enough params."
        echo "USAGE:    run-docker.sh <ACTIVE_PROFILE>"
else        
	docker run -d -p 8083:8083 \
	--env HOST=$HOST \
	--env ACTIVE_PROFILE=$ACTIVE_PROFILE \
	--log-driver json-file \
	--log-opt max-size=20m \
	--log-opt max-file=25 \
	--hostname $HOST \
	--name traductor-proxy \
 	rgs/traductor-proxy
fi	

