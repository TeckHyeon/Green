package swing03;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class CalcTest extends JFrame {
	public CalcTest() {
		setTitle("간단 계산기");
		
		initComponent();
		
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(300, 300);
		this.setVisible(true);		
	}
	
	private void initComponent() {
		// 화면 layout
		this.setLayout( new GridLayout(5, 2) );
		
		// 화면 배치
		JLabel         lblVal1   =  new  JLabel("값1");
		this.add(lblVal1);		
		JTextField     txtVal1   =  new  JTextField( 10 );
		this.add(txtVal1);
		
		JLabel         lblVal2   =  new  JLabel("값2");
		this.add(lblVal2);
		JTextField     txtVal2   =  new  JTextField( 10 );
		this.add(txtVal2);
		
		JButton        btnAdd    =  new  JButton("더하기");
		this.add(btnAdd);
		JButton        btnSub    =  new  JButton("빼기");
		this.add(btnSub);
		JButton        btnMul    =  new  JButton("곱하기");
		this.add(btnMul);
		JButton        btnDiv    =  new  JButton("나누기");
		this.add(btnDiv);
		
		JLabel         lblResult =  new  JLabel("결과");
		this.add(lblResult);
		
		// 기능연결
		ActionListener  btnClick = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton btn = (JButton) e.getSource();  // 눌러진 버튼
				int  val1 = Integer.parseInt( txtVal1.getText() );
				int  val2 = Integer.parseInt( txtVal2.getText() );
				int  val  = 0;
				switch( btn.getText()  ) {
				case "더하기": val = val1 + val2; break;
				case "빼기":   val = val1 - val2; break;
				case "곱하기": val = val1 * val2; break;
				case "나누기": val = val1 / val2; break;
				}
				lblResult.setText( String.valueOf(val) );
			}
		};
		
		// 더하기
		btnAdd.addActionListener( btnClick );
		btnSub.addActionListener( btnClick );
		btnMul.addActionListener( btnClick );
		btnDiv.addActionListener( btnClick );
		
		
		
		
		
	}
	public static void main(String[] args) {
		new CalcTest();		
	}

}












