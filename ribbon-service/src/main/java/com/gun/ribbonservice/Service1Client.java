package com.gun.ribbonservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("service1") // eureka icerisinde gorunen application name
public interface Service1Client {

    @GetMapping("/service1")
    public String getService1();

}
