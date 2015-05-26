# peaceful-basic-platform

> 这里是一些琐碎的文件，不会涉及到具体公司内部业务，但它是自己一些工程基本的通用配置

### peaceful-parent
#### maven各个生命周期的基本配置
> 包括maven特定的几个构建周期，还包括构建环境配置，版本号控制，css，js文件压缩，javadoc生成，source源码上传，以及测试插件

### peaceful-web-parent
#### 基本jar包版本控制
> 普通java项目和web项目也许会依赖的jar包管理，比如Google guava，spring ,javaee,mysql等等

### peaceful-common-utils
#### 一些基础的工具包，比如处理字符串，集合，日期，环境，加密 ...
>
    日期处理 DateUtils
    加密处理 MD5Utils Base64Utils
    运行环境 EnvironmentUtils
    properties文件读取 AppConfigs


### peaceful-web-utils
#### web项目要用到的一些基本工具类
>
    配合maven插件使用
    Application 项目全局信息，比如获取运行环境，构建版本号
    servlet request response cookie 对象操作类Http
        在同一线程上下文下可以直接通过Http拿到当前的request和response对象，这可以借助于HttpContextFilter过滤器类拦截每次请求并把每次请求信息放入到Http变量中
        所以使用http类之前，需要在web项目中配置拦截器类





