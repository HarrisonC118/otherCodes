package com.hatcher.service.impl;

import com.hatcher.dao.UserMapper;
import com.hatcher.entity.Img;
import com.hatcher.dao.ImgMapper;
import com.hatcher.entity.vo.ImgDisplay;
import com.hatcher.service.IImgService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author HatcherCheung
 * @since 2021-10-25
 */
@Service
public class ImgServiceImpl extends ServiceImpl<ImgMapper, Img> implements IImgService {

    @Autowired
    private ImgMapper imgDao;
    @Override
    public int addImg(Img img) {
        return imgDao.insert(img);
    }

    /**
     * 查询用户发布的所有图片信息
     * @param userId 用户id
     * @return
     */
    @Override
    public List<ImgDisplay> queryImgsByUserId(String userId) {
        List<ImgDisplay> imgDisplays = imgDao.queryImgsByUserId(userId);
        return imgDisplays;
    }
}
