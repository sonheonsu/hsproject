package classtest;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class SF extends JFrame{

	public SF() {
		// TODO Auto-generated constructor stub

		this.setVisible(true);
		this.setSize(500,500);
		JButton bt = new JButton("Hello");
		this.add(bt,BorderLayout.SOUTH);
	}

	static int count=0;
	public static void main(String[] args) {
		//		SF s = new SF();
		new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				while(true){
					System.out.println(count++);
					try {
						this.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}

		}.run();;
	}
}
