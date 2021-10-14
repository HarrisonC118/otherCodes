package com.hatcher.api;


import com.hatcher.service.ICategoryService;
import com.hatcher.utils.JsonResult;
import com.hatcher.vo.ItemsVo;
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
 * 商品分类  前端控制器
 * </p>
 *
 * @author HatcherCheung
 * @since 2021-10-05
 */
@RestController
@RequestMapping("/category")
@Api(value = "商品分类管理", tags = {"查询大级下的6个分类的最新数据"})
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/getSixItemsLazy/{rootCatId}")
    @ApiOperation(value = "查询大级下的6个分类的最新数据", notes = "查询大级下的6个分类的最新数据")
    public JsonResult getSixItemsLazy(
            @ApiParam(name = "rootCatId", value = "父类的id", required = true)
            @PathVariable Integer rootCatId) {
        if (rootCatId == null) {
            return JsonResult.errorMsg("参数不能为空！");
        }
        List<ItemsVo> subCatList = categoryService.getSixNewItemsLazy(rootCatId);
        return JsonResult.ok(subCatList);
    }
}
