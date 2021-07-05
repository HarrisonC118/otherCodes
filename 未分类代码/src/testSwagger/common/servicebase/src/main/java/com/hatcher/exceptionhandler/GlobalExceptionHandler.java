package com.hatcher.exceptionhandler;

import com.hatcher.R;
import com.hatcher.exception.MyException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    @ResponseBody()//返回数据
    public R error(Exception e){
        e.printStackTrace();
        return R.error().message("执行了全局异常错误类");
    }
    @ExceptionHandler(MyException.class)
    @ResponseBody
    public R MyException(MyException e){
        return R.error().message(e.getMessage()).code(e.getCode());
    }
}
