package spring_pro.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import spring_pro.filter.MyFilter;
import spring_pro.interceptor.MyInterceptor;

/**
 * @ClassName FIlterConfig
 * @Description TODO
 * @Author Enki
 * @Date 2024/8/13 14:41
 * @Verison 1.0
 **/
@Configuration
public class FilterConfig implements WebMvcConfigurer {
    @Bean
    public FilterRegistrationBean<MyFilter> myFilterFilterRegistrationBean() {
        FilterRegistrationBean<MyFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new MyFilter());
        registrationBean.addUrlPatterns("/user/*"); // 只拦截 /api/* 路径下的请求
        registrationBean.setOrder(1); // 设置过滤器的执行顺序
        return registrationBean;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/user/**")
                .excludePathPatterns("/api/**");
    }
}
