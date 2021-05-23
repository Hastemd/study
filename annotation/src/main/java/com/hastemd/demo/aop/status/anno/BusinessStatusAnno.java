package com.hastemd.demo.aop.status.anno;


import java.lang.annotation.*;

/**
 * 执行删除tx_business_status表数据的 注解
 *
 * @author lijie  2020/12/7.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface BusinessStatusAnno {

    /**
     * 将需要删除的idList放在参数的第一位
     * 此注解的目的就是为了根据id 删除数据
     * 1. 如果有idList, 就直接根据idList删除数据
     * 2. 如果没有idList, 就根据markClass 和 idField 去取出需要的id
     * <p>
     * List<Long> 目前只能有一个, 且放在第一个参数位置, 此数据存在就不会在从别的对象中去取id值了
     *
     * @return
     */
    boolean idList() default false;


}
