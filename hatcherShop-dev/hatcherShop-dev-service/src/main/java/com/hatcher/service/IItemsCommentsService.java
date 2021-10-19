package com.hatcher.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hatcher.entity.ItemsComments;
import com.hatcher.vo.CommentLevelCountsVo;
import com.hatcher.vo.ItemCommentsVo;

import java.util.List;

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
    CommentLevelCountsVo queryCommentCounts(String itemId);

    /**
     * 查询商品不同等级的评论
     *
     * @param pageNum  当前的页数
     * @param pageSize 当前页评论要展示多少条
     * @param level    评论等级(好评、中评、差评)
     * @param itemId   商品Id
     * @return
     */
    List<ItemCommentsVo> queryItemComments(Integer pageNum, Integer pageSize, Integer level, String itemId);
}
