package com.lpf.study.demo04;

/**
 * @author lpf
 * @version 1.0
 * @date 2019/6/16 10:33
 **/
public class Demo {
    public static void main(String[] args) {
        Calculator calculator = new CalculatorImpl();
        int sum = cal((int a, int b)->{
            return a + b;
        });
        System.out.println("sum：" + sum);
    }
    private static int cal(Calculator calculator){
        return calculator.sum(111,222);
    }
}
