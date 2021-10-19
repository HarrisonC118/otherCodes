package com.hatcher.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hatcher.entity.ItemsComments;
import com.hatcher.vo.ItemCommentsVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 商品评价表  Mapper 接口
 * </p>
 *
 * @author HatcherCheung
 * @since 2021-10-05
 */
public interface ItemsCommentsMapper extends BaseMapper<ItemsComments> {

    /**
     * 根据商品id和评论等级获取该商品的全部评论
     *
     * @param page   每页的条数
     * @param itemId 项目id
     * @param level  评论等级
     * @return
     */
    List<ItemCommentsVo> queryCommentsByItemIdAndLevel(IPage<ItemCommentsVo> page, @Param("itemId") String itemId, @Param("level") Integer level);
}
