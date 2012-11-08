import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTextField;
import javax.swing.event.MouseInputAdapter;
import javax.swing.event.MouseInputListener;


public class TextBox extends JTextField implements FormElement{
	
	private static final long serialVersionUID = 1L;
	private int elementFocus;	
	private Label label;
	private int dX;
	private int dY;
	private int maxStringLength;
	
	public TextBox() {	
		setLayout(new BorderLayout());
		label = new Label("Text Box");
		label.setBounds(0,0,75,20);
		dX = 0;
		dY = 0;
		maxStringLength = 100;
		elementFocus = 0;
		setBounds(104, 220, 85, 20);
		setEnabled(false);
	}
	
	public Label getLabel() {
		return label;
	}
	
	public int getDX() {		
		return getX() - (label.getX() + label.getWidth()); 
	}
	
	public int getDY() {
		return getY() - label.getY();
	}

	@Override
	public void moveButton(int x, int y) {
		label.setLocation(x - dX - label.getWidth() - getWidth()/2, y - dY - getHeight()/2);
		setLocation(x - getWidth()/2 , y - getHeight()/2);
		
	}

	@Override
	public void draw(FormPanel fp) {
		fp.add(this);
		fp.add(label);
	}

	@Override
	public void removeFrom(FormPanel fp) {
		fp.remove(this);	
		fp.remove(label);
	}
	
	@Override
	public void setMouseListener(MouseAdapter m) {
		addMouseListener(m);	
		addMouseMotionListener(m);		
	}
	
	private void resize() {
	      if (getParent() != null) {
	        getParent().revalidate();
	      }
	  }
	
	@Override
	public void setDefaultMouseListener() {
		
		MouseInputListener resizeListener = new MouseInputAdapter() {
						
		    public void mouseMoved(MouseEvent me) {
		      if (hasFocus()) {
		          ResizableBorder border = (ResizableBorder)getBorder();
		          setCursor(Cursor.getPredefinedCursor(border.getCursor(me)));
		      }
		    }

		    public void mouseExited(MouseEvent mouseEvent) {
		       setCursor(Cursor.getDefaultCursor());
		       
		    }

		    private int cursor;
		    private Point startPos = null;

		    public void mousePressed(MouseEvent me) {
		      ResizableBorder border = (ResizableBorder)getBorder();
		      cursor = border.getCursor(me);
		      startPos = me.getPoint();
		      requestFocus();
		      getParent().repaint();
		      getParent().getParent().repaint();
		      repaint();
		    }		    
		    

		    public void mouseDragged(MouseEvent me) {

		      if (startPos != null) {

		        int x = getX();
		        int y = getY();
		        int w = getWidth();
		        int h = getHeight();

		        int dx = me.getX() - startPos.x;
		        int dy = me.getY() - startPos.y;
		 
		        switch (cursor) {
		          case Cursor.N_RESIZE_CURSOR:
		            if (!(h - dy < 20)) {		            	
		              setBounds(x, y + dy, w, h - dy);
		              resize();
		            }
		            break;

		          case Cursor.S_RESIZE_CURSOR:
		            if (!(h + dy < 20)) {
		              setBounds(x, y, w, h + dy);
		              startPos = me.getPoint();
		              resize();
		            }
		            break;

		          case Cursor.W_RESIZE_CURSOR:
		            if (!(w - dx < 20)) {
		              setBounds(x + dx, y, w - dx, h);
		              resize();
		            }
		            break;

		          case Cursor.E_RESIZE_CURSOR:
		            if (!(w + dx < 20)) {
		              setBounds(x, y, w + dx, h);
		              startPos = me.getPoint();
		              resize();
		            }
		            break;

		          case Cursor.NW_RESIZE_CURSOR:
		            if (!(w - dx < 20) && !(h - dy < 20)) {
		              setBounds(x + dx, y + dy, w - dx, h - dy);
		              resize();
		            }
		            break;

		          case Cursor.NE_RESIZE_CURSOR:
		            if (!(w + dx < 20) && !(h - dy < 20)) {
		              setBounds(x, y + dy, w + dx, h - dy);
		              startPos = new Point(me.getX(), startPos.y);
		              resize();
		            }
		            break;

		          case Cursor.SW_RESIZE_CURSOR:
		            if (!(w - dx < 20) && !(h + dy < 20)) {
		              setBounds(x + dx, y, w - dx, h + dy);
		              startPos = new Point(startPos.x, me.getY());
		              resize();
		            }
		            break;

		          case Cursor.SE_RESIZE_CURSOR:
		            if (!(w + dx < 20) && !(h + dy < 20)) {
		              setBounds(x, y, w + dx, h + dy);
		              startPos = me.getPoint();
		              resize();
		            }
		          break;

		          case Cursor.MOVE_CURSOR:
		            Rectangle bounds = getBounds();
		            bounds.translate(dx, dy);
		            setBounds(bounds);
		            resize();
		          }


		          setCursor(Cursor.getPredefinedCursor(cursor));
		        }
		     }

		   public void mouseReleased(MouseEvent mouseEvent) {
		     startPos = null;
		    }
		  };
		  		  
	    
		  addMouseListener(resizeListener);
		  addMouseMotionListener(resizeListener);
		  label.setDefaultMouseListener();
		
	}

}
