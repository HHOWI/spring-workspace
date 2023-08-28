package com.kh.lotto;

import lombok.Data;

@Data
public class Player {

	private Lotto lotto;

	public Player() {
	}

	public Player(Lotto lotto) {
		this.lotto = lotto;
	}

	public void auto() {
		boolean check = true;
		System.out.println(getClass().getName() + "자동 번호 추출");
		while (check) {
			for (int i = 0; i < 7; i++) {
				lotto.selectedNumber();
				int num = lotto.getNum();
				System.out.println((i + 1) + "번째 번호" + "[" + num + "]");
			}
			
		}
	}
}
