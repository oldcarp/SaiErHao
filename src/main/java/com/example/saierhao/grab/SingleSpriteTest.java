package com.example.saierhao.grab;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author
 * @date 2023年06月14日 17:33
 */
public class SingleSpriteTest implements PageProcessor {
    @Override
    public void process(Page page) {
        //获取精灵名称
        String name = page.getHtml().css("div.item1>dl>dt").toString();
        //获取精灵种族值 -- 方向
        List<String> raceValue1 = page.getHtml().css("div.race>table>thead>tr>td").all();
        //获取精灵种族值 -- 分布
        List<String> raceValue2 = page.getHtml().css("div.race>table>tbody>tr>td").all();
        //精灵种族值
        Map<String,String> raceValue = new HashMap<>();
        for (int i = 0; i <raceValue1.size(); i++){
            raceValue
                    .put(
                            raceValue1
                                    .get(i).replace("<td>","").replace("</td>",""),
                            raceValue2
                                    .get(i).replace("<td>","").replace("</td>","")
                    );
        }
        //获取精灵属性
        String stats = page.getHtml().css("div.item2>dl>dt>i").toString();
        //获取魂印 -- 地址
        String passivity = page.getHtml().css("div.item51>p>span").toString();
        //获取技能
        List<String> all = page.getHtml().css("div.elvedata>table>tbody>tr").all();
        //去除最后一行杂数据
        all.remove(all.size() - 1);
        //计数器
        int count = 1;
        //输出精灵名称 及 属性
        System.out.println(name.replace("<dt>","").replace("</dt>",""));
        System.out.println("属性："+stats.replace("<i>","").replace("</i>",""));
        //魂印地址
        if (null != passivity) {
            if (passivity.indexOf("//") < 0) {
                System.out.println(passivity.substring(passivity.indexOf("<span>")+6,passivity.indexOf("</span>")));
            }else {
                System.out.println("魂印地址：http:"+passivity.substring(passivity.indexOf("//"),passivity.indexOf("html")+4));
            }
        }else {
            System.out.println("魂印地址：无");
        }
        //迭代输出种族值
        System.out.println("种族值：");
        raceValue.forEach((k,y) -> {
            System.out.println(k+":"+y);
        });
        //迭代输出技能
        for (String s : all) {
            s = s.replaceAll("<td>", "")
                    .replaceAll("</td>", "")
                    .replaceAll("</tr>", "")
                    .replaceAll("<td style=\"text-align:left\">", "");
            System.out.println(detectTrAndReplace(s, count));
            count++;
        }
    }

    @Override
    public Site getSite() {
        return Site.me().setSleepTime(100).setRetryTimes(3);
    }

    public static void main(String[] args) {
        Spider.create(new SingleSpriteTest()).addUrl("https://news.4399.com/gonglue/seer/tujian/839539.htm").run();
    }

    /*
    检测技能tr并替换
     */
    private String detectTrAndReplace(String tr, int count) {
        if (tr.startsWith("<tr>")) {
            tr = tr.replace("<tr>", "第" + count + "个技能");
        } else {
            tr = tr.replaceAll("<tr class=\"odd\"> ", "第" + count + "个技能");
        }
        if (tr.indexOf("<td") > 1) {
            tr = tr.replace(tr.substring(tr.indexOf("<td"), tr.indexOf("</span>") + 7), "");
        }
        return tr;
    }
}
