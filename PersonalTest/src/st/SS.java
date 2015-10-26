package st;

public class SS {
	public static void main(String[] args) {
		
		
		int k[] = { 9, 1, 2, 5, 4, 7, 8, 6, 3};
		
		printArray(k);//출력
		setArray(k);//배열 정렬
		printArray(k);;//다시출력
		
	}
	
	
	//숫자 배열을 받아서 그 배열 원소를 출력하는 메소드
	public static void printArray(int []val){
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ배열출력ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		for (int i = 0; i < val.length; i++) {
			System.out.print(val[i]+"\t");
		}
		System.out.println();
		System.out.println();
		System.out.println();
	}
	
	//숫자 배열을 받아서 그안의 배열을 정렬하는 메소드
	public static void setArray(int []val){
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ배열정렬ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		int max = 0;
		for (int i = 0; i < val.length; i++) {
			max = val[i];
			for (int j = 0; j < val.length; j++) {
				if(val[j]>max && i!=j){
					max = val[i];
					int temp = val[i];
					val[i] = val[j];
					val[j] = temp;
				}
			}
		}
		System.out.println();
		System.out.println();
		System.out.println();
		
	}
	
	
	
}
