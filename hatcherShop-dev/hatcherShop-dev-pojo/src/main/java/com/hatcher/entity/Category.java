package com.hatcher.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * <p>
 * 商品分类
 * </p>
 *
 * @author HatcherCheung
 * @since 2021-10-05
 */
@ApiModel(value = "Category对象", description = "商品分类 ")
public class Category implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("分类名称")
    private String name;

    @ApiModelProperty("分类类型")
    private Integer type;

    @ApiModelProperty("父id")
    private Integer fatherId;

    @ApiModelProperty("图标")
    private String logo;

    @ApiModelProperty("口号")
    private String slogan;

    @ApiModelProperty("分类图")
    private String catImage;

    @ApiModelProperty("背景颜色")
    private String bgColor;

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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getFatherId() {
        return fatherId;
    }

    public void setFatherId(Integer fatherId) {
        this.fatherId = fatherId;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    public String getCatImage() {
        return catImage;
    }

    public void setCatImage(String catImage) {
        this.catImage = catImage;
    }

    public String getBgColor() {
        return bgColor;
    }

    public void setBgColor(String bgColor) {
        this.bgColor = bgColor;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name=" + name +
                ", type=" + type +
                ", fatherId=" + fatherId +
                ", logo=" + logo +
                ", slogan=" + slogan +
                ", catImage=" + catImage +
                ", bgColor=" + bgColor +
                "}";
    }
}
