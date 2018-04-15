package com.cuiwei.classloader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class DiskClassLoader extends ClassLoader{
	private String myLibPath;
	public DiskClassLoader(String path){
		this.myLibPath = path;
	}
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		String fileName = getFileName(name);
		File file = new File(myLibPath,fileName);
		InputStream ins = null;
		ByteArrayOutputStream bos = null;
		byte [] data = null;
		try {
			ins = new FileInputStream(file);
			bos = new ByteArrayOutputStream();
			int len = 1024;
			byte[] buffer = new byte[len];
			while((len = ins.read(buffer, 0, len))!=-1){
				bos.write(buffer, 0, len);
			}
			data = bos.toByteArray();
			return defineClass(name, data, 0, data.length);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(ins!=null){
				try {
					ins.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(bos!=null){
				try {
					bos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return super.findClass(name);
	}
	private String getFileName(String name) {
		int index = name.lastIndexOf(".");
		if(index == -1){
			return name + ".class";
		}else{
			return name.substring(index + 1) + ".class";
		}
	}
}
