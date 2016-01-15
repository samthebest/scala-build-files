#!/bin/bash

docker images | grep scala-jupyter >/dev/null

exists=$?

if [ "$exists" = "1" ]; then
	
	echo "######################################################################"
	echo ""
	echo "Building the docker image as it does not exist, this will only happen once"
	echo ""
	echo "#######################################################################"
	docker build -t scala-notebook docker

fi

notebooks=`pwd`/notebooks

if [ "$1" != "" ]; then
	notebooks=$1
fi

docker run -v ~/.ivy2:/root/.ivy2 -v $notebooks:/root/notebooks scala-jupyter &

sleep 5

cid=`docker ps -q`

url=http://`docker inspect --format '{{ .NetworkSettings.IPAddress }}' $cid`:8888

echo "################################################"
echo ""
echo "The URL for your notebook is: $url"
echo ""
echo "################################################"
