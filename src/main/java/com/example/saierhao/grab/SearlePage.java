package com.example.saierhao.grab;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.*;

/**
 * @author
 * @date 2023年06月15日 11:00
 */
public class SearlePage implements PageProcessor {
    @Override
    public void process(Page page) {
        //精灵技能明细地址
        List<String> all = page.getHtml().css("div#jlist>ul>li>a").all();

        //精灵名称
        List<String> allImg = page.getHtml().css("div#jlist>ul>li>a>img").all();

        //精灵ID
        String id = UUID.randomUUID().toString().replaceAll("-","");
        //整合
        List<Map<String,String>> mapList = new ArrayList<>();
        for (int i = 0; i < allImg.size(); i++){
            Map<String,String> map = new HashMap<>();
            map.put("ID",UUID.randomUUID().toString().replaceAll("-",""));
            map.put("name",processName(allImg.get(i)));
            map.put("address",processingAddress(all.get(i)));
//            System.out.println("ID:"+UUID.randomUUID().toString().replaceAll("-",""));
//            System.out.println("name:"+processName(allImg.get(i)));
//            System.out.println("address:"+processingAddress(all.get(i)));
            mapList.add(map);
            System.out.println(mapList);
        }

    }

    @Override
    public Site getSite() {
        return Site.me().setSleepTime(100).setRetryTimes(3);
    }

    public static void main(String[] args) {
        Spider.create(new SearlePage()).addUrl("http://www.4399.com/flash/seer.htm").run();
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
