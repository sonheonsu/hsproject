package n03.com.shs.arrayTest;

public class Test1 {
	public static void main(String[] args) {
		
		int k[] = {9,1,2,8,6,4,5,7};
		
		for (int i = 0; i < k.length; i++) {
			System.out.print(k[i] + "\t");
		}
		System.out.println();
		
		for (int i = 0; i < k.length; i++) {
			for (int j = i; j < k.length; j++) {
				if(k[j] < k[i]){
					int temp = k[j];
					k[j] = k[i];
					k[i] = temp;
				}
			}
		}
		
		
		for (int i = 0; i < k.length; i++) {
			System.out.print(k[i] + "\t");
		}

		
		
		
		
	}
}
