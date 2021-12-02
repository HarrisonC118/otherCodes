package com.hatcher.controller;

import com.hatcher.entity.Group;
import com.hatcher.service.impl.GroupServiceImpl;
import com.hatcher.utils.JsonResult;
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
 * 添加一个组
 * @author: HatcherCheung
 * Date:  2021/10/25
 */
@WebServlet("/addGroup")
@Controller
public class AddGroup extends HttpServlet {
    private WebApplicationContext ctx = null;
    @Override
    public void init() throws ServletException {
        ServletContext context = getServletContext();
        ctx = WebApplicationContextUtils.getWebApplicationContext(context);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GroupServiceImpl groupService = ctx.getBean("groupServiceImpl", GroupServiceImpl.class);
        String userId = req.getParameter("userId");
        String groupName = req.getParameter("groupName");
        String groupContent = req.getParameter("groupContent");
        Group group = new Group();
        group.setGroupName(groupName);
        group.setGroupContent(groupContent);
        group.setUserId(userId);
        PrintWriter writer = resp.getWriter();
        int i = groupService.AddGroupInfo(group);
        if (i == -1) {
            writer.write(JsonResult.errorMsg("添加分组失败！").getMsg());
        } else {
            writer.write(JsonResult.ok("添加分组成功").getData().toString());
        }
    }
}
