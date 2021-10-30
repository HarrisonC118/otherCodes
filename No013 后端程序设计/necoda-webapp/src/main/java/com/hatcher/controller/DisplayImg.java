package com.hatcher.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URLDecoder;

/**
 * 给url
 * @author: HatcherCheung
 * Date:  2021/10/29
 */
@WebServlet("/displayImg")
public class DisplayImg extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String filepath = URLDecoder.decode(req.getParameter("imgUrl"), "UTF-8");
        System.out.println("filepath = " + filepath);
        //读取本地图片输入流
        FileInputStream fis = new FileInputStream(filepath);
        //得到文件大小
        int i = fis.available();
        //byte数组用于存放图片字节数据
        byte[] buff = new byte[i];

        fis.read(buff);
        fis.close();

        //设置发送到客户端的响应内容类型
        resp.setContentType("image/*");
        OutputStream out = resp.getOutputStream();
        out.write(buff);
        out.close();
    }
}
