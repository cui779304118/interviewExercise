package com.cuiwei.collection;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
public class SetTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Set<String> words=new HashSet<>();
		long totalTime=0;
		
		FileReader fr=new FileReader("a.txt");
		Scanner in=new Scanner(fr);
		while(in.hasNext()){
			String word=in.next();
			long callTime=System.currentTimeMillis();
			words.add(word);
			callTime=System.currentTimeMillis()-callTime;
			totalTime+=callTime;
		}
		
		Iterator<String> iter=words.iterator();
		for(int i=1;i<=20&&iter.hasNext();i++){
			System.out.println(iter.next());
			System.out.println("...");
			System.out.println(words.size()+" distinct words. "+totalTime+"millliseconds.");
		}

	}

}
