package com.cuiwei.classloader;

import java.lang.reflect.Method;

public class ClassLoaderMain {

	public static void main(String[] args) {
		DiskClassLoader diskClassLoader = new DiskClassLoader("F://java");
		try {
			Class c = diskClassLoader.loadClass("com.cuiwei.classloader.ClassLoaderTest");
			
			if(c != null){
				try {
					Object obj = c.newInstance();
					Method method = c.getMethod("say", null);
					method.invoke(obj, null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
