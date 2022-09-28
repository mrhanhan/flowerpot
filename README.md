<p style="text-align: center;" align="center">
    <img src="https://gitee.com/nut-cloud/flowerpot/raw/master/doc/images/logo.gif" alt="花盆">
</p>
<div style="text-align: center;"  align="center">
    <h2  style="text-align: center;"  align="center">花盆</h2>
</div>
<div align="center">
<a href='https://gitee.com/nut-cloud/flowerpot/stargazers'><img src='https://gitee.com/nut-cloud/flowerpot/badge/star.svg?theme=dark' alt='star'></img></a>
<a href='https://gitee.com/nut-cloud/flowerpot/stargazers'><img src='https://gitee.com/nut-cloud/flowerpot/badge/fork.svg?theme=dark' alt='star'></img></a>
</div>
<hr/>

### 起源
<p style="text-indent: 2em;">
    花盆项目灵感来哦源于舍友玩的植物大战僵尸中的花盆。想要有所成就，守卫家园保护大脑不被僵尸吃掉，就需要在花盆里种植植物进行在花盆中种植植物进抵挡僵尸的进攻。
</p>

### 模块说明

```lua
    flowerapot
    ├── flowerapot-code-generator           -- 代码生成器模块
    |   ├── flowerpot-universal-code-generator  -- 通用的代码生成器
    ├── flowerapot-service                       -- service 根模块
    |   ├── flowerapot-authorize                 -- 认证服务模块 根模块
    |   |   ├── flowerapot-authorize-common         -- 认证服务 通用模块、实体枚举、工具类
    |   |   ├── flowerapot-authorize-service        -- 认证服务 服务模块
    |   |   ├── flowerapot-authorize-api            -- 认证服务 对外开发的接口模块
    |   ├── flowerapot-mailbox                   -- 邮箱服务模块 根模块
    |   |   ├── flowerapot-mailbox-common           -- 邮箱服务 通用模块、实体枚举、工具类
    |   |   ├── flowerapot-mailbox-service          -- 邮箱服务 服务模块
    |   |   ├── flowerapot-mailbox-api              -- 邮箱服务 对外开发的接口模块
    |   |   ├── flowerapot-mailbox-auto...          -- 邮箱服务 自动配置模块
    |   ├── flowerapot-storage                    -- 存储服务模块 根模块
    |   |   ├── flowerapot-storage-common           -- 存储服务 通用模块、实体枚举、工具类
    |   |   ├── flowerapot-storage-api              -- 存储服务 对外开发的接口模块
    |   |   ├── flowerapot-storage-service          -- 存储服务 服务模块
    |   |   ├── flowerapot-storage-auto...          -- 存储服务 自动配置模块
    |   ├── flowerapot-system-service          -- 系统服务模块 根模块
    |   |   ├── flowerapot-system-common            -- 系统服务 通用模块、实体枚举、工具类
    |   |   ├── flowerapot-system-service           -- 系统服务 服务模块
    |   |   ├── flowerapot-system-api               -- 系统服务 对外开发的接口模块
    ├── flowerapot-admin                    -- admin 模块
    |   ├── flowerapot-admin-web                -- admin 外部接口模块
    ├── flowerapot-common                   -- 通用模块
    ├── sql                                 -- 全局SQL存放位置 一般来讲，每个需要入库数据的模块，都会对应一个目录
    |   ├── flowerapot-admin-web                -- Admin Web 模块SQL
    
```
### 开发原则
 1. 业务模块不涉第三方组件（例如: Zookeeper, Redis, 等等,可以使用间接方式对第三方功能组件进行支持) 具体需要看业务功能。非强制性约定。三思而后行
 2. 所有功能必须归类，不可直接随意放到一个模块中。三思而后行
 3. 服务之间只能依赖 flowerpot-xxx-service-common、flowerpot-xxx-service-api。
 4. 所有服务模块都应当遵守 common, api, dao, impl, autoconfigure, rpc, web 分包 （按需而立）
 5. 普通方法(保存，更新，删除，详情【并不是必须的，一般复炸结构才需要】，记录) 对应方法命名(save, update, delete, detail, get)
    
### 技术栈
#### 后端技术
|技术名称|版本|说明|官网
|----|----|----|-----|
|Spring Boot    |2.3.2.RELEASE| 构建服务     |[https://spring.io/projects/spring-boot](https://spring.io/projects/spring-boot) , [（中文）https://www.bookstack.cn](https://www.bookstack.cn/read/springboot/README.md)|
|Spring Cloud   |Hoxton.SR6   | 微服务解决方案|[https://spring.io/projects/spring-cloud/](https://spring.io/projects/spring-cloud/), [（中文）https://www.bookstack.cn](https://www.bookstack.cn/read/spring-cloud-docs/README.md)|
|Mybatis Plus   |3.3.2        | ORM        |[https://baomidou.com](https://baomidou.com/)|
|Maven          |             | 构建项目     |[http://maven.apache.org](http://maven.apache.org/)|

### 文档
1. [Maven包依赖管理](./doc/maven.md)
2. 服务说明  
    2.1. [存储服务说明](./doc/service/flowerpot-storage-service.md)  
    2.2. [邮件服务说明](./doc/service/flowerpot-mailbox-service.md)  
    2.3. [授权服务说明](./doc/service/flowerpot-authroize-service.md)
3. flowerpot-admin  
    3.1. [后台服务说明](./doc/flowerpot-admin/flowerpot-admin-web.md)
 