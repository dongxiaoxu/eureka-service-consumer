package site.dongxiaoxu.springcloud.eurekaserviceconsumer.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/consumer")
public class ConsumerController {

    @RequestMapping("/hello")
    public String hello() {
        RestTemplate restTemplate = new RestTemplate();
        Map<String, Object> params;
        params = new HashMap<>(4);
        params.put("name", "dongxiaoxu");
        String response;
        ResponseEntity<String> responseEntity;
        responseEntity = restTemplate.getForEntity("http://localhost:8050/provider/msg?name={name}", String.class, params);
        response = responseEntity.getBody();
        System.out.println(response);
        response = restTemplate.getForObject("http://localhost:8050/provider/msg?name={name}", String.class, "xiaoxu");
        System.out.println(response);
        MultiValueMap<String, String> valueMap = new LinkedMultiValueMap<>();
        valueMap.add("name", "xu");
        response = restTemplate.postForObject("http://localhost:8050/provider/msg", valueMap, String.class);
        return  response;
    }
}
