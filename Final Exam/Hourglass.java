import java.awt.*;
import java.util.*;
import java.awt.geom.*;
import javax.swing.*;

public class Hourglass implements Moveable {
	private int xx;
	private int yy;
	private int width;
	private int t = 0;

	public Hourglass(int x0, int y0, int w) {
		xx = x0;
		yy = y0;
		width = w;
	}

	public void translate(int dx, int dy) {
		t++;
		if (t == 200) {
			t = 0;
		}
	}

	public void draw(Graphics2D g2) {

		Rectangle2D.Double rec = new Rectangle2D.Double(0, 0, 400, 400);
		g2.setColor(Color.black);
		g2.fill(rec);

		g2.setStroke(new BasicStroke(8));
		g2.setColor(Color.green);
		Shape line = new Line2D.Double(0.0, 400, 400.0, 0.0);
		g2.fill(line);
		g2.draw(line);

		g2.setStroke(new BasicStroke(8));
		Shape line2 = new Line2D.Double(0.0, 0.0, 400.0, 400.0);
		g2.fill(line2);
		g2.draw(line2);

		GeneralPath path = new GeneralPath(GeneralPath.WIND_EVEN_ODD);
		g2.setColor(Color.yellow);
		g2.setStroke(new BasicStroke(1));
		
		path.moveTo(200, 200);
		path.lineTo(t,t);
		path.lineTo(400-t,t);
		path.lineTo(200,200);
	//	g2.draw(path);
	//	g2.fill(path);
		
		path.moveTo(0, 400);
		path.lineTo(t,400-t);
		path.lineTo(400-t,400-t);
		path.lineTo(400,400);
		path.lineTo(0,400);
		g2.draw(path);
		g2.fill(path);

		for (int i = 0; i < 20; i++) {
			Rectangle2D.Double sand = new Rectangle2D.Double(199, Math.random() * (405 - 200) + 193, 2, 2);
			g2.fill(sand);
		}

	}

}