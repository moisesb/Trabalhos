import java.awt.event.MouseAdapter;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JComponent;


public class CheckBox extends JComponent implements FormElement{
		
	private static final long serialVersionUID = 1L;
	private int elementFocus;
	private int numberOfOptions;
	private Label label;
	private JCheckBox option[];
	private ButtonGroup buttonGroup;
	

	public CheckBox() {
		super();
		
		label = new Label("Check Box");
		option = new JCheckBox[3];
		option[0] = new JCheckBox("opção 1");
		option[1] = new JCheckBox("opção 2");
		option[2] = new JCheckBox("opção 3");
		option[0].setBounds(0, 0, 97, 23);
		
		
		buttonGroup = new ButtonGroup();
		buttonGroup.add(option[0]);
		buttonGroup.add(option[1]);
		buttonGroup.add(option[2]);
		
		elementFocus = 1;
		numberOfOptions = 3;
		
		
		
	}
	

	@Override
	public void moveButton(int x, int y) {
		
		
	}

	@Override
	public void draw(FormPanel fp) {
		
		
	}

	@Override
	public void removeFrom(FormPanel fp) {
		
		
	}

	@Override
	public void setMouseListener(MouseAdapter m) {
		
		
	}

	@Override
	public void setDefaultMouseListener() {
		
		
	}

}
