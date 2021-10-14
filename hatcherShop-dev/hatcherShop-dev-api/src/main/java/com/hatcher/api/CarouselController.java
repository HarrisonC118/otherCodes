package com.hatcher.api;


import com.hatcher.entity.Carousel;
import com.hatcher.entity.Category;
import com.hatcher.enums.CarouselIsDisplay;
import com.hatcher.service.ICarouselService;
import com.hatcher.service.ICategoryService;
import com.hatcher.utils.JsonResult;
import com.hatcher.vo.CategoryVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    private ICarouselService carouselService;

    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/getCarousel")
    @ApiOperation(value = "获取轮播图", notes = "获取所有允许展示的轮播图")
    public JsonResult getCarousel() {
        List<Carousel> allCarousel = carouselService.getAllCarousel(CarouselIsDisplay.yes.type);
        return JsonResult.ok(allCarousel);
    }

    @GetMapping("/getAllRootLevelCat")
    @ApiOperation(value = "获得所有大类的数据", notes = "只要大类的数据")
    public JsonResult getAllRootLevelCat() {
        List<Category> categories = categoryService.queryRootLevelCat();
        return JsonResult.ok(categories);
    }

    @GetMapping("/getAllRootLevelCat/{rootCatId}")
    @ApiOperation(value = "获得大类商品下面的子类", notes = "获得大类商品下面的子类")
    public JsonResult getSubCats(
            @ApiParam(name = "rootCatId", value = "父类的id", required = true)
            @PathVariable Integer rootCatId) {
        if (rootCatId == null) {
            return JsonResult.errorMsg("参数不能为空！");
        }
        List<CategoryVo> subCatList = categoryService.getSubCatList(rootCatId);
        return JsonResult.ok(subCatList);
    }
}
