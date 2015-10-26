package n02.com.shs.game;

import java.util.Random;

public class Game {
	public static void main(String[] args) {
		//케릭터 2개 만들기 
		Character c1 = new Character("홍길동");
		Character c2 = new Character("아무게");
		
		//무기 2개 만들기
		ItemAttack item1 = new ItemAttack("무기1", 8);
		ItemAttack item2 = new ItemAttack("무기2", 7);
		
		//아이템장 착시키기
		c1.setItemAttack(item1);
		c2.setItemAttack(item2);
		
		//싸우기
		System.out.printf("%s가 이김",Fight.fightUser(c1, c2).getName());
	}
}
