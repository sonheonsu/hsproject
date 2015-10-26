package classtest;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Cmd_GUI extends JFrame{

	private JTextArea textarea;
	private JTextField textfield;
	private JLabel label;
	private JPanel bottomPanel;

	public Cmd_GUI() {
		// TODO Auto-generated constructor stub
		initComponent();	//Component 초기화
		initFrame();		//JFrame 초기화
	}//Cmd_GUI

	private void initFrame(){
		this.setVisible(true);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setSize(dim.width*5/6, dim.height*5/6);
		this.setLocation((dim.width/2)-(this.getWidth()/2), (dim.height/2)-(this.getHeight()/2));
	}//initFrame

	private void initComponent(){
		//TextArea 설정
		textarea = new JTextArea();	
		textarea.setBackground(Color.BLACK);
		textarea.setForeground(Color.white);
		this.add(textarea);

		//Bottom Panel 설정
		bottomPanel = new JPanel(new BorderLayout());
		this.add(bottomPanel,BorderLayout.SOUTH);

		//textfield 설정
		textfield = new JTextField();

		//Enter Event 등록
		textfield.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(isReservedWord(textfield.getText())){

				}else{
					textarea.append(">  "+textfield.getText()+"\n");
					textarea.append("일치하는 명령어가 없습니다\n");

					textfield.setText("");
				}

			}});
		bottomPanel.add(textfield);

		//label 설정
		label = new JLabel("Command");
		bottomPanel.add(label,BorderLayout.WEST);

	}//initComponent

	private void clearCmd(){
		textarea.setText(">");
		textfield.setText("");
	}//clearCmd

	private boolean isReservedWord(String cmdStr){
		boolean res = false;
		if(cmdStr.equals("clear")){
			clearCmd();
			res = true;
		}

		if(cmdStr.equals("getlist")){
			String items[] = {"담배","술","허니버터칩"};
			textarea.append(">  getlist\n");
			for (int i = 0; i < items.length; i++) {
				textarea.append("["+i+"]"+items[i]+"\n");	
				textfield.setText("");
			}
			res = true;
		}

		if(cmdStr.equals("getstorename")){
			textarea.append(">  getstorename\n");
			textarea.append("SIST Convenient Store\n");
			textfield.setText("");
			res = true;
		}
		if(cmdStr.equals("timetodie")){


		}


		return res;
	}




	public static void main(String[] args) {
		Cmd_GUI cmd = new Cmd_GUI();
	}//main


}//Cmd_GUI

