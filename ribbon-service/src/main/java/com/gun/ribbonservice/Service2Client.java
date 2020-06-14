package com.gun.ribbonservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("service2") // eureka icerisinde gorunen application name
public interface Service2Client {

    @GetMapping("/service2")
    public String getService2();

}
