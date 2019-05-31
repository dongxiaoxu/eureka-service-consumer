package site.dongxiaoxu.springcloud.eurekaserviceconsumer.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("eureka-provider")
public interface ConsumerClient {

    @RequestMapping("/provider/msg")
    String hello(@RequestParam(name = "name") String name);
}

