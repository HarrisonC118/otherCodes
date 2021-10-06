package com.hatcher.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hatcher.entity.ItemsImg;
import com.hatcher.mapper.ItemsImgMapper;
import com.hatcher.service.IItemsImgService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商品图片  服务实现类
 * </p>
 *
 * @author HatcherCheung
 * @since 2021-10-05
 */
@Service
public class ItemsImgServiceImpl extends ServiceImpl<ItemsImgMapper, ItemsImg> implements IItemsImgService {

}
