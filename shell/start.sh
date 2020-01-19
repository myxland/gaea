#!/bin/bash

cd `dirname $0`
PROJECT_DIR=$1
DEPLOY_DIR=`pwd`

PIDS=`jps | grep $PROJECT_DIR | awk '{print $1}'`
if [ -n "$PIDS" ]; then
    echo "ERROR: The $PROJECT_DIR already started!"
    echo "PID: $PIDS"
    exit 1
fi

cd $PROJECT_DIR
mvn clean package

cd target
JAR_NAME=`find . -name '*.jar'`

LOGS_DIR=$DEPLOY_DIR/logs
#如果不存在目录，则创建
if [ ! -d $LOGS_DIR ]; then
    mkdir $LOGS_DIR
fi
STDOUT_FILE=$LOGS_DIR/stdout.log

nohup java -jar $JAR_NAME > $STDOUT_FILE 2>&1 &
echo "OK!"
PIDS=`jps | grep $PROJECT_DIR | awk '{print $1}'`
echo "PID: $PIDS"