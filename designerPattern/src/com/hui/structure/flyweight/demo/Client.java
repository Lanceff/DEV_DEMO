package com.hui.structure.flyweight.demo;

/**
 * @author: Lance
 * @Date: 2020-09-10 09:48
 * @Description:
 */
public class Client {

    public static void main(String[] args) {
        // 创建一个工厂类
        WebSiteFactory factory = new WebSiteFactory();
        // 客户要一个以新闻形式发布的网站
        WebSite webSite1 = factory.getWebSiteCategory("新闻");
        webSite1.use(new OutsideUser("tom"));
        // 客户要一个以博客形式发布的网站
        WebSite webSite2 = factory.getWebSiteCategory("博客");
        webSite2.use(new OutsideUser("jack"));
        // 客户要一个以博客形式发布的网站
        WebSite webSite3 = factory.getWebSiteCategory("博客");
        webSite3.use(new OutsideUser("smith"));
        // 客户要一个以博客形式发布的网站
        WebSite webSite4 = factory.getWebSiteCategory("博客");
        webSite4.use(new OutsideUser("king"));
        System.out.println("网站的分类共=" + factory.getWebSiteCount());
    }
}
