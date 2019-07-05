package com.cn.controller;

import com.alibaba.fastjson.JSONObject;
import com.cn.serviceImpl.MysqlOpsImpl;
import com.cn.serviceImpl.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;


/**
 * @Author: zhangjixu
 * @CreateDate: 2018/8/27
 * @Description:
 * @Version: 1.0.0
 */
@RestController
public class DataController implements EnvironmentAware {

    @Autowired
    private TestService testService;

    @Autowired
    private MysqlOpsImpl mysqlOpsImpl;

    private Environment environmentAware = null;

    private static final Logger LOGGER = LoggerFactory.getLogger(DataController.class);

    @RequestMapping(value = "/getJmeter", produces = "application/json; charset=utf-8", method = RequestMethod.GET)
    public Object getJmeter(String name, String age) {
        JSONObject json = new JSONObject();
        json.put("code", 100);
        json.put("name", name);
        json.put("age", age);
        LOGGER.error("name {}, age {}", name, age);
        return json;
    }

    @RequestMapping(value = "/nginx", produces = "application/json; charset=utf-8", method = RequestMethod.GET)
    public Object nginx() {
        mysqlOpsImpl.test();
        return "nginx";
    }

    @RequestMapping(value = "/json", produces = "application/json; charset=utf-8", method = RequestMethod.POST)
    public Object data(@RequestBody String params) {
        JSONObject json = JSONObject.parseObject(params);
        String name = json.getString("name");
        String age = json.getString("age");
        LOGGER.error(" json  name {}, age {}", name, age);
        json.put("code", 100);
        return json;
    }

    @RequestMapping(value = "/async", produces = "application/json; charset=utf-8", method = RequestMethod.GET)
    public Object async() throws ExecutionException, InterruptedException {
        System.out.println("start");
        Future<String> future = testService.get("data");
        LOGGER.error(" ================================ async");
        System.out.println(" 开始 ******** " + future.isDone());

        if (future.isDone()) {
            System.out.println(" 完成了 " + future.get());
        }
        System.out.println("end");

        System.out.println(" ******** " + future.isDone());
        return future.get();
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.environmentAware = environment;
    }
}
