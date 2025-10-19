package com.wei.study03.config;

import com.github.xiaoymin.knife4j.spring.extension.OpenApiExtensionResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

@Slf4j
@Configuration
@EnableSwagger2WebMvc
public class Knife4jConfigration {
    // 【重要】 指定Controller包路径
    private String basePackage = "com.wei.study03.controller";
    // 分组名称
    private String groupName = "user";
    // 主机名
    private String host = "http://localhost:8080";
    // 标题
    private String title = "学子商城在线API文档";
    // 简介
    private String description = "学子商城在线API文档";
    // 服务条款
    private String termsOfServiceUrl = "http://www.apache.org/licenses/LTCENSE-2.0";
    // 联系人
    private String contactName = "魏鑫";
    // 联系网址
    private String contactURL = "http://www.baidu.com";
    // 联系邮箱
    private String contactEmail = "java@tedu.cn";
    // 版本号
    private String version = "1.0.0";
    // 自动注入 Knife4j 的扩展解析器，用于加载自定义扩展功能
    @Autowired
    private OpenApiExtensionResolver openApiExtensionResolver;
    // 构造方法，在创建配置对象时输出调试日志
    public Knife4jConfigration() {
        log.info("创建配置了对象：Knife4jConfigration");
    }

    // 声明一个Spring bean，创建并配置Swagger 的Docket对象
    @Bean
    public Docket docket(){
        // 定义 API 文档的分钟名称
        String groupName = "1.0.0";

        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .host(host)
                .apiInfo(apiInfo())
                .groupName(groupName)
                .select()
                .apis(RequestHandlerSelectors.basePackage(basePackage))
                .paths(PathSelectors.any())
                .build()
                .extensions(openApiExtensionResolver.buildExtensions(groupName));
        return docket;
    }
    // 创建API文档的基本信息
    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title(title)
                .description(description)
                .termsOfServiceUrl(termsOfServiceUrl)
                .contact(new Contact(contactName,contactURL,contactEmail))
                .version(version)
                .build();
    }


}
