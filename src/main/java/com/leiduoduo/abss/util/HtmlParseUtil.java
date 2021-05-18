package com.leiduoduo.abss.util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

public class HtmlParseUtil {
    public static void main(String[] args) throws IOException {
        String url="http://search.dangdang.com/?key=java";
        // 解析网页
        Document document = Jsoup.parse(new URL(url), 3000);
        Element element = document.getElementById("component_59");
        // System.out.println(element.html());
        // 获取所有的li元素
        Elements li = element.getElementsByTag("li");
        // 获取元素中的内容
        for (Element element1 : li) {
            String eleurl = element1.getElementsByTag("a").eq(0).attr("href");
            String img = element1.getElementsByTag("img").eq(0).attr("data-original");
            Double price = Double.parseDouble(element1.getElementsByClass("search_now_price").eq(0).text().substring(1));
            String title = element1.getElementsByClass("name").eq(0).text();
            // 出版社
            String press = element1.getElementsByClass("search_book_author").get(0).getElementsByTag("span").eq(2).text().substring(1);
            // 作者
            String author = element1.getElementsByClass("search_book_author").get(0).getElementsByTag("span").eq(0).text();
            // 版次
            String edition = "1";
            int shopNumber = new Random().nextInt(10);
            String shopCode = "13869168164163516";
            String shopName = "不打烊书店";
            // 书籍描述
            String message = element1.getElementsByClass("detail").text();
            int number = 500;

            System.out.println("===================================");
            System.out.println(img);
            System.out.println(press);
            System.out.println(author);
            System.out.println(price);
            System.out.println(title);
            System.out.println(message);
            Document eledocument = Jsoup.parse(new URL(eleurl), 3000);
            String isbn = eledocument.getElementById("detail_describe").getElementsByTag("li").eq(4).text().substring(11);
            System.out.println(isbn);

        }

    }
}
