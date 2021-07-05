## 逻辑删除
1. 在实体类的属性上加`@TableLogic`注解
2. controller中使用`@DeleteMapping("/{id}")`接收要删除的id
3. 在@DeleteMapping修饰的方法参数中使用`@PathVariable("id")`接收传入的值
## 整合swagger
1. 在项目中创建公共模块，让所有的模块都能用
2. 创建SwaggerConfig类

```java
package com.configq.servicebase;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class com.config.SwaggerConfig{
@Bean
public Docket webApiConfig(){

        return new Docket(DocumentationType.SWAGGER_2)
        .groupName("webApi")
        .apiInfo(webApiInfo())
        .select()
        .paths(Predicates.not(PathSelectors.regex("/admin/.*")))
        .paths(Predicates.not(PathSelectors.regex("/error.*")))
        .build();

        }

@Bean
public Docket adminApiConfig(){

        return new Docket(DocumentationType.SWAGGER_2)
        .groupName("adminApi")
        .apiInfo(adminApiInfo())
        .select()
        .paths(Predicates.and(PathSelectors.regex("/admin/.*")))
        .build();

        }

private ApiInfo webApiInfo(){

        return new ApiInfoBuilder()
        .title("网站-课程中心API文档")
        .description("本文档描述了课程中心微服务接口定义")
        .version("1.0")
        .contact(new Contact("Helen","http://atguigu.com","55317332@qq.com"))
        .build();
        }

private ApiInfo adminApiInfo(){

        return new ApiInfoBuilder()
        .title("后台管理系统-课程中心API文档")
        .description("本文档描述了后台管理系统课程中心微服务接口定义")
        .version("1.0")
        .contact(new Contact("Helen","http://atguigu.com","55317332@qq.com"))
        .build();
        }
        }
```
3. 在其他模块中引入刚才创建的公共模块

```xml
        <dependency>
            <groupId>com.configcom.config</groupId>
            <artifactId>service_base</artifactId>
            <version>0.0.1-SNAPSHOT</version>
        </dependency>
```
4. 在主启动类中加上注解`@ComponentScan(basePackages = {"com.configq"})`
   设置包扫描规则，不然扫不到刚才配置的configration
5. 访问网页localhost:8001/swagger-ui.html
### 乐观锁和悲观锁

- 悲观锁：串行操作。只能有一个人操作，另一个人如果也想操作必须等待（效率低）
- 乐观所：加了 version。用版本号做控制，所有人都能拿到信息，但是最终只有一个人可以修改（判断开始和结束的版本号是否一致）

```html
    丢失更新：两个人并发修改一个值，但是最后提交的数据会覆盖前一个人提交的数据
```

#### mp 怎么用乐观锁

1. 在表里添加版本号字段
2. 在实体类中添加版本号的属性和注解
3. 配置一个乐观锁的插件
```java
//插件代码
package com.practice.mybatisplus.mpdemo;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.practice.mybatisplus.mpdemo.mapper")
public class SpringBootConfiguration {
@Bean
public MybatisPlusInterceptor mybatisPlusInterceptor() {
MybatisPlusInterceptor mybatisPlusInterceptor = new MybatisPlusInterceptor();
mybatisPlusInterceptor.addInnerInterceptor(new OptimisticLockerInnerInterceptor());
return mybatisPlusInterceptor;
}
}
```
```java
//entity代码，要加@version注解
package com.practice.mybatisplus.mpdemo.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @TableId(type = IdType.ASSIGN_UUID)
    private String id;
    private String name;
    private Integer age;
    private String email;
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
    @Version
    private Integer version;
}

```
### mp分页
1. 配置插件
   和乐观锁的插件代码一样
2. new一个Page<>
3. 调用Page的方法实现分页
```
        Page<User> page = new Page<>(1,3);
        userMapper.selectPage(page,null);//把数据全都装进page
        page.getCurrent();//查看当前页
        page.getRecords() ;//返回每页数据的list集合
        page.getSize();//每页显示数据的数量
        page.getTotal();//获取总记录数
        page.getPages();//获取一共有多少页
        page.hasNext();//是否有下一页，有就返回true
        page.hasPrevious();//是否有上一页，如果有就是true
```
## 删除
- 逻辑删除
   - 增加标志位。在表里还有但是查不出来
      1. ```yaml
       mybatis-plus:
         global-config:
           db-config:
             logic-delete-field: flag  # 全局逻辑删除的实体字段名(since 3.3.0,配置后可以忽略不配置@TableLogic)
             logic-delete-value: 1 # 逻辑已删除值(默认为 1)
             logic-not-delete-value: 0 # 逻辑未删除值(默认为 0)
       ```
      2. 用deleteById的时候就是逻辑删除了
- 物理删除
   - 在表中就删除了
     ```
     userMapper.deleteById();//删除一条数据
     userMapper.deleteBatchIds(Arrays.asList(1,2));//批量删除
     ```
    
#### @RequestBody()
>　使用json格式接收数据
> 注意：必须使用POST方式传值才能收到
```java
//接收的参数可以没有
 @RequestBody(required = false) TeacherQuery teacherQuery
```
#### ControllerAdvice 
> 是一个增强版的Controller

主要有三个功能:
1. 全局异常处理
2. 全局数据绑定
3. 全局数据预处理