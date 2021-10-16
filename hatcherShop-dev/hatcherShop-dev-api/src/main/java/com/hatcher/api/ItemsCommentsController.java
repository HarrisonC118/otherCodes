package com.hatcher.api;


import com.hatcher.service.IItemsCommentsService;
import com.hatcher.utils.JsonResult;
import com.hatcher.vo.CommentLevelCountsVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 商品评价表  前端控制器
 * </p>
 *
 * @author HatcherCheung
 * @since 2021-10-05
 */
@RestController
@RequestMapping("/items-comments")
@Api(tags = "商品评论Api")
public class ItemsCommentsController {
    @Autowired
    private IItemsCommentsService iItemsCommentsService;

    @ApiOperation(value = "访问评论数量", notes = "包括全部评论、好评、中评、差评的数量")
    @GetMapping("/getItemCounts")
    public JsonResult getItemCounts(
            @RequestParam("itemId")
            @ApiParam(name = "itemId", value = "需要查询的商品id号", required = true)
                    String itemId) {
        CommentLevelCountsVo commentLevelCountsVo = iItemsCommentsService.queryCommentCounts(itemId);
        return JsonResult.ok(commentLevelCountsVo);
    }
}
