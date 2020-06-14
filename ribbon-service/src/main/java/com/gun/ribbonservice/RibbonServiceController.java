package com.gun.ribbonservice;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/ribbon")
public class RibbonServiceController {

    private final RestTemplate restTemplate;
    private final Service1Client service1Client;
    private final Service2Client service2Client;


    public RibbonServiceController(RestTemplate restTemplate, Service1Client service1Client, Service2Client service2Client) {
        this.restTemplate = restTemplate;
        this.service1Client = service1Client;
        this.service2Client = service2Client;
    }

    @GetMapping
    public String hello() {
        return "hello from ribbon service";
    }

    @GetMapping("/runservice1")
    public String runService1() {
        ResponseEntity<String> response = this.restTemplate.exchange("http://SERVICE1/service1", HttpMethod.GET, null, String.class);
        return response.getBody();
    }

    @GetMapping("/runservice2")
    public String runService2() {
        ResponseEntity<String> response = this.restTemplate.exchange("http://SERVICE2/service2", HttpMethod.GET, null, String.class);
        return response.getBody();
    }

    @GetMapping("/service1WithFeign")
    public String service1WithFeing() {
        return service1Client.getService1();
    }

    @GetMapping("/service2WithFeign")
    public String service2WithFeing() {
        return service2Client.getService2();
    }
}
