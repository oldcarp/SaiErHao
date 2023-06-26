package com.example.saierhao.grab;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.List;

/**
 * 获取精灵魂印效果
 * @author
 * @date 2023年06月16日 16:38
 */
public class getPassivity implements PageProcessor {


    @Override
    public void process(Page page) {
        //魂印总计
        List<String> all = page.getHtml().css("div.content>p").all();
        all.remove(0);
        all.remove(all.size() - 1);
        for (String s:all) {
            s = s.replace("<p>","").replace("</p>","").replace("<br>","");
            System.out.println(s);
        }
        //精灵名称

        //魂印名
        String passivityName = all.get(0).substring(all.get(0).indexOf("\">")+2,all.get(0).indexOf("</span>"));
        System.out.println("魂印名称："+passivityName);
        //魂印效果
    }

    @Override
    public Site getSite() {
        return Site.me().setSleepTime(1000).setRetryTimes(3);
    }

    public static void main(String[] args) {
        Spider.create(new getPassivity()).addUrl("http://news.4399.com/news/seerwenda/981767.html").run();
    }
}
