package com.hatcher.controller;

import com.hatcher.entity.Group;
import com.hatcher.entity.Img;
import com.hatcher.service.impl.GroupServiceImpl;
import com.hatcher.service.impl.ImgServiceImpl;
import com.hatcher.utils.JsonResult;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

/**
 * 添加一张图片
 * @author: HatcherCheung
 * Date:  2021/10/26
 */
@WebServlet("/addImg")
@Controller
public class AddImg  extends HttpServlet {
    // 存储图片的目录名字
    private static final String UPLOAD_DIRECTORY = "upload";
    private WebApplicationContext ctx = null;
    @Override
    public void init() throws ServletException {
        ServletContext context = getServletContext();
        ctx = WebApplicationContextUtils.getWebApplicationContext(context);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ImgServiceImpl imgService = ctx.getBean("imgServiceImpl", ImgServiceImpl.class);
//        从inputStream流中获取userId和groupId
        ServletInputStream inputStream = req.getInputStream();
        byte[] b = new byte[1024];
        inputStream.skip(103);
        int userIdLen = inputStream.read(b, 0, 32);
        String userId = new String(b, 0, userIdLen);
        System.out.println("userId = " + userId);
        inputStream.skip(106);
        int groupIdLen = inputStream.read(b, 0, 32);
        String groupId = new String(b, 0, groupIdLen);
        System.out.println("groupId = " + groupId);
//        获取完毕
        Img img = new Img();
        img.setUserId(userId);
        img.setGroupId(groupId);
        String url = getUrl(req);
        System.out.println("url = " + url);
        img.setImgUrl(url);
        PrintWriter writer = resp.getWriter();
        int i = imgService.addImg(img);
        if (i == -1) {
            writer.write(JsonResult.errorMsg("添加图片失败！").getMsg());
        } else {
            writer.write(JsonResult.ok("添加图片成功").getData().toString());
        }
    }
    private String getUrl(HttpServletRequest req) {
        String filePath = null;
        String uploadPath = req.getServletContext().getRealPath("./") + File.separator + UPLOAD_DIRECTORY;
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }
        // 配置上传参数
        DiskFileItemFactory factory = new DiskFileItemFactory();
        // 设置临时存储目录
        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

        ServletFileUpload upload = new ServletFileUpload(factory);
        try {
            // 解析请求的内容提取文件数据
            @SuppressWarnings("unchecked")
            List<FileItem> formItems = upload.parseRequest(req);

            if (formItems != null && formItems.size() > 0) {
                // 迭代表单数据
                for (FileItem item : formItems) {
                    // 处理不在表单中的字段
                    if (!item.isFormField()) {
                        String fileName = new File(item.getName()).getName();
                        filePath = uploadPath + File.separator + fileName;
                        File storeFile = new File(filePath);
                        // 在控制台输出文件的上传路径
                        System.out.println(filePath);
                        // 保存文件到硬盘
                        item.write(storeFile);
                        req.setAttribute("message",
                                "文件上传成功!");
                    }
                }
            }
        } catch (Exception ex) {
            req.setAttribute("message",
                    "错误信息: " + ex.getMessage());
        }

        try {
            return URLEncoder.encode(filePath,"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "";
    }
}
