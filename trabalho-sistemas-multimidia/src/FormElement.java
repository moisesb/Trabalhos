import java.awt.event.MouseAdapter;


public interface FormElement {	
	public void moveButton (int x, int y);
	public void draw(FormPanel fp);
	public void removeFrom(FormPanel fp);
	public void setMouseListener(MouseAdapter m);
	public void setDefaultMouseListener();
}
