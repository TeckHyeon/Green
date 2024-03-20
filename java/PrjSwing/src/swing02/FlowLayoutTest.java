package swing02;

import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FlowLayoutTest extends JFrame {

	public FlowLayoutTest() {
		setTitle("FlowLayout Test");
		
		initComponent();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(300,200);
		setVisible(true);
	}

	private void initComponent() {
		JPanel  pan1 = new JPanel();
		pan1.setLayout( new FlowLayout() );
		
		// component 추가
		JButton btn1 = new JButton("버튼1");		
		pan1.add(btn1);
		JButton btn2 = new JButton("버튼2");		
		pan1.add(btn2);
		JButton btn3 = new JButton("버튼3");		
		pan1.add(btn3);
		JButton btn4 = new JButton("버튼4                               ");		
		pan1.add(btn4);
		JButton btn5 = new JButton("버튼5");		
		pan1.add(btn5);
		
		// 기능추가
		btn1.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("버튼1 클릭");
			}
		} );	
		
		btn2.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("버튼2 클릭");
			}
		} );	
		
		btn3.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("버튼3 클릭");
			}
		} );	
		
		this.add(pan1);
	}

	public static void main(String[] args) {
		new FlowLayoutTest();

	}
	
	

}
