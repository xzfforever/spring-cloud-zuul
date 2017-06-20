##Spring Cloud Zuul
<li>API Gateway架构图<br/>
![](https://raw.githubusercontent.com/xzfforever/images/master/zuul/api-gateway.png)
<li>API Gateway职责通常有：
>1、负责请求转发、协议转换<br/>
>2、负责请求结果聚合<br/>
>3、授权、监控、负载均衡<br/>
>4、权限控制、动态路由<br>

<li>Spring Cloud提供Zuul组件来实现API Gateway
<li>在Zuul中，要实现权限控制，需要继承ZuulFilter并重载其中的方法





<li>参考资料
>http://blog.csdn.net/a60782885/article/details/69486566[Spring Cloud入门3——API Gateway(权限控制)]
