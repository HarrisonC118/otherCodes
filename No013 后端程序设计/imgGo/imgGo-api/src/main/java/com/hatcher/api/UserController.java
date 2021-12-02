package com.hatcher.api;

import com.hatcher.bo.UserLoginBo;
import com.hatcher.bo.UserRegisterBo;
import com.hatcher.entity.User;
import com.hatcher.service.IUserService;
import com.hatcher.utils.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: HatcherCheung @Date: 2021/11/15 @Description:
 */
@RestController
@Api(value = "用户Controller", tags = "用户接口")
@RequestMapping("user")
public class UserController {
	@Autowired
	private IUserService userService;

	@ApiOperation(value = "用户注册")
	@PostMapping("/register")
	// public JsonResult userRegister(@ApiParam("用户对象，有用户名和密码") @RequestBody UserRegisterBo user) {
	public JsonResult userRegister(@ApiParam("用户名") @RequestParam String username,
	                               @ApiParam("密码") @RequestParam String password) {
		UserRegisterBo userRegisterBo = new UserRegisterBo(username, password);
		int register = userService.register(userRegisterBo);
		if (register != 1) {
			return JsonResult.errorMsg("用户创建失败，请重试！");
		}
		return JsonResult.ok();
	}

	@PostMapping("/login")
	@ApiOperation(value = "用户登录")
	// public JsonResult userLogin(@ApiParam("用户对象，有用户名和密码") @RequestBody UserLoginBo user) {
	public JsonResult userLogin(@ApiParam("用户名") @RequestParam String username,
	                            @ApiParam("密码") @RequestParam String password) {
		UserLoginBo userLoginBo = new UserLoginBo(username, password);
		User login = userService.login(userLoginBo);
		if (login == null) {
			return JsonResult.errorMsg("用户名或密码错误！");
		}
		return JsonResult.ok("用户" + login.getUsername() + "登录成功！");
	}
}
