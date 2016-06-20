package com.core.swng.app.maintanance;

import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {
		ArrayList<Integer> str=new ArrayList<Integer>();
	    str.add(0);
	    str.add(1);
	    str.add(2);
	    str.add(3); 
	    System.out.println(str.get(1));
	    System.out.println(str.get(2));
	    str.remove(2);
	    System.out.println(str.get(2));
	    //Result = [0, 1, 2, 3]
	    str.add(1, 11);
	    str.add(2, 12);
	    //Result = [0, 11, 12, 1, 2, 3]
	    System.out.println(str.get(1));
	    System.out.println(str.get(2));
	    
	}

}
