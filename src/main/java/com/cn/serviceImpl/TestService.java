package com.cn.serviceImpl;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

/**
 * @Author: zhangjixu
 * @CreateDate: 2018/9/4
 * @Description:
 * @Version: 1.0.0
 */
@Service
public class TestService {

    @Async
    public Future<String> get(String str){
        try {
            Thread.sleep(3000);
            System.out.println("async task " + str);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new AsyncResult<>("success");
    }

}
