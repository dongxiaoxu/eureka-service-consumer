package site.dongxiaoxu.springcloud.eurekaserviceconsumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.dongxiaoxu.springcloud.eurekaserviceconsumer.client.ConsumerClient;

@RestController
@RequestMapping("/feign")
public class FeignController {

    @Autowired
    private ConsumerClient consumerClient;

    @GetMapping("/hello")
    public String hello() {
        return this.consumerClient.hello("xiaoxu");
    }


}
