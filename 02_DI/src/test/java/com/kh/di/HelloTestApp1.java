package com.kh.di;

public class HelloTestApp1 {

	public static void main(String[] args) {

		// 1. 객체 생성
		Hello hello = new Hello();

		// 2. printMessage() 메서드 호출
		hello.setMessage("으악");

		hello.printMessage();
	}
}
