package com.hatcher.api;

import com.hatcher.bo.AddGroupBo;
import com.hatcher.bo.UpdateGroupInfoBo;
import com.hatcher.entity.Group;
import com.hatcher.entity.Img;
import com.hatcher.service.IGroupService;
import com.hatcher.service.IImgService;
import com.hatcher.utils.JsonResult;
import com.hatcher.vo.GroupNameAndContentVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.*;

/**
 * @author: HatcherCheung
 * @Date: 2021/11/16
 * @Description: 分组控制器
 */
@RestController
@Api(value = "groupController", tags = {"分组相关方法"})
@RequestMapping("group")
public class GroupController {
	private static final String IMG_BASE_LOCATION = File.separator + "images" + File.separator + "user_upload";
	private static final String IMG_DEFAULT_UPLOAD_LOCATION = "C:\\Users\\11090\\Pictures\\Camera Roll\\1001.png";
	@Autowired
	private IGroupService groupService;
	@Autowired
	private IImgService imgService;

	@ApiOperation(value = "添加分组")
	@PostMapping("/addGroup")
	public JsonResult addGroup(
			@ApiParam(value = "分组对象")
			@RequestBody
					AddGroupBo groupBo) {
		String i = groupService.addGroupInfo(groupBo);
		if ("null".equals(i)) {
			return JsonResult.errorMsg("添加失败！");
		}
		UploadDefaultPic(groupBo.getUserId(), i);
		return JsonResult.ok("添加成功");
	}

	@ApiOperation(value = "修改分组信息")
	@PostMapping("/updateGroupInfo")
	public JsonResult updateGroupInfo(
			@ApiParam(value = "分组对象")
			@RequestBody
					UpdateGroupInfoBo updateGroupInfoBo) {
		Group group = groupService.getById(updateGroupInfoBo.getGroupId());
		System.out.println(updateGroupInfoBo);
		group.setGroupContent(updateGroupInfoBo.getGroupContent());
		group.setGroupName(updateGroupInfoBo.getGroupName());
		group.setGmtModified(null);
		if (groupService.updateById(group)) {
			return JsonResult.ok("修改成功");
		}
		return JsonResult.errorMsg("修改失败！");
	}

	@GetMapping("/getGroupInfo/{groupId}")
	@ApiOperation("通过分组id获取分组信息")
	public JsonResult getGroupInfoById(@ApiParam(value = "分组id") @PathVariable("groupId") String groupId) {
		Group byId = groupService.getById(groupId);
		GroupNameAndContentVo groupVo = new GroupNameAndContentVo();
		groupVo.setGroupId(byId.getId());
		groupVo.setGroupName(byId.getGroupName());
		groupVo.setGroupContent(byId.getGroupContent());
		return JsonResult.ok(groupVo);
	}

	private void UploadDefaultPic(String userId, String groupId) {
		String ImgLocation = userId + File.separator + groupId + File.separator + "default.jpg";
		// 文件路径
		String FileLocation = IMG_BASE_LOCATION + File.separator + ImgLocation;
		File file = new File(FileLocation);
		InputStream inputStream = null;
		FileOutputStream fileOutputStream = null;
		if (file.getParentFile() != null) {
			file.getParentFile().mkdirs();
		}
		try {
			// 指定默认图片
			inputStream = new FileInputStream(IMG_DEFAULT_UPLOAD_LOCATION);
			fileOutputStream = new FileOutputStream(file);
			// 把输入流中的数据复制到输出流中
			IOUtils.copy(inputStream, fileOutputStream);
			Img img = new Img();
			img.setUserId(userId);
			img.setGroupId(groupId);
			img.setImgUrl(ImgLocation);
			imgService.addImg(img);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (fileOutputStream != null) {
				try {
					fileOutputStream.flush();
					fileOutputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
