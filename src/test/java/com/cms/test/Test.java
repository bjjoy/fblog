package com.cms.test;

import java.util.HashSet;
import java.util.Set;

public class Test {

	public static void main(String[] args) {
		S f = new S();
		f.caculate();
		System.out.println(f.value);
		String a = "123";
		 int sum = 0;  
	        for(int i=0;i<a.length();++i){  
	            sum = sum*31+a.charAt(i);  
	        }
	        System.out.println(sum);
	        System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MAX_VALUE+Integer.MAX_VALUE+2);
	}
}
class F{
    public int value;
    public F(){
//        this.value = 1;
    }
    public void caculate(){
    	this.value += 1;
    }
}
class S extends F{
	public void caculate(){
		this.value -= 3;
	}
	public void mul(int v){
		caculate();
		super.caculate();
		this.value *= v;
	}
}