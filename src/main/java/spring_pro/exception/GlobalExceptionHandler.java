//package spring_pro.exception;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.context.support.DefaultMessageSourceResolvable;
//import org.springframework.http.HttpStatus;
//import org.springframework.lang.NonNull;
//import org.springframework.validation.BindException;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.MethodArgumentNotValidException;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.ResponseStatus;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//
//import javax.validation.ConstraintViolationException;
//import javax.validation.ValidationException;
//
///**
// * @ClassName GlobalExceptionHandler
// * @Description 统一异常处理
// * @Author Enki
// * @Date 2024/8/8 16:39
// * @Verison 1.0
// **/
//@Slf4j
//@RestControllerAdvice
//public class GlobalExceptionHandler {
//
//    @ResponseBody
//    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
//    @ExceptionHandler(value = {BindException.class, ValidationException.class, MethodArgumentNotValidException.class})
//    public ResponseResult<ExceptionData> handleParameterVerificationException(@NonNull Exception e) {
//        ExceptionData.ExceptionDataBuilder exceptionDataBuilder = ExceptionData.builder();
//        log.warn("Exception: {}", e.getMessage());
//
//        if (e instanceof BindException) {
//            BindingResult bindingResult = ((MethodArgumentNotValidException) e).getBindingResult();
//            bindingResult.getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage)
//                    .forEach(exceptionDataBuilder::error);
//        } else if (e instanceof ConstraintViolationException) {
//            if (e.getMessage() != null) {
//                exceptionDataBuilder.error(e.getMessage());
//            }
//        } else {
//            exceptionDataBuilder.error("invalid parameter");
//        }
//        return ResponseResultEntity.fail(exceptionDataBuilder.build(), "invalid parameter");
//    }
//}
