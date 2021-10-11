package com.hatcher.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @author: HatcherCheung
 * Date:  2021/10/8
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    /**
     * 创建时间
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        if (metaObject.hasGetter("gmtCreate") && metaObject.hasGetter("gmtModified")) {
            setFieldValByName("gmtCreate", System.currentTimeMillis(), metaObject);
            setFieldValByName("gmtModified", System.currentTimeMillis(), metaObject);
        }
    }

    /**
     * 最后一次更新时间
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        if (metaObject.hasGetter("et.gmtModified")) {
            setFieldValByName("gmtModified",System.currentTimeMillis(), metaObject);
        }
    }

}