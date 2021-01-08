### 子模块依赖报错，版本号显示unknown，但是本地有jar包
1. 应该是dependencyManagement 的原因，在子模块中加version后，过了一段时间，清掉version，也没报错了。。。
初步怀疑是IDE编译慢的问题，以后尽量别复制版本号到子模块中，可以避免这个问题。 

#### 搭建eureka server时依旧出现
看视频源码也是没有指定version，却可以运行，我这里必须指定version？？？
```xml
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>
    <version>2.2.1.RELEASE</version>
</dependency>
```

### eureka server第一次运行出现NoSuchMethodError
```
java.lang.NoSuchMethodError: javax.servlet.ServletContext.getVirtualServerName()Ljava/lang/String;
```
应该是默认使用了servlet-api3.0一下的包，在项目依赖包中（Project Structure）找到2.x的包，删掉重新运行即可。
这里怀疑是优先加载了servlet-api2.5，从而没有使用springboot默认的tomcat-embed包中的servlet。



