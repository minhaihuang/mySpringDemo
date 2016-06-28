package com.hhm.aop_05_Proceeding;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;

/**
 * AOP编程的切面，用于存放公共的代码，
 * 
 * 此处是用于测试环绕通知，环绕通知使得有机会在一个方法执行之前和执行之后运行。可决定该方法在何时执行，
 * 是否执行。调用 ProceedingJoinPoint的proceed()方法会导致后台的连接点方法执行。
 * 注意：
 * 1，不管调用几次proceed()方法，最终只会执行一次
 * 2，用的是ProceedingJoinPoint类，而不是JoinPoint类

 * 
 * @author 黄帅哥
 * 
 */
public class Security {
	/**
	 * JoinPoint对象，用于获取连接点(joinPoint)的信息 ，返回参数、返回目标、相关特征
	 * 
	 * @param joinPoint
	 */
	private void checkSecurity(ProceedingJoinPoint proceedingJoinPoint) {
		System.out.println("进行安全性检测。。。。");
		System.out.println("连接点类：" + proceedingJoinPoint.getClass());
		System.out.println("目标对象类型：" + proceedingJoinPoint.getTarget());

		//获取目标对象的方法名
		Signature signature = proceedingJoinPoint.getSignature();
		System.out.println("方法名：" + signature.getName());

		//获取方法的参数
		Object[] argvs = proceedingJoinPoint.getArgs();
		if (argvs != null && argvs.length > 0) {
			for (Object arg : argvs) {
				System.out.println("参数：" + arg);
			}
		}
		
		try {
			//调用主要业务方法
			proceedingJoinPoint.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
}
