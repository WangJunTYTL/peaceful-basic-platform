# peaceful-basic-platform

Global parent pom , you can use it in jar or war project as your maven parent pom setting
 
    <parent>
            <groupId>com.peaceful</groupId>
            <artifactId>peaceful-parent</artifactId>
            <version>1.0-SNAPSHOT</version>
    </parent> 

## peaceful-parent

### The basic configuration for build setting

1. project build coding:`UTF-8`
1. maven repositories:`repo2`
1. default profiles: `dev`、`test`、`product`. The project has three running env or build env:dev、test、product. you can specify the  environment by :
    
    `mvn -Penv[test][product]  compile[deploy][jetty:run]`
      
Default env is dev,ou can get the env value in pom by ${project.environment} and in Java code by invoke `Application.getRunningMode()`
    
### setting build plugin

1. buildnumber-maven-plugin:1.3 phase:validate  desc:use timestamp as build version,you can get the version value by `${timestamp}`
   in pom.xml and get the value in Java code by invoke `Application.getBuildVersion()` 
1. maven-jar-plugin:2.6
1. maven-compiler-plugin:3.3
1. maven-war-plugin:2.0.2
1. maven-resources-plugin:2.7
1. maven-source-plugin:2.4   phase:deploy
1. maven-javadoc-plugin:2.9.1 phase:deploy
1. maven-surefire-plugin:2.7  desc: default skip test
1. yuicompressor-maven-plugin:1.5.0  desc:compress style file: .js .css
1. jetty-maven-plugin:8.1.8.v20121106 desc: start web project in jetty, default port 8888，you can change web port in your pom to override Settings
 
 
    <properties>        
        <jetty.stop.port>9999</jetty.stop.port>
        <jetty.run.port>8888</jetty.run.port>
    </properties>
    
### setting dependencies    

log:slf4j log4j perf4j
test：junit
common tools:guava、commons-lang3、httpclient
json：fastjson
web：jstl、javaee-api
db:mysql、c3p0
framework:spring、springMvc、mybatis

## peaceful-common-utils

配合 parent pom 配置文件，可以读取构建的基本信息，比如构建时间、版本号、项目运行环境


