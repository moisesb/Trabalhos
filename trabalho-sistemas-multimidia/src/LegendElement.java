import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;



public class LegendElement extends JComponent{
	
	private static final long serialVersionUID = 1L;
	private BufferedImage image;
	private String label;
	private String id;
	private int posX;
	private int posY;
	private Color fontColor;
	
	public LegendElement(String src, String label) throws IOException {
		id = src;
		if (src.equals("RED")) {
			image = ImageIO.read(new File("image/red.png"));
		}
		if (src.equals("BLUE")) {
			image = ImageIO.read(new File("image/blue.png"));
		}
		if (src.equals("YELLOW")) {
			image = ImageIO.read(new File("image/yellow.png"));
		}
		if (src.equals("GREEN")) {
			image = ImageIO.read(new File("image/green.png"));
		}
		if (src.equals("CURSOR_UP")) {
			image = ImageIO.read(new File("image/cursor_up.png"));
		}
		if (src.equals("CURSOR_DOWN")) {
			image = ImageIO.read(new File("image/cursor_down.png"));
		}
		if (src.equals("CURSOR_LEFT")) {
			image = ImageIO.read(new File("image/cursor_left.png"));
		}
		if (src.equals("CURSOR_RIGHT")) {
			image = ImageIO.read(new File("image/cursor_right.png"));
		}
		if (src.equals("ENTER")) {
			image = ImageIO.read(new File("image/ok.png"));
		}
		if (src.equals("MENU")) {
			image = ImageIO.read(new File("image/menu.png"));
		}
		if (src.equals("INFO")) {
			image = ImageIO.read(new File("image/info.png"));
		}
		fontColor = Color.BLACK;
		posX = 0;
		posY = 0;		
		this.label = label;
		
	}
	
	@Override
	public void setLocation(int x, int y) {
		posX = x;
		posY = y;
		setLocation(new Point(x,y));		
	}
		
	
	@Override
	public void paintComponents(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponents(g);
		g.drawImage(image, posX, posY, null);
		g.drawString(label, posX, posY+30);
	}
	
}
