package com.example.saierhao.grab;

import com.example.saierhao.generator.domain.Fairybook;
import com.example.saierhao.generator.mapper.FairybookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.downloader.HttpClientDownloader;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.*;

/**
 * 获取所有精灵数据
 *
 * @author
 * @date 2023年06月15日 11:00
 */
@Component
public class SearlePage implements PageProcessor {

    @Autowired
    private FairybookMapper fairybookMapper;

    @Override
    public void process(Page page) {
        //精灵技能明细地址
        List<String> all = page.getHtml().css("div#jlist>ul>li>a").all();

        //精灵名称
        List<String> allImg = page.getHtml().css("div#jlist>ul>li>a>img").all();

        //精灵ID
        String id = UUID.randomUUID().toString().replaceAll("-", "");
        //整合
        List<Map<String, String>> mapList = new ArrayList<>();
        for (int i = 0; i < allImg.size(); i++) {
            Map<String, String> map = new HashMap<>();
            String s = UUID.randomUUID().toString().replaceAll("-", "");
            String s1 = processName(allImg.get(i));
            String s2 = processingAddress(all.get(i));
            map.put("ID", s);
            map.put("name", s1);
            map.put("address", s2);
            mapList.add(map);

            save(s, s1, s2);
        }
        outPut(mapList);
    }

    @Override
    public Site getSite() {
        return Site.me().setSleepTime(100).setRetryTimes(3);
    }

    public static void main(String[] args) {
        Spider spider = Spider.create(new SearlePage());//FitnessProcessor为自己创建的类
        String gifUrl = "http://www.4399.com/flash/seer.htm";
        spider.setDownloader(new HttpClientDownloader()).addUrl(gifUrl).thread(10).run();
    }

    /*
    处理名称格式
     */
    public String processName(String s) {
        return s.replace(
                        s.substring(s.indexOf("<img"), s.indexOf("alt=") + 4), "")
                .replace("\">", "")
                .replace("\"赛尔号", "")
                .replaceAll("\\{", "")
                .replaceAll("}", "");
    }

    /*
    处理地址格式
     */
    public String processingAddress(String s) {
        return s.replace("<a href=\"", "")
                .replace(
                        s.substring(s.indexOf("\">"), s.indexOf("</a>") + 4), ""
                );
    }

    /**
     * 正确格式输出
     *
     * @param mapList
     */
    public void outPut(List<Map<String, String>> mapList) {
        for (Map<String, String> map : mapList) {
            String put = "";
            for (Map.Entry<String, String> entry : map.entrySet()) {
                put = put.concat(entry.getKey()).concat("=").concat(entry.getValue()).concat(", ");
            }
            System.out.println(put.substring(0, put.lastIndexOf(",")));
        }
    }

    public void save(String s, String s1, String s2) {
        Fairybook fairybook = new Fairybook();
        fairybook.setID(s);
        fairybook.setName(s1);
        fairybook.setAddress(s2);
        fairybookMapper.insert(fairybook);
    }
}
