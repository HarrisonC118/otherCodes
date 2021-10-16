package com.hatcher.vo;

/**
 * 商品的评论等级及数量
 *
 * @author: HatcherCheung
 * Date:  2021/10/16
 */
public class CommentLevelCountsVo {
    /**
     * 全部评论数
     */
    private Integer totalCounts;
    /**
     * 好评的数量
     */
    private Integer goodCounts;
    /**
     * 中评的数量
     */
    private Integer normalCounts;
    /**
     * 差评的数量
     */
    private Integer badCounts;

    public Integer getTotalCounts() {
        return totalCounts;
    }

    public void setTotalCounts(Integer totalCounts) {
        this.totalCounts = totalCounts;
    }

    public Integer getGoodCounts() {
        return goodCounts;
    }

    public void setGoodCounts(Integer goodCounts) {
        this.goodCounts = goodCounts;
    }

    public Integer getNormalCounts() {
        return normalCounts;
    }

    public void setNormalCounts(Integer normalCounts) {
        this.normalCounts = normalCounts;
    }

    public Integer getBadCounts() {
        return badCounts;
    }

    public void setBadCounts(Integer badCounts) {
        this.badCounts = badCounts;
    }
}
