package com.cuiwei.offer;

/*
 * 懒汉式
 */

public class Singleton {
	private static Singleton instance;
	private Singleton(){}
	
	public static Singleton getInstance(){
		if(instance==null){
			instance=new Singleton();
		}
		return instance;
	}

}

/*饿汉式
 * public class Singleton{
 * private static Singleton instance=new Singleton();
 * private Singleton(){}
 * public static Singleton getInstance(){
 * return instance;
 * }
 * }
 */


/*静态内部类
 * public class Singleton{
 * private static class SingletonHolder{
 * private static final Singleton INSTANCE=new Singleton();
 * }
 * private Singleton(){}
 * public static final Singleton getInstance(){
 * return SingletonHolder.INSTANCE}
 * }
 * 
 */


/*双重检验锁
 * public class Singleton{
 * private volatile static Singleton singleton;
 * private Singleton(){}
 * public static Singleton getSingleton(){
 * if(singleton==null){
 * synchronized(Singleton.class){
 * if(singleton==null){
 * singleton=new singleton();
 * }
 * 
 * }
 * 
 * 
 * }
 * 
 * 
 * 
 * }
 * 
 * 
 * }
 * 
 * 
 * 
 * 
 * 
 */





