package com.cms.test;

import java.util.HashSet;
import java.util.Set;

public class Test {

	public static void main(String[] args) {
		int num = 16;
		Set<Integer> set = new HashSet<Integer>();
		int []r = new int[num];
		int i = 0;
		while(set.size()<16){
			int tmp = (int)(Math.random()*100%16);
			if(!set.contains(tmp)){
				r[i++] = tmp;
			}
			set.add(tmp);
		}
		for(i = 0; i<16;i++){
			System.out.println(r[i]);
		}
	}
}
