package com.hatcher.api;

import com.hatcher.entity.Img;
import com.hatcher.service.IImgService;
import com.hatcher.service.IUserService;
import com.hatcher.utils.JsonResult;
import com.hatcher.vo.ImgDisplay;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
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
	private static final String IMG_BASE_LOCATION = File.separator + "images" + File.separator + "user_upload";
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

	@ApiOperation("添加图片")
	@PostMapping(value = "/addImg", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
	public JsonResult AddImg(
			@ApiParam("用户id") @RequestParam("userId") String userId,
			@ApiParam("分组id") @RequestParam("groupId") String groupId,
			@ApiParam("图片文件") @RequestParam("multipartFiles") MultipartFile multipartFile
	) {
//		System.out.println("当前文件数量：" + multipartFiles.length);
		// 获取每个文件
//		for (MultipartFile multipartFile : multipartFiles) {

		String ImgLocation = userId + File.separator + groupId + File.separator + multipartFile.getOriginalFilename();
		// 文件路径
		String FileLocation = IMG_BASE_LOCATION + File.separator + ImgLocation;
		File file = new File(FileLocation);
		InputStream inputStream = null;
		FileOutputStream fileOutputStream = null;
		if (file.getParentFile() != null) {
			file.getParentFile().mkdirs();
		}
		try {
			inputStream = multipartFile.getInputStream();
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
//		}
		return JsonResult.ok();
	}

	@ApiOperation("删除图片")
	@DeleteMapping("/deleteImg")
	public JsonResult DeleteImg(@ApiParam("图片Id") @RequestParam("userId") String userId) {
		Img byId = imgService.getById(userId);
		if (imgService.getGroupImgNum(byId.getGroupId()) <= 1) {
			return JsonResult.errorMsg("分组中至少要有一张图片！");
		}
		Integer integer = imgService.deleteImgByImgId(userId);

		if (integer != 1) {
			return JsonResult.errorMsg("图片删除失败！");
		}
		return JsonResult.ok("图片删除成功！");
	}
}
