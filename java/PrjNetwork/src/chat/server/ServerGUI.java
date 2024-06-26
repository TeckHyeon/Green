package chat.server;
 
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
 
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
 
public class ServerGUI extends JFrame implements ActionListener{
    
    private static final long serialVersionUID =1L;
    private JTextArea jta = new JTextArea(40,25);
    private JTextField jtf = new JTextField(25);
    private ServerBackground server = new ServerBackground();
    
    public ServerGUI() throws IOException{
        
        add(jta, BorderLayout.CENTER);
        add(jtf, BorderLayout.SOUTH);
        jtf.addActionListener(this); // 기능추가를 위한 이벤트 연결
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setBounds(200, 100, 400, 600);
        setTitle("서버부분");
        server.setGui(this); 
        //serverbackground class 가 현재 Jframe을 조작할 수 있도록
        //현재클래스의 정보를 생성자에게 보내준다.
        server.setting(); //GUI가 실행될때 서버도 같이 동작하도록..
    }
    
    public static void main(String[] args) throws IOException{
        new ServerGUI();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String msg = "서버 : " +jtf.getText() + "\n";
        System.out.print(msg);
        server.sendMessage(msg);
        appendMsg(msg);
        jtf.setText("");
    }
    
    public void appendMsg(String msg) {
        jta.append(msg);
    }
}