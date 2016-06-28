package com.hhm.spring_02_JDKProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
/**
 * 这是对象的动态代理类
 * @author 黄帅哥
 *
 */
public class ObjectJDKProxy implements InvocationHandler{
	//引入代理的真实角色
	private Object realObject=null;
	
	
	
	public ObjectJDKProxy(Object realObject) {
		super();
		this.realObject = realObject;
	}


	/**
	 * 创建被代理角色（真实角色）
	 * @return
	 */
	public Object createRealObjectInstance(){
		// 参数1：类加载器
		// 参数2：设置代理类实现的接口，跟目标对象使用相同接口
		// 参数3：回调对象，当代理对象方法调用时，调用该参数指定对象的invoke方法
		return Proxy.newProxyInstance(this.realObject.getClass().getClassLoader(),
				realObject.getClass().getInterfaces(), this);
	}

	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {

		this.checkSecurity();
		System.out.println("代理类："+proxy.getClass());
		System.out.println("代理方法名称："+method.getName());
		if(args !=null && args.length>0){
			for(Object arg:args){
				System.out.println("参数："+arg);
			}
		}
		
		//调用目标对象(被代理对象）的方法
		Object returnValue=method.invoke(this.realObject,args);
		System.out.println("return value:"+returnValue);
		return returnValue;
	}

	public void checkSecurity(){
		System.out.println(" check security by proxy.....");
	}
}
