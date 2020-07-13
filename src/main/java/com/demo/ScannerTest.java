package com.demo;

import java.util.Scanner;

/**
 * @author alp.zxy
 * @date 2020/7/12
 */
public class ScannerTest {
    public static void main(String[] args) {
        int age;
        double weight, height, bmi;
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入你的年龄:");
        age = scanner.nextInt();
        System.out.println("请输入你的体重:");
        weight = scanner.nextDouble();
        System.out.println("请输入你的身高:");
        height = scanner.nextDouble();

        bmi = weight/(height*height);

        System.out.println("BMI: "+bmi);


    }

}
