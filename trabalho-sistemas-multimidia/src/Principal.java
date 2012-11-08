import java.util.LinkedList;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


public class Principal {

	public static LinkedList<Object> componentList = new LinkedList<Object>();	
	
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		// TODO Auto-generated method stub
		
		UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		
		FramePrincipal framePrincipal = new FramePrincipal();
		framePrincipal.setVisible(true);
		
	}

}
