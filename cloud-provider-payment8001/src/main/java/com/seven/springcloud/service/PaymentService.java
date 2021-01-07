package com.seven.springcloud.service;

import com.seven.springcloud.entity.Payment;

/**
 * @author SevenWong
 * @date 2021-01-07 17:03:29
 */
public interface PaymentService {

    int add(Payment payment);

    Payment read(Long id);

}
