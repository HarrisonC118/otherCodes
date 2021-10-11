package com.hatcher.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hatcher.entity.Carousel;

import java.util.List;

/**
 * <p>
 * 轮播图  服务类
 * </p>
 *
 * @author HatcherCheung
 * @since 2021-10-05
 */
public interface ICarouselService extends IService<Carousel> {
    /**
     * 根据是否展示来请求轮播图数据
     *
     * @param isShow 是否展示，0不展示，1展示
     * @return 轮播图的信息列表
     */
    List<Carousel> getAllCarousel(Integer isShow);
}
