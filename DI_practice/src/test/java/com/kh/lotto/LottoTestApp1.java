package com.kh.lotto;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kh.lotto.impl.LottoImpl;

public class LottoTestApp1 {

	public static void main(String[] args) {

		ApplicationContext factory = new ClassPathXmlApplicationContext("/config/lotto.xml");
		
		Player player = (Player) factory.getBean("player");
		player.auto();
		
	}

}
