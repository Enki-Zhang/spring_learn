package spring_pro.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * @ClassName ApiVersion
 * @Description 自定义接口注解版本
 * @Author Enki
 * @Date 2024/8/12 11:18
 * @Verison 1.0
 **/

@Target({ElementType.METHOD,ElementType.TYPE})

public @interface ApiVersion {
}
