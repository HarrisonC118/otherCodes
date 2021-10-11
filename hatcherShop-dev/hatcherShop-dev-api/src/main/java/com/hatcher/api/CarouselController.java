package com.hatcher.api;


import com.hatcher.entity.Carousel;
import com.hatcher.enums.CarouselIsDisplay;
import com.hatcher.service.ICarouselService;
import com.hatcher.utils.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 轮播图  前端控制器
 * </p>
 *
 * @author HatcherCheung
 * @since 2021-10-05
 */
@RestController
@Api(value = "轮播图", tags = {"轮播图的接口"})
@RequestMapping("carousel")
public class CarouselController {
    @Autowired
    private ICarouselService CarouselService;

    @GetMapping("/getCarousel")
    @ApiOperation(value = "获取轮播图", notes = "获取所有允许展示的轮播图")
    public JsonResult getCarousel() {
        List<Carousel> allCarousel = CarouselService.getAllCarousel(CarouselIsDisplay.yes.type);
        return JsonResult.ok(allCarousel);
    }
}
