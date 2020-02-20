package com.bjsxt.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import com.bjsxt.test.bean.User;

public class Demo03 {

	public static void main(String[] args) {
		String path ="com.bjsxt.test.bean.User";
		try {
		Class<User> clazz =(Class<User>) Class.forName(path);
		
		//通过反射API调用构造方法，构造对象
		User u =clazz.newInstance();   //其实是调用了User的无参构造对象
		System.out.println(u);
		
		Constructor<User> c = clazz.getDeclaredConstructor(int.class,int.class,String.class);
		User u2 =c.newInstance(1001,18,"李家乐二");
		System.out.println(u2.getUname());
		
		//通过反射API调用普通方法
		User u3 =clazz.newInstance();
		Method method = clazz.getDeclaredMethod("setUname", String.class);
		method.invoke(u3, "李家乐三");//u3.setUname("李家乐三”）
		System.out.println(u3.getUname());
		
		//通过反射API操作属性
		User u4 =clazz.newInstance();
		Field f = clazz.getDeclaredField("uname");
		f.setAccessible(true);//这个属性不需要安全检查，可以直接访问
		f.set(u4, "李家乐四");//通过反射直接写属性
		System.out.println(u4.getUname());//通过反射直接读属性的值
		System.out.println(f.get(u4));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	

}
