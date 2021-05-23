package com.hastemd.demo.aop.status.aop;

import com.hastemd.demo.aop.status.anno.BusinessStatusAnno;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * tx_business_status 表删除数据aop
 *
 * @author lijie@ane56.com
 * @date 2020/12/7
 */
@Aspect
@Component
@Slf4j
public class BusiStatusAspect {

    /**
     * 此注解的目的就是为了根据id 删除数据
     * 1. 如果有idList, 就直接根据idList删除数据
     * 2. 如果没有idList, 就根据markClass 和 idField 去取出需要的id
     *
     * @param joinPoint
     * @param businessStatusAnno
     */
    @SuppressWarnings("Unchecked")
    @After(value = "@annotation(businessStatusAnno)")
    public void afterHandle(JoinPoint joinPoint, BusinessStatusAnno businessStatusAnno) {
        log.info("执行了 Aspect 的, @After");
        log.info("执行了 Aspect 的, @After");
    }
}
