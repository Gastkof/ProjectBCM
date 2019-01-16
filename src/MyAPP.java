import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Dialog.ModalExclusionType;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import java.awt.Font;

public class MyAPP {

	private JFrame frame;
	private JTextField userName;
	private JTextField password;
	public static List<Manager> managers=new ArrayList<Manager>();
	/**
	 * Launch the application.
	 * @throws ProgramException 
	 */
	public static void main(String[] args) throws ProgramException {
		//BCM.Menu(6); // read scech from ser file
		BCM.Menu(8);
		BCM.Menu(5);
		managers =  Arrays.asList(BCM.managers);
		BCM.program.setSerial(BCM.schedule.getLastIndex());
		System.out.println(managers);
		
		System.out.println(Program.getSerialId());


		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyAPP window = new MyAPP();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MyAPP() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setSize(442, 339);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.getContentPane().setLayout(null);
		
				JLabel lblUserName = new JLabel("Username:");
				lblUserName.setBounds(79, 62, 77, 20);
				frame.getContentPane().add(lblUserName);
				
						userName = new JTextField();
						userName.setBounds(170, 59, 103, 26);
						frame.getContentPane().add(userName);
						userName.setColumns(10);
		
				JLabel lblNewLabel = new JLabel("Password:");
				lblNewLabel.setBounds(81, 93, 73, 20);
				frame.getContentPane().add(lblNewLabel);
		
				password = new JTextField();
				password.setBounds(170, 90, 103, 26);
				password.setColumns(10);
						frame.getContentPane().add(password);
		
				JButton btnLogin = new JButton("Login");
				btnLogin.setBounds(144, 129, 71, 29);
				btnLogin.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						String name = userName.getText();
						String pass = password.getText();

						if(!(name.equals("")&& pass.equals("")) ){

							if(name.equals("ADMIN")&&pass.equals("ADMIN")) {

								AdminPage Admin = new AdminPage();
								Admin.setVisible(true);
								JOptionPane.showMessageDialog(frame, "You are signed in as Admin");
								frame.setVisible(false);

							}

							else if(!managers.isEmpty()) {
								for(Manager man :managers) {
									if(man.getManagerId()==Integer.parseInt(name)  && man.getManagerId()==Integer.parseInt(pass)  ) {
										frame.setVisible(false);
										MangerPage manager = new MangerPage();
										manager.setVisible(true);
										JOptionPane.showMessageDialog(frame, "Hello, " + man.getName() + ".\nYou are signed in as Manager");
									
									}


									else {
										continue;
									}
								}

							}
							else {
								JOptionPane.showMessageDialog(frame,  "try again");

							}




						}


					}
				});
				frame.getContentPane().add(btnLogin);
				
				JTextPane txtpnforAdminLogin = new JTextPane();
				txtpnforAdminLogin.setFont(new Font("David", Font.BOLD, 14));
				txtpnforAdminLogin.setEnabled(false);
				txtpnforAdminLogin.setEditable(false);
				txtpnforAdminLogin.setText("*for Admin login:\r\n\tUser name & Password: ADMIN");
				txtpnforAdminLogin.setBounds(20, 168, 397, 48);
				frame.getContentPane().add(txtpnforAdminLogin);
				
				JTextPane txtpnforManagerLogin = new JTextPane();
				txtpnforManagerLogin.setText("*for Manager login:\r\n\tUser name & Password: id");
				txtpnforManagerLogin.setFont(new Font("David", Font.BOLD, 14));
				txtpnforManagerLogin.setEnabled(false);
				txtpnforManagerLogin.setEditable(false);
				txtpnforManagerLogin.setBounds(20, 228, 397, 57);
				frame.getContentPane().add(txtpnforManagerLogin);
	}

	/**
	 * @return the frame
	 */
	public JFrame getFrame() {
		return frame;
	}

	/**
	 * @param frame the frame to set
	 */
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
}
