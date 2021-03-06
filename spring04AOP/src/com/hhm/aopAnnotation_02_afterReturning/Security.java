package com.hhm.aopAnnotation_02_afterReturning;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * 这是切面类，用于存放公共的代码
 * 
 * 用注解的方式实现AOP编程
 * 
 * @author 黄帅哥
 * 
 */
@Aspect //声明该类是切面
public class Security {
	/**
	 * @Pointcut 用于声明切入点，声明在方法前
	 * 用于声明切入点的方法须满足：返回值为void、无参、用private修饰、方法体为空
	 */
	@Pointcut(value="execution(* com.hhm.aopAnnotation_02_afterReturning.UserDaoImpl.add*(..))")
	private void pointCutAdd(){}
	
	@Pointcut(value="execution(* com.hhm.aopAnnotation_02_afterReturning.UserDaoImpl.delete*(..))")
	private void pointCutDelete(){}
	
	
	
	@AfterReturning(value="pointCutAdd()||pointCutDelete()", returning="returnValue")
	//注意，方法的返回值名称必须要与@AfterReturning的returning属性值一样
	private void checkSecurity(JoinPoint joinPoint,Object returnValue) {
		System.out.println("进行安全性检测。。。。");
		System.out.println("连接点类：" + joinPoint.getClass());
		System.out.println("目标对象类型：" + joinPoint.getTarget());

		// 获取目标对象的方法名
		Signature signature = joinPoint.getSignature();
		System.out.println("方法名：" + signature.getName());

		// 获取方法的参数
		Object[] argvs = joinPoint.getArgs();
		if (argvs != null && argvs.length > 0) {
			for (Object arg : argvs) {
				System.out.println("参数：" + arg);
			}
		}
		System.out.println(returnValue);
	}
}