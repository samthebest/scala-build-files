FROM ubuntu:latest

RUN apt-get update && apt-get -y install htop mc sysstat netcat net-tools lsof \
telnet traceroute wget busybox nano less ed vim man sudo zip unzip curl ssh \
openssl logrotate libc-bin locales software-properties-common

WORKDIR /root/

# Install java

RUN echo oracle-java8-installer shared/accepted-oracle-license-v1-1 select true | /usr/bin/debconf-set-selections
RUN add-apt-repository ppa:webupd8team/java
RUN apt-get update
RUN apt-get install -y oracle-java8-installer

RUN export JAVA_HOME=/usr/lib/jvm/java-8-oracle/

ENV JAVA_HOME /usr/lib/jvm/java-8-oracle/

# Install sbt

RUN echo "deb http://dl.bintray.com/sbt/debian /" | sudo tee -a /etc/apt/sources.list.d/sbt.list
RUN apt-get update
RUN apt-get -y --force-yes install sbt

ADD install-scala-jupyter.sh /root/install-scala-jupyter.sh

RUN /root/install-scala-jupyter.sh

EXPOSE 8888

ADD .jupyter /root/.jupyter

CMD ipython3 notebook
