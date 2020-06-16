package com.wm.zgy.bootmybatismbplusshiroesquartz;

import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @Author renjiaxin
 * @Date 2020/6/15
 * @Description 介绍
 */
public class LambdaAndStream {

    public static void main(String[] args) {
        //----------------消费型接口--------------------//
        System.out.println("----------------消费型接口--------------------");
        // 消费型接口: 有一个参数, 没有返回值
        // 这个定义了这个consumer要怎么做事情
        Consumer<String> consumer = str -> System.out.println(str + "\n\n");
        consumerMethodOld("hello");
        consumerMethodNew("hello");
        consumerMethodNew02("hello", consumer);

        //----------------供给型接口--------------------//
        System.out.println("----------------供给型接口--------------------");
        // 供给型接口: 没有参数, 有一个返回值
        System.out.println(supplierMethodOld("hello world!"));
        System.out.println(supplierMethodNew("我草! \n\n"));

        //----------------断言型接口--------------------//
        System.out.println("----------------断言型接口--------------------");
        System.out.println("年龄大于18岁: " + predicateMethodOld(22));
        System.out.println("姓名长度超过20: " + predicateMethodNew("张飞"));

    }

    /**
     * 消费型：没有返回值，一个参数
     */
    public static <String> void consumerMethodOld(String string) {

        // 有无参数，有无返回值，说的是这个, consumer接口有一个参数, 没有返回值
        Consumer<String> consumer = new Consumer<String>() {
            // 这个str就是我们的消费型接口的一个参数
            @Override
            public void accept(String str) {
                System.out.println("字符串的长度是: " + str.toString().length());
            }
        };
        // 调用外部参数, 发挥实际的作用，在这个函数之中，Consumer接口是为这个函数而服务的
        consumer.accept(string);
    }

    public static <T> void consumerMethodNew(T t) {
        // 这个str就是我们的消费型接口的一个参数
        Consumer<T> consumer2 = str -> System.out.println("字符串的长度是: " + str.toString().length());
        consumer2.accept(t);
    }

    public static <T> void consumerMethodNew02(T t, Consumer<T> consumer) {
        // 这个str就是我们的消费型接口的一个参数
        consumer.accept(t);
    }

    /**
     * 供给型：有返回值，没有参数
     *
     * @return
     */
    public static <T> T supplierMethodOld(T str) {
        Supplier<T> supplier = new Supplier<T>() {
            @Override
            public T get() {
                return str;
            }
        };
        return supplier.get();
    }

    public static <String> String supplierMethodNew(String str) {
        // Supplier接口之中，是没有参数的
        Supplier<String> supplier = () -> str;
        return supplier.get();
    }

    public static boolean predicateMethodOld(Integer age) {
        Predicate<Integer> predicate = new Predicate<Integer>() {
            @Override
            public boolean test(Integer temp) {
                return temp > 18;
            }
        };
        return predicate.test(age);
    }

    public static <String> boolean predicateMethodNew(String name) {
        Predicate<String> predicate = ss -> ss.toString().length() > 20;
        return predicate.test(name);
    }

}
