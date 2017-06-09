package com.study.handler;

import com.study.utils.ResultUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author yk
 * @version 1.0 Date: 2017/6/8
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Map defaultException(HttpServletRequest request, Exception e){
        // 运行时异常
        if(e instanceof RuntimeException){
            e.printStackTrace();
//            return ResultUtils.error(500, "服务器错误");
        }
        //404 异常
        if(e instanceof NoHandlerFoundException){
            logger.error(e.getMessage());
            return ResultUtils.error(404, "找不到资源");
        }
        e.printStackTrace();
        return ResultUtils.error(500, "服务器错误");
    }
}
