package com.example.saierhao.runner;

import com.example.saierhao.generator.domain.Fairybook;
import com.example.saierhao.generator.service.FairybookService;
import com.example.saierhao.utils.SearlePageUtils;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Spider;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author
 * @date 2023年06月26日 15:46
 */
@Component
public class ApplicationReadyRunner implements ApplicationListener<ApplicationReadyEvent> {

    @Resource
    private SearlePageUtils searlePageUtils;

    @Resource
    private FairybookService fairybookService;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        //表头获取
//        Spider.create(searlePageUtils).addUrl("http://www.4399.com/flash/seer.htm").run();
        //明细获取
        List<Fairybook> list = fairybookService.list();

        //种族值获取
        //被动获取
        //技能获取
    }
}
