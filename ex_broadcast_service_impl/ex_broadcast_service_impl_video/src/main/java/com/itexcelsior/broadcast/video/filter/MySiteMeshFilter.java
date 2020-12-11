package com.itexcelsior.broadcast.video.filter;

import org.sitemesh.builder.SiteMeshFilterBuilder;
import org.sitemesh.config.ConfigurableSiteMeshFilter;
import org.springframework.context.annotation.Configuration;

import javax.servlet.annotation.WebFilter;

/**
 * @author zxw </br>
 * @create 2020/8/28/13:31 </br>
 * @description: </br>
 */
@Configuration
@WebFilter(filterName = "sitemesh",urlPatterns = "/*") //添加注解代替XML方式开启过滤器
public class MySiteMeshFilter extends ConfigurableSiteMeshFilter
{
    @Override
    protected void applyCustomConfiguration(SiteMeshFilterBuilder builder) {

        builder.addDecoratorPath("/*","/layout/default")
        .addExcludedPath("/static/**").addExcludedPath("/index");

    }
}


