package com.hatcher.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author: HatcherCheung
 * Date:  2021/11/15
 */
@Configuration
@EnableSwagger2
public class Swagger2Configuration {
    /**
     * SWAGGER_SCAN_BASE_PACKAGE: 包扫描路径,就是controller的包
     * VERSION: 当前版本
     */
    public static final String SWAGGER_SCAN_BASE_PACKAGE = "com.hatcher.api";
    public static final String VERSION = "1.0.0";

    @Bean
    public Docket createRestApi() {
        // 指定api类型为swagger2
        return new Docket(DocumentationType.SWAGGER_2)
                // api文档的信息，版本、作者、联系方式啥的
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage(SWAGGER_SCAN_BASE_PACKAGE))
                // 可以根据url路径设置哪些请求加入文档，忽略哪些请求
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                //设置文档的标题
                .title("HatcherCheung_imgGo")
                // 作者信息 姓名，主页，邮箱
                .contact(new Contact("HatcherCheung", "https://gitee.com/ChewieKIM", "1109079622@qq.com"))
                // 设置文档的描述
                .description("imgGo 接口文档")
                // 设置文档的版本号-> 1.0.0 Version information
                .version(VERSION)
                // 网站地址
                .termsOfServiceUrl("https://gitee.com/ChewieKIM")
                // 设置文档的License信息->1.3 License information
                .termsOfServiceUrl("http://www.baidu.com")
                .build();
    }
}