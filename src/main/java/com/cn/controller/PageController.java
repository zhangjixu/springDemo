package com.cn.controller;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UrlPathHelper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: zhangjixu
 * @CreateDate: 2018/8/31
 * @Description:
 * @Version: 1.0.0
 */
@Controller
public class PageController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PageController.class);

    @RequestMapping(value = "/login", produces = "application/json; charset=utf-8", method = RequestMethod.GET)
    public String login(Map<String,Object> map, Model model) {
        map.put("key", "map");
        model.addAttribute("model", "model");
        return "/login";
    }

    @RequestMapping("/page")
    public ModelAndView page() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("key", "modeAndView");
        modelAndView.setViewName("/login");
        return modelAndView;
    }

    @RequestMapping("/write")
    public void hanadle(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().println("<h1>response</h1>");
    }

    @RequestMapping("/forword")
    public Map<String,String> forword(HttpServletRequest request, HttpServletResponse response) throws IOException {
        UrlPathHelper urlPathHelper = new UrlPathHelper();
        System.out.println(urlPathHelper.getLookupPathForRequest(request));
        Map<String,String> map = new HashMap<>();
        map.put("map", "map");
        System.out.println(map);
        return map;
    }

    @RequestMapping("/login1")
    public String nopage(HttpServletRequest request, HttpServletResponse response) {
        LOGGER.error(" ============= uri {} ", request.getRequestURI());
        LOGGER.error(" ============= url {} ", request.getRequestURL());
        return "/login";
    }



}
