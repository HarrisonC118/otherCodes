package com.hatcher.controller;

import com.hatcher.entity.User;
import com.hatcher.service.impl.UserServiceImpl;
import com.hatcher.utils.JsonResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 用户登录
 * @author: HatcherCheung
 * Date:  2021/10/8
 */
@WebServlet("/userLogin")
@Controller
public class UserLogin extends HttpServlet {
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
        User user = userService.login(username, password);
        PrintWriter writer = resp.getWriter();
        writer.write(JsonResult.ok(user).getMsg());
    }
}
