package com.hatcher.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hatcher.entity.Items;
import com.hatcher.entity.ItemsImg;
import com.hatcher.entity.ItemsParam;
import com.hatcher.entity.ItemsSpec;
import com.hatcher.mapper.ItemsImgMapper;
import com.hatcher.mapper.ItemsMapper;
import com.hatcher.mapper.ItemsParamMapper;
import com.hatcher.mapper.ItemsSpecMapper;
import com.hatcher.service.IItemsService;
import com.hatcher.vo.SearchItemsVo;
import com.hatcher.vo.ShopCartVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <p>
 * 商品表 商品信息相关表：分类表，商品图片表，商品规格表，商品参数表 服务实现类
 * </p>
 *
 * @author HatcherCheung
 * @since 2021-10-05
 */
@Service
public class ItemsServiceImpl extends ServiceImpl<ItemsMapper, Items> implements IItemsService {
    @Autowired
    private ItemsParamMapper itemsParamDao;
    @Autowired
    private ItemsImgMapper itemsImgDao;
    @Autowired
    private ItemsSpecMapper itemsSpecDao;
    @Autowired
    private ItemsMapper itemsDao;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, rollbackFor = Exception.class)
    public List<ItemsImg> queryItemImgList(String itemId) {
        QueryWrapper<ItemsImg> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("item_id", itemId);
        return itemsImgDao.selectList(queryWrapper);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, rollbackFor = Exception.class)
    public List<ItemsSpec> queryItemSpecList(String itemId) {
        QueryWrapper<ItemsSpec> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("item_id", itemId);
        return itemsSpecDao.selectList(queryWrapper);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, rollbackFor = Exception.class)
    public ItemsParam queryItemParam(String itemId) {
        QueryWrapper<ItemsParam> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("item_id", itemId);
        return itemsParamDao.selectOne(queryWrapper);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, rollbackFor = Exception.class)
    public Items queryItemById(String itemId) {
        QueryWrapper<Items> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", itemId);
        return itemsDao.selectOne(queryWrapper);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, rollbackFor = Exception.class)
    public List<SearchItemsVo> searchItems(IPage<SearchItemsVo> page, String keywords, String sort) {
        return itemsDao.searchItems(page, keywords, sort);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, rollbackFor = Exception.class)
    public List<ShopCartVo> queryItemsBySpecIds(String specIds) {
        String[] ids = specIds.split(",");
        List<String> specIdsList = new ArrayList<>();
        // 使用Collections的工具类，把String[]中的所有数据添加到List中
        Collections.addAll(specIdsList, ids);
        return itemsDao.queryItemsBySpecIds(specIdsList);
    }
}
