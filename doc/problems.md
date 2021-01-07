### 子模块依赖报错，版本号显示unknown，但是本地有jar包
1. 应该是dependencyManagement 的原因，在子模块中加version后，过了一段时间，清掉version，也没报错了。。。
初步怀疑是IDE编译慢的问题，以后尽量别复制版本号到子模块中，可以避免这个问题。 
