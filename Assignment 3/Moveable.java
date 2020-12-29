import java.awt.Graphics2D;

public interface Moveable {

	void draw(Graphics2D g2);

	void translate(int dx, int dy);
}
