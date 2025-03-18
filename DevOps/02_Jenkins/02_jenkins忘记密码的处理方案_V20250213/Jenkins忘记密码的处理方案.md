# Jenkins忘记密码的处理方案





## mac系统

Mac系统下jenkins用户的登录信息保存在如下位置：

```shell
/Users/xxx/.jenkins/users/登录的用户名/config.xml
```

复制该文件，以防万一。 

找到如下的代码，进行替换，默认密码为：admin

```
<hudson.security.HudsonPrivateSecurityRealm_-Details>
<passwordHash>#jbcrypt:$2a$10$oZgKQuNVqiMglf2lqPm2WOfXqZoq5gWt4NvrT1iugjCNEtVDsUP1G</passwordHash> 
</hudson.security.HudsonPrivateSecurityRealm_-Details>
```



## TODO

1.  将/Users/xxx/.jenkins/users/登录的用户名/config.xml 文件中的密码设置为空，会出现什么情况，没办法记住长长的加密后的密文

## 参考资料

https://www.cnblogs.com/Owen-ET/p/15076175.html

