package com.hatcher.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hatcher.entity.Items;
import com.hatcher.entity.ItemsImg;
import com.hatcher.entity.ItemsParam;
import com.hatcher.entity.ItemsSpec;
import com.hatcher.vo.SearchItemsVo;

import java.util.List;

/**
 * <p>
 * 商品表 商品信息相关表：分类表，商品图片表，商品规格表，商品参数表 服务类
 * </p>
 *
 * @author HatcherCheung
 * @since 2021-10-05
 */
public interface IItemsService extends IService<Items> {
    /**
     * 根据商品id查询商品列表
     *
     * @param itemId 商品id
     * @return
     */
    public Items queryItemById(String itemId);

    /**
     * 根据商品id查询商品的图片列表
     *
     * @param itemId 商品id
     * @return
     */
    public List<ItemsImg> queryItemImgList(String itemId);

    /**
     * 根据商品id查询商品规格
     *
     * @param itemId 商品id
     * @return
     */
    public List<ItemsSpec> queryItemSpecList(String itemId);

    /**
     * 根据商品id获取参数
     *
     * @param itemId 商品id
     * @return
     */
    public ItemsParam queryItemParam(String itemId);

    /**
     * 搜索商品
     *
     * @param page     分页信息
     * @param keywords 关键字
     * @param sort     根据啥排序
     * @return
     */
    List<SearchItemsVo> searchItems(IPage<SearchItemsVo> page, String keywords, String sort);
}
