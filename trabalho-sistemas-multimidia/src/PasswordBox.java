
public class PasswordBox extends TextBox{

	private static final long serialVersionUID = 1L;
	
	public PasswordBox () {
		super();
		setText("*****");
		Label label = getLabel();
		label.setText("Password Box");
		label.setBounds(0,0,99,20);
	}

}
