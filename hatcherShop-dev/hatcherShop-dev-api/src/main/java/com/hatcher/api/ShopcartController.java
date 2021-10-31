package com.hatcher.api;

import com.hatcher.bo.ShopcartBo;
import com.hatcher.service.IItemsService;
import com.hatcher.utils.JsonResult;
import com.hatcher.vo.ShopCartVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author: HatcherCheung
 * Date:  2021/10/21
 */
@RestController
@RequestMapping("shopcart")
@Api(value = "购物车接口", tags = {"购物车相关api"})
public class ShopcartController {
    @Autowired
    private IItemsService iItemsService;

    @PostMapping("/addItem/{userId}")
    public JsonResult addItem(
            @PathVariable("userId") String userId,
            @RequestParam ShopcartBo shopcartBo,
            HttpServletRequest request,
            HttpServletResponse response
    ) {
        if (StringUtils.isBlank(userId)) {
            return JsonResult.errorMsg("");
        }
        // TODO 如果用户是登录的状态，购物车会同步到redis缓存
        return JsonResult.ok();
    }

    @GetMapping("specIds")
    @ApiOperation(value = "通过商品规格的id获取最新商品信息", notes = "通过商品规格的id获取最新商品信息,主要是刷新商品价格")
    public JsonResult refreshCartItemsBySpecIds(
            @ApiParam(value = "商品规格的多个id", required = true, example = "1,2,3,4")
            @RequestParam("itemSpecIds")
                    String itemSpecIds
    ) {
        if (StringUtils.isBlank(itemSpecIds)) {
            return JsonResult.ok("");
        }
        System.out.println("itemSpecIds-->" + itemSpecIds);
        List<ShopCartVo> shopCartVos = iItemsService.queryItemsBySpecIds(itemSpecIds);
        return JsonResult.ok(shopCartVos);
    }
}
