package com.hatcher.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hatcher.entity.Category;
import com.hatcher.mapper.CategoryMapper;
import com.hatcher.service.ICategoryService;
import com.hatcher.vo.CategoryVo;
import com.hatcher.vo.ItemsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        return categoryDao.getSubCatList(rootId);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, rollbackFor = Exception.class)
    public List<ItemsVo> getSixNewItemsLazy(Object rootId) {
        Map<String, Object> map = new HashMap<>();
        // 因为父类的id不一定是int类型的，还有可能是string类型的，所以用map传
        map.put("rootCatId", rootId);
        return categoryDao.getSixNewItemsLazy(map);
    }
}
