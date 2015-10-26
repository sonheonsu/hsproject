package classtest;

public class Ex01_Class {
	
	static final double EARTH_SURFACE_AREA = 4 * Math.PI * 6400* 6400;
	
	
	static {
		System.out.println("Test");
	}
	
	public static void main(String[] args) {
		//Ex01_Class
		
		Ex01_Class test = new Ex01_Class();
		int k = test.sum2(1,2,3,4,5,6,7,8,9,10);
		System.out.println(k);
		
	}//main
	
	public int sum2(int ...val){
		int res = 0;
		for (int i = 0; i < val.length; i++) {
			res += val[i];
		}
		return res;
	}
	
	
}//Ex01_Class
