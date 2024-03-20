package swing03;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class AgeCalc extends JFrame {	
	
	// Fields
	JButton      btnCalc1, btnCalc2;
	JTextField   txtBirthYear;
	JLabel       lblResult; 
		
	public AgeCalc()  {
		super("나이 계산기");
		
		initComponent();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(300, 300);
		setVisible(true);

	}

	private void initComponent() {
		getContentPane().setLayout( new FlowLayout() );
		
		this.txtBirthYear = new JTextField( 20 );
		this.txtBirthYear.setPreferredSize(new Dimension(260, 30));  // 버튼의 크기를 지정
		this.txtBirthYear.setText("1999");
		this.txtBirthYear.setToolTipText("태어난 연도를 입력하세요");		
		getContentPane().add(txtBirthYear);
		
		this.btnCalc1    =  new JButton("나이계산(text)");
		btnCalc1.setHorizontalAlignment(SwingConstants.LEFT);
		this.btnCalc1.setPreferredSize(new Dimension( 200, 30 ));		
		getContentPane().add(btnCalc1);
		// 기능부여 : 나이계산(text) 버튼을 클릭했을때
		this.btnCalc1.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int     birthYear  = Integer.parseInt(  txtBirthYear.getText() );				
				int     age        = calcAge(birthYear);  
				String  adult      = "미성년자";
				if( age > 19  ) 
					adult = "성인";
				String  fmt        = "<html>";
				fmt               += "<style>h3 {color:red;}</style>"; 
				fmt               += "<h2>결과</h2>"; 
				fmt               += "<h3>나이:%d</h3>"; 
				fmt               += "<h3>성인:%s 입니다</h3>"; 
				fmt               += "</html>"; 
				String  result     = String.format(fmt, age, adult);
				lblResult.setText(result);
			}

		
		} );
		
		
		this.btnCalc2    =  new JButton("나이계산(dialog)");
		this.btnCalc2.setPreferredSize(new Dimension( 200, 30 ));
		getContentPane().add(btnCalc2);
		this.btnCalc2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String  bYearStr = JOptionPane.showInputDialog(
						null,
						"태어난 연도를 입력하세요", 
						"입력",
						JOptionPane.OK_OPTION,
						null,
						null,
						"1999"
						).toString();
				
				int     birthYear  = Integer.parseInt(  bYearStr );				
				int     age        = calcAge(birthYear);  
				String  adult      = "미성년자";
				if( age > 19  ) 
					adult = "성인";
				String  fmt        = "<html>";
				fmt               += "<style>h3 {color:red;}</style>"; 
				fmt               += "<h2>결과</h2>"; 
				fmt               += "<h3>나이:%d</h3>"; 
				fmt               += "<h3>성인:%s 입니다</h3>"; 
				fmt               += "</html>"; 
				String  result     = String.format(fmt, age, adult);
				lblResult.setText(result);
								
			}
		});
		
		
		
		this.lblResult   =  new JLabel("결과:");
		this.lblResult.setPreferredSize(new Dimension( 200, 150 ));
		getContentPane().add(lblResult);
	}
	
	private int calcAge(int birthYear) {
		LocalDate  now      =  LocalDate.now(); 
		int        thisYear =  now.getYear();
		return thisYear - birthYear;
	}

	
	public static void main(String[] args) {
		new AgeCalc();
	}

}








