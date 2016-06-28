package com.hhm.aop_01_before;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;

/**
 * AOP编程的切面，用于存放公共的代码，
 * 
 * 此处是用于进行数据的安全性检测，在调用主要方法之前调用此方法
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
	private void checkSecurity(JoinPoint joinPoint) {
		System.out.println("进行安全性检测。。。。");
		System.out.println("连接点类：" + joinPoint.getClass());
		System.out.println("目标对象类型：" + joinPoint.getTarget());

		//获取目标对象的方法名
		Signature signature = joinPoint.getSignature();
		System.out.println("方法名：" + signature.getName());

		//获取方法的参数
		Object[] argvs = joinPoint.getArgs();
		if (argvs != null && argvs.length > 0) {
			for (Object arg : argvs) {
				System.out.println("参数：" + arg);
			}
		}
		
		//出现异常，则会无法调用主要业务逻辑方法
		//throw new RuntimeException("服务器异常");
	}
}
