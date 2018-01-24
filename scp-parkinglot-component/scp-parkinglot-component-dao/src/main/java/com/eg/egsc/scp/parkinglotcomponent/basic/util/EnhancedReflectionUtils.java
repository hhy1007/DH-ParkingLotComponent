/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.basic.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.springframework.util.ReflectionUtils;
import org.springframework.util.StringUtils;

/**
 * 通过反射 处理一些属性或方法
 * 
 * @Class Name EnhancedReflectionUtils
 * @Author zhangli
 * @Create In 2017年12月14日
 */
public class EnhancedReflectionUtils {

    private EnhancedReflectionUtils() {
    }
    
    public static void setFieldValue(Object targetObject, String name, Object value) {
        Field field = ReflectionUtils.findField(targetObject.getClass(), name);
        setFieldValue(targetObject, field, value);
    }

    public static void setFieldValue(Object targetObject, Field field, Object value) {
        ReflectionUtils.makeAccessible(field);
        ReflectionUtils.setField(field, targetObject, value);
    }

    public static Object getFieldValue(Object targetObject, Field field) {
        ReflectionUtils.makeAccessible(field);
        return ReflectionUtils.getField(field, targetObject);
    }

    public static Object getFieldValue(Object targetObject, String fieldName) {
        return getFieldValue(targetObject, getField(targetObject.getClass(), fieldName));
    }

    public static Field getField(Object targetObject, String fieldName) {
        return getField(targetObject.getClass(), fieldName);
    }

    public static Object getMethodValueForField(Object targetObject, String fieldName) {
        Method method = getMethodForField(targetObject.getClass(), fieldName);
        return ReflectionUtils.invokeMethod(method, targetObject);
    }

    public static Object invokeMethod(Object targetObject, String methodName, 
            Object... value) {
        Method method = getMethodForMethodName(targetObject.getClass(), methodName, value);
        return ReflectionUtils.invokeMethod(method, targetObject, value);
    }

    public static Method getMethodForMethodName(Class<?> clazz, String methodName, 
            Object... value) {
        Method method = null;
        if (value != null && value.length > 0) {
            Class<?>[] classTypes = new Class[value.length];
            for (int i=0; i<value.length; i++) {
                classTypes[i] = value[i].getClass();
            }
            method = ReflectionUtils.findMethod(clazz, methodName, classTypes);
        } else {
            method = ReflectionUtils.findMethod(clazz, methodName);
        }
        return method;
    }

    public static Method getMethodForField(Class<?> clazz, String fieldName) {
        String capitalizedFieldName = StringUtils.capitalize(fieldName);
        Method method = ReflectionUtils.findMethod(clazz, "get" + capitalizedFieldName);
        if (method == null) {
            method = ReflectionUtils.findMethod(clazz, "is" + capitalizedFieldName);
        }
        return method;
    }

    @SuppressWarnings({"rawtypes"})
    public static Method setMethodForField(Class<?> clazz, String fieldName) 
            throws NoSuchFieldException {
        Method method = null;
        String capitalizedFieldName = StringUtils.capitalize(fieldName);
        Class[] parameterTypes = new Class[1];
        Field field = clazz.getDeclaredField(fieldName);
        parameterTypes[0] = field.getType();
        method = ReflectionUtils.findMethod(clazz, "set" + capitalizedFieldName,
                parameterTypes);
        if (method == null) {
            method = ReflectionUtils.findMethod(clazz, "is" + capitalizedFieldName);
        }
        return method;
    }

    public static Object setMethodValueForField(Object targetObject, String fieldName,
            Object value) throws NoSuchFieldException {
        Method method = setMethodForField(targetObject.getClass(), fieldName);
        return ReflectionUtils.invokeMethod(method, targetObject, value);
    }

    public static Field getField(Class<?> clazz, String name) {
        return ReflectionUtils.findField(clazz, name);
    }
}

