package com.hatcher.dao;

import com.hatcher.entity.Img;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hatcher.entity.vo.ImgDisplay;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author HatcherCheung
 * @since 2021-10-25
 */
public interface ImgMapper extends BaseMapper<Img> {
    /**
     * 查询用户发布的所有图片信息
     * @param userId 用户id
     * @return
     */
    List<ImgDisplay> queryImgsByUserId(String userId);
}
