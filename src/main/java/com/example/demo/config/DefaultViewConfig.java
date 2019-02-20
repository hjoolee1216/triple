package com.example.demo.config;


import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.context.ConfigurableWebApplicationContext;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@Configuration
public class DefaultViewConfig extends WebMvcConfigurerAdapter {

    @Autowired
    private ConfigurableWebApplicationContext context;
    


    @Override
    public void addViewControllers(ViewControllerRegistry viewControllerRegistry) {
        List<String> profiles = Arrays.asList(context.getEnvironment().getActiveProfiles());

        StringBuffer redirectPage = new StringBuffer();
        
        redirectPage.append("redirect:/swagger-ui.html");
           

        viewControllerRegistry.addViewController("/").setViewName(redirectPage.toString());
        viewControllerRegistry.setOrder(Ordered.HIGHEST_PRECEDENCE);
        super.addViewControllers(viewControllerRegistry);
    }
}
