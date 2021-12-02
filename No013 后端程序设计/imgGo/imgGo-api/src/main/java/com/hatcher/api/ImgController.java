package com.hatcher.api;

import com.hatcher.service.IImgService;
import com.hatcher.service.IUserService;
import com.hatcher.utils.JsonResult;
import com.hatcher.vo.ImgDisplay;
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
 * @author: HatcherCheung
 * @Date: 2021/11/16
 * @Description: 图片控制器
 */
@Api(value = "图片Controller", tags = "控制图片的展示、添加")
@RequestMapping("img")
@RestController
public class ImgController {
	@Autowired
	private IImgService imgService;
	@Autowired
	private IUserService userService;

	@ApiOperation("获取用户的所有照片")
	@GetMapping("/getImg/{userId}")
	public JsonResult QueryImgsById(@ApiParam("用户id") @PathVariable("userId") String userId) {

		if (!userService.isIdExist(userId)) {
			return JsonResult.errorMsg("用户id不存在！");
		}
		List<ImgDisplay> imgDisplays = imgService.queryImgsByUserId(userId);
		return JsonResult.ok(imgDisplays);
	}
}
