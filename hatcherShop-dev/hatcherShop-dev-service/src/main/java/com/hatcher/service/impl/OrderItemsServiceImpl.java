package com.hatcher.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hatcher.entity.OrderItems;
import com.hatcher.mapper.OrderItemsMapper;
import com.hatcher.service.IOrderItemsService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单商品关联表  服务实现类
 * </p>
 *
 * @author HatcherCheung
 * @since 2021-10-05
 */
@Service
public class OrderItemsServiceImpl extends ServiceImpl<OrderItemsMapper, OrderItems> implements IOrderItemsService {

}
