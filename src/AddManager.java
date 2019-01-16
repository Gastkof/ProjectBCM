import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class AddManager extends JFrame {

	private JPanel contentPane;
	private JTextField txtId;
	private JTextField txtName;
	public static Manager manager;
	//public static ArrayList<Manager>managers=new ArrayList<Manager>();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		//managers= (ArrayList<Manager>) Arrays.asList(BCM.managers);
		
		BCM.deserialize("schedule.ser");
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddManager frame = new AddManager();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AddManager() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(30, 60, 171, 33);
		contentPane.add(lblId);
		
		txtId = new JTextField();
		txtId.setBounds(165, 63, 199, 30);
		contentPane.add(txtId);
		txtId.setColumns(10);
		
		JLabel lblName = new JLabel("name");
		lblName.setBounds(30, 120, 135, 20);
		contentPane.add(lblName);
		
		txtName = new JTextField();
		txtName.setColumns(10);
		txtName.setBounds(165, 117, 199, 30);
		contentPane.add(txtName);
		
		JButton btnAddManger = new JButton("ADD Manger");
		btnAddManger.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				manager = new Manager(Integer.parseInt(txtId.getText()), txtName.getText());
				if(!MyAPP.managers.contains(manager)) {
					MyAPP.managers.add(manager);
					JOptionPane.showMessageDialog(btnAddManger, "Add a new Manager ");
				}
				
				else {
					JOptionPane.showMessageDialog(btnAddManger, "try again ");
				}

				
			}
		});
		btnAddManger.setBounds(141, 173, 140, 33);
		contentPane.add(btnAddManger);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 378, 31);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("menu");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmAdminPage = new JMenuItem("Admin page");
		mntmAdminPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AdminPage adminPage = new AdminPage();
				adminPage.setVisible(true);
				dispose();
			}
		});
		mnNewMenu.add(mntmAdminPage);
	}
}
