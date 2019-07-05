package com.cn.scheduled;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @Author: zhangjixu
 * @CreateDate: 2018/9/2
 * @Description:
 * @Version: 1.0.0
 */
@Component
public class AutoTask {

    //@Scheduled(cron = "0/10 * * * * ? ")
    public void run() {
        System.out.println(" success");
    }

}
