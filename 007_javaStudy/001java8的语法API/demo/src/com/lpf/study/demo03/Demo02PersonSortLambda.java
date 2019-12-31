package com.lpf.study.demo03;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author lpf
 * @version 1.0
 * @date 2019/6/16 10:20
 **/
public class Demo02PersonSortLambda {
    public static void main(String[] args) {
        Person[] array = {
            new Person("lpf2",30),
            new Person("lpf",20),
            new Person("lpf3",40)
        };

        //查看数组本来的样子
        System.out.println(Arrays.toString(array));

        //对数组进行排序, 通过Lambda表达式简化有参数，有返回值的接口的实现
        Arrays.sort(array, (Person p1, Person p2)->{
            return p1.getAge() - p2.getAge();
        });
        System.out.println("按照年龄进行排序：");
        System.out.println(Arrays.toString(array));

    }

}
