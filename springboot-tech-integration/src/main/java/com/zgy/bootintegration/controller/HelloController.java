package com.zgy.bootintegration.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.zgy.bootintegration.utils.JacksonUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author renjiaxin
 * @Date 2020/5/15
 * @Description
 */
@RestController
public class HelloController {
    @ResponseBody
    @RequestMapping("hello")
    public String hello() throws JsonProcessingException {
        return JacksonUtil.getJsonFromObject("hello");
    }
}
