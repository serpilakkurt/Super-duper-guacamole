package Business;

import java.awt.HeadlessException;
import javax.swing.JFrame;
import Logic.Oyun;


public class OyunEkranı extends JFrame{

    public OyunEkranı(String string) throws HeadlessException {
        super(string);
    }

    
    
    public static void main(String[] args) {
        OyunEkranı ekran=new OyunEkranı("Super Mario");
        
        ekran.setResizable(false);
        ekran.setFocusable(false);//JFrame üzerinden odağı aldık
        
        ekran.setSize(1500,600);
        
        ekran.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
        Oyun oyun=new Oyun();
      
        
        
        oyun.requestFocus();//direkt klavyeden işlemlerimizi anlaması için direkt bana odağı ver şeklinde kullanılır
        
        oyun.addKeyListener(oyun);//klavye işlemlerimizi anlamayı sağlıyor
        
        oyun.setFocusable(true);//odağı JPanel e verdik
        
        oyun.setFocusTraversalKeysEnabled(false);//odak gezinme tuşları etkin diyor biz bunu false yapıyoruz ki klavye işlemlerimiz direkt olarak gerçekleşebilsin.
        
        ekran.add(oyun);//JPanel i JFrame e ekledik
        
        ekran.setVisible(true);//JPanel i JFrame e eklendiği zaman direkt olarak oluşsun
        
        oyun.imageL1.setBounds(210,440,32,32);
        oyun.imageL1.setVisible(true);
        oyun.add(oyun.imageL1);

        oyun.imageL2.setBounds(420,530,32,32);
        oyun.imageL2.setVisible(true);
        oyun.add(oyun.imageL2);

        oyun.imageL3.setBounds(720,530,32,32);
        oyun.imageL3.setVisible(true);
        oyun.add(oyun.imageL3);

        oyun.imageL4.setBounds(820,530,32,32);
        oyun.imageL4.setVisible(true);
        oyun.add(oyun.imageL4);

        oyun.imageL5.setBounds(1150,530,32,32);
        oyun.imageL5.setVisible(true);
        oyun.add(oyun.imageL5);
    }    
}