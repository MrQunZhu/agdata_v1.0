package org.clesun.utils;

import java.lang.annotation.*;

/**
 * 对当前方法的功能进行描述，以便于进行操作日志的记录、权限控制
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface MethodDescription {
    /**
     * 方法功能代码
     */
    String value() default "NoDesc";
    /**
     * 方法操作显示名称
     */
    String showName() default "";

    /**
     * 方法返回方式
     * @return  默认 ResultTypeEnum.Ajax
     */
    ResultTypeEnum resultType() default ResultTypeEnum.Ajax;

}
