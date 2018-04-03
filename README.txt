1、不使用mybatis的注解方法，而是使用xml定义resultmap,因为注解无法写复杂的SQL。
2、spring默认使用的datasource为HikariDataSource
3、需要编写Dao、Server，接口可以不用写，毕竟业务需求不多。
4、mybatis的mapper接口相当于Dao，所以Dao可以不用定义，直接使用mapper注入service就可以了。
5、service是需要创建的，虽然有些方法逻辑不多，如直接调用Dao中的方法。
3、需要编写Dao、Server，接口是否需要写，视项目需要。
4、如果遇到配置都没错，而mapper注入失败，报org.springframework.beans.factory.NoSuchBeanDefinitionException的错误，可能是maven资源库的问题，删掉资源库中的依赖包，重新下载。（因为我的工作空间不止当前一个项目，也有其他的maven项目，可能存在依赖包冲突）

