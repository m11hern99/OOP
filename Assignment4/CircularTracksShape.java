
import java.awt.*;
import java.util.*;
import java.awt.Color;
import java.awt.geom.*;
import javax.swing.*;

public class CircularTracksShape implements Moveable
{
  private int xx;
  private int yy;
  private int width;
  int n;
  double theta = 0;

  private  double[] x = new double[20]; 
  private  double[] y = new double[20];
  
  double[] xmax = new double[20];
  double[] ymax = new double[20];
  double[] xmin = new double[20];
  double[] ymin = new double[20];

 Color[] cc = {Color.decode("#ADFFFA"), Color.decode("#FFADE1"), Color.decode("#F2FFAD"), Color.decode("#FFE0AD"),
               Color.decode("#ADB4FF"), Color.decode("#ADFFB0"), Color.decode("#FFA998"), Color.decode("#A9FA6D"),
               Color.decode("#ADFFFA"), Color.decode("#FFADE1"), Color.decode("#F2FFAD"), Color.decode("#FFE0AD"),
               Color.decode("#ADB4FF"), Color.decode("#ADFFB0"), Color.decode("#FFA998"), Color.decode("#E9FA6D")};
 
  public CircularTracksShape(int x0, int y0, int w){
	  xx = x0;
	  yy = y0;
	  width = w;
	  n = width/40; 

	  for(int i=0; i<= n-1; i=i+1){ 
	   x[i] = 300 + (20 * i ) * Math.cos(theta)+10;
	   y[i]=  300 + (20 * i) * Math.sin(theta);
	 }
	  
	
}
public void translate(int dx, int dy){
	theta = theta + Math.PI/300;
	for (int i=0; i<= n-1; i= i+2) {
	    int j=i+5;
		x[i] = 300 + (((20*i+10)) * Math.cos((j*theta)));
		y[i] = 300 + (((20*i+10)) * Math.sin((j*theta)));
	  } 
	 for (int i=1; i<= n-1; i= i+2){
		int j=i+5;
		x[i] = 300 + (((20*i+10)) * Math.cos((j*-theta)));
		y[i] = 300 + (((20*i+10)) * Math.sin((j*-theta)));

	  }  
}

  public void draw(Graphics2D g2)
  {   
      Rectangle2D.Double rec = new Rectangle2D.Double(0, 0,600,600);
      g2.setColor(Color.pink);
      g2.fill(rec);
      
     for(int i= 0; i<=n-1; i++){
      Ellipse2D.Double circle = new Ellipse2D.Double(20*i, 20*i,width-(40*i),width-(40*i));
      g2.setColor(cc[i]);
      g2.fill(circle);
    }

    Random gen = new Random();
    
    for (int i=0; i<= n-1; i= i+1){
      Color c = new Color(Math.abs(gen.nextInt()) % 255, Math.abs(gen.nextInt()) % 255, Math.abs(gen.nextInt()) % 255);
      g2.setColor(c);
      Ellipse2D.Double ball = new Ellipse2D.Double(x[i]-10, y[i]-10, 20, 20);
      g2.fill(ball);     
      g2.draw(ball);
     }

  } 

}