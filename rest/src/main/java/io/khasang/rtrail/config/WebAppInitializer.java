package io.khasang.rtrail.config;

import io.khasang.rtrail.config.application.WebConfig;
import org.springframework.security.web.session.HttpSessionEventPublisher;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import org.springframework.web.filter.CharacterEncodingFilter;
import javax.servlet.Filter;
import javax.servlet.ServletContext;

// web.xml
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{WebConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return null;
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    protected void registerContextLoaderListener(ServletContext servletContext) {
        servletContext.addListener(HttpSessionEventPublisher.class);
        super.registerContextLoaderListener(servletContext);
    }

    /**
     * fix 90% of codding problem
     * */
    @Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter characterEncodingFilter =
                new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("utf-8");
        return new Filter[] { characterEncodingFilter };
    }

}
