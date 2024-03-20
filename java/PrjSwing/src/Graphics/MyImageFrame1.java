package Graphics;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import java.util.Random;
 
import javax.imageio.*;
import javax.swing.*;
 
public class MyImageFrame1 extends JFrame implements ActionListener {
 

       BufferedImage img;

       private int pieces = 4;
       private int totalPieces = pieces * pieces;
       private int[] pieceNumber;  // 잘라진 그림 번호
 
       public MyImageFrame1() {
             setTitle("Image Draw Test");
             try {
                    img = ImageIO.read(new File("D:/dev/java/PrjSwing/src/Graphics/space.jpg"));
             } catch (IOException e) {
                    System.out.println(e.getMessage());
                    System.exit(0); 
             }
             
             pieceNumber = new int[totalPieces];
             for (int i = 0; i < totalPieces; i++) {
                 pieceNumber[i] = i;
             }
             
             System.out.println("1");
             add(new MyPanel(), BorderLayout.CENTER);
             
             System.out.println("2");
             JButton button = new JButton("DIVIDE");
             button.addActionListener(this);
             add(button, BorderLayout.SOUTH);
             
             System.out.println("3");             
             setSize(600, 600);
             setVisible(true);
             System.out.println("4");             
       }
 
       void divide() {
             Random rand = new Random();
             int ri;
             for (int i = 0; i < totalPieces; i++) {
                    ri = rand.nextInt(totalPieces);
                    int tmp = pieceNumber[i];
                    pieceNumber[i] = pieceNumber[ri];
                    pieceNumber[ri] = tmp;
             }
       }
 

       class MyPanel extends JPanel {
    	    
    	     public MyPanel() {
    	    	 System.out.println("MyPanel()");
    	     }
    	   
             public void paintComponent(Graphics g) {
                    System.out.println("paintComponent");
            	 	super.paintComponent(g);  // 부모기능을 수행한다
                    
                    int pieceWidth  = img.getWidth(null) / pieces;
                    int pieceHeight = img.getHeight(null) / pieces;
                    for (int x = 0; x < pieces; x++) {
                           int sx = x * pieceWidth;
                           for (int y = 0; y < pieces; y++) {
                                 int sy = y * pieceHeight;
                                 int number = pieceNumber[x * pieces + y];
                                 int dx = (number / pieces) * pieceWidth;
                                 int dy = (number % pieces) * pieceHeight;
                                 g.drawImage(img, dx, dy, dx + pieceWidth, dy + pieceHeight,
                                              sx, sy, sx + pieceWidth, sy + pieceHeight, null);
                           }
                    } 
             }
 
       }
 
       public static void main(String[] args) {
             new MyImageFrame1();
       }
 
       // 버튼을 클릭하면
       public void actionPerformed(ActionEvent e) {
    	   	 System.out.println("actionPerformed");
             divide();
             repaint(); // 화면을 새로 고침(새로 그린다)
 
       }
}





