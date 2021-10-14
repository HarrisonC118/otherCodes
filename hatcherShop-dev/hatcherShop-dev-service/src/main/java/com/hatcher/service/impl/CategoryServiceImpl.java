package com.hatcher.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hatcher.entity.Category;
import com.hatcher.mapper.CategoryMapper;
import com.hatcher.service.ICategoryService;
import com.hatcher.vo.CategoryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
    @Autowired
    private CategoryMapper categoryDao;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, rollbackFor = Exception.class)
    public List<Category> queryRootLevelCat() {
        QueryWrapper<Category> categoryQueryWrapper = new QueryWrapper<Category>();
        categoryQueryWrapper.eq("type", 1);
        List<Category> categories = categoryDao.selectList(categoryQueryWrapper);
        return categories;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, rollbackFor = Exception.class)
    public List<CategoryVo> getSubCatList(Integer rootId) {
        List subCatList = categoryDao.getSubCatList(rootId);
        return subCatList;
    }
}
