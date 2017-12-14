package org.spring.springboot.web;

import org.spring.springboot.info.UserInfo;
import org.springframework.web.bind.annotation.*;

/**
 * Spring Boot HelloWorld 案例
 *
 */
@RestController
public class HelloWorldController {

    @RequestMapping("/")
    public String sayHello() {
        return "Hello,World!";
    }

    @PostMapping(value = "/request_param")
    public String requestParam(@RequestParam(value = "name") String name) {
        return name;
    }

    @PostMapping(value = "/request_body")
    public UserInfo requestBody(@RequestParam(value = "name") String name, @RequestBody UserInfo info) {
        System.out.println(name);
        return info;
    }
}
