
package Logic;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
import javax.swing.JPanel;
import java.util.Timer;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;




public class Oyun extends JPanel implements KeyListener{
/*
    KeyListener: bir tane interface.Belirli bir tuşa bastığımız zaman gerekli olan metodları kullanmamızı sağlar.
    ActionListener: nesnelerimizi hareket ettirmemizi sağlayan interface.
  */
   
    Timer timer1=new Timer();
    Timer timer2 = new Timer();
    TimerTask timerTask;
    TimerTask indir;
 
    public int c;
    public BufferedImage image1;
    public BufferedImage image2;
    public BufferedImage image3;
    public BufferedImage image4;
    public BufferedImage image5;
    public BufferedImage image6;
    public BufferedImage image7;
    
    public int fareX=930;
    public int faredirX=5;
    public int bocekY=490;
    public int bocekdirY=7;
    public int bocek2Y=490;
    public int bocekdir2Y=7;
    public int marioX=0;//sol alt köşeden başlayacak
    public int marioY=490;
    public int dirmarioY=100;
    public int dirmarioX=10;//20 milim sağ veya sola kaydırrabilmek için 
    public int bulutX=200;
    public int bulutdirX=1;
    public int bulut2X=600;
    public int bulutdir2X=1;
    public int bulut3X=1100;
    public int bulutdir3X=1;
    
    
    ImageIcon image12 = new ImageIcon("altin.png");
    public JLabel imageL1 = new JLabel(image12);
    
     ImageIcon image13 = new ImageIcon("altin.png");
    public JLabel imageL2 = new JLabel(image13);
    
     ImageIcon image14 = new ImageIcon("altin.png");
    public JLabel imageL3 = new JLabel(image14);
    
     ImageIcon image15 = new ImageIcon("altin.png");
    public JLabel imageL4 = new JLabel(image15);
    
     ImageIcon image16 = new ImageIcon("altin.png");
    public JLabel imageL5 = new JLabel(image16);
    
    public boolean kontrolet(){

          if (new Rectangle(marioX,-marioY,image1.getWidth()/5,image1.getHeight()/5).intersects(new Rectangle(fareX,530,image2.getWidth()/15,image2.getHeight()/15))) {
                  return true;
                }

                if (new Rectangle(marioX,marioY,image1.getWidth()/5,image1.getHeight()/5).intersects(new Rectangle(400,bocekY,image3.getWidth()/20,image3.getHeight()/20))) {
                    return true;
                }
                if (new Rectangle(marioX,marioY,image1.getWidth()/5,image1.getHeight()/5).intersects(new Rectangle(1200,bocek2Y,image4.getWidth()/20,image4.getHeight()/20))) {
                    return true;
                }

                return false;

         }
     int puan=0;
     public boolean altıntopla(){
        
         if (new Rectangle(marioX,marioY,image1.getWidth()/5,image1.getHeight()/5).intersects(new Rectangle(210,440,32,32))){
             puan=50;
             return true;
         }return false;
         
     }  
     public boolean altıntopla2(){
         if (new Rectangle(marioX,marioY,image1.getWidth()/5,image1.getHeight()/5).intersects(new Rectangle(420,530,32,32))){
          puan=100;
             return true;
         }return false;
     }
      public boolean altıntopla3(){
         if (new Rectangle(marioX,marioY,image1.getWidth()/5,image1.getHeight()/5).intersects(new Rectangle(720,530,32,32))){
            puan=150;
             return true;
         }return false;
      }
       public boolean altıntopla4(){
         if (new Rectangle(marioX,marioY,image1.getWidth()/5,image1.getHeight()/5).intersects(new Rectangle(820,530,32,32))){
           puan=200;
             return true;
         }return false;
       }
        public boolean altıntopla5(){
         if (new Rectangle(marioX,marioY,image1.getWidth()/5,image1.getHeight()/5).intersects(new Rectangle(1050,530,32,32))){
            puan=250;
             return true;
         }
        return false;
        } 
     
     
       
    public Oyun() {
        
        this.timerTask = new TimerTask() {
            @Override
            public void run() {
                calistir();
            }
        };
       
        timer2.schedule(timerTask, 0,100);
       
        try {
            image1 = ImageIO.read(new FileImageInputStream(new File("mario.png")));
             image2 = ImageIO.read(new FileImageInputStream(new File("fare.png")));
             image3 = ImageIO.read(new FileImageInputStream(new File("bocek.png")));
              image4 = ImageIO.read(new FileImageInputStream(new File("bocek.png")));
              image5 = ImageIO.read(new FileImageInputStream(new File("bulutpng.png")));
              image6 = ImageIO.read(new FileImageInputStream(new File("bayrak1.png")));
              image7 = ImageIO.read(new FileImageInputStream(new File("altin.png")));
        } catch (IOException ex) {
            Logger.getLogger(Oyun.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        setBackground(Color.BLUE);
        setLayout(null);
     
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g); //To change body of generated methods, choose Tools | Templates.
        int a = 440;
        g.drawImage(image1,marioX,marioY,image1.getWidth()/3,image1.getHeight()/3,this);
        g.drawImage(image2,fareX,530,image2.getWidth()/10,image2.getHeight()/10,this);
        g.drawImage(image3,400,bocekY,image3.getWidth()/15,image3.getHeight()/15,this);
        g.drawImage(image4,1200,bocek2Y,image4.getWidth()/15,image4.getHeight()/15,this);
        g.drawImage(image5,bulutX,80,image5.getWidth()/5,image5.getHeight()/7,this);
        g.drawImage(image5,bulut2X,100,image5.getWidth()/5,image5.getHeight()/7,this);
        g.drawImage(image5,bulut3X,80,image5.getWidth()/5,image5.getHeight()/7,this);
        g.drawImage(image6,1450,250,image6.getWidth()/2,image6.getHeight()/2,this);
       
       g.setColor(Color.GREEN);
       g.fillRect(200,500,70,90); 
       g.setColor(Color.GREEN);
       g.fillRect(600,400,70,180);
       g.setColor(Color.GREEN);
       g.fillRect(1000,400,70,180);
       
     
         
     
       if(altıntopla()){
            
            this.imageL1.setVisible(false);
               
          
        }
       
         if(altıntopla2()){
            this.imageL2.setVisible(false);
           
            
        }
       
          if(altıntopla3()){
           this.imageL3.setVisible(false);
           
            
        }
        
           if(altıntopla4()){
             this.imageL4.setVisible(false);
             
            
        }
          
            if(altıntopla5()){
            this.imageL5.setVisible(false);
             
            
        }
       
       if(kontrolet()) {
            timer2.cancel();
            String message = "Kaybettiniz...\n"+"Puanınız:"+puan;
            
            JOptionPane.showMessageDialog(this, message);
            puan=0;
            System.exit(0);
        }
        
      
        
           if(marioX==1430){
               String message2 =( "Tebrikler Kazandınız..\n"+ "Puanınız:"+ puan) ;
                                
              JOptionPane.showMessageDialog(this, message2);
              puan=0;
              System.exit(0);
              
           }
            
    }
    

    @Override
    public void repaint() {
        super.repaint(); //To change body of generated methods, choose Tools | Templates.
    }
     @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
    c = e.getKeyCode();//sağ basınca sağ sola basınca sola
        
            if(c == KeyEvent.VK_LEFT){
                    if (marioX <=0)
                        marioX=0;
                    else if((marioX==260 && marioY!=400) ||(marioX==650 && marioY!=300) ||(marioX==1070 && marioY!=299) )
                        marioX=marioX;
                    else if(marioY==400)
                        marioX -= dirmarioX;
                    else
                        marioX -= dirmarioX;
                    
            } else
                
              if(c == KeyEvent.VK_RIGHT){

                    if (marioX >=1430)
                        marioX=1430;
                    else if((marioX >=0 && marioX<=110) || (marioX>=260 && marioX<=500) || (marioX>=650 && marioX<=920)|| (marioY==400) ||  (marioY==300) ||  (marioY==299)
                           || (marioX>=1070 && marioX<=1430) )
                        
                        marioX += dirmarioX;
                    
              }
             
                 indir = new TimerTask() {
                     @Override
                     public void run() {
                         
                            if(marioY>490 || marioY<490){
                                
                                marioY=490;
                                timer1.cancel();
                            }else if(marioY == 490){
                                 marioY -= dirmarioY;
                                
                            }
                        }//run
                   };//indir*/
                 
                 
                 
                 
                if(c == KeyEvent.VK_SPACE){
                    
                     timer1 = new Timer();
                     timer1.schedule(indir,0,100);//indir:görev, 0:hangi zamanda başlayacağı, 100:ne sıklıkla çalışacak(zaman dilimi)
                   
                     if((marioX==120 || marioX==260) ){
                           timer1.cancel();
                           marioY=400;
                          }
                     
                     if( marioX==510 || marioX==650){
                          timer1.cancel();
                           marioY=300;
                      }
                     
                     if( marioX==930 || marioX==1070){
                          timer1.cancel();
                           marioY=299;
                      }
                    if(marioX>=300){
                           dirmarioY=180;
                           timer1.schedule(indir,0,100);

                       }
                
                }    
                
                
    }
                         
    @Override
    public void keyReleased(KeyEvent ke) {
 
    }
    
    
   
    
 public void calistir() {
     
        if(marioX>260 && marioY==400)
            marioY=490;
        
        if ( marioX<110 && marioY==400)
            marioY=490;
        
         if(marioX>650 && marioY==300)
            marioY=490;
        
        if ( marioX<510 && marioY==300)
            marioY=490;

        if(marioX>1070 && marioY==299)
            marioY=490;

        if ( marioX<930 && marioY==299)
            marioY=490;
        
        fareX -= faredirX;
        if(fareX<=680){
            faredirX=-faredirX;
        }
        if(fareX>=950){
            faredirX = -faredirX;
        }
        
        
        bocekY -= bocekdirY;
        if(bocekY<=300){
            bocekdirY=-bocekdirY;
        }
        if(bocekY>=530){
            bocekdirY=-bocekdirY;
        }
        
        bocek2Y -= bocekdir2Y;
        if(bocekY<=300){
            bocekdir2Y=-bocekdir2Y;
        }
        if(bocekY>=530){
            bocekdir2Y=-bocekdir2Y;
        }
        
        
        bulutX -= bulutdirX;
        if(bulutX <=100){
            bulutdirX =-bulutdirX;
        }
        if(bulutX>=200){
            bulutdirX = -bulutdirX;
        }
      
        bulut2X -= bulutdir2X;
        if(bulut2X <=500){
            bulutdir2X =-bulutdir2X;
        }
        if(bulut2X>=600){
            bulutdir2X = -bulutdir2X;
        }
      
        bulut3X -= bulutdir3X;
        if(bulut3X <=1000){
            bulutdir3X =-bulutdir3X;
        }
        if(bulut3X>=1100){
            bulutdir3X = -bulutdir3X;
        }
       
            
      
      repaint();
      
     
    }

    
    
}
