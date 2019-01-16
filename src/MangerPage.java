import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class MangerPage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MangerPage frame = new MangerPage();
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
	public MangerPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnSchedule = new JButton("Schedule");
		btnSchedule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				SchedulePage scPage= new SchedulePage();
				scPage.setVisible(true);
				JOptionPane.showMessageDialog(rootPane, "You are being transfered to the Schedule");
				dispose();
			
				
			}
		});
		btnSchedule.setBounds(15, 33, 154, 48);
		contentPane.add(btnSchedule);
		
		JButton btnProgramsChange = new JButton("Program Editor");
		btnProgramsChange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ProgramChange programChange;
				try {
					programChange = new ProgramChange();
					programChange.setVisible(true);
					//JOptionPane.showMessageDialog(rootPane, "you sign as Manager ");
					dispose();
				} catch (ProgramException | UnavailableSpotException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	

				
			}
		});
		btnProgramsChange.setBounds(218, 33, 175, 48);
		contentPane.add(btnProgramsChange);
		
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
