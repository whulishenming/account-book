package com.lsm.accountBook.util;

import com.lsm.accountBook.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

@Slf4j
public class ParamUtils {

    /**
     * t的所有属性不能为空
     * @param t
     * @param <T>
     */
    public static <T> void notNullValidator(T t) {

        if (t == null) {
            throw new BusinessException(0, "参数不能为空");
        }

        Class<?> clazz = t.getClass();

        Field[] declaredFields = clazz.getDeclaredFields();

        for (Field field : declaredFields) {

            String fieldName = field.getName();
            if (!"serialVersionUID".equals(fieldName)) {
                if (isFieldEmpty(fieldName, t)){
                    throw new BusinessException(0, fieldName + "不能为空");
                }
            }
        }
    }

    /**
     * filterFields对应的属性不能为空
     * @param t
     * @param filterFields
     * @param <T>
     */
    public static <T> void notNullValidator(T t, String... filterFields){

        if (t == null) {
            throw new BusinessException(0, "参数不能为空");
        }

        for (String fieldName : filterFields) {
            if (isFieldEmpty(fieldName, t)){
                throw new BusinessException(0, fieldName + "不能为空");
            }

        }
    }

    private static <T> Object getFieldValueByName(String fieldName, T t){
        try {
            Class<?> clazz = t.getClass();

            PropertyDescriptor pd = new PropertyDescriptor(fieldName, clazz);

            Method getMethod = pd.getReadMethod();

            return getMethod.invoke(t);
        } catch (Exception e) {

            log.error(e.getMessage());

            throw new BusinessException(0, "服务异常");
        }
    }

    private static <T> boolean isFieldEmpty(String fieldName, T t){

        return EmptyUtils.isEmpty(getFieldValueByName(fieldName, t));

    }
}
