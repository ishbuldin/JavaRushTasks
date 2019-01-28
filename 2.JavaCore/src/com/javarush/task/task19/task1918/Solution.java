package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //String fileName = br.readLine();
        String fileName = "D:/3.txt";
        br.close();
        BufferedReader fr = new BufferedReader(new FileReader(fileName));
        StringBuilder sb = new StringBuilder();
        while (fr.ready()) {
            sb.append(fr.readLine());
        }
        fr.close();
        String tag = args[0];
        //Document html = Jsoup.parse(sb.toString());
        //Elements span = html.body().getElementsByTag(tag);
        //System.out.println(span);
        parse(sb.toString(), tag);
    }
/*
    public static void parse(String html, String tag) {
        String openTag = "<" + tag;
        String closeTag = "</" + tag + ">";
        int openIndex = html.indexOf(openTag);
        int closeIndex = html.indexOf(closeTag) + closeTag.length();
        String result = html.substring(openIndex, closeIndex);

        if (result.substring(openTag.length()).contains(openTag)) {
            closeIndex = html.substring(closeIndex).indexOf(closeTag) + closeTag.length() + closeIndex;
            result = html.substring(openIndex, closeIndex);
            System.out.println(result);
            parse(html.substring(openIndex + openTag.length()), tag);
        }
        else {
            System.out.println(result);
            if (closeIndex < html.lastIndexOf(closeTag) + closeTag.length()) {
                openIndex = html.substring(closeIndex).indexOf(openTag) + closeIndex;
                closeIndex = html.substring(openIndex).indexOf(closeTag) + closeTag.length() + openIndex;
                parse(html.substring(openIndex), tag);
            }
        }
    }
*/


    public static void parse(String html, String tag) {
        String openTag = "<" + tag;
        String closeTag = "</" + tag + ">";
        int openIndex = html.indexOf(openTag);
        if (openIndex == -1)
            return;
        int closeIndex = html.indexOf(closeTag) + closeTag.length();
        String result = html.substring(openIndex, closeIndex);

        if (result.substring(openTag.length()).contains(openTag)) {
            closeIndex = html.substring(closeIndex).indexOf(closeTag) + closeTag.length() + closeIndex;
            result = html.substring(openIndex, closeIndex);
            System.out.println(result);
            openIndex = html.substring(openIndex + openTag.length()).indexOf(openTag) + openIndex + openTag.length();
            String test = html.substring(openIndex);
            parse(html.substring(openIndex), tag);
        }
        else {
            System.out.println(result);
            if (closeIndex < html.lastIndexOf(closeTag) + closeTag.length()) {
                openIndex = html.substring(closeIndex).indexOf(openTag) + closeIndex;
                //closeIndex = html.substring(openIndex).indexOf(closeTag) + closeTag.length() + openIndex;
                parse(html.substring(openIndex), tag);
            }
        }
    }


}