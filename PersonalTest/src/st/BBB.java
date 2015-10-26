package st;

public class BBB {
	public static void main(String[] args) {
		
		
		int count = 0;
		int flag = 0;
		
		if(count>-1 || (flag++)>-1 ){
			count++;
		}
		
		if((flag) == 1 && (count++)>-1 ){
			count++;
		}
		System.out.println(count);
		System.out.println(flag);
	}
}

