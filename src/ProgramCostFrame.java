

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class ProgramCostFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextArea costFR;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProgramCostFrame frame = new ProgramCostFrame();
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
	public ProgramCostFrame() {
		
		try {
			BCM.Menu(8);
		} catch (ProgramException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1005, 706);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(5, 5, 925, 538);
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.add(panel);
		
		JLabel label = new JLabel("enter the cost");
		label.setBounds(49, 27, 275, 44);
		panel.add(label);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(272, 27, 215, 44);
		panel.add(textField);
		
		JButton button = new JButton("Enter");
	
		button.setBounds(531, 27, 180, 44);
		panel.add(button);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(61, 120, 757, 334);
		panel.add(scrollPane);
		
		costFR = new JTextArea();
		scrollPane.setViewportView(costFR);
		costFR.setEditable(false);
		costFR.setColumns(10);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				costFR.setText(Schedule.costShow(Integer.valueOf(textField.getText())));
				
			}
		});
	}
}
