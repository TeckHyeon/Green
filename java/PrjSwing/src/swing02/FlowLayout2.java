package swing02;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FlowLayout2 extends JFrame {

	JButton [] btns; 
			
	public FlowLayout2() {
		this.setTitle("FlowLayout 2");
		
		initComponent();
		
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(300, 250); // JFrame size
		this.setVisible( true );
	}
	
	private void initComponent() {
		
		btns = new JButton[] {
			new JButton("단추 1"),	
			new JButton("단추 2"),	
			new JButton("단추 3"),	
			new JButton("단추 4"),	
			new JButton("단추 5")	
		};
		
		Color [] colors = {Color.red, Color.BLUE, Color.cyan, Color.magenta, Color.orange};
		
		
		JPanel  pan1 = new JPanel();		
		for (int i = 0; i < btns.length; i++) {			
			btns[i].setForeground( colors[i] );
			// setPreferredSize : layout 과 무관하게 사이즈 지정 가능
			btns[i].setPreferredSize(new Dimension(260, 30));				
			
			btns[i].addActionListener(new ActionListener() {				
				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println( e.getActionCommand() + " 클릭");					
				}
			});
			pan1.add(btns[i]);			
		}		
		
		this.add( pan1 );
		
		
	}

	public static void main(String[] args) {
		new FlowLayout2();

	}

}






