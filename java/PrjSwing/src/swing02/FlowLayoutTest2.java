package swing02;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FlowLayoutTest2 extends JFrame {
	public FlowLayoutTest2() {
		setTitle("Flow layout Test2");
		
		init();
				
		setSize(300,300);
		setVisible(true);		
	}
	
	private void init() {
		JPanel  pan1 = new JPanel();
		pan1.setLayout( new FlowLayout() );
		
		JButton []  btns = new JButton[5];
		for (int i = 0; i < btns.length; i++) {
			JButton  btn = new JButton("단추" + i);
			btns[i]      = btn;
			pan1.add( btns[i]  );
			
			btns[i].addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					//System.out.println( e );
					System.out.println( e.getActionCommand() + "클릭"  );					
				}
			});
		}	   
	    
	    this.add(pan1);
	}

	public static void main(String[] args) {
		new FlowLayoutTest2();
	}
}










