import java.awt.*;
import java.awt.geom.*;
import java.awt.Color;
import java.awt.Stroke;
import java.util.*;

public class ClockIcon implements Moveable{
	Random gen = new Random();
	Color c = Color.BLACK;
	double theta = (-Math.PI / 2);
	double gamma = (-Math.PI / 2);
	double alpha = (-Math.PI / 2);
	Point2D.Double origin = new Point2D.Double(300,300);
	private int x,y,width;
	private int h = 0,m = 0,count =0;
	int reset = 1;
	
	public ClockIcon(int q, int p, int s, int a, int b, int c){
		x = q;
		p = y;
		s = width;
		a = h;
		b=m;
		count =c;
	}

	public void setH(int x){
		h = x;
		gamma = (-Math.PI/2) + ( x * (Math.PI / 6));
	}
	
	public void setM(int x){
		m = x;
		alpha = (-Math.PI/2) + ( x * (Math.PI / 30));
	}
	
	public void setCount(int x){
		count = x + (m*60) +  (h * 3600) ;
		theta = (-Math.PI/2) + ( x * (Math.PI / 30)); 
	}
	
	public void setReset(){
		reset = 0;
	}
	
	public int getH(){
		return h;
	}
	
	public int getM(){
		return m;
	}
	
	public int getCount(){
		return count;
	}
	
	public void translate(int dx, int dy) {
		if(reset == 0) {
			theta = (-Math.PI / 2);
			gamma = (-Math.PI / 2);
			alpha = (-Math.PI / 2);
			reset = 1;
		}
		theta = theta + (Math.PI /30);
		count ++;
		if((count % 60) == 0) {				
			alpha = alpha + (Math.PI / 30);
		}
		if((count % 720) == 0) {
			gamma = gamma + (Math.PI/6);
		}
	}
	public void draw(Graphics2D g2) {
		
		Point2D.Double endSecond = new Point2D.Double(300 + 120*Math.cos(theta), 300 + 120*Math.sin(theta));
		g2.setStroke(new BasicStroke(2));
		g2.setColor(c);
		Shape seconds = new Line2D.Double(origin, endSecond);
		g2.fill(seconds);
		g2.draw(seconds);
				
		Point2D.Double endMinutes = new Point2D.Double(300 + 140*Math.cos(alpha), 300 + 140*Math.sin(alpha));
		g2.setStroke(new BasicStroke(5));
		Shape minutes = new Line2D.Double(origin, endMinutes);
		g2.fill(minutes);
		g2.draw(minutes);
		
		Point2D.Double endHour = new Point2D.Double(300 + 100*Math.cos(gamma), 300 + 100*Math.sin(gamma));
		g2.setStroke(new BasicStroke(5));
		Shape hour = new Line2D.Double(origin, endHour);
		g2.draw(hour);

		Ellipse2D.Double circle =  new Ellipse2D.Double(292.5, 292.5,15,15);
		g2.setColor(Color.BLACK);
		g2.fill(circle);
		
		for(int j=0;j<60;j++) {
			circle =  new Ellipse2D.Double( (300 + (170*Math.cos(j* (Math.PI / 30)))) - 2, (300 + (170*Math.sin(j* (Math.PI / 30)))) - 2, 4, 4);
			g2.fill(circle);

		}
		g2.setColor(Color.RED);
		for (int j=0; j<12;j++) {
			circle =  new Ellipse2D.Double( (300 + (170*Math.cos(j* (Math.PI / 6)))) - 5, (300 + (170*Math.sin(j* (Math.PI / 6)))) - 5, 10, 10);
			g2.fill(circle);
		}
	}

}