package com.hatcher.controller;

import com.hatcher.entity.vo.ImgDisplay;
import com.hatcher.service.impl.ImgServiceImpl;
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
import java.util.List;

/**
 * 查询用户的所有图片
 * @author: HatcherCheung
 * Date:  2021/10/28
 */
@WebServlet("/queryImgsById")
@Controller
public class QueryImgsById extends HttpServlet {
    private WebApplicationContext ctx = null;
    @Override
    public void init() throws ServletException {
        ServletContext context = getServletContext();
        ctx = WebApplicationContextUtils.getWebApplicationContext(context);
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId = req.getParameter("userId");
        ImgServiceImpl imgService = ctx.getBean("imgServiceImpl", ImgServiceImpl.class);
        List<ImgDisplay> imgDisplays = imgService.queryImgsByUserId(userId);
        PrintWriter writer = resp.getWriter();
        writer.write(JsonResult.ok(imgDisplays).toStr());
    }
}
