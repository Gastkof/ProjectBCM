

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import java.awt.ComponentOrientation;
import javax.swing.ListSelectionModel;
import javax.swing.DropMode;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.time.DayOfWeek;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class SchedulePage extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			BCM.Menu(8);
		} catch (ProgramException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SchedulePage frame = new SchedulePage();
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
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public SchedulePage() {
		try {
			BCM.Menu(8);
		} catch (ProgramException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 943, 718);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel lblEnterTheDay = new JLabel("Pick specific day:");
		lblEnterTheDay.setBounds(141, 31, 127, 30);
		contentPane.add(lblEnterTheDay);


		JComboBox spinner = new JComboBox();
		spinner.setMaximumRowCount(7);

		spinner.setModel(new DefaultComboBoxModel(DaysOfTheWeek.values()));
		spinner.setSelectedIndex(0);
		spinner.setBounds(280, 32, 168, 30);
		contentPane.add(spinner);
		Vector row = new Vector<>();

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(15, 78, 830, 584);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

		JButton btnFullWeek = new JButton("Full Week");
		btnFullWeek.setBounds(493, 27, 117, 40);
		contentPane.add(btnFullWeek);

		DefaultTableModel model = new DefaultTableModel(
				new Object[][] {
					{null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null},
					{null, null, null, null, null, null, null},
				},
				new String[] {
						"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"
				}
				);

		for(int i =0; i<DaysOfTheWeek.values().length;i++) {
			int k=0;
			for (Program p : Schedule.getWeekly3()[i]) {
				model.setValueAt(p.getProName(), k++, i);
			}
		}

		table.setEnabled(false);
		table.setModel(model);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 378, 31);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("menu");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmLogout = new JMenuItem("logOut");
		mntmLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MyAPP myAPP = new MyAPP();
				myAPP.getFrame().setVisible(true);
				dispose();
			}
		});
		mnNewMenu.add(mntmLogout);

		spinner.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int i =0;
				DefaultTableModel tmodel =  new DefaultTableModel(
						new Object[][] {
							{null, null, null, null, null, null, null},
							{null, null, null, null, null, null, null},
							{null, null, null, null, null, null, null},
							{null, null, null, null, null, null, null},
							{null, null, null, null, null, null, null},
							{null, null, null, null, null, null, null},
							{null, null, null, null, null, null, null},
							{null, null, null, null, null, null, null},
							{null, null, null, null, null, null, null},
							{null, null, null, null, null, null, null},
							{null, null, null, null, null, null, null},
							{null, null, null, null, null, null, null},
							{null, null, null, null, null, null, null},
							{null, null, null, null, null, null, null},
							{null, null, null, null, null, null, null},
							{null, null, null, null, null, null, null},
							{null, null, null, null, null, null, null},
							{null, null, null, null, null, null, null},
						},
						new String[] {
								"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"
						}
						);
				
				for (Program program : BCM.schedule.getWeekly3()[spinner.getSelectedIndex()]) {
					System.out.println(program);
					tmodel.setValueAt(program.getProName(),i++, spinner.getSelectedIndex());
				}
				table.setModel(tmodel);

			}
		});
		
		btnFullWeek.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				table.setModel(model);	
			}
		});




	}
}
