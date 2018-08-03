package com.lsm.accountBook.util;

import java.util.Collection;
import java.util.Map;

public class EmptyUtils {
    /**
     * 判断是否为空
     * @param t
     * @param <T>
     * @return
     */
    public static <T> boolean isEmpty(T t) {

        if (t == null) {

            return true;
        }

        if (t instanceof String && "".equals(((String) t).trim())) {

            return true;
        }

        if (t instanceof Collection && ((Collection) t).isEmpty()) {

            return true;
        }

        if (t instanceof Map && ((Map) t).isEmpty()) {

            return true;
        }

        return false;
    }

}
