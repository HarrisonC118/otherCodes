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
import org.springframework.web.bind.annotation.*;

/**
 * @author: HatcherCheung @Date: 2021/11/15 @Description:
 */
@RestController
@Api(value = "用户Controller", tags = "用户接口")
@RequestMapping("user")
public class UserController {
	private static final Integer USER_INSERT_SUCCESS = 1;
	@Autowired
	private IUserService userService;

	@ApiOperation(value = "用户注册")
	@PostMapping("/register")
	public JsonResult userRegister(@ApiParam("用户名") @RequestParam String username,
	                               @ApiParam("密码") @RequestParam String password) {
		UserRegisterBo userRegisterBo = new UserRegisterBo(username, password);
		if (userService.isUsernameExist(username)) {
			return JsonResult.errorMsg("用户已存在，请重试！");
		}
		int register = userService.register(userRegisterBo);
		if (register != USER_INSERT_SUCCESS) {
			return JsonResult.errorMsg("用户创建失败，请重试！");
		}
		return JsonResult.ok("用户创建成功，正在返回登录页面！");
	}

	@PostMapping("/login")
	@ApiOperation(value = "用户登录")
	public JsonResult userLogin(@ApiParam("用户名") @RequestParam String username,
	                            @ApiParam("密码") @RequestParam String password) {
		UserLoginBo userLoginBo = new UserLoginBo(username, password);
		User login = userService.login(userLoginBo);
		if (login == null) {
			return JsonResult.errorMsg("用户名或密码错误！");
		}
		return JsonResult.ok("用户" + login.getUsername() + "登录成功！");
	}

	@PostMapping("/getIdByUsername/{username}")
	@ApiOperation(value = "通过用户的用户名获取对应的id")
	public JsonResult getIdByUsername(@ApiParam("用户名") @PathVariable("username") String username) {
		if (!userService.isUsernameExist(username)) {
			return JsonResult.errorMsg("用户名不存在");
		}
		String idByUsername = userService.getIdByUsername(username);
		return JsonResult.ok(idByUsername);
	}
}
