package n02.com.shs.game;

import java.util.Random;

public class Fight {
	
	
	public static Character fightUser(Character c1, Character c2){
		Random rnd = new Random();
		Character[] characterArray = new Character[2];
		Character winUser = null;
		characterArray[0] = c1;
		characterArray[1] = c2;
		
		while (true) {
			int turn = rnd.nextInt(2);
			
			if(turn == 0){
				//0번째 케릭터가 공격
				int hp = characterArray[1].getHp();
				hp -= characterArray[0].getDamage();
				characterArray[1].setHp(hp);
				
				System.out.printf("[%s]가 [%s]에게 데미지[%d]을 주었고, [%s]의 hp는 [%d]입니다\n"
						,characterArray[0].getName()
						,characterArray[1].getName()
						,characterArray[0].getDamage()
						,characterArray[1].getName()
						,characterArray[1].getHp());
			}else{
				//1번째 케릭터가 공격
				int hp = characterArray[0].getHp();
				hp -= characterArray[1].getDamage();
				characterArray[0].setHp(hp);
				
				System.out.printf("[%s]가 [%s]에게 데미지[%d]을 주었고, [%s]의 hp는 [%d]입니다\n"
						,characterArray[1].getName()
						,characterArray[0].getName()
						,characterArray[1].getDamage()
						,characterArray[0].getName()
						,characterArray[0].getHp());
			}
			
			if(characterArray[0].isDead()){
				//1번 케릭터 이김
				winUser = characterArray[1];
				break;

			}else if(characterArray[0].isDead()){
				//0번 케릭터 이김
				winUser = characterArray[0];
				break;
			}
		}
		return winUser;
	}
}
