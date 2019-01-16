package org.eclipse.wb.swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.util.concurrent.ScheduledExecutorService;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class ProgramCost extends JFrame {

	private JPanel contentPane;
	private JTextField txtCost;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProgramCost frame = new ProgramCost();
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
	public ProgramCost() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 883, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEnterTheCost = new JLabel("enter the cost");
		lblEnterTheCost.setBounds(49, 27, 275, 44);
		contentPane.add(lblEnterTheCost);
		
		txtCost = new JTextField();
		txtCost.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		txtCost.setBounds(272, 27, 215, 44);
		contentPane.add(txtCost);
		txtCost.setColumns(10);
		
		JButton btnEnter = new JButton("Enter");
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
			}
		});
		btnEnter.setBounds(531, 27, 180, 44);
		contentPane.add(btnEnter);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(49, 104, 775, 390);
		contentPane.add(scrollPane);
		
		JList list = new JList();
		scrollPane.setViewportView(list);
	}
}
