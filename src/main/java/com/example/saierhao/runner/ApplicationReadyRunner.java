package com.example.saierhao.runner;

import com.example.saierhao.generator.domain.Fairybook;
import com.example.saierhao.generator.service.FairybookService;
import com.example.saierhao.generator.service.WizarddetailService;
import com.example.saierhao.utils.EntityQueue;
import com.example.saierhao.utils.SearlePageUtils;
import com.example.saierhao.utils.WizarddetailUtils;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Spider;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
    @Resource
    private WizarddetailUtils wizarddetailUtils;
    @Resource
    private WizarddetailService wizarddetailService;
    @Resource
    private EntityQueue entityQueue;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        //表头获取
        Spider.create(searlePageUtils).addUrl("http://www.4399.com/flash/seer.htm").run();
        List<Fairybook> fairyBookList = entityQueue.getFairyBookList();
        fairyBookList.sort(Comparator.comparing(Fairybook::getName));
        fairybookService.saveBatch(fairyBookList);
        entityQueue.clearFairyBookList();
        System.out.println("数据插入完毕");
        //明细获取
//        List<Fairybook> list = fairybookService.list();
//        String[] addresses = list.stream().map(it -> "https://" + it.getAddress()).collect(Collectors.toList()).toArray(new String[]{});
//        Spider.create(wizarddetailUtils).addUrl(addresses).run();
        //种族值获取
        //被动获取
        //技能获取
    }
}
