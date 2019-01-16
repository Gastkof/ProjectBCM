import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenu;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuBar;

public class AdminPage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminPage frame = new AdminPage();
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
	public AdminPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAddManager = new JButton("Add Manager");
		btnAddManager.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AddManager addman= new AddManager();
				addman.setVisible(true);
				dispose();
			}
		});
		btnAddManager.setBounds(64, 45, 142, 38);
		contentPane.add(btnAddManager);
		
		JButton btnShowSchedule = new JButton("Show Schedule");
		btnShowSchedule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(rootPane, "You are being transfered to the Schedule");
				dispose();
				SchedulePage schedulePage = new SchedulePage();
				schedulePage.setVisible(true);
			}
		});
		btnShowSchedule.setBounds(221, 45, 168, 38);
		contentPane.add(btnShowSchedule);
		
		JButton btnShowProgramCost = new JButton("Show Program Cost");
		btnShowProgramCost.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ProgramCostFrame pCost = new ProgramCostFrame();
				pCost.setVisible(true);
				dispose();
			}
		});
		btnShowProgramCost.setBounds(127, 90, 193, 53);
		contentPane.add(btnShowProgramCost);
		
		JMenuBar menu = new JMenuBar();
		menu.setBounds(0, 0, 89, 29);
		contentPane.add(menu);
		
		JMenuItem mntmLogout = new JMenuItem("logout");
		mntmLogout.setBounds(0, 0, 89, 29);
		mntmLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MyAPP my = new MyAPP();
				my.getFrame().setVisible(true);
				dispose();
			}
		});
		
	     menu.add(mntmLogout);
	}

}
