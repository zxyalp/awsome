package com.demo;

/**
 * @author alp.zxy
 * @date 2020/7/11
 */
public class HelloWorld {

    public static void main(String[] args){

        int intValue = 1234567892;
        long longValue = 123456789012383L;

        float floatValue = intValue;
        double doubleValue = intValue;
        System.out.println("整型变量intValue = "+intValue);
        System.out.println("浮点型变量floatValue = "+floatValue);
        System.out.println("双精度浮点型变量doubleValue = "+doubleValue);

        floatValue = longValue;
        doubleValue = longValue;

        System.out.println("长整型变量longValue = "+longValue);
        System.out.println("浮点型变量floatValue = "+floatValue);
        System.out.println("双精度浮点型变量doubleValue = "+doubleValue);
    }
}