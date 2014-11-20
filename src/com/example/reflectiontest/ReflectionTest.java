package com.example.reflectiontest;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

public class ReflectionTest implements ActionListener, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int bInt;
	public Integer bInteger[] = new Integer[4];
	private String strA = "123456abc";
	public String strB;
	
	public ReflectionTest(){
		
	}
	
	public ReflectionTest(int a, String str){
		
	}
	
	public int abc(int a, String str){
		System.out.println("ReflectionTest ---> " + "a = " + a + ", str = " + str);
		return 0;
	}
	
	protected static void edf() {
        
    }
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}

}
