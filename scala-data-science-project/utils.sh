#!/bin/bash

function start-notebook {
	image=$1
	docker_dir=$2

	docker images | grep $image >/dev/null

	exists=$?

	if [ "$exists" = "1" ]; then
		
		echo "######################################################################"
		echo ""
		echo "Building the docker image as it does not exist, this will only happen once"
		echo ""
		echo "#######################################################################"
		docker build -t $image $docker_dir

	fi

	notebooks=`pwd`/notebooks

	if [ "$3" != "" ]; then
		notebooks=$3
	fi

	docker run -v ~/.ivy2:/root/.ivy2 -v $notebooks:/root/notebooks $image &

	sleep 5

	cid=`docker ps -q`

	url=http://`docker inspect --format '{{ .NetworkSettings.IPAddress }}' $cid`:8888

	echo "################################################"
	echo ""
	echo "The URL for your notebook is: $url"
	echo ""
	echo "################################################"
}
