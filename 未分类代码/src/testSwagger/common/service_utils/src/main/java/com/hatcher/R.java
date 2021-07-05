package com.hatcher;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.HashMap;
import java.util.Map;

@Accessors(chain = true)//链式编程
@Data
public class R {
    @ApiModelProperty("是否成功")
    private Boolean success;
    @ApiModelProperty("返回码")
    private Integer code;
    @ApiModelProperty("返回消息")
    private String message;
    @ApiModelProperty("返回数据")
    private Map<String, Object> data = new HashMap<>();
    private R() { }//构造方法私有
    //成功的方法
    public static R success(){
        R r = new R();
        r.setSuccess(true);
        r.setCode(ResultCode.SUCCESS);
        r.setMessage("成功！");
        return r;
    }
    //失败的方法
    public static R error(){
        R r = new R();
        r.setSuccess(true);
        r.setCode(ResultCode.SUCCESS);
        r.setMessage("成功！");
        return r;
    }
    public R message(String message){
        this.setMessage(message);
        return this;
    }
    public R data(String a,Object o){
        Map<String, Object> d = new HashMap<>();
        d.put(a,o);
        this.setData(d);
        return this;
    }
    public R code(Integer i){
        this.setCode(i);
        return this;
    }
}
