package n02.com.shs.game;

public class ItemAttack {
	private String name;
	private int strikingPower;
	
	public ItemAttack(String name, int strikingPower ) {
		this.name = name;
		this.strikingPower = strikingPower;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getStrikingPower() {
		return strikingPower;
	}
	public void setStrikingPower(int strikingPower) {
		this.strikingPower = strikingPower;
	}
}
