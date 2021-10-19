package com.hatcher.api;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hatcher.entity.Items;
import com.hatcher.entity.ItemsImg;
import com.hatcher.entity.ItemsParam;
import com.hatcher.entity.ItemsSpec;
import com.hatcher.finals.BaseController;
import com.hatcher.service.IItemsService;
import com.hatcher.utils.JsonResult;
import com.hatcher.vo.ItemInfoVo;
import com.hatcher.vo.SearchItemsVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
public class ItemsController extends BaseController {
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

    @GetMapping("/searchItems")
    @ApiOperation(value = "查询指定关键字商品", notes = "除了关键字，还可以指定排序的标准")
    public JsonResult searchItems(
            @ApiParam(value = "关键字", name = "keywords", required = true)
            @RequestParam("keywords") String keywords,
            @ApiParam(value = "排序标志", name = "sort", allowableValues = "k,c,p")
            @RequestParam("sort") String sort,
            @RequestParam("pageNum")
            @ApiParam(name = "pageNum", value = "当前是第几页")
                    Integer pageNum,
            @RequestParam("pageSize")
            @ApiParam(name = "pageSize", value = "一页显示多少条评论")
                    Integer pageSize) {
        if (pageNum == null) {
            pageNum = 1;
        }
        if (pageSize == null) {
            pageSize = COMMENT_PAGE_SIZE;
        }
        if (StringUtils.isBlank(sort)) {
            sort = "c";
        }
        if (StringUtils.isBlank(keywords)) {
            return JsonResult.errorMsg("请求错误！");
        }
        IPage<SearchItemsVo> page = new Page<>(pageNum, pageSize);
        List<SearchItemsVo> searchItemsVos = iItemsService.searchItems(page, keywords, sort);
        return JsonResult.ok(searchItemsVos);
    }
}
