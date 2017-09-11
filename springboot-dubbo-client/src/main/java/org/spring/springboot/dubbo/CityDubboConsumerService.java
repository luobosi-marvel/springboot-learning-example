package org.spring.springboot.dubbo;

import com.alibaba.dubbo.config.annotation.Reference;
import org.spring.springboot.domain.City;
import org.springframework.stereotype.Component;

/**
 * 城市 Dubbo 服务消费者
 *
 */
@Component
public class CityDubboConsumerService {

    /**
     * 这里是服务消费者，提供一个接口，
     * 和服务提供者提供的接口一致，
     * 使用 Dubbo 的注解注入
     */
    @Reference(version = "1.0.0")
    CityDubboService cityDubboService;

    public void printCity() {
        String cityName="温岭";
        City city = cityDubboService.findCityByName(cityName);
        System.out.println(city.toString());
    }
}
