package com.coderme.demo.jdk.current;

import org.junit.Test;
import sun.misc.Unsafe;

import java.io.Serializable;
import java.lang.reflect.Field;

/**
 * @author qiudm
 * @date 2018/6/25 11:07
 * @desc
 */
public class UnSafeTest implements Serializable {

    private volatile Integer value = 10;

    private static Long sumOfLong = null;

    private static  Unsafe unsafe = null;

    static {
        try {

            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            unsafe = (Unsafe)field.get(null);
            sumOfLong = unsafe.objectFieldOffset(UnSafeTest.class.getDeclaredField("value"));
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void demoTest1() {
        int addSum = addSum();

        System.out.println("addSum = " + addSum);
    }


    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public static Unsafe getUnsafe() {
        return unsafe;
    }

    public static void setUnsafe(Unsafe unsafe) {
        UnSafeTest.unsafe = unsafe;
    }

    public Long getSumOfLong() {
        return sumOfLong;
    }

    public void setSumOfLong(Long sumOfLong) {
        this.sumOfLong = sumOfLong;
    }

    private int addSum() {
        this.setValue(1);
        System.out.println("sumOfLong = " + sumOfLong);
        return unsafe.getAndAddInt(this, sumOfLong, 1) + 1;
    }

}
