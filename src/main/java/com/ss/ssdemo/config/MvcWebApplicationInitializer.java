package com.ss.ssdemo.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @author wangf
 * @description：
 * @create 2019/02/26
 */

public class MvcWebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {


    /**
     * 注册springSecurityFilterChain到Spring MVC
     * @return
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{WebSecurityConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[0];
    }

    @Override
    protected String[] getServletMappings() {
        return new String[0];
    }
}
