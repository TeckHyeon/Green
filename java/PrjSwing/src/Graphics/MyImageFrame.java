package Graphics;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyImageFrame extends JFrame {
 
       BufferedImage img = null;

       public MyImageFrame() {
             setTitle("Image Load Test");

             try {
            	 String imgPath = "D:/dev/java/PrjSwing/src/Graphics/cat.jpg"; 
                 img = ImageIO.read(new File(imgPath));            
             } catch (IOException e) {
                    System.out.println(e.getMessage());
                    System.exit(0);
              }
 
             add(new MyPanel());
             pack();

             setVisible(true);
       }
 
       // 내부클래수 
       class MyPanel extends JPanel {

    	   // paint(Graphics g) : 화면에 그려질때 동작한다
    	   // paint() : 이벤트 메소드 - JFrame 이 화면에 setVisible(true)
    	   // 화면에 변화가 생기면 실행되는 이벤트
             public void paint(Graphics g) {
                    g.drawImage(img, 0, 0, null);
             }
 
             public Dimension getPreferredSize() {
                    if (img == null) {
                           return new Dimension(100, 100);
                    } else {
                           return new Dimension(img.getWidth(null), img.getHeight(null));
                         //  return new Dimension(600, 600);
                    }
             }
       }
 
       public static void main(String[] args) {
             new MyImageFrame();
       }
}