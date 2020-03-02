# 银行客户管理系统的实现
**环境**：`Hibernate` `javase 1.7` `tomcat 8.0`
---
**变更**：修改老的项目，重新构造为 maven 项目

**注意**：
1. 发布项目名应为 `BankCMS`;
> 因为前端界面代码写死了访问路径 URL；
2. 修改 `ShowSqlFile.java` 里的 `doGet` 方法的 `path` 和 `bak` 定义的目录；
> 这种代码非常不灵活，违法了开闭原则，但鉴于是以前的代码，此次目的只是调整为 maven 项目，故且先不修改，并且
> sql 文件的恢复功能也有问题，建议使用 apache 的 `SQLExec` 类去做，特在此说明；
---
<br>
详细介绍参照[这篇博客](https://blog.csdn.net/ai_xao/article/details/77880161) 
很荣幸有很多朋友需要用到我的代码，之前有在csdn 上传过，但鉴于大家积分不够，所以又补充在这里了
