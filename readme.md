### 1、概述：

本框架是一套微服务框架，SpringCloud版本Greenwich.SR2，SpringBoot版本2.1.7.RELEASE，SpringCloudAlibaba版本2.1.0.RELEASE。使用微服务相关的组件：Hystrix、Feign、Nacos、Gateway、Sentinel、XXL-JOB、ELK日志相关组件。

### 2、目录结构及说明

|- zxgk-microservices

	|- zxgk-common     #通用的基础模块，常用的工具类
	|- zxgk-config     #~~微服务的配置中心~~ ***已废弃***，目前使用nacos作为配置中心
	|- zxgk-eureka     #~~微服务的注册发现中心~~***已废弃***，目前使用nacos作为服务注册发现中心
	|- zxgk-gateway    #微服务的网关服务
	|- zxgk-job        #微服务的分布式定时器
	|- zxgk-log-elk    #微服务的分布式日志分析
	|- zxgk-open-api   #微服务的对外的服务管理
		|- zxgk-car-verify-api        #微服务的对外的车辆核查
		|- zxgk-people-verify-api     #微服务的对外的人员核查
	|- zxgk-server     #微服务的对内的服务管理
	    |- zxgk-mock    #大数据模拟服务
	    |- zxgk-senseface    #商汤服务
	    |- zxgk-vehicle      #车辆二次识别
	|- zxgk-server-monitor  #微服务的服务监控管理
	|- zxgk-examples       #相关的示例

### 3、服务端口划分及说明

| 服务说明         | 服务名              | 端口      |
| ---------------- | ------------------- | --------- |
| 注册配置中心服务 | nacos服务默认端口   | 8848      |
| 网关服务         | zxgk-gateway        | 9999      |
| 分布式定时器     | zxgk-job            | 9001      |
| 日志分析服务     | zxgk-log-elk        | 9002      |
| 服务监控         | zxgk-server-monitor | 9009      |
| 对外服务接口     | zxgk-open-api       | 8000~8999 |
| 对内服务接口     | zxgk-server         | 7000~7999 |
| 示例工程     | zxgk-examples         | 6000~6999 |

### 4、基础模块说明	

注册中心：Nacos

配置中心：Nacos

动态网关：Spring Cloud Gateway

服务容错：Spring Cloud Hystrix

服务调用：Spring Cloud OpenFeign

文档管理：Swagger2

服务监控：Spring Boot Admin

日志管理：ES + Kibana、Zipkin

分表分库：ShardingSphere

缓存服务：Redis

消息组件：RocketMQ


###相关服务地址说明

Nacos服务        http://10.10.15.23/nacos     nacos/nacos

API文档聚合          http://localhost:9999/doc.html

Elasticsearch    http://10.10.15.22:9100






