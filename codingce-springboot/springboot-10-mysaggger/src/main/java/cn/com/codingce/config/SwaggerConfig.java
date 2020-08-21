package cn.com.codingce.config;

import cn.com.codingce.controller.HelloController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean //配置docket以配置Swagger具体参数  链式编程
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                //用的自己的             return new Docket(DocumentationType.SWAGGER_2); 默认
                .apiInfo(apiInfo())
                //enable    是否启动Swagger, 如果false则Swagger不能再浏览器中访问
                //.enable(false)
                .select()
                //RequestHandlerSelectors配置要扫面接口的方式
                //basePackage   指定要扫描的包      .apis(RequestHandlerSelectors.basePackage("cn.com.codingce.controller"))
                //any() 扫描全部
                //no() 都不扫描
                //withClassAnnotation   :扫描类上的注解, 参数是一个注解反射的对象
                //withMethodAnnotation  :扫描方法上的注解
                .apis(RequestHandlerSelectors.basePackage("cn.com.codingce.controller"))
                //paths() 过滤路径
                //.paths(PathSelectors.ant("/codingce/**"))
                .build();//build工厂模式
    }

    //配置swaagger信息
    private ApiInfo apiInfo() {
        //作者信息
        Contact contact = new Contact("马鑫泽", "https://i.codingce.com.cn", "codingce@gmail.com");
        return new ApiInfo("掌上编程",
                "即使再小的帆也能远航",
                "1.0",
                "https://i.codingce.com.cn",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());
    }




}