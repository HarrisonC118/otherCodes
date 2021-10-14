package com.hatcher.vo;

import com.baomidou.mybatisplus.annotation.TableId;

import java.util.List;

/**
 * @author: HatcherCheung
 * Date:  2021/10/14
 */
public class CategoryVo {
    @TableId
    private Integer id;
    private String name;
    private String type;
    private Integer fatherId;
    private List<CategorySubCatVo> subCategory;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getFatherId() {
        return fatherId;
    }

    public void setFatherId(Integer fatherId) {
        this.fatherId = fatherId;
    }

    public List<CategorySubCatVo> getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(List<CategorySubCatVo> subCategory) {
        this.subCategory = subCategory;
    }
}
