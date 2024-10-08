package spring_pro.result;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName ResponseStatus
 * @Description 返回状态码
 * @Author Enki
 * @Date 2024/8/7 10:39
 * @Verison 1.0
 **/
@Getter
@AllArgsConstructor
public enum ResponseStatus implements BaseErrorInfoInterface {
    SUCCESS("200", "success"),
    FAIL("500", "failed"),

    HTTP_STATUS_200("200", "ok"),
    HTTP_STATUS_400("400", "request error"),
    HTTP_STATUS_401("401", "no authentication"),
    HTTP_STATUS_403("403", "no authorities"),
    HTTP_STATUS_500("500", "server error");
    /**
     * response code
     */
    private final String resultCode;

    /**
     * description.
     */
    private final String resultMessage;
    /**
     * 创建不可修改列表可以确保 HTTP 状态码的定义和使用的一致性
     */
    public static final List<ResponseStatus> HTTP_STATUS_ALL = Collections.unmodifiableList(
            Arrays.asList(HTTP_STATUS_200, HTTP_STATUS_400, HTTP_STATUS_401, HTTP_STATUS_403, HTTP_STATUS_500
            ));


    @Override
    public String getResultMessage() {
        return resultMessage;
    }

    @Override
    public String getResultCode() {
        return resultCode;
    }
}
