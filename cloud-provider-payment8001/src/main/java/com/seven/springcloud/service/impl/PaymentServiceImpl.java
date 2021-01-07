package com.seven.springcloud.service.impl;

import com.seven.springcloud.dao.PaymentDao;
import com.seven.springcloud.entity.Payment;
import com.seven.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author SevenWong
 * @date 2021-01-07 17:05:13
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Override
    public int add(Payment payment) {
        return paymentDao.add(payment);
    }

    @Override
    public Payment read(Long id) {
        return paymentDao.read(id);
    }
}
