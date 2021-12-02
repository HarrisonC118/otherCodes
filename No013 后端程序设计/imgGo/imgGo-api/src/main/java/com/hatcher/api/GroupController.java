package com.hatcher.api;

import com.hatcher.bo.AddGroupBo;
import com.hatcher.service.IGroupService;
import com.hatcher.utils.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: HatcherCheung
 * @Date: 2021/11/16
 * @Description: 分组控制器
 */
@RestController
@Api(value = "groupController", tags = {"分组相关方法"})
@RequestMapping("group")
public class GroupController {

	@Autowired
	private IGroupService groupService;

	@ApiOperation(value = "添加分组")
	@PostMapping("/addGroup")
	public JsonResult addGroup(
			@ApiParam(value = "分组对象")
			@RequestBody
					AddGroupBo groupBo) {
		int i = groupService.addGroupInfo(groupBo);
		if (i != 1) {
			return JsonResult.errorMsg("添加失败！");
		}
		return JsonResult.ok("添加成功");
	}
}
