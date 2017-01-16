#!/usr/bin/env bash

echo "该项目是基础依赖项目，有新的项目需要立项时只需依赖该项目可以帮助你快速集成项目的开发环境"

echo "install parent pom"
mvn clean install -f ./peaceful-boot-parent/pom.xml || exit 1
mvn clean install -f ./peaceful-parent/pom.xml || exit 1

echo 'install peaceful basic jar'
mvn clean install -f ./peaceful-boot/pom.xml
mvn clean install -f ./peaceful-boot-web/pom.xml
mvn clean install -f ./peaceful-common-utils/pom.xml

