package com.coderme.demo.luoji;

import com.google.common.base.Objects;
import org.junit.Test;

/**
 * @author qiudm
 * @date 2018/6/21 11:02
 * @desc
 */
public class AndOr {

    @Test
    public void andOrTest() {
        Integer a = 1;
        //1
        if(!Objects.equal(a, 1) && !Objects.equal(a,2)) {
            System.out.println("a1 = " + a);
        }

        //2
        if(!Objects.equal(a, 1) || !Objects.equal(a,2)) {
            System.out.println("a2 = " + a);
        }
    }




}
