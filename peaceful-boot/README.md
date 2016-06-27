# peaceful boot

快速集成项目

1. 管理公共依赖包，常用的包会通过该项目一次性引入进来，如common-lang3、guava、Json、log、test 等等,另外也会在这里增加常用的工具类，如日期、唯一Id生成
等等
2. 管理项目配置，该项目下peaceful-boot-reference.properties作为默认的配置信息，你也可以在classpath下放入application.properties作为
你的配置文件覆盖相同的配置KEY或增加新的配置KEY，并通过Application.getConfigContext获取合并后的配置信息
3. 运行环境区分，你可以通过在application.properties中通过设置running.env配置环境，并可以通过Application.isDev、isTest、isProduct方法
判断当前运行环境
