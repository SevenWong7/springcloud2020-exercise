package com.seven.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.seven.springcloud.entity.CommonResult;
import com.seven.springcloud.entity.Payment;
import com.seven.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author SevenWong
 * @date 2021-01-07 17:06:55
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/payment/create")
    public CommonResult add(@RequestBody  Payment payment) {
        int rows = paymentService.add(payment);
        return new CommonResult(200, "插入结果： " + rows);
    }

    @GetMapping("/payment/get/{id}")
    @HystrixCommand(fallbackMethod = "getFallback")
    public CommonResult<Payment> get(@PathVariable("id") Long id) {
        Payment payment = paymentService.read(id);
        System.out.println(125436);
        if (payment != null) {
            return new CommonResult<>(200, "成功 serverPort：" + serverPort, payment);
        } else {
            throw new RuntimeException("测试hystrix异常");
        }
    }

    private CommonResult<Payment> getFallback(@PathVariable("id") Long id) {
        return new CommonResult<>(401, "fallback");
    }

}
