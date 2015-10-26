package n01.com.shs.game;

public class Student {
	
	private String name;	//이름
	private String hack;	//학번
	
	private int grade;		//학년
	
	private int kor;		//국어
	private int eng;		//영어
	private int math;		//수학
	private double avg;		//평균
	
	private int rank;		//등수
	
	public Student(String name, String hack, int grade) {
		this.name = name;
		this.hack = hack;
		this.grade = grade;
	}

	public double getAvg() {
		return avg;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHack() {
		return hack;
	}

	public void setHack(String hack) {
		this.hack = hack;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}
	
	public void setAVG(){
		avg = this.kor+this.eng+this.math/3;
	}
	public void setAVG(int kor, int eng, int math){
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		avg = (this.kor+this.eng+this.math)/3;
	}
	
	public String getInformation(){
		return String.format("학년:%d\t석차[%d] %s\t%s\t평균:%.1f"
				, this.grade
				, this.rank
				, this.name
				, this.hack
				, this.avg);
	}
	
	
	
}
