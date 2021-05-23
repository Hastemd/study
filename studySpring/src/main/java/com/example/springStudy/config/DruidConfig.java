package com.example.springStudy.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DruidConfig {
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource druid(){
        return new DruidDataSource();
    }
 
    @Bean
    public ServletRegistrationBean statViewServlet(){
        ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        Map<String,String> params = new HashMap<String,String>();
        params.put("loginUsername","admin");//设置后台登录名
        params.put("loginPassword","666");//密码
        params.put("allow","");//设置默认就是允许所有访问
        params.put("deny","192.168.84.129");//设置黑名单
        bean.setInitParameters(params);
        return bean;
    }
 
    @Bean
    public FilterRegistrationBean webStatFilter(){
        FilterRegistrationBean frb = new FilterRegistrationBean();
        frb.setFilter(new WebStatFilter());
        Map<String,String> params = new HashMap<String,String>();
        params.put("exclusions","*.js,*.css,/druid/*");//设置不拦截请求
        frb.setInitParameters(params);
        frb.setUrlPatterns(Arrays.asList("/*"));//拦截请求
        return  frb;
    }
}

