package n01.com.shs.game;

import java.util.Random;

public class StudentRankStart {
	public static void main(String[] args) {
		
		Student st1[] = new Student[10];
		
		for (int i = 0; i < st1.length; i++) {
			st1[i] = new Student("dsdf", "12312", 1);
			st1[i].setAVG(1, 1, 1);
		}
		
		Student st[] = new Student[10];
		
		String firstName[] = {"홍","김","손","민","정","박","송","서"};
		String middileName[] = {"홍","김","손","민","정","박","송","서","헌"};
		String lastNmae[] = {"홍","김","손","민","정","박","송","서"};
		
		Random rnd = new Random();
		
		for (int i = 0; i < st.length; i++) {
			st[i] = new Student(
					firstName[rnd.nextInt(firstName.length)]
					+ middileName[rnd.nextInt(firstName.length)]
					+ lastNmae[rnd.nextInt(firstName.length)]
					, "10120038"
					, 1);
			
			st[i].setAVG(rnd.nextInt(100)+1, rnd.nextInt(100)+1,rnd.nextInt(100)+1);
		}
		
		System.out.println("랭킹 매기기전 전");

		
		for (int i = 0; i < st.length; i++) {
			System.out.println(st[i].getInformation());
		}
		
		System.out.println();
		System.out.println();
		
		System.out.println("랭킹 매긴 후(set Rank)");
		
		Rank rnk = new Rank();
		rnk.setRank(st);
		
		for (int i = 0; i < st.length; i++) {
			System.out.println(st[i].getInformation());
		}
		
		System.out.println();
		System.out.println();
		
		System.out.println("랭킹 정렬 후(get Rank)");
		System.out.println(rnk.getRank(st));
		
	}
}
