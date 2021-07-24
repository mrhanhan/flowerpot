## 授权服务

    花盆授权服务是基于RBAC3（Role Based Access Control） 来是选授权以及验证的模块。


### 权限表结构
![](../images/flowerpo-authroize-db-table.png)

### 后台权限拦截原理
![](../images/flowerpot-authroize-intercept.png)

### 所支持的权限拦截规则
1. 需要登录、不需要不登陆 (默认需要登录)
2. 是否有指定角色
3. 是否有指定权限码（默认）
4. 是否指定IP
5. 复合条件关系，and / ro 前面 四种
