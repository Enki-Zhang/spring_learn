package spring_pro.filter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName MyFilter
 * @Description 过滤器
 * @Author Enki
 * @Date 2024/8/13 14:11
 * @Verison 1.0
 **/
@Slf4j
@WebFilter(urlPatterns = "/*")
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("过滤器初始化。。。。");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        System.out.println("filter 请求前置处理");
        String method = request.getMethod();
        System.out.println("过滤器拦截请求方法："+ method);
        try {
            filterChain.doFilter(request,response);
        } finally {
            System.out.println("过滤器后置处理。。。。");
        }

    }

    @Override
    public void destroy() {
        System.out.println("销毁过滤器");
    }
}
