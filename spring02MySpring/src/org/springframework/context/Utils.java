package org.springframework.context;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

/**
 * 该类用来解析XML文件
 * 
 * @author 黄帅哥
 * 
 */
public class Utils {

	public static Object readXmlFile(InputStream in) {
		// 用来存储返回对象的容器
		Map<String, Object> beanMap = new HashMap<String, Object>();
		try {
			// 利用dom4j来解析XML文件
			SAXReader reader = new SAXReader();
			Document document = reader.read(in);

			// 获取没有子元素标签的bean标签
			String beanPath = "/beans/bean";
			List<Node> beanNodeList = document.selectNodes(beanPath);

			// 利用反射和内省初始化bean
			for (Node beanNode : beanNodeList) {
				// 转换为元素节点
				Element element = (Element) beanNode;
				// 获取bean标签的id和class属性的值
				String idvalue = element.attributeValue("id");
				// 获取全限定类名
				String className = element.attributeValue("class");
				// 获取反射类，构建反射对象
				Class clazz = Class.forName(className);

				// 创建bean对象，并且将其实例化
				Object obj = clazz.newInstance();
				// 加入对象到容器
				beanMap.put(idvalue, obj);
			}

			/**
			 * <bean id="user" class="com.hhm.spring_02_di.User"> 
			 * 	<property name="room" ref="room"></property> 
			 * </bean>
			 */
			// 获取带property子元素的bean标签，并且将其property子元素实例化
			
			
			String beanPropertyPath = "/beans/bean/property";
			//获取所有property节点
			List<Node> propertyBeanNodeList=document.selectNodes(beanPropertyPath);
			if(propertyBeanNodeList!=null){
				for (Node node : propertyBeanNodeList) {
					//转换为element对象
					Element propertyElement=(Element)node;
					
					//获取property标签的name属性和ref属性的值
					String nameValue=propertyElement.attributeValue("name");
					String refValue=propertyElement.attributeValue("ref");
					
					/*
					 * 找到该property子标签的bean父标签，根据父标签的id属性的值，找到当前类的对象，
					 * 在利用内省技术
					 */
				
					//父元素
					Element beanElement=propertyElement.getParent();
					//父元素的id属性的值
					String beanId=beanElement.attributeValue("id");
					//找到当前类的对象
					Object bean=beanMap.get(beanId);
					
					//内省技术
					BeanInfo beanInfo=Introspector.getBeanInfo(bean.getClass());
					PropertyDescriptor[] pDescriptors=beanInfo.getPropertyDescriptors();
					
					for (PropertyDescriptor propertyDescriptor : pDescriptors) {
						//找到当前属性
						if(propertyDescriptor.getName().equals(nameValue)){
							//找到映射的bean对象
							Object setPropertyValueBean=beanMap.get(refValue);
							//激活
							propertyDescriptor.getWriteMethod().invoke(bean, new Object[]{setPropertyValueBean});
						}
					}
				}
				
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
		return beanMap;
	}
}
