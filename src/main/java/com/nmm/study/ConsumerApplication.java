package com.nmm.study;

import com.nmm.study.service.DubboServiceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@ImportResource("classpath:/dubbo.xml")
@RestController
public class ConsumerApplication {
    //注入声明的服务
    @Autowired
    private DubboServiceProvider dubboServiceProvider;

    public  static void main(String[] args){
        SpringApplication.run(ConsumerApplication.class,args);
    }

    //测试服务调用
    @ResponseBody
    @RequestMapping("/sayhello/{name}")
    public String hello(@PathVariable String name){
        return dubboServiceProvider.sayHello(name);
    }
}
