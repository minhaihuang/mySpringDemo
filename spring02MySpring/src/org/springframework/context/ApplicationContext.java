package org.springframework.context;
/**
 * 自己写一个Spring框架的ApplicationContext，熟悉其实现原理
 * @author 黄帅哥
 *
 */
public interface ApplicationContext {
	public Object getBean(String beanName);
}
