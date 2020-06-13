package com.gofocus.demo;

/**
 * @Author: GoFocus
 * @Date: 2020-06-11 14:53
 * @Description:
 */
public class Main {

    public static void main(String[] args) {   String s1 = "a";

        String str1="";
        String str2="";

        /**
         * 计算concat所用时间
         */
        long str1Start = System.currentTimeMillis();
        for (int i=0;i<10000;i++){
            str1=str1.concat(s1);
        }
        long str1End = System.currentTimeMillis();
        System.out.println("concat计算时间为：" + (str1End - str1Start));

        /**
         * 计算+所用时间
         */
        long str2Start = System.currentTimeMillis();
        for (int i=0;i<10000;i++){
            str2=str2+s1;
        }
        long str2End = System.currentTimeMillis();
        System.out.println("+计算时间为：" + (str2End - str2Start));}
}
