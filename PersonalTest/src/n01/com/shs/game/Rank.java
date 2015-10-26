package n01.com.shs.game;

public class Rank {
	
	
	
	public void setRank(Student[] st){
		
		int studentIndex[] = new int[st.length];
		for (int i = 0; i < studentIndex.length; i++) {
			studentIndex[i] = i;
		}
		
		double max = 0;
		
		for (int i = 0; i < st.length; i++) {
			max = st[studentIndex[i]].getAvg();
			for (int j = 0; j < st.length; j++) {
				if(st[studentIndex[j]].getAvg() > max && i != j){
					max = st[studentIndex[j]].getAvg();
					int temp = studentIndex[j];
					studentIndex[j] = studentIndex[i];
					studentIndex[i] = temp;
				}
			}
		}
		
		int count=1; 
		for (int i = studentIndex.length-1; i >=0 ; i--) {
			st[studentIndex[i]].setRank(count++);
		}
	}
	
	public String getRank(Student[] st){
		
		String res = "";
		int studentIndex[] = new int[st.length];
		for (int i = 0; i < studentIndex.length; i++) {
			studentIndex[i] = i;
		}
		
		double max = 0;
		
		for (int i = 0; i < st.length; i++) {
			max = st[studentIndex[i]].getAvg();
			for (int j = 0; j < st.length; j++) {
				if(st[studentIndex[j]].getAvg() > max && i != j){
					max = st[studentIndex[j]].getAvg();
					
					int temp = studentIndex[j];
					studentIndex[j] = studentIndex[i];
					studentIndex[i] = temp;
				}
			}
		}
		
		for (int i = studentIndex.length-1; i >=0 ; i--) {
			res += st[studentIndex[i]].getInformation()+"\n";
		}
		return res;
	}

}
