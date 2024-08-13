package spring_pro.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName MyInterceptor
 * @Description TODO
 * @Author Enki
 * @Date 2024/8/13 15:09
 * @Verison 1.0
 **/
@Slf4j
@Component
public class MyInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        log.info("拦截器前置处理 得到请求url {}", request.getRequestURI());

        // 返回 true 继续执行后续的拦截器或处理器，返回 false 中止处理
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("在请求处理之后但在视图渲染之前执行");
        log.info("url地址 {}", request.getRequestURI());
        if (modelAndView != null) {
            log.info("modelAndView {}", modelAndView.getViewName());
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("在视图渲染之后执行");
        if (ex != null) {
            ex.printStackTrace();
        }
    }
}
