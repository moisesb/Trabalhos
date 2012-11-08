import java.awt.Color;
import java.awt.Point;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.border.EmptyBorder;


public class FramePrincipal extends JFrame implements MouseListener, MouseMotionListener, KeyListener{

	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JMenuBar menuBar;
	private FormPanel formPanel;	
	private JMenu mnArquivo;
	private JMenuItem mntmNovo;
	private JMenuItem mntmAbrir;	
	private int state = 0;
	private int option = 0;		
	private JSplitPane splitPane;	
	private FormElement elementPreview;
	private boolean mouseEntered;
	private JPanel panel;
	private JButton buttonLegend;
	private JButton buttonRadioButtons;
	private JButton buttonCheckBox;
	private JButton buttonPasswordBox;
	private JButton buttonTextBox;
	private JButton buttonStateButton;
	
	
	

	public FramePrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 523);		
		state =0;
		option = 0;
				
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnArquivo = new JMenu("Arquivo");
		menuBar.add(mnArquivo);
		
		mntmNovo = new JMenuItem("Novo");
		mnArquivo.add(mntmNovo);
		
		mntmAbrir = new JMenuItem("Abrir");
		mnArquivo.add(mntmAbrir);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.LIGHT_GRAY);
		desktopPane.setBounds(0, -20, 704, 484);
		contentPane.add(desktopPane);
		
		splitPane = new JSplitPane();
		splitPane.setBounds(0, 21, 704, 463);
		splitPane.setDividerLocation(160);
		desktopPane.add(splitPane);
		
		formPanel = new FormPanel();	
		formPanel.setBackground(SystemColor.control);
		splitPane.setRightComponent(formPanel);		
		formPanel.setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(SystemColor.control);
		splitPane.setLeftComponent(panel);
		panel.setLayout(null);
		
		buttonStateButton = new JButton("State Button");
		buttonStateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearPreview();
				selectComponent(e);
				
			}
		});
		buttonStateButton.setBounds(10, 33, 125, 23);
		panel.add(buttonStateButton);
		
		buttonTextBox = new JButton("Text Box");
		buttonTextBox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {				
				clearPreview();
				selectComponent(e);
			}
		});
		buttonTextBox.setBounds(10, 67, 125, 23);
		panel.add(buttonTextBox);
		
		buttonPasswordBox = new JButton("Password Box");
		buttonPasswordBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearPreview();
				selectComponent(e);
			}
		});
		buttonPasswordBox.setBounds(10, 101, 125, 23);
		panel.add(buttonPasswordBox);
		
		buttonCheckBox = new JButton("Check Box");
		buttonCheckBox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {				
				clearPreview();
				selectComponent(e);
			}
		});
		buttonCheckBox.setBounds(10, 135, 125, 23);
		panel.add(buttonCheckBox);
		
		buttonRadioButtons = new JButton("Radio Button");
		buttonRadioButtons.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {				
				clearPreview();
				selectComponent(e);				
			}
		});
		buttonRadioButtons.setBounds(10, 169, 125, 23);
		panel.add(buttonRadioButtons);
		
		buttonLegend = new JButton("Legend");
		buttonLegend.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {				
				clearPreview();
				selectComponent(e);
			}
		});
		buttonLegend.setBounds(10, 203, 125, 23);
		panel.add(buttonLegend);
		
		formPanel.addMouseListener(this);
		formPanel.addMouseMotionListener(this);
		
	}


	@Override
	public void mouseClicked(MouseEvent e) {		
		
	}


	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		requestFocus();
		if (state ==  0) {			
			
		}else {
					
			insertComponent();
		}
		formPanel.repaint();
		splitPane.repaint();
				
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
						
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub		
		if ((elementPreview != null) && (dentroDaTela(e.getPoint())) && (!mouseEntered)) {
			elementPreview.draw(formPanel);
			mouseEntered = true;
		}
				
	}


	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		if ((elementPreview != null) && (!dentroDaTela(e.getPoint())) && (mouseEntered)) {
			elementPreview.removeFrom(formPanel);			
			formPanel.repaint();
			splitPane.repaint();
			mouseEntered = false;
		}		
	}


	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
		if (elementPreview != null)  {		
			elementPreview.moveButton(e.getX(), e.getY());			
		}
				
		
	}
	
	// Métodos
	
	public boolean dentroDaTela(Point p) {			
		if ((p.x >= 0) && (p.y <= formPanel.getWidth()))
			if ((p.y >= 0) && (p.y <= formPanel.getHeight()))
				return true;
		return false;
	}
	
			
	
	
	public void insertComponent() {
		if (state == 1) {
			ResizableBorder border = new ResizableBorder(8);			
			elementPreview.draw(formPanel);
			
			if (option == 2) {				
				
				StateButton button = (StateButton)elementPreview;				
				button.setBorder(border);
				button.setDefaultMouseListener();
				button.addKeyListener(this);				
			}
			
			if (option == 3) {
				
				TextBox textBox = (TextBox)elementPreview;				
				textBox.setEnabled(true);
				textBox.setBorder(border);
				textBox.setDefaultMouseListener();
				textBox.addKeyListener(this);
			}
			
			if (option == 4) {				
				PasswordBox passwordBox = (PasswordBox)elementPreview;				
				passwordBox.setEnabled(true);
				passwordBox.setBorder(border);
				passwordBox.setDefaultMouseListener();
				passwordBox.addKeyListener(this);
			}
			state = 0;
			option = 0;
			elementPreview = null;
		}
	}
	
	public void clearPreview() {
		if (elementPreview != null) {
			elementPreview.removeFrom(formPanel);
			formPanel.repaint();
			splitPane.repaint();
			elementPreview = null;
		}
	}
		
	public void selectComponent(ActionEvent e) {
		
		Object obj = e.getSource();
		if (obj ==  buttonStateButton) {
			option = 2;
			state=1;	
			elementPreview = new StateButton();	
		}
		
		if (obj == buttonTextBox) {
			option = 3;
			state=1;
			elementPreview = new TextBox();
		}
			
		if (obj == buttonPasswordBox) {
			option = 4;
			state=1;
			elementPreview = new PasswordBox();
		}
		
		
		if (obj != null) {
			mouseEntered = false;
		
			elementPreview.setMouseListener(new MouseAdapter() {
				
				public void mouseMoved(MouseEvent e) {
					// TODO Auto-generated method stub
					
					if (elementPreview != null)  {
						JComponent component = (JComponent)elementPreview;
						Point parentOnScreen = component.getParent().getLocationOnScreen();						
						elementPreview.moveButton(e.getXOnScreen() - parentOnScreen.x, e.getYOnScreen() - parentOnScreen.y);						
					}
							
					
				}
				
				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
					if (elementPreview != null) {						
						insertComponent();
					}
				}
								
				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					if (elementPreview != null) {
						elementPreview.removeFrom(formPanel);			
						formPanel.repaint();
						splitPane.repaint();
						mouseEntered = false;
					}	
				}
				
			});		
			
		}
	}


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub		
		
		if (e.getKeyCode() == 127){
			FormElement element = (FormElement) getFocusOwner();
			element.removeFrom(formPanel);
			element = null;
			formPanel.repaint();
			splitPane.repaint();	
			state = 0;
			option = 0;
			
		}
		
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
