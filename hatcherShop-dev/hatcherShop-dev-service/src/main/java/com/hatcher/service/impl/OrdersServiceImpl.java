package com.hatcher.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hatcher.entity.Orders;
import com.hatcher.mapper.OrdersMapper;
import com.hatcher.service.IOrdersService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单表; 服务实现类
 * </p>
 *
 * @author HatcherCheung
 * @since 2021-10-05
 */
@Service
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Orders> implements IOrdersService {

}
