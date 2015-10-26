package rotto;

public class RottoTest {
	public static void main(String[] args) {

		Rotto rotto = new Rotto();
		Rotto userRotto = null;
		int count = 0;
		int uCount = 0;



		do {
//			System.out.println(rotto);
//			System.out.println(userRotto);
			count = 0;
			userRotto = new Rotto();
			for (int i = 0; i < rotto.getBall().length; i++) {
				if(rotto.getBall()[i] == userRotto.getBall()[i]){
					count++;
				}
			}
			uCount++;
		} while (count != 7);
		System.out.println(rotto);
		System.out.println(userRotto);
		System.out.println(uCount);


		


	}
}
