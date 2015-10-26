package st;

public class Test {
	public static void main(String[] args) {
		
		Student st1 = new Student("홍길동", "11111");
		Student st2 = new Student("아무게", "11111");
		Student st3 = new Student();
		
		System.out.println(whoamI(st1));
		System.out.println(whoamI(st2));
		System.out.println(whoamI(st3));
		
		
		
		name();
		name("d");
	}
	
	public static String whoamI(Student st){
		String name = "";
		name = st.name;
		return name;
	}
	
	public static void name() {
		
	}
	public static void name(String s){
		
	}
}
