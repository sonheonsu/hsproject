package classtest;

import java.util.ArrayList;

public class Test {
	public static void main(String[] args) {

		System.out.println(sum(1,100));		
		System.out.println(sum(3,91));

		System.out.println();

		System.out.println(sum1(1,100));		
		System.out.println(sum1(3,91));

		long start = System.currentTimeMillis();
		getPrime(50000);
		long end = System.currentTimeMillis();
		System.out.println("수행시간 : " + (end - start));
		
		
		
		ArrayList<Integer> prime = new ArrayList<Integer>();
		start = System.currentTimeMillis();
		getPrime(50000, prime);
		end = System.currentTimeMillis();
		System.out.println("수행시간 : " + (end - start));
		
		
		
		System.out.println(shiftSum());
	}

	//더하기 알고리즘
	public static int sum(int start, int end){

		int check = (start+end) % 2;
		//		System.out.println(check);
		int res = 0;
		if(check == 0){
			//더하는 숫자의 갯수가 홀수개
			res = start + (end -1);
			res = res * (end-start)/2;
			res += end;
		}else{
			//더하는 숫자의 갯수가 짝수개
			res = start+end;
			res = res * (res/2);
		}
		return res;
	}
	//더하기 검증
	public static int sum1(int start, int end){

		int res = 0;
		for (int i = start; i <= end; i++) {
			res += i;
		}


		return res;
	}


	//소스 알고리즘 최적화전
	public static void getPrime(int num) {
		int i = 2; // i : 나눌 대상
		boolean isPrime = true;

		while (i <= num) {
			isPrime = true;

			for (int n = 2; n < i; n++) {
				if (i % n == 0) {
					isPrime = false;
					break;//한번 여기에오는순간 뒤에수를 확일할 필요가 없다.
				}
			}

			if (isPrime == true)
				System.out.println(i);
			i++;
		}
	}
	//소스 알고리즘 최적화후
	public static void getPrime(int num, ArrayList<Integer> prime) {
		prime.add(2); 
		
		for (int i = 2; i <= num; i++) {
			for (int j = 0; prime.size() > j; j++) {
				if (i % prime.get(j) == 0) break; // 소수가 아닌 경우 pass
				
				if (j + 1 == prime.size()) // 소수일 때
					prime.add(i);
			}
		}
		
		for (Integer result : prime) {
			System.out.println(result);
		}
	}

	//1+1 최적화
	public static int shiftSum(){
		return 1 << 1;
	}
	
	
}
