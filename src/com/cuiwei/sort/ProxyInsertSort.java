package com.cuiwei.sort;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class ProxyInsertSort implements MethodInterceptor {

	public Object createProxy(Object target){
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(target.getClass());
		enhancer.setCallback(this);
		return enhancer.create();
	} 
	
	public Object intercept(Object target, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
		Object result = null;
		Long st = System.currentTimeMillis();
		result = methodProxy.invokeSuper(target, args);
		Long en = System.currentTimeMillis();
		System.out.println("【"+ method.getName() +"】总共耗时：" +(en-st) +"毫秒");
		return result;
	}
}
