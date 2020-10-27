package com.hui.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * @author: Lance
 * @Date: 2020-08-27 18:28
 * @Description: 切入点（Pointcut）:在哪些类，哪些方法上切入（where）
 * 通知（Advice）:在方法执行的什么实际（when:方法前/方法后/方法前后）做什么（what:增强的功能）
 * @Before :在被代理方法执行之前执行，它不能控制被代理方法的执行与否
 * @AfterReturning :在被代理方法正常return之后执行
 * @AfterThrowing :在被代理方法抛出异常后执行
 * @After :在上述两种情况（正常return或抛出异常）之后执行
 * @Around :在被代理方法前后执行。只有该方法才能控制被代理方法执行与否（）
 * 切面（Aspect）:切面 = 切入点 + 通知，通俗点就是：在什么时机，什么地方，做什么增强！
 * 织入（Weaving）:把切面加入到对象，并创建出代理对象的过程。（由 Spring 来完成）
 */
//切面
@Aspect
public class LogAspects {

    /**
     * 切点（并不一定需要，因为通知的注解里也可以直接描述切点）
     * 抽取公共的切入点表达式
     * 1、被本类引用
     * 2、被其他的切面引用
     */
    @Pointcut("execution(public int com.hui.aop.MyService.*(..))")
    public void pointCut() {
    }

    /**
     * 前置通知
     */
    @Before("pointCut()")
    public void beforeDeal(JoinPoint joinPoint) {
        System.out.println("@Before");
    }

    /**
     * 后置通知
     */
    @After("pointCut()")
    public void afterDeal(JoinPoint joinPoint) {
        System.out.println("@After");
    }

    //@Before在目标方法之前切入；切入点表达式（指定在哪个方法切入）
    @Before("pointCut()")
    public void logStart(JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        System.out.println(""+joinPoint.getSignature().getName()+"运行。。。@Before:参数列表是：{"+Arrays.asList(args)+"}");
    }

    @After("com.hui.aop.LogAspects.pointCut()")
    public void logEnd(JoinPoint joinPoint){
        System.out.println(""+joinPoint.getSignature().getName()+"结束。。。@After");
    }

    //JoinPoint一定要出现在参数表的第一位
    @AfterReturning(value="pointCut()",returning="result")
    public void logReturn(JoinPoint joinPoint,Object result){
        System.out.println(""+joinPoint.getSignature().getName()+"正常返回。。。@AfterReturning:运行结果：{"+result+"}");
    }

    @AfterThrowing(value="pointCut()",throwing="exception")
    public void logException(JoinPoint joinPoint,Exception exception){
        System.out.println(""+joinPoint.getSignature().getName()+"异常。。。异常信息：{"+exception+"}");
    }
}
