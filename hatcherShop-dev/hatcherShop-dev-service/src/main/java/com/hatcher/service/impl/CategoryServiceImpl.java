package com.hatcher.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hatcher.entity.Category;
import com.hatcher.mapper.CategoryMapper;
import com.hatcher.service.ICategoryService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商品分类  服务实现类
 * </p>
 *
 * @author HatcherCheung
 * @since 2021-10-05
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements ICategoryService {

}
