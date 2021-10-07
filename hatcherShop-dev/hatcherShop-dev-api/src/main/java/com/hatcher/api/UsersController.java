package com.hatcher.api;


import com.hatcher.bo.UserBO;
import com.hatcher.service.impl.UsersServiceImpl;
import com.hatcher.utils.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 用户表  前端控制器
 * </p>
 *
 * @author HatcherCheung
 * @since 2021-10-05
 */
@RestController
@Api(tags = "用户操作的接口")
public class UsersController {
    @Autowired
    private UsersServiceImpl usersService;

    @GetMapping("/usernameIsExist")
    @ApiOperation(value = "判断用户是否存在", notes = "判断用户是否存在，先判断是不是空字符串，在判断是否存在。存在或空返回500错误", httpMethod = "GET")
    public JsonResult usernameIsExist(@RequestParam(value = "username", required = true) String username) {
        // 比较传入的username 是不是空字符串
        if (StringUtils.isBlank(username)) {
            // 如果是，就返回500错误
            return JsonResult.errorMsg("您输入的内容为空！请重试！");
        }
        // 查找用户名是否存在,如果存在就返回500错误
        boolean isExist = usersService.queryUsernameIsExist(username);
        if (isExist) {
            return JsonResult.errorMsg("用户名已存在！请重试！");
        }
        // 用户名没有重复，就返回200表示请求成功
        return JsonResult.ok();
    }

    @PostMapping("/regist")
    @ApiOperation(value = "注册", notes = "用户注册。先判断是不是空字符串，在判断是否存在，密码是不是少于六位，确认密码和密码是否一致。", httpMethod = "POST")
    public JsonResult regist(@RequestBody UserBO userBO) {
        String username = userBO.getUsername();
        String password = userBO.getPassword();
        String confirmPwd = userBO.getConfirmPassword();
        // 判断用户名和密码不为空
        if (StringUtils.isBlank(username)) {
            return JsonResult.errorMsg("您输入的内容为空！请重试！");
        }
        // 判断用户名是否存在
        if (usersService.queryUsernameIsExist(username)) {
            return JsonResult.errorMsg("用户名已存在！请重试！");
        }
        // 判断密码不少于6位
        if (password.length() < 6) {
            return JsonResult.errorMsg("密码长度不能少于6位！请重试！");
        }
        // 判断两次密码是否一致
        if (!password.equals(confirmPwd)) {
            return JsonResult.errorMsg("两次密码不一致！请重试！");
        }
        // 实现注册
        usersService.createUser(userBO);
        return JsonResult.ok("注册成功！");
    }
}
