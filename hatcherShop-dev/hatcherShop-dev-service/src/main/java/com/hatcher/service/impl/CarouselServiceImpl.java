package com.hatcher.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hatcher.entity.Carousel;
import com.hatcher.mapper.CarouselMapper;
import com.hatcher.service.ICarouselService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 轮播图  服务实现类
 * </p>
 *
 * @author HatcherCheung
 * @since 2021-10-05
 */
@Service
public class CarouselServiceImpl extends ServiceImpl<CarouselMapper, Carousel> implements ICarouselService {
    @Autowired
    private CarouselMapper carouselDao;

    @Override
    public List<Carousel> getAllCarousel(Integer isShow) {
        QueryWrapper<Carousel> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("is_show", isShow);
        queryWrapper.orderByAsc("sort");
        List<Carousel> carousels = carouselDao.selectList(queryWrapper);
        return carousels;
    }
}
