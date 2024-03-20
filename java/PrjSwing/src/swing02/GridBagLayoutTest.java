package swing02;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class GridBagLayoutTest  extends  JFrame {

	public  GridBagLayoutTest() {
		this.setTitle("gridBag 레이아웃");
		
		initComponent();
		
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(500, 500);
		this.setVisible(true);
	}
	
	private void initComponent() {
	
		GridBagLayout  gbl =  new GridBagLayout();
		this.setLayout( gbl );
		
		JButton [] btns = new JButton[5];
		for (int i = 0; i < btns.length; i++) {
			btns[i] = new JButton("버튼 " + (i+1));
		}
		
		// Constraints : 제약조건 - options
		GridBagConstraints [] gbc = new GridBagConstraints[ btns.length ];
		
		gbc[0]         =  new GridBagConstraints();
		gbc[0].gridx   =  0;   // column
		gbc[0].gridy   =  0;   // row
		this.add( btns[0], gbc[0] );
		
		gbc[1]         =  new GridBagConstraints();
		gbc[1].gridx   =  0;
		gbc[1].gridy   =  1;
		this.add( btns[1], gbc[1] );
		
		gbc[2]         =  new GridBagConstraints();
		gbc[2].gridx   =  0;
		gbc[2].gridy   =  2;
		this.add( btns[2], gbc[2] );
		
		gbc[3]         =  new GridBagConstraints();
		gbc[3].gridx   =  1;
		gbc[3].gridy   =  0;
		this.add( btns[3], gbc[3] );
		
		gbc[4]            =  new GridBagConstraints();
		gbc[4].gridx      =  1;
		gbc[4].gridy      =  1;
		gbc[4].gridwidth  =  2;
		gbc[4].gridheight =  2;
		gbc[4].fill       =  GridBagConstraints.VERTICAL;				
		this.add( btns[4], gbc[4] );
				
		
	}

	public static void main(String[] args) {
		new  GridBagLayoutTest();
	}

}











