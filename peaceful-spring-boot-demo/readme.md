spring boot 
-------

这仅是个demo，用于学习spring boot，集成下面组件

* spring boot 
* velocity

## 启动方式

* 直接在idea中运行main函数
* 打成jar包后，通过命令运行java -jar target/${jarname}.jar
* 通过maven命令启动：mvn spring-boot:run

### 启动后可访问

* Json格式响应：http://127.0.0.1:8080
* 直接访问静态页面:http://127.0.0.1:8080/index.html
* 访问velocity页面:http://127.0.0.1:8080/vm