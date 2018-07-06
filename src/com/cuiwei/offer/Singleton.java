package com.cuiwei.offer;

/*
 * 懒汉模式，线程不安全
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

/*
 * public class Singleton{
 * private static Singleton instance=new Singleton();
 * private Singleton(){}
 * public static Singleton getInstance(){
 * return instance;
 * }
 * }
 */


/*静态内置类模式
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


/*双重校验锁模式DCL
 * public class Singleton{
 * private volatile static Singleton singleton;
 * private Singleton(){}
 * public static Singleton getSingleton(){
 * if(singleton==null){
 * synchronized(Singleton.class){
 * if(singleton==null){
 * singleton=new singleton();
 * }
 * } 
 * 
 * } 
 * }
 * 
 * }
 * 
 */

/**
 * 静态代码块实现
 */
//public class Singleton{
//	private static Singleton instance = null;
//	private Singleton(){}
//	{
//		instance = new Singleton();
//	}
//	public Singleton getInstance(){
//		return instance;
//	}
//	
//}

/**
 * 通过enum枚举类来实现
 */

//public class Singleton{
//	public enum EnumSingleton{
//		enumSingleton;
//		private Singleton instance;
//		private EnumSingleton(){
//			instance = new Singleton();
//		}
//		public Singleton getSingleton(){
//			return instance;
//		}
//	}
//	public static Singleton getInstance(){
//		return EnumSingleton.enumSingleton.getSingleton();
//	}
//}




