package com.bjsxt.test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import com.bjsxt.test.annotation.SxtField;
import com.bjsxt.test.annotation.SxtTable;

/**
 * 使用反射读取注解的信息，模拟处理注解信息的流程
 * @author A
 *
 */
public class Demo05 {

	
	public static void main(String[] args) throws NoSuchFieldException, SecurityException {
		
		try {
			Class clazz = Class.forName("com.bjsxt.test.annotation.SxtStudent");
			
			//获得类的所有有效注解
			Annotation[] annotations = clazz.getAnnotations();
			for (Annotation a : annotations) {
				System.out.println(a);
			}
			//获取类的指定的注解
			SxtTable st =(SxtTable) clazz.getAnnotation(SxtTable.class);
			System.out.println(st.value());
			
			//获得了类的属性的注解
			Field g = clazz.getDeclaredField("id");
			SxtField sxtField = g.getAnnotation(SxtField.class);
			System.out.println(sxtField.columnName()+"--"+sxtField.type()+"--"+sxtField.length());
			
			Field f = clazz.getDeclaredField("studentName");
			SxtField sxtField1 = f.getAnnotation(SxtField.class);
			System.out.println(sxtField1.columnName()+"--"+sxtField1.type()+"--"+sxtField1.length());
			
			Field h = clazz.getDeclaredField("age");
			SxtField sxtField2 = h.getAnnotation(SxtField.class);
			System.out.println(sxtField2.columnName()+"--"+sxtField2.type()+"--"+sxtField2.length());
			
			//根据获得的表名、字段的信息，拼出DDL语句，然后，使用JDBC执行这个SQL，在数据库中生成的相关的表
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
