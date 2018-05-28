package com.coderme.demo.iteror;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author qiudm
 * @date 2018/5/28 16:02
 * @desc
 */
public class IterorTest {

    @Test
    public void iterorTest() {

        List<String> str = Lists.newArrayList("a", "b", "c");
        Iterator<String> iterator = str.iterator();
        List<String> strings = Lists.newArrayList(iterator);

        for (int i = 0; i < 5; i++) {
            for (String s : strings) {
                System.out.println("iterator = " + s);
            }
        }


    }


}
