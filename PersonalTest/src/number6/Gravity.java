package number6;

public class Gravity {
	
	//지구 중심까지의 거리 (단위 Km)
	public final static int POLAR_DISTANCE = 6357000;			//극지방(북극)(m)
	public final static int EQUATOR_DISTANCE = 6387000; 		//적도(m)
	public final static double M = 5.972 * 10E24;				//지구질량 (kg)
	public final static double G = 6.673 * 10E-11;				//만유인력 (mE3/kgE2)
	
	//적도, 북극에서 몸무게 측정시 다르다. 
	//적도(위도 0)에서 70KG인 사람이 북극에 갔을 때 몸두게?
	//인자값 - 각 위도, 질량에 따라 나올수 있는 무게를 구하는 프로그램
	
	
	/**
		동일한 사람인데, 적도와 북극에서 무게을 측정했을 때 다르게 나타나는 이유?
		중력가속도는 극지방으로 갈 수록 커진다.
			- 질량은 물질 고유의 변하지 않는 양이고, 무게는 지구가 당기는 힘이기
			때문에 상대적인 양이다. 

		
		적도 지방이 부푼 타원체이다.
			- 지구 중력은 지구가 거의 구에 가까우므로 지구 중심으로 부터의 거리의 제곱에 반비례한다. 
			  따라서 지구 자전효과 때문에 약간 부푼 적도는 극지방보다 지구중심에서 멀기 때문에
			  중력이 작다.
		
		지구 중심으로 부터 거리 d, 무게(w)
			적도(d) > 극지방(d)
			적도(w) < 극지방(w)
	
		중력 : G * Mm/R^2
			M:지구질량, m:사람 질량
			R:지구 반경 G:만유인력 상수
	 */
	
	
	
	public static void main(String[] args) {
		int pol;	//북극에서 지구중심까지의 거리
		int eqa;	//적도에서 지구중심까지의 거리
		
		
		//1. 위도 경도 값으로 부터 지구 중심으로부터 거리를 구한다.
		pol = getDistance(1,0);	//북극
		eqa = getDistance(2,0);	//적도
		
		//2. 지구중심으로 부터 거리고 질량을 대입해서 중력 가속도를 구한다.
		System.out.println(getGravity(pol,50));	//북극에서 질량이 50인 물체의 중력가속도
		System.out.println(getGravity(eqa,50));	//적도에서 질량이 50인 물체의 중력가속도
	}
	
	
	//위도 경도 값을 가지고 지구 중심으로 부터 거리 구하는 메소드
	public static int getDistance(int lat, int lon){
		//lat = 위도
		//lon = 경도
		
		//위도 경도에 따른 지구중심으로 부터의 거리를 구한다.
		//구하는식이 너무 어렵기 때문에 
		//	(1,0) = 극지방(북극)
		//	(2,0) = 적도	
		// 라고 가정한다.
		
		int distance = 0;
		distance = (lat == 1) ? POLAR_DISTANCE : EQUATOR_DISTANCE;
		return distance;
	}
	
	//지구 중심으로부터 거리와 무게를 가지고 중력을 구하는 메소드
	public static double getGravity(int distance, int weight){
		double gravity = 0;
		
		/**
		 	중력 : G * Mm/R^2
			M:지구질량, m:사람 질량
			R:지구 반경 G:만유인력 상수
		 * */
		gravity = G * M * weight / (distance * distance);
		return gravity;
	}
	
	
}
