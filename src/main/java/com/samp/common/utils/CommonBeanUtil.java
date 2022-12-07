package com.samp.common.utils;

import com.samp.common.component.context.ApplicationContextProvider;

/**
 * Spring 컨테이너 Bean 객체 얻어오기
 */
public class CommonBeanUtil {

    public static Object getBean(String beanName) {
        return ApplicationContextProvider.getContext().getBean(beanName);
    }

    public static <T> Object getBean(Class<T> clz) {
        return ApplicationContextProvider.getContext().getBean(clz);
    }
}
