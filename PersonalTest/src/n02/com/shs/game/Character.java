package n02.com.shs.game;

public class Character {
	private String name;
	private int hp;
	private ItemAttack itemAttack;
	private int lv;
	
	public Character(String name) {
		this.name =name;
		this.hp = 100;
		this.lv = 1;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getLv() {
		return lv;
	}
	public void setLv(int lv) {
		this.lv = lv;
	}
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public ItemAttack getItemAttack() {
		return itemAttack;
	}
	public void setItemAttack(ItemAttack itemAttack) {
		this.itemAttack = itemAttack;
	}
	public boolean isDead(){
		return (hp < 1) ? true : false;
	}
	public int getDamage(){
		int attack = 1;
		if(!(itemAttack.equals(null)))
			attack =  itemAttack.getStrikingPower();
		return lv * attack;
	}	
	
}
