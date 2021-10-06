package com.hatcher.api;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 轮播图  前端控制器
 * </p>
 *
 * @author HatcherCheung
 * @since 2021-10-05
 */
@Controller
@RestController("/carousel")
@Api(value = "carousel", tags = {"控制carousel的方法"})
public class CarouselController {
    @GetMapping
    @ApiOperation("测试方法")
    public String test() {
        return "HelloWorld!";
    }
}
