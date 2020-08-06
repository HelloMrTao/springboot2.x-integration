package com.zgy.bootintegration.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author renjiaxin
 * @Date 2020/8/6
 * @Description 生成cookie, 读取Cookie
 */
@Controller
@RequestMapping("cookie")
public class CookieContorller {

    /**
     *  创建cookie
     *
     * @param response
     * @return str
     */
    @GetMapping("create")
    @ResponseBody
    public String cookie(HttpServletResponse response) {
        Cookie c1 = new Cookie("name", "zhangsan");
        Cookie c2 = new Cookie("hobby", "跳舞");
        response.addCookie(c1);
        response.addCookie(c2);
        return "创建cookie， 请通过F12在network之中查看";
    }

    /**
     * 获取cookie
     *
     * @param request
     * @return str
     */
    @GetMapping("get")
    @ResponseBody
    public String cookie(HttpServletRequest request) {
        StringBuilder cookieStr = new StringBuilder();
        Cookie[] cookies = request.getCookies();
        for (int i = 0; i < cookies.length; i++) {
            cookieStr.append(cookies[i].getName() +", " +cookies[i].getValue()+ "; ");
        }
        return "cookie的信息是: " + cookieStr.toString();
    }
}
