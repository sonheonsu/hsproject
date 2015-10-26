package rotto;

import java.util.Random;

public class Rotto {
	
	private final int BALLCOUNT = 7;
	private int ball[];
	
	public Rotto() {
		ball = new int[BALLCOUNT];
		ball = getBalls();
	}
	
	private boolean checkball(int[] balls){
		boolean res = true;
		int temp = 0;
		
		for (int i = 0; i < balls.length; i++) {
			temp = balls[i];
			for (int j = 0; j < balls.length; j++) {
				if(temp == balls[j] && i!=j && temp!=0)
					res = false;
			}
		}
		return res;
	}
	
	
	private int[] setball(int[] balls){
		int max = 0;
		for (int i = 0; i < balls.length; i++) {
			max = balls[i];
			for (int j = 0; j < balls.length; j++) {
				if(balls[j] >= max && i!=j ){
					max = balls[i];
					
					int temp = balls[i];
					balls[i] = balls[j];
					balls[j] = temp;
				}
			}
		}
		return balls;
	}
	
	private int[] getBalls(){
		int balls[] =new int[7];
		Random rnd = new Random();
		
		for (int i = 0; i < balls.length; i++) {
			do {
				balls[i] = rnd.nextInt(45)+1;
			} while (!checkball(balls));
		}
		
		setball(balls);
		
		return balls;
	}
	
	public int[] getBall(){
		return this.ball;
	}
	@Override
	public String toString() {
		String res="";
		for (int i = 0; i < ball.length; i++) {
			res += ball[i]+"\t";
		}
		return res;
	}
	
}
