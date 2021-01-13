#### 笔记
##### 分布式CAP理念
这个定理的内容是指的是在一个分布式系统中、Consistency（一致性）、 Availability（可用性）、Partition tolerance（分区容错性），三者不可得兼

##### Ribbon
应用内负载均衡，与Nginx区别是，Nginx是进服务器前的负载，Ribbon是本地调用RestTemplate的负载。
负载均衡轮询算法： 请求rest的次数 % server的数量
