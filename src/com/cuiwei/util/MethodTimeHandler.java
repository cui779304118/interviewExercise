package com.cuiwei.util;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class MethodTimeHandler implements MethodInterceptor {

	public Object getProxy(Class targetClass){
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(targetClass);
		enhancer.setCallback(this);
		return enhancer.create();
	}
	
	public Object intercept(Object target, Method method, Object[] args,
			MethodProxy methodProxy) throws Throwable {
		Long startTime = System.currentTimeMillis();
		Object result = methodProxy.invokeSuper(target, args);
		Long endTime = System.currentTimeMillis();
		System.out.println("方法【"+ method.getName() +"】,耗时：" + (endTime - startTime) + "毫秒！" );
		return result;
	}
}
