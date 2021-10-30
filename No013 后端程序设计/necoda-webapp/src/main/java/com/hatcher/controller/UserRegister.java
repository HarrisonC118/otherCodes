package com.hatcher.controller;

import com.hatcher.entity.User;
import com.hatcher.service.IUserService;
import com.hatcher.service.impl.UserServiceImpl;
import com.hatcher.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 用户注册
 * @author: HatcherCheung
 * Date:  2021/10/25
 */
@WebServlet("/userRegister")
@Controller
public class UserRegister extends HttpServlet {
    private WebApplicationContext ctx = null;
    @Override
    public void init() throws ServletException {
        ServletContext context = getServletContext();
        ctx = WebApplicationContextUtils.getWebApplicationContext(context);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserServiceImpl userService = ctx.getBean("userService", UserServiceImpl.class);
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        int register = userService.register(username, password);
        PrintWriter writer1 = resp.getWriter();
        if (register == -1) {
            writer1.write(JsonResult.errorMsg("用户名重复！").getMsg());
        } else {
            writer1.write(JsonResult.ok("注册成功！").getData().toString());
        }
    }
}
