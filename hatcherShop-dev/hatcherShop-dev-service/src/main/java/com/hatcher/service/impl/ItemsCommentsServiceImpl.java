package com.hatcher.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hatcher.entity.ItemsComments;
import com.hatcher.enums.ItemCommentLevel;
import com.hatcher.mapper.ItemsCommentsMapper;
import com.hatcher.service.IItemsCommentsService;
import com.hatcher.vo.CommentLevelCountsVo;
import com.hatcher.vo.ItemCommentsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 商品评价表  服务实现类
 * </p>
 *
 * @author HatcherCheung
 * @since 2021-10-05
 */
@Service
public class ItemsCommentsServiceImpl extends ServiceImpl<ItemsCommentsMapper, ItemsComments> implements IItemsCommentsService {
    @Autowired
    private ItemsCommentsMapper itemsCommentsDao;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, rollbackFor = Exception.class)
    public CommentLevelCountsVo queryCommentCounts(String itemId) {
        CommentLevelCountsVo commentLevelCountsVo = new CommentLevelCountsVo();
        int goodCounts = getCommentCounts(itemId, ItemCommentLevel.good.type);
        int normalCounts = getCommentCounts(itemId, ItemCommentLevel.normal.type);
        int badCounts = getCommentCounts(itemId, ItemCommentLevel.bad.type);
        int totalCounts = goodCounts + normalCounts + badCounts;
        commentLevelCountsVo.setGoodCounts(goodCounts);
        commentLevelCountsVo.setNormalCounts(normalCounts);
        commentLevelCountsVo.setBadCounts(badCounts);
        commentLevelCountsVo.setTotalCounts(totalCounts);
        return commentLevelCountsVo;
    }

    @Transactional(propagation = Propagation.SUPPORTS, rollbackFor = Exception.class)
    @Override
    public List<ItemCommentsVo> queryItemComments(Integer pageNum, Integer pageSize, Integer level, String itemId) {
        IPage<ItemCommentsVo> page = new Page<>(pageNum, pageSize);
        List<ItemCommentsVo> itemCommentsVos = itemsCommentsDao.queryCommentsByItemIdAndLevel(page, itemId, level);
        return itemCommentsVos;
    }


    /**
     * 根据id和level等级查询记录的数量
     *
     * @param itemId 商品id
     * @param level  商品评价等级
     * @return
     */
    @Transactional(propagation = Propagation.SUPPORTS, rollbackFor = Exception.class)
    protected int getCommentCounts(String itemId, Integer level) {
        QueryWrapper<ItemsComments> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("item_id", itemId);
        queryWrapper.eq("comment_level", level);
        return itemsCommentsDao.selectCount(queryWrapper).intValue();
    }
}
