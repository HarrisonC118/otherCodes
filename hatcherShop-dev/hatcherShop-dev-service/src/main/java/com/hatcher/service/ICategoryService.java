package com.hatcher.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hatcher.entity.Category;
import com.hatcher.vo.CategoryVo;

import java.util.List;

/**
 * <p>
 * 商品分类  服务类
 * </p>
 *
 * @author HatcherCheung
 * @since 2021-10-05
 */
public interface ICategoryService extends IService<Category> {
    /**
     * 查询所有大分类
     *
     * @return 分类的详细信息
     */
    List<Category> queryRootLevelCat();

    /**
     * 根据父类的ID获得所有的子类(中类和小类)
     *
     * @param rootId 父类的id
     * @return
     */
    List<CategoryVo> getSubCatList(Integer rootId);
}
