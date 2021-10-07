package com.hatcher.api;


import com.hatcher.bo.UserBO;
import com.hatcher.entity.Users;
import com.hatcher.service.impl.UsersServiceImpl;
import com.hatcher.utils.CookieUtils;
import com.hatcher.utils.JsonResult;
import com.hatcher.utils.JsonUtils;
import com.hatcher.utils.MD5Utils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
    final static Logger looger = LoggerFactory.getLogger(UsersController.class);
    @Autowired
    private UsersServiceImpl usersService;

    @GetMapping("/usernameIsExist")
    @ApiOperation(value = "判断用户是否存在", notes = "判断用户是否存在，先判断是不是空字符串，在判断是否存在。存在或空返回500错误", httpMethod = "GET")
    public JsonResult usernameIsExist(@RequestParam(value = "username", required = true) String username) {
        looger.info("======开始判断用户是否存在======");
        // 比较传入的username 是不是空字符串
        if (StringUtils.isBlank(username)) {
            // 如果是，就返回500错误
            looger.warn("======输入的内容为空======");
            return JsonResult.errorMsg("您输入的内容为空！请重试！");
        }
        // 查找用户名是否存在,如果存在就返回500错误
        boolean isExist = usersService.queryUsernameIsExist(username);
        if (isExist) {
            looger.warn("======用户名已存在======");
            return JsonResult.errorMsg("用户名已存在！请重试！");
        }
        // 用户名没有重复，就返回200表示请求成功
        return JsonResult.ok();
    }

    @PostMapping("/regist")
    @ApiOperation(value = "注册", notes = "用户注册。先判断是不是空字符串，在判断是否存在，密码是不是少于六位，确认密码和密码是否一致。", httpMethod = "POST")
    public JsonResult regist(@RequestBody UserBO userBO, HttpServletRequest request, HttpServletResponse response) {
        looger.info("======用户注册信息======");
        String username = userBO.getUsername();
        String password = userBO.getPassword();
        String confirmPwd = userBO.getConfirmPassword();
        // 判断用户名和密码不为空
        if (StringUtils.isBlank(username)) {
            looger.warn("======输入的内容为空======");
            return JsonResult.errorMsg("您输入的内容为空！请重试！");
        }
        // 判断用户名是否存在
        if (usersService.queryUsernameIsExist(username)) {
            looger.warn("======用户名已存在======");
            return JsonResult.errorMsg("用户名已存在！请重试！");
        }
        // 判断密码不少于6位
        if (password.length() < 6) {
            looger.warn("======密码长度少于6位======");
            return JsonResult.errorMsg("密码长度不能少于6位！请重试！");
        }
        // 判断两次密码是否一致
        if (!password.equals(confirmPwd)) {
            looger.warn("======两次密码不一致======");
            return JsonResult.errorMsg("两次密码不一致！请重试！");
        }
        // 实现注册
        Users user = usersService.createUser(userBO);
        // 设置部分用户信息不作为json字符串返回
        user = setNullProperty(user);
        // 设置cookie
        CookieUtils.setCookie(request, response, "userInfo", JsonUtils.objectToJson(user), true);
        looger.info("======用户：" + user.getUsername() + "注册成功======");
        return JsonResult.ok("注册成功！");
    }

    @PostMapping("/login")
    @ApiOperation(value = "用户登录", notes = "用户登录", httpMethod = "POST")
    public JsonResult login(@RequestBody UserBO userBO, HttpServletRequest request, HttpServletResponse response) {
        looger.info("======用户开始登录======");
        String username = userBO.getUsername();
        String password = userBO.getPassword();
        // 判断用户名和密码不为空
        if (StringUtils.isBlank(username)) {
            looger.warn("======输入的内容为空======");
            return JsonResult.errorMsg("您输入的内容为空！请重试！");
        }
        // 判断密码不少于6位
        if (password.length() < 6) {
            looger.warn("======密码长度少于6位======");
            return JsonResult.errorMsg("密码长度不能少于6位！请重试！");
        }

        // 实现登录
        Users user = null;
        try {
            user = usersService.queryUserForLogin(username, MD5Utils.getMD5Str(password));
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (user == null) {
            looger.warn("======用户名或密码错误======");
            return JsonResult.errorMsg("用户名或密码错误！");
        }

        // 设置部分用户信息不作为json字符串返回
        user = setNullProperty(user);
        // 设置cookie
        CookieUtils.setCookie(request, response, "userInfo", JsonUtils.objectToJson(user), true);
        looger.info("======用户：" + user.getUsername() + "登录成功======");
        return JsonResult.ok(user);
    }

    private Users setNullProperty(Users user) {
        looger.info("======设置用户：" + user.getUsername() + "不必要的信息为null======");
        user.setPassword(null);
        user.setMobile(null);
        user.setEmail(null);
        user.setCreatedTime(null);
        user.setUpdatedTime(null);
        user.setBirthday(null);
        return user;
    }
}
