package spring_pro.exception;

import lombok.Data;
import spring_pro.resEnum.ResponseStatus;

/**
 * @ClassName ServiceException
 * @Description 统一异常类
 * @Author Enki
 * @Date 2024/8/9 9:29
 * @Verison 1.0
 **/
@Data
public class ServiceException extends RuntimeException {

    private static final long serialVersionUID = 8831333620700795586L;
    private ResponseStatus status;

    public ServiceException(ResponseStatus status, String message) {
        super(message);
        this.status = status;
    }

//    public ServiceException(ResponseStatus status) {
//        this(status);
//    }

}
