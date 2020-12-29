import java.awt.*;
import java.util.*;
import java.awt.Color;
import java.awt.geom.*;
import javax.swing.*;
public class TwoCarsIcon implements Moveable
{
	private int width;
	int n;
	double theta;
	int z;

	private double[] x = new double[120];
	private double[] y = new double[120];

	Color[] cc = {Color.decode("#ADFFFA"), Color.decode("#FFADE1"), Color.decode("#F2FFAD"), Color.decode("#FFE0AD"),
			Color.decode("#ADB4FF"), Color.decode("#ADFFB0"), Color.decode("#FFA998"), Color.decode("#A9FA6D"),
			Color.decode("#ADFFFA"), Color.decode("#FFADE1"), Color.decode("#F2FFAD"), Color.decode("#FFE0AD"),
			Color.decode("#ADB4FF"), Color.decode("#ADFFB0"), Color.decode("#FFA998"), Color.decode("#E9FA6D")};
	public TwoCarsIcon(int x0, int y0, int w){
		width = w;
		n = w/40;
		theta =0;  // 120 = number of circles in 15 tracks
		z=0;
		for (int i=0; i<= n-1; i= i+2){   // this is for the track 
			int k = i + 1;  // this is the number of circles in a track
			for(int j = 0; j<k;j++) {     // j is used to calculate the degrees away from the starting point of the first circle
				x[z] = 300 +  (20*i+10) * Math.cos(theta +  -j *( 2 * Math.asin(10.0 / (20*i+10)))); 
				y[z] = 300 +  (20*i+10) * Math.sin(theta +  -j *( 2 * Math.asin(10.0 / (20*i+10))));
				z++; // keeps track of place in array up until index 119 for the total # of of circles (120)
			}
		}
		for (int i=1; i<= n-1; i= i+2){   // this is for the track 
			int k = i + 1;  // this is the number of circles in a track
			for(int j = 0; j<k;j++) {     // j is used to calculate the degrees away from the starting point of the first circle
				x[z] = 300 +  (20*i+10) * Math.cos(theta +  -j *( 2 * Math.asin(10.0 / (20*i+10)))); 
				y[z] = 300 +  (20*i+10) * Math.sin(theta +  -j *( 2 * Math.asin(10.0 / (20*i+10))));
				z++; // keeps track of place in array up until index 119 for the total # of of circles (120)
			}
		}
	}
	public void translate(int dx, int dy){ 
		z=0;
		theta = theta + Math.PI/200;
		for (int i=0; i<= n-1; i= i+2){ 
			int k = i + 1;
			for(int j = 0; j<k;j++) {
				x[z] = 300 +  (20*i+10) * Math.cos( ((k+3)*theta) -  j *( 2 * Math.asin(10.0 / (20*i+10))));
				y[z] = 300 +  (20*i+10) * Math.sin( ((k+3)*theta) -  j *( 2 * Math.asin(10.0 / (20*i+10))));
				z++;
			}
		}
		for (int i=1; i<= n-1; i= i+2){   
			int k = i + 1;
			for(int j = 0; j<k;j++) { 
				x[z] = 300 +  (20*i+10) * Math.cos( ((k+3)*-theta) -  j *( 2 * Math.asin(10.0 / (20*i+10))));
				y[z] = 300 +  (20*i+10) * Math.sin( ((k+3)*-theta) -  j *( 2 * Math.asin(10.0 / (20*i+10))));
				z++;
			}
		}
	}
	public void draw(Graphics2D g2) 
	{
		Rectangle2D.Double rec = new Rectangle2D.Double(0, 0,600,600);
		g2.setColor(Color.pink);
		g2.fill(rec);
		for(int i= 0; i<=n-1; i++){  // this loop assigns one random color to each circle in a track.
			Ellipse2D.Double circle = new Ellipse2D.Double(20*i, 20*i,width-(40*i),width-(40*i));
			g2.setColor(cc[i]);
			g2.fill(circle);
		}
		Random gen = new Random();
		int d = 0;
		for (int j=0; j<= n-1; j = j+2){ 
			int k = j + 1;
			Color c = new Color(Math.abs(gen.nextInt()) % 255, Math.abs(gen.nextInt()) % 255, Math.abs(gen.nextInt()) % 255);
			g2.setColor(c);
			for (int i=0; i<k; i++){
				Ellipse2D.Double ball = new Ellipse2D.Double(x[d]-10, y[d]-10, 20, 20);
				g2.fill(ball);
				g2.draw(ball);
				d++;
			}
		}
		for (int j=1; j<= n-1; j = j+2){ 
			int k = j + 1;
			Color c = new Color(Math.abs(gen.nextInt()) % 255, Math.abs(gen.nextInt()) % 255, Math.abs(gen.nextInt()) % 255);
			g2.setColor(c);
			for (int i=0; i<k; i++){
				Ellipse2D.Double ball = new Ellipse2D.Double(x[d]-10, y[d]-10, 20, 20);
				g2.fill(ball);
				g2.draw(ball);
				d++;
			}
		}
	}
}