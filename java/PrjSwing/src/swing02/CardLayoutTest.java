package swing02;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;


public class CardLayoutTest extends JFrame {
	
	CardLayout card;
	Container  c; 	
	
	// 생성자
	public CardLayoutTest() {
		this.setTitle("CardLayout Test");
		
		initComponent();
		
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(500, 500);
		this.setVisible(true);
	}

	private void initComponent() {
		c     =  this.getContentPane(); // 현재 조작하는 JFrame의 컨테이너 정보
		card  =  new CardLayout(40, 30); //  margin  x, y 
		//card  =  new CardLayout(); // x, y  margin : 0  
		c.setLayout( card );
		
		JButton  btn1 = new JButton("버튼 1");
		JButton  btn2 = new JButton("버튼 버튼 2");
		JButton  btn3 = new JButton("버튼 버튼 버튼 3");
		
		// 이벤트추가 : 버튼이 클릭되면 수행할 동작을 추가
		// btn1 이 클릭되면(Action 이 발생하면)
		//    new  ButtonListener() 에 있는 명령이 실행된다 
		//	addActionListener( class implements ActionListener ) 해야만 한다	
		btn1.addActionListener( new ButtonListener() );
		btn2.addActionListener( new ButtonListener() );
		btn3.addActionListener( new ButtonListener() );
		
		/* 익명클래스방식
		ActionListener   btnClick  =  new ActionListener() {  // new			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println( e.getActionCommand() );
				card.next(c);					
			}
		};
		
		btn1.addActionListener(btnClick);
		btn2.addActionListener(btnClick);
		btn3.addActionListener(btnClick);
		*/
		c.add(btn1);
		c.add(btn2);
		c.add(btn3);

	}
	
	// inner class (내부 클래스): class 안의 class - old coding
	class  ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton  btn = (JButton) e.getSource();
			System.out.println( btn.getText() + " 클릭");
			card.next( c );
		}
		
	}
	

	public static void main(String[] args) {
		new CardLayoutTest();

	}


}




