package com.perye.upms.shiro.cas;

import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Perye
 * @Date: 2019-03-26
 */
@RestControllerAdvice
public class ShiroExceptionHandler {

    @ExceptionHandler(value = {UnauthorizedException.class})
    public Map<String, Object> unauthorizedExceptionHandler(HttpServletRequest request, Exception e) {
        return noPermissionResult();
    }

    private Map<String, Object> noPermissionResult() {
        Map<String, Object> result = new HashMap<>();
        result.put("code", 0);
        result.put("msg", "暂无权限");
        return result;
    }

}