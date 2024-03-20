package swing04;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class FindName  extends  JFrame {
	
	JComboBox     cbOption;
	JTextField    txtName;
	JButton       btnFind;
	JTextArea     taMember;
	JScrollPane   sp;	
	
	public FindName() {
		setTitle("멤버 검색");
		init();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(500, 400);
		setVisible(true);		
	}

	private void init() {
		
		this.txtName        =   new JTextField(20);
		txtName.setToolTipText("검색정보를 입력하세요");
		this.btnFind        =   new JButton("찾기");
		this.taMember       =   new JTextArea(10, 16);
		taMember.setFont(new Font("HY견고딕", Font.PLAIN, 22));
		this.sp             =   new JScrollPane( taMember );    
		
		JPanel       p      =   new JPanel( new FlowLayout() );
		
		this.cbOption       =   new JComboBox();		
		cbOption.setModel(
			new DefaultComboBoxModel(
					new String[] {
							"번호", "이름", "이메일", "태어난 연도"	
					}	
			)			
		);
		
		p.add(cbOption);
		p.add(txtName);
		p.add(btnFind);
			
		this.add(p,  BorderLayout.NORTH);
		this.add(sp);
		
		// 기능추가
		btnFind.addActionListener((ActionEvent e) -> {
			ArrayList<Member>  memList = getMemberList();
			String result = "";
			for (Member member : memList) {
				result += member.toString() + "\n";
			} 
			taMember.setText( result );
		});		
		
	}

	private ArrayList<Member> getMemberList() {
		ArrayList<Member>  memList = new ArrayList<>();
		
		// 번호,이름,이메일,연도
		Member          mem   = null; 
		
		String          path  = "D:/dev/java/PrjSwing/src/swing04/member.txt";
		
		// 선택한 구분 (번호/이름/이메일/연도) -> cbOption
		int             selIdx =  cbOption.getSelectedIndex(); // 선택한 항목의 번호(0~)
		
		// 입력한 검색어  -> txtName
		String          sText  =  txtName.getText().trim(); 
		
		FileReader      fr     =  null;
		BufferedReader  br     =  null;
		try {
			fr = new FileReader( path );
			br = new BufferedReader( fr );
			
			br.readLine();  // 제목			
			String line = "";
			while( (line = br.readLine() ) != null  ) {
				mem  = new Member( line );
				
				switch( selIdx  ) {
				case 0 : // 번호
					if( mem.getNum() == Integer.parseInt(sText) ) {
						memList.add( mem );
					}
					break;
				case 1 : // 이름	
					if( mem.getName().contains(sText)  ) {
						memList.add( mem );
					}
					break;
				case 2 : // 이메일
					if( mem.getEmail().contains(sText)  ) {
						memList.add( mem );
					}
					break;
				case 3 : // 연도
					if( mem.getBirthYear().equals( sText )  ) {
						memList.add( mem );
					}
					break;
				}  // switch end
				
			}	// while end		
			
		} catch (FileNotFoundException e) {			
			e.printStackTrace();
		} catch (IOException e) {			
			e.printStackTrace();
		} finally {
			try {				
				if( br != null ) br.close();
				if( fr != null ) fr.close();
			} catch (IOException e) {			
				e.printStackTrace();
			}
		}  // try end
			
		return  memList;
	}  // getMemberList() end

	public static void main(String[] args) {
		new FindName();
	}

}
