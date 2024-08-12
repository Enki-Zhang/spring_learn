package spring_pro.result;

/**
 * @ClassName BaseErrorInfoInterface
 * @Description 自定义基础接口类 状态码枚举类需要实现该接口
 * @Author Enki
 * @Date 2024/8/12 8:48
 * @Verison 1.0
 **/

public interface BaseErrorInfoInterface {
    /**
     * 获取错误信息
     *
     * @return
     */
    String getResultMessage();

    /**
     * 获取状态码
     * @return
     */
    String getResultCode();
}
