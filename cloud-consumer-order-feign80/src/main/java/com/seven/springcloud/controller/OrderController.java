package com.seven.springcloud.controller;

import com.seven.springcloud.entity.CommonResult;
import com.seven.springcloud.entity.Payment;
import com.seven.springcloud.service.OrderClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author SevenWong
 * @date 2021-01-07 17:46:18
 */
@RestController
public class OrderController {

    @Autowired
    private OrderClientService orderClientService;

    @GetMapping("/consumer/payment/create")
    public CommonResult create(Payment payment) {
        return orderClientService.create(payment);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult get(@PathVariable("id") Long id) {
        return orderClientService.get(id);
    }

}
