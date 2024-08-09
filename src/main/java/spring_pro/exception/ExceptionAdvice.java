package spring_pro.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import spring_pro.resEnum.ResponseResult;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;

/**
 * @ClassName ExceptionAdvice
 * @Description TODO
 * @Author Enki
 * @Date 2024/8/9 11:20
 * @Verison 1.0
 **/
@Slf4j
@RestControllerAdvice
public class ExceptionAdvice {

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)//当抛出异常被捕获后返回状态码400错误
    @ExceptionHandler(ServiceException.class)
    public ResponseResult<Exception> handleServiceException(ServiceException serviceException, HttpServletRequest request) {
        log.warn("request {} throw ServiceException \n", request, serviceException);
        return ResponseResult.fail(serviceException.getMessage());
    }
}
