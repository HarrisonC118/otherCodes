package com.hatcher.api;


import com.hatcher.service.impl.UsersServiceImpl;
import com.hatcher.utils.JsonResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 用户表  前端控制器
 * </p>
 *
 * @author HatcherCheung
 * @since 2021-10-05
 */
@RestController
public class UsersController {
    @Autowired
    private UsersServiceImpl usersService;

    @GetMapping("/usernameIsExist")
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
}
