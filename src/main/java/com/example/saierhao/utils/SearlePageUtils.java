package com.example.saierhao.utils;

import com.example.saierhao.generator.domain.Fairybook;
import com.example.saierhao.generator.service.FairybookService;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

/**
 * @author
 * @date 2023年06月15日 11:00
 */
@Component
public class SearlePageUtils implements PageProcessor {

    @Resource
    private EntityQueue entityQueue;

    @Override
    public void process(Page page) {
        //精灵技能明细地址
        List<String> all = page.getHtml().css("div#jlist>ul>li>a").all();
        //精灵名称
        List<String> allImg = page.getHtml().css("div#jlist>ul>li>a>img").all();
        //整合
        for (int i = 0; i < allImg.size(); i++){
            Fairybook fairybook = new Fairybook();
            fairybook.setID(UUID.randomUUID().toString().replaceAll("-",""));
            fairybook.setName(processName(allImg.get(i)));
            fairybook.setAddress(processingAddress(all.get(i)));
            entityQueue.addFairyBook(fairybook);
        }

    }

    @Override
    public Site getSite() {
        return Site.me().setSleepTime(100).setRetryTimes(3);
    }

    /*
    处理名称格式
     */
    public String processName(String s){
        return s.replace(
                        s.substring(s.indexOf("<img"), s.indexOf("alt=") + 4), "")
                .replace("\">", "")
                .replace("\"赛尔号", "");
    }
    /*
    处理地址格式
     */
    public String processingAddress(String s){
        return s.replace("<a href=\"", "")
                .replace(
                        s.substring(s.indexOf("\">"), s.indexOf("</a>")+4), ""
                );
    }
}
