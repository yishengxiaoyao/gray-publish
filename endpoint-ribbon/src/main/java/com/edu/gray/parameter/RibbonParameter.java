package com.edu.gray.parameter;

/**
 * @author xiaoyao.
 * @date 2021/7/31.
 * @time 10:27 PM.
 */
public class RibbonParameter {
    private static final ThreadLocal threadLocal = new ThreadLocal();
    public static <T> T get(){
        return (T) threadLocal.get();
    }

    public static <T> void set(T t){
        threadLocal.set(t);
    }
}
