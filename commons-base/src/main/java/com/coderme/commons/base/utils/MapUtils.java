package com.coderme.commons.base.utils;

import com.google.common.base.Objects;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @author qiudm
 * @date 2018/6/19 17:08
 * @desc
 */
public class MapUtils {

    public static Map<String, Object> java2Map(Object obj) {
        Map<String, Object> maps = new HashMap();

        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
                String name = propertyDescriptor.getName();
                if (!Objects.equal(name, "class")) {
                    Method readMethod = propertyDescriptor.getReadMethod();
                    Object val = readMethod.invoke(obj, new Object[0]);
                    maps.put(name, val);
                }
            }
        } catch (IntrospectionException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return maps;
    }


}
