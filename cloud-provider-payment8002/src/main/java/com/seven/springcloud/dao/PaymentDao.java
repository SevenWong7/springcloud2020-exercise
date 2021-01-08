package com.seven.springcloud.dao;

import com.seven.springcloud.entity.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author SevenWong
 * @date 2021-01-07 16:46:23
 */
@Mapper
public interface PaymentDao {

    int add(Payment payment);

    Payment read(@Param("id") Long id);

}
