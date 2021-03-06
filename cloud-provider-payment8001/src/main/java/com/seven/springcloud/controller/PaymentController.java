package com.seven.springcloud.controller;

import com.seven.springcloud.entity.CommonResult;
import com.seven.springcloud.entity.Payment;
import com.seven.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author SevenWong
 * @date 2021-01-07 17:06:55
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Resource
    private DiscoveryClient discoveryClient;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/payment/create")
    public CommonResult add(@RequestBody  Payment payment) {
        int rows = paymentService.add(payment);
        return new CommonResult(200, "插入结果： " + rows);
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> get(@PathVariable("id") Long id) {
        Payment payment = paymentService.read(id);
        System.out.println(125436);
        if (payment != null) {
            return new CommonResult<>(200, "成功 serverPort：" + serverPort, payment);
        } else {
            return new CommonResult<>(400, "没有记录");
        }
    }

    @GetMapping("/payment/discovery")
    public Object discoveryClientInfo() {
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info(service);
        }
        List<ServiceInstance> instanceList = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instanceList) {
            log.info(instance.getUri().toString());
        }
        return this.discoveryClient;
    }

}
