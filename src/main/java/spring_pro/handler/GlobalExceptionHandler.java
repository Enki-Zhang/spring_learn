package spring_pro.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import spring_pro.exception.MyException;
import spring_pro.result.ResponseStatus;
import spring_pro.result.ResultBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName GlobalExceptionHandler
 * @Description 全局异常处理类
 * @Author Enki
 * @Date 2024/8/12 9:03
 * @Verison 1.0
 **/
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 自定义异常处理方法
     *
     * @param request
     * @param e
     * @return
     */
    @ExceptionHandler(value = MyException.class)
    public ResultBody bizExceptionHandler(HttpServletRequest request, MyException e) {
        log.error("业务发生异常！ 原因是{}", e.getErrorMsg());
        return ResultBody.error(e.getErrorCode(), e.getErrorMsg());
    }

    /**
     * 空指针异常
     *
     * @param request
     * @param e
     * @return
     */
    @ExceptionHandler(value = NullPointerException.class)
    public ResultBody exceptionHandler(HttpServletRequest request, NullPointerException e) {
        log.error("空指针异常");
        return ResultBody.error(ResponseStatus.FAIL);
    }

    /**
     * 处理其他异常
     *
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    public ResultBody exceptionHandler(HttpServletRequest req, Exception e) {
        log.error("未知异常！原因是:", e);
        return ResultBody.error(ResponseStatus.FAIL);
    }
}
