package com.seven.springcloud.service;

import com.seven.springcloud.entity.CommonResult;
import com.seven.springcloud.entity.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author SevenWong
 * @date 2021-01-13 12:08:57
 */
@FeignClient("cloud-payment-service")
public interface OrderClientService {
    @GetMapping("/payment/create")
    CommonResult create(Payment payment);

    @GetMapping("/payment/get/{id}")
    CommonResult get(@PathVariable("id") Long id);
}
