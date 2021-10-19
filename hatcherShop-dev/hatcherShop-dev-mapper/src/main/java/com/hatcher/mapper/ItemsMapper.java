package com.hatcher.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hatcher.entity.Items;
import com.hatcher.vo.SearchItemsVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 商品表 商品信息相关表：分类表，商品图片表，商品规格表，商品参数表 Mapper 接口
 * </p>
 *
 * @author HatcherCheung
 * @since 2021-10-05
 */
public interface ItemsMapper extends BaseMapper<Items> {
    /**
     * 搜索商品
     *
     * @param page     分页信息
     * @param keywords 关键字
     * @param sort     根据啥排序
     * @return
     */
    List<SearchItemsVo> searchItems(IPage<SearchItemsVo> page, @Param("keywords") String keywords, @Param("sort") String sort);
}
