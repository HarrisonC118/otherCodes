package com.hatcher.api;


import com.hatcher.entity.Items;
import com.hatcher.entity.ItemsImg;
import com.hatcher.entity.ItemsParam;
import com.hatcher.entity.ItemsSpec;
import com.hatcher.service.IItemsService;
import com.hatcher.utils.JsonResult;
import com.hatcher.vo.ItemInfoVo;
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
 * 商品表 商品信息相关表：分类表，商品图片表，商品规格表，商品参数表 前端控制器
 * </p>
 *
 * @author HatcherCheung
 * @since 2021-10-05
 */
@RestController
@RequestMapping("/items")
@Api(value = "商品接口", tags = "商品信息展示的相关接口")
public class ItemsController {
    @Autowired
    private IItemsService iItemsService;

    @GetMapping("/infos/{itemId}")
    @ApiOperation(value = "查询指定的商品详细信息", notes = "查询指定的商品详细信息")
    public JsonResult getItems(
            @ApiParam(value = "商品id", name = "itemId", required = true)
            @PathVariable String itemId) {
        if (itemId == null) {
            return JsonResult.errorMsg("商品id不能为空！");
        }
        Items items = iItemsService.queryItemById(itemId);
        List<ItemsImg> itemsImgs = iItemsService.queryItemImgList(itemId);
        ItemsParam itemsParam = iItemsService.queryItemParam(itemId);
        List<ItemsSpec> itemsSpecs = iItemsService.queryItemSpecList(itemId);
        ItemInfoVo itemInfoVo = new ItemInfoVo();
        itemInfoVo.setItem(items);
        itemInfoVo.setItemImgList(itemsImgs);
        itemInfoVo.setItemsParam(itemsParam);
        itemInfoVo.setItemsSpecList(itemsSpecs);
        return JsonResult.ok(itemInfoVo);
    }
}
