package com.example.saierhao.runner;

import com.example.saierhao.generator.service.FairybookService;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author
 * @date 2023年06月26日 15:46
 */
@Component
public class ApplicationReadyRunner implements ApplicationListener<ApplicationReadyEvent> {

    @Resource
    private FairybookService fairybookService;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        System.out.println(fairybookService.getBaseMapper().selectById(1));
    }
}
