package com.demo;

import java.text.NumberFormat;

/**
 * @author alp.zxy
 * @date 2020/7/12
 */
public class NumberFormatTest {
    public static void main(String[] args) {
        Double myNumber = 12345.123456789;
        Double test = 1.2345;
        NumberFormat numberFormat = NumberFormat.getInstance();
        String myString = numberFormat.format(myNumber);
        System.out.println("默认格式："+myString);
        myString = NumberFormat.getCurrencyInstance().format(myNumber);
        System.out.println("默认格式："+myString);

    }
}
