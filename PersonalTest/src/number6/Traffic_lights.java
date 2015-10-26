package number6;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Arc2D;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;



class M_Panel extends JPanel{

	//각각의 기능을 가진 6개의 버튼 생성
	JButton bt1,bt2,bt3,bt4,bt5,bt6;

	/*bt5 버튼 기능 - 원의 Location을 Random으로 지정해 주기 위한
	* Loaction 인자 값을 저장 할 인트형 배열을 만듦. 
	* 참조하기위해 M_Panel생성자 위에 정의*/
	int[] c = new int[16];

	/* 배경색, 신호등의 on,off 색깔 지정  paintComponent함수와 
	* actionPerformed함수에서 쓰기위해 생성자 위에 정의 함
	* 필요한 색의 RGB값을 찾아 지정 */
	Color back_g = new Color(0,0,0);

	Color g_on = new Color(29,219,22);
	Color y_on = new Color(255,228,0);
	Color r_on = new Color(255,0,0);

	Color g_off = new Color(34,80,28);
	Color y_off = new Color(102,92,0);
	Color r_off = new Color(103,0,0);
	//신호등 색의 Default 값
	Color green = g_off,red = r_off,yellow = y_off;

	/* 3가지 색이 디스플레이 되는 경우의 수는 3^2(개) 이다.
	* repaint()함수를 썻을때, 모든 경우를 구현하기에는 
	* 소스가 길어지기 때문에, flg_r(빨강),flg_g(초록),flg_y(노랑)
	* 을 써서, 각 색깔이 꺼졌는지 켜졌는지 알 수 있다.
	* flg_(r,g,b) 값이 1이면 켜짐, 0이면 꺼짐 상태이다.  */
	int flg_r=0;
	int flg_g=0;
	int flg_y=0;
	int flg_re=0;

	/* fig값은 어떤 버튼이 이벤트가 일어 났는지 표현하기 위해 만들었다.
	* 버튼이 6개 이니깐 flg값은 1~6 이다. 
	* 5번 버튼의 기능은 Random으로 원을 각기 다른 색으로 생성 시켜주고
	* 다른 색의 배경을 디스플레이 하는 기능이다.
	* 이때 기능을 다 수행하고, 원래 상태로 만들기 위해 flg번호 0번도 사용한다.
	*/
	int flg=0;

	/* 신호등의 녹 노 빨 색깔을 디스플레이하는 원의 위에 흰색 눈섭모양을 만들기 위해
	필요한 Arc2D 를 저장하는 ArrayListt 객체 생성*/
	ArrayList<Shape> shape_a = new ArrayList<Shape>();


	//M_Panel생성자
	public M_Panel(){
		Shape s;//Shape 객체 생성

		//Panel Layout은 null로 지정
		setLayout(null);
		//버튼 이름 생성
		bt1 = new JButton("Green");
		bt2 = new JButton("Yellow");
		bt3 = new JButton("Red");
		bt4 = new JButton("Auto");
		bt5 = new JButton("Random");
		bt6 = new JButton("Reset");

		/*버튼에 ActionListener 추가 위치는 M_Panel 내부에 구현된
		My_Action Class 이다. */
		bt1.addActionListener(new My_Action());
		bt2.addActionListener(new My_Action());
		bt3.addActionListener(new My_Action());
		bt4.addActionListener(new My_Action());
		bt5.addActionListener(new My_Action());
		bt6.addActionListener(new My_Action());

		//현재 배경색을 추가 back_g 생성자 위의 Color 객체
		this.setBackground(back_g);

		//버튼추가
		this.add(bt1);
		this.add(bt2);
		this.add(bt3);
		this.add(bt4);
		this.add(bt5);

		//6번 버튼은 Reset버튼, 색은 gray로 설정
		bt6.setBackground(Color.gray);
		this.add(bt6);

		/*Panel의 Layout이 null이기 때문에 절대값으로
		컴포넌트들의 Location을 지정*/
		bt1.setBounds(0 , 372, 200, 100);
		bt2.setBounds(200,372,200,100);
		bt3.setBounds(400,372,200,100);
		bt4.setBounds(600,372,200,100);
		bt5.setBounds(800, 372, 200, 100);
		bt6.setBounds(0, 0, 100, 20);

		//빨, 노, 초 위에 흰색 눈섭모양 그림 생성 및 ArrayList<Shape>에 추가
		s = new Arc2D.Float(40,45,280,220,0,180,Arc2D.OPEN);
		shape_a.add(s);
		s = new Arc2D.Float(350,45,280,220,0,180,Arc2D.OPEN);
		shape_a.add(s);
		s = new Arc2D.Float(660,45,280,220,0,180,Arc2D.OPEN);
		shape_a.add(s);


	}
/* 신호등을 그리기 위한 method */
protected void paintComponent(Graphics g){
	super.paintComponent(g);

	/* gn_x는 녹색등 x좌표 절대 값. yl_x, red_x도 x좌표 절대값
	all_y 모든 등의 y좌표 절대값 */
	int gn_x=30,yl_x=340,red_x=650,all_y=50;

	// 전등위 눈섭모양 구현
	Graphics2D g2 = (Graphics2D) g;
	g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
	RenderingHints.VALUE_ANTIALIAS_ON);//매끄럽게하기 위해서
	g2.setColor(Color.white);


	/* 1번 버튼을 눌렸을떄 
	* flg가 1, flg_g가 0이면
	* green색은 녹색등이 on된 색깔 로 바뀜.
	* flg_g=1 이 되어서 켜진상태 표시.
	*  
	* 녹색등이 한번 켜진후, 버튼1의 이벤트가 생겨,
	* flg값이 1이 되면 이전의 flg_g 의 켜진상태를
	* 보고 green색을 녹색등 off색으로 바꾼후
	* flg_g=0 으로 꺼진상태 표시
	* 
	* 나머지 flg 2,3도 이와 같음.
	*/
	if(flg==1 && flg_g==0)
	{
		green = g_on;
		flg_g=1;
	}else if(flg==1){
		green = g_off;
		flg_g=0;
	}

	if(flg==2 && flg_y==0)
	{
		yellow=y_on;
		flg_y=1;
	}else if(flg==2) {
		yellow = y_off;
		flg_y=0;
	}

	if(flg==3 && flg_r==0)
	{
		red = r_on;
		flg_r=1;
	}else if(flg==3){
		red = r_off;
		flg_r=0;

	}

	/* flg4 기능은 actionPerformed() 함수에서 구현
	* flg=5의 기능은 5번 Random Button이 이벤트가 생겼을때
	* c[x] 배열의 숫자가 Random으로 생성.
	* red,yellow,green,back_g의 색깔의 RGB값도 Random으로 생성*/
	if(flg == 5){

		g.setColor(red);
		g.fillOval(c[0] ,c[1], 50, 50);
		g.setColor(red);
		g.fillOval(c[2] , c[3], 50, 50);
		g.setColor(red);
		g.fillOval(c[4] , c[5], 50, 50);
		g.setColor(yellow);
		g.fillOval(c[6] , c[7], 50, 50);
		g.setColor(yellow);
		g.fillOval(c[8] , c[9], 50, 50);
		g.setColor(yellow);
		g.fillOval(c[10] ,c[11], 50, 50);
		g.setColor(green);
		g.fillOval(c[12] , c[13], 50, 50);
		g.setColor(green);
		g.fillOval(c[14] , c[15], 50, 50);
		g.setColor(green);
		g.fillOval(c[14] , c[15], 50, 50);
		g.setColor(red);
		g.fillOval(c[1] ,c[0], 50, 50);
		g.setColor(red);
		g.fillOval(c[3] , c[2], 50, 50);
		g.setColor(red);
		g.fillOval(c[5] , c[4], 50, 50);
		g.setColor(yellow);
		g.fillOval(c[7] , c[6], 50, 50);
		g.setColor(yellow);
		g.fillOval(c[8] , c[9], 50, 50);
		g.setColor(yellow);
		g.fillOval(c[10] ,c[11], 50, 50);
		g.setColor(green);
		g.fillOval(c[12] , c[11], 50, 50);
		g.setColor(green);
		g.fillOval(c[14] , c[13], 50, 50);
		g.setColor(green);
		g.fillOval(c[15] , c[14], 50, 50);
		//배경색 변화
		super.setBackground(back_g);
	}


	/*flg6의 기능은 왼쪽 상단의 Reset버튼을 구현하여 초기화를 시켜줌. */
	if(flg==6)
	{
		//색깔 초기화
		green = g_off;
		yellow=y_off;
		red = r_off;

		//모든 색깔이 꺼진 상태로 초기화
		flg_g=0;flg_y=0;flg_r=0;
		repaint();
		//배경색깔 초기화
		super.setBackground(Color.black);

	}


	/* 신호등의 전구와 색깔및 배경색 표시를 하는 기능
	* flg가 5일때를 제외함.
	* flg가 5일때는 원이 Random의 Loaction으로 배치 할 때,
	* 신호등을 지우고 배치하기 위해 5일때를 제외함*/
	if(flg != 5){
		//신호등 위의 흰색 눈썹모양의 굵기 지정
		g2.setStroke(new BasicStroke(30));
		for(Shape s : shape_a){g2.draw(s);}

		/* 눈썹을 그린후 다시 굵기 초기화
		* 이렇게 해주지 않으면 버튼이 이상해짐.
		*/
		g2.setStroke(new BasicStroke(2));

		/* 이벤트에 의해 flg값이 바뀌고 그 flg값에 의해 위에서 
		* 색깔을 바꿔주는 기능을 수행한 뒤, 신호등을 그리고 지정한 
		* 색으로 색을 바꿈.*/
		g.setColor(green);
		g.fillOval(gn_x , all_y, 300, 250);
		g.setColor(yellow);
		g.fillOval(yl_x , all_y, 300, 250);
		g.setColor(red);
		g.fillOval(red_x , all_y, 300, 250);

		//5번 버튼을 눌렸을때, 마지막에 배경색을 default 색으로 만든다
		if(flg==0){
			super.setBackground(Color.black);
		}
	}
}

//Panel Class의 내부에 ActionListner Class 구현
class My_Action implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		/* 1번 버튼 이벤트 발생 -> 1번 flg을 세우고 repaint();
		* 2번,3번 도 똑같은 기능. 
		*/
		if(e.getSource() == bt1){
			flg=1;
			repaint();
		}
		if(e.getSource() == bt2){
			flg=2;
			repaint();
		}
		if(e.getSource() == bt3){
			flg=3;
			repaint();
		}

		// 4번 버튼 이벤트 발생시 
		if(e.getSource() ==bt4){
			//4번 플레그 세움.
			flg=4;

			//전등색깔 초기화
			green = g_off;
			yellow=y_off;
			red = r_off;

			//3번 for문 돌림, i값 증가.
			for(int i=0; i<3; i++){
			/*i가 0일떄
			* green은 녹색등 켜진색깔.
			* 녹색불은 3초동안 켜지도록 딜레이 생성
			*/
				if(i==0){
					green=g_on;
					paint(getGraphics());
					try {
						Thread.sleep(3000);
					} catch (Exception e1) {}

				}

				/* i가 1일때, 녹색등 끄고, 노란불 On
				* 노란불은 1초동안 켜지도록 딜레이 생성*/
				else if(i==1){
					green=g_off;yellow=y_on;
					paint(getGraphics());
				try {
					Thread.sleep(1000);
				} catch (Exception e1) {}
				paint(getGraphics());}
				
				/* i가 3일떄, 노란불 off 빨간불 on
				* 2초 딜레이 생성                      */
				else{
					yellow=y_off;red=r_on;
					paint(getGraphics());
				try {
				Thread.sleep(2000);
				} catch (Exception e1) {}
				paint(getGraphics());}


				}
			//for문이 끝나면 빨간불 끄고 repaint
			red=r_off;
			repaint();
		}

		//5번 버튼 이벤트 발생
		if(e.getSource() == bt5){
			flg=5;//5번 flg 

			/* 50번 반복 안이 for문은 원의 위치를 지정해 줄 상수값 
			* Random으로 생성*/
			for(int i=0; i<30; i++){
				for(int j=0; j<16; j++){
					if(j%2==0){
						c[j]=(int)(Math.random()*1000);}
					else{
						c[j]=(int)(Math.random()*500);
					}
				}

				// 녹,노,빨 색의 RGB값을 랜덤으로 지정
				/* paint(getGraphics()) 함수를 각각 써준 이유는
				하나의 색깔이 바뀔때 마다 변한 색을 디스플레이 하기 위해 각각 
				paint 함수를 사용*/
				green = new Color((int) (Math.random()*255.0),
					(int) (Math.random()*255.0),(int) (Math.random()*255.0));
				paint(getGraphics());

				yellow = new Color((int) (Math.random()*255.0),
					(int) (Math.random()*255.0),(int) (Math.random()*255.0));

				paint(getGraphics());
				back_g = new Color((int) (Math.random()*255.0),
					(int) (Math.random()*255.0),(int) (Math.random()*255.0));
				paint(getGraphics());

				red = new Color((int) (Math.random()*255.0),
					(int) (Math.random()*255.0),(int) (Math.random()*255.0));
				paint(getGraphics());

				//약간의 딜레이를 주고 그림을 그림
				try {
					Thread.sleep(50);
					} catch (Exception e1) {}
				}

				/*그림을 다 그렸으면 다 그렸다는 flg=0 신호를 주고 색깔 초기화*/
				flg=0;
				green = g_off;
				yellow= y_off;
				red = r_off;
				repaint();

			}

			//6번 reset 버튼 이벤트
			if(e.getSource() == bt6){
				flg=6;
				repaint();
	
			}

		}

	}

}



class M_Frame extends JFrame{

	M_Panel mp = new M_Panel();//Panel 객체 생성

	public M_Frame()
	{

		int f_x=0,f_y=0;// frame의 x,y 좌표
		this.setTitle("Traffic_lights");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(1000,500);
		this.setResizable(false);//크기 조절 x

		//화면의 절대값을 얻어 frame이 화면 정중앙에 배치 되도록 설정
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension sc = kit.getScreenSize();
		f_x = sc.width/2 - this.getSize().width/2;
		f_y = sc.height/2 - this.getSize().height/2;
		this.setLocation(f_x,f_y);

		this.add(mp);

		this.setVisible(true);
	}

}




public class Traffic_lights {
		public static void main(String args []){
		M_Frame mf = new M_Frame();
	}
}
