import javax.swing.Icon;
import java.util.*;
import java.awt.*;
import java.awt.geom.Line2D;

public class ShapeIcon implements Icon {

	private int width;
	private int height;
	private Moveable shape;
	
	public ShapeIcon(Moveable s, int x, int y) {
		shape = s;
		width = x;
		height = y;
	}

	public int getIconWidth() {
		return width;
	}

	public int getIconHeight() {
		return height;
	}
	public void paintIcon(Component c, Graphics g, int x, int y) {
		Graphics2D g2 = (Graphics2D) g;
		shape.draw(g2);
	}

}

