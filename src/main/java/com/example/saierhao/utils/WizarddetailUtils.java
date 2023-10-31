package com.example.saierhao.utils;

import com.example.saierhao.generator.domain.Wizarddetail;
import com.example.saierhao.generator.service.WizarddetailService;
import org.springframework.stereotype.Controller;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

import javax.annotation.Resource;

/**
 * 明细获取
 * @author
 * @date 2023年06月28日 11:38
 */
@Controller
public class WizarddetailUtils implements PageProcessor {

    @Override
    public void process(Page page) {
        //获取精灵名称
        String name = page.getHtml().css("div.item1>dl>dt").toString().replace("<dt>","").replace("</dt>","");
        //获取精灵属性
        String stats = page.getHtml().css("div.item2>dl>dt>i").toString().replace("<i>","").replace("</i>","");
        //获取魂印 -- 地址
        String passivity = page.getHtml().css("div.item51>p>span").toString();
        //魂印地址或魂印效果
        if (null != passivity) {
            if (passivity.indexOf("//") < 0) {
                passivity = passivity.substring(passivity.indexOf("<span>")+6,passivity.indexOf("</span>"));
            }else {

                passivity = "http:"+passivity.substring(passivity.indexOf("//"),passivity.indexOf("html")+4);
            }
        }else {
            passivity = "无";
        }
        Wizarddetail wizarddetail = new Wizarddetail();
        wizarddetail.setName(name);
        wizarddetail.setStats(stats);
        wizarddetail.setSoulmark(passivity);
    }

    @Override
    public Site getSite() {
        return Site.me().setSleepTime(100).setRetryTimes(3);
    }
}
