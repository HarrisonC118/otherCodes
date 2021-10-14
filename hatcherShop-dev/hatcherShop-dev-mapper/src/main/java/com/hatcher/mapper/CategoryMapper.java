package com.hatcher.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hatcher.entity.Category;
import com.hatcher.vo.CategoryVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 商品分类  Mapper 接口
 * </p>
 *
 * @author HatcherCheung
 * @since 2021-10-05
 */
public interface CategoryMapper extends BaseMapper<Category> {

    /**
     * 获取子类的所有信息
     *
     * @param rootCatId 父类的Id值
     * @return 所有子类的信息
     */
    List<CategoryVo> getSubCatList(@Param("rootCatId") Integer rootCatId);

}
