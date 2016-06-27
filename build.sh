#!/usr/bin/env bash

echo "该项目是基础依赖项目，有新的项目需要立项时只需依赖该项目可以帮助你快速集成项目的开发环境，工具类以及其它公共服务"

echo "install peaceful-boot-parent pom"
mvn clean install -f ./peaceful-boot-parent/pom.xml || exit 1

echo "install peaceful-boot jar"
mvn clean install -f ./peaceful-boot/pom.xml || exit 1

while read line
do
    echo $line
done <  ./peaceful-boot/README.md
echo "[INFO] ------------------------------------------------------------------------"

