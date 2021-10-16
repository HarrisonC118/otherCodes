package com.hatcher.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hatcher.entity.ItemsComments;
import com.hatcher.vo.CommentLevelCountsVo;

/**
 * <p>
 * 商品评价表  服务类
 * </p>
 *
 * @author HatcherCheung
 * @since 2021-10-05
 */
public interface IItemsCommentsService extends IService<ItemsComments> {
    /**
     * 查询评论的数量
     *
     * @param itemId 商品id
     */
    public CommentLevelCountsVo queryCommentCounts(String itemId);
}
