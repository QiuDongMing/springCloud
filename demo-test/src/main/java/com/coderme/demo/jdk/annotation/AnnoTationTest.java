package com.coderme.demo.jdk.annotation;

import com.sun.istack.internal.NotNull;
import jdk.nashorn.internal.runtime.logging.Logger;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;


/**
 * @author qiudm
 * @date 2018/6/15 17:57
 * @desc
 */
public class AnnoTationTest {

    public void method(@NotNull String name, @NotNull Integer age) {

    }


    @Test
    public void myTest() {
        AnnoTationTest annoTationTest = new AnnoTationTest();
        annoTationTest.method("aa", 9);

        Method[] declaredMethods = annoTationTest.getClass().getDeclaredMethods();
        System.out.println("declaredMethods = " + declaredMethods.length);

        for (Method m : declaredMethods) {
            Annotation[][] parameterAnnotations = m.getParameterAnnotations();
            System.out.println("parameterAnnotations = " + parameterAnnotations.length);
            for (int i = 0; i < parameterAnnotations.length; i++) {
                System.out.println("i = " + i);
                System.out.println("parameterAnnotations len = " + parameterAnnotations[i].length);
                for (int j = 0; j < parameterAnnotations[i].length; j++) {
                    System.out.println("j = " + j);
                    Annotation annotation = parameterAnnotations[i][j];
                    System.out.println("annotation = " + annotation);
                }
            }
        }
    }


    @Test
    public void arrayStream() {
        String[][] arr = new String[2][2];
        int k=1;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = (k++)+"";
            }
        }


        for (String[] a : arr) {
            for (String s : a) {
                System.out.println("s = " + s);
            }
        }

    }


}
