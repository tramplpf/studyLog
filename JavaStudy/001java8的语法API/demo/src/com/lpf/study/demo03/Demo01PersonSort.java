package com.lpf.study.demo03;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author lpf
 * @version 1.0
 * @date 2019/6/16 10:20
 **/
public class Demo01PersonSort {
    public static void main(String[] args) {
        Person[] array = {
            new Person("lpf2",30),
            new Person("lpf",20),
            new Person("lpf3",40)
        };

        //查看数组本来的样子
        System.out.println(Arrays.toString(array));

        //对数组进行排序
        Arrays.sort(array, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAge() - o2.getAge();
            }
        });
        System.out.println("按照年龄进行排序：");
        System.out.println(Arrays.toString(array));


    }

}
