#!/bin/bash

# Script to install Scala Jupyter

set -e

sudo apt-get -y install ipython
sudo apt-get -y install python-pip

sudo apt-get update && sudo apt-get install -y python3-dev python3-pip build-essential libzmq3-dev
sudo pip3 install virtualenv
sudo pip3 install pyzmq

python3 -c 'import zmq; print(zmq.zmq_version())'

sudo pip3 install --upgrade "ipython[all]"

# 2.11 kernal
wget https://oss.sonatype.org/content/repositories/snapshots/com/github/alexarchambault/jupyter/jupyter-scala-cli_2.11.6/0.2.0-SNAPSHOT/jupyter-scala_2.11.6-0.2.0-SNAPSHOT.zip

unzip jupyter-scala_2.11.6-0.2.0-SNAPSHOT.zip

chmod +x jupyter-scala_2.11.6-0.2.0-SNAPSHOT/bin/jupyter-scala

./jupyter-scala_2.11.6-0.2.0-SNAPSHOT/bin/jupyter-scala || echo "Already have jupyter-scala kernal 2.11"

# 2.10 kernal
wget https://oss.sonatype.org/content/repositories/snapshots/com/github/alexarchambault/jupyter/jupyter-scala-cli_2.10.5/0.2.0-SNAPSHOT/jupyter-scala_2.10.5-0.2.0-SNAPSHOT.zip

unzip jupyter-scala_2.10.5-0.2.0-SNAPSHOT.zip

chmod +x jupyter-scala_2.10.5-0.2.0-SNAPSHOT/bin/jupyter-scala

./jupyter-scala_2.10.5-0.2.0-SNAPSHOT/bin/jupyter-scala || echo "Already have jupyter-scala kernal 2.10"

rm jupyter-scala_2.10.5-0.2.0-SNAPSHOT.zip jupyter-scala_2.11.6-0.2.0-SNAPSHOT.zip

sudo pip3 install jupyter_console


# Finally to run: ipython3 notebook
