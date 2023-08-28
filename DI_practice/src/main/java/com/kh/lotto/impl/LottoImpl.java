package com.kh.lotto.impl;

import java.util.Random;

import com.kh.lotto.Lotto;

public class LottoImpl implements Lotto {

	private int num;
	
	public LottoImpl() {
		System.out.println(getClass().getName() + "생성자..");
	}
	
	@Override
	public void selectedNumber() {
		num = new Random().nextInt(45) + 1;
	}

	@Override
	public int getNum() {
		return num;
	}

}
