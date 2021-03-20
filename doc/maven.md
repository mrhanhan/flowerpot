# Maven 复杂结构管理
    直接重点。 dependencyManagement 和 类似 (spring-boot-dependencies) 这种关系；



```lua
    |-- pom.xml (顶级，管理版本，以及一些其他的东西)
    |-- |-- pom.xml (flowerpot-admin, 管理admin 依赖的pom， 下面的XML是 此pom的一部分)
    |-- |-- |-- ...pom (flowrpot-admin 下面具体模块的pom)
    |-- |--...pom (其他模块pom)
```

```xml

<!--  -->
<dependencyManagement>
    <dependencies>
        <!-- 导入花盆系统服务依赖管理， 一定要指定版本。做好层级管理，否在会循环引用-->
        <dependency>
            <groupId>com.flowerpot</groupId>
            <artifactId>flowerpot-system-service</artifactId>
            <version>${flowerpot.service.version}</version>
            <scope>import</scope>
            <type>pom</type>
        </dependency>
        
    </dependencies>
</dependencyManagement>

```