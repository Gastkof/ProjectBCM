import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ListModel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.border.CompoundBorder;
import javax.swing.border.MatteBorder;
import javax.swing.text.Caret;

//import javafx.scene.control.ComboBox;

import java.awt.Color;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.event.CaretListener;
import javax.swing.event.CaretEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.InputMethodEvent;
import javax.swing.JFormattedTextField;
import javax.swing.JTabbedPane;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.JSpinner;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListDataListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JScrollPane;
import javax.swing.DropMode;
import javax.swing.JInternalFrame;
import javax.swing.SpinnerNumberModel;
import javax.swing.JButton;
import java.awt.Rectangle;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Component;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class ProgramChange extends JFrame {

	//static array
	private ArrayList<String> actor;

	private JPanel contentPane;
	private JTextField Name;
	private JTextField programTime;
	private JTextField startHour;
	private JTextField endhour;
	private JFrame jframe;
	private JComboBox dayComboBox;
	private JComboBox programTypeCombo;
	private JComboBox programCombo;
	private JComboBox deleteProgramComboBox;
	private JComboBox deleteTypeComboBox;
	private JComboBox deleteDaysComboBox;
	private JFrame notificationFrame;
	private JTextField programTimeUpdate;
	private JTextField startHourUpdate;
	private JTextField endhourUpdate;
	private JButton btnSchedule, btnScheduleUpdate, btnScheduleDelete;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) throws ProgramException, UnavailableSpotException,IMDBExecption, AddException, GenerException,SubtitleExecption {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProgramChange frame = new ProgramChange();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws ProgramException 
	 */
	@SuppressWarnings("deprecation")
	public ProgramChange() throws ProgramException, UnavailableSpotException {
		//BCM.Menu(8);
		//		AddManager.managers =  Arrays.asList(BCM.managers);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 840, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane);
		DefaultListModel<Genres> lm = new DefaultListModel<>();
		//BCM.Menu(8);
		BCM.Menu(5);
		//		lm.addAll((List<Genres>)Arrays.asList(Genres.values()));
		for (Genres g : Genres.values())
			lm.addElement(g);

		JPanel AddProgram = new JPanel();
		tabbedPane.addTab("Add Program", null, AddProgram, null);
		AddProgram.setLayout(null);

		btnSchedule = new JButton("Schedule");
		ActionListener scechduleListner = new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				SchedulePage scPage= new SchedulePage();
				scPage.setVisible(true);
				JOptionPane.showMessageDialog(rootPane, "You are being transfered to the Schedule");


			}
		};
		
		btnSchedule.addActionListener(scechduleListner);
		btnScheduleUpdate = new JButton("Schedule");
		btnScheduleUpdate.addActionListener(scechduleListner);
		btnScheduleDelete = new JButton("Schedule");
		btnScheduleDelete.addActionListener(scechduleListner);
		btnSchedule.setBounds(327, 535, 154, 48);
		btnScheduleUpdate.setBounds(342, 548, 154, 48);
		btnScheduleDelete.setBounds(262, 235, 154, 48);

		//contentPane.add(btnSchedule);

		JComboBox comboBox = new JComboBox();

		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Movie", "News", "Series", "TvShow"}));
		comboBox.setBounds(175, 56, 182, 26);
		AddProgram.add(comboBox);

		JLabel label = new JLabel("Program Type");
		label.setBounds(15, 51, 172, 31);
		AddProgram.add(label);

		JLabel ProgramName = new JLabel("Program Name");
		ProgramName.setBounds(15, 114, 172, 31);
		AddProgram.add(ProgramName);

		Name = new JTextField();
		Name.setBounds(175, 116, 188, 29);
		AddProgram.add(Name);
		Name.setColumns(10);

		JLabel programGeners = new JLabel("program Geners");
		programGeners.setBounds(15, 161, 153, 26);
		AddProgram.add(programGeners);


		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(175, 161, 182, 66);

		AddProgram.add(scrollPane);
		JList<Genres> list = new JList();
		//list.setDropMode(DropMode.ON);
		list.setModel(lm);
		//list.setVisibleRowCount(4);
		scrollPane.setViewportView(list);

		JLabel lblProgramTime = new JLabel("Program time");
		lblProgramTime.setBounds(15, 246, 129, 26);
		AddProgram.add(lblProgramTime);

		programTime = new JTextField();
		programTime.setBounds(175, 246, 181, 26);
		AddProgram.add(programTime);
		programTime.setColumns(10);

		JLabel lblStartHour = new JLabel("start hour");
		lblStartHour.setBounds(15, 288, 129, 26);
		AddProgram.add(lblStartHour);

		startHour = new JTextField();
		startHour.setBounds(175, 288, 182, 31);
		AddProgram.add(startHour);
		startHour.setColumns(10);

		endhour = new JTextField();
		endhour.setColumns(10);
		endhour.setBounds(175, 335, 182, 31);
		AddProgram.add(endhour);

		JLabel endHour = new JLabel("end hour");
		endHour.setBounds(15, 335, 129, 26);
		AddProgram.add(endHour);

		JLabel lblProgarmManager = new JLabel("Progarm Manager");
		lblProgarmManager.setBounds(15, 377, 153, 31);
		AddProgram.add(lblProgarmManager);

		JComboBox ManSelc = new JComboBox();
		ManSelc.setBounds(175, 382, 182, 26);
		//					ManSelc.setModel(new DefaultComboBoxModel(BCM.managers));
		ManSelc.setModel(new DefaultComboBoxModel(MyAPP.managers.toArray()));

		AddProgram.add(ManSelc);

		JPanel moviePanel = new JPanel();
		moviePanel.setBounds(424, 56, 342, 164);
		AddProgram.add(moviePanel);
		moviePanel.setLayout(null);

		JLabel lblProgramDay = new JLabel("Program day");
		lblProgramDay.setBounds(0, 0, 146, 31);
		moviePanel.add(lblProgramDay);

		JComboBox dayPick = new JComboBox();
		dayPick.setBounds(160, 2, 182, 26);
		moviePanel.add(dayPick);
		dayPick.setModel(new DefaultComboBoxModel(DaysOfTheWeek.values()));


		JSpinner IMDBSpin = new JSpinner();
		IMDBSpin.setBounds(160, 44, 182, 26);
		moviePanel.add(IMDBSpin);
		IMDBSpin.setModel(new SpinnerNumberModel(new Double(0), new Double(0), new Double(10.0), new Double(0.1)));

		JLabel lblImdb = new JLabel("IMDB");
		lblImdb.setBounds(0, 47, 153, 26);
		moviePanel.add(lblImdb);

		JTextField actors = new JTextField();
		actors.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (actors.getText().equals("*Sperate values by ','"))
					actors.setText("");
			}
		});

		actors.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				if (actors.getText().equals("*Sperate values by ','"))
					actors.setText("");

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});
		actors.setBounds(160, 83, 182, 39);
		actors.setText("*Sperate values by ','");
		moviePanel.add(actors);



		JLabel actorsLabel = new JLabel("Actors");
		actorsLabel.setBounds(0, 89, 144, 33);
		moviePanel.add(actorsLabel);

		JLabel lblSubtitel = new JLabel("Subtitel");
		lblSubtitel.setBounds(0, 138, 129, 26);
		moviePanel.add(lblSubtitel);

		JComboBox subtitleComo = new JComboBox();
		subtitleComo.setBounds(160, 138, 182, 26);
		moviePanel.add(subtitleComo);
		subtitleComo.setModel(new DefaultComboBoxModel(Languages.values()));

		JPanel NewsPanel = new JPanel();
		NewsPanel.setLayout(null);
		NewsPanel.setBounds(424, 56, 342, 164);
		AddProgram.add(NewsPanel);

		JTextField BroadcastertextArea = new JTextField();
		BroadcastertextArea.setBounds(145, 36, 182, 39);
		NewsPanel.add(BroadcastertextArea);

		JLabel lblBroadcaster = new JLabel("Broadcaster");
		lblBroadcaster.setBounds(15, 36, 144, 39);
		NewsPanel.add(lblBroadcaster);

		JPanel SeriesPanel = new JPanel();
		SeriesPanel.setLayout(null);
		SeriesPanel.setBounds(424, 56, 342, 164);
		AddProgram.add(SeriesPanel);

		JLabel label_1 = new JLabel("Program day");
		label_1.setBounds(0, 0, 146, 31);
		SeriesPanel.add(label_1);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(121, 10, 154, 130);
		SeriesPanel.add(scrollPane_1);

		JList dayList = new JList<>();
		DefaultListModel<DaysOfTheWeek> daysModel = new DefaultListModel<>();

		for (DaysOfTheWeek d : DaysOfTheWeek.values())
			daysModel.addElement(d);

		dayList.setModel(daysModel);
		scrollPane_1.setViewportView(dayList);

		JPanel TVPanel = new JPanel();
		TVPanel.setLayout(null);
		TVPanel.setBounds(424, 56, 342, 143);
		AddProgram.add(TVPanel);

		JLabel dayPicker = new JLabel("Program day:");
		dayPicker.setSize(100, 39);
		dayPicker.setLocation(15, 90);
		TVPanel.add(dayPicker);

		JComboBox<DaysOfTheWeek> comboDays = new JComboBox<>();
		comboDays.setSize(172, 49);
		comboDays.setLocation(155, 90);
		comboDays.setModel(new DefaultComboBoxModel<>(DaysOfTheWeek.values()));
		TVPanel.add(comboDays);

		JTextField HostText = new JTextField();
		HostText.setBounds(145, 5, 182, 26);
		TVPanel.add(HostText);

		JLabel lblHost = new JLabel("Host");
		lblHost.setBounds(15, 5, 144, 39);
		TVPanel.add(lblHost);

		JLabel lblGuest = new JLabel("Guest");
		lblGuest.setBounds(15, 50, 144, 39);
		TVPanel.add(lblGuest);

		JTextField GuestText = new JTextField();
		GuestText.setBounds(145, 50, 182, 26);
		TVPanel.add(GuestText);

		JButton btnAddProgram = new JButton("Add Program");

		NewsPanel.setVisible(false);
		SeriesPanel.setVisible(false);
		TVPanel.setVisible(false);


		btnAddProgram.setBounds(310, 440, 182, 41);
		AddProgram.add(btnAddProgram);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				switch ((String)comboBox.getSelectedItem()) {
				case "Movie":
					moviePanel.setVisible(true);
					NewsPanel.setVisible(false);
					SeriesPanel.setVisible(false);
					TVPanel.setVisible(false);

					break;
				case "News":
					moviePanel.setVisible(false);
					NewsPanel.setVisible(true);
					SeriesPanel.setVisible(false);
					TVPanel.setVisible(false);
					break;
				case "Series":
					moviePanel.setVisible(false);
					NewsPanel.setVisible(false);
					SeriesPanel.setVisible(true);
					TVPanel.setVisible(false);
					break;
				case "TvShow":
					moviePanel.setVisible(false);
					NewsPanel.setVisible(false);
					SeriesPanel.setVisible(false);
					TVPanel.setVisible(true);
					break;
				default:
					break;
				}

			}
		});

		btnAddProgram.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Genres[] gen = new Genres[list.getSelectedValues().length];
				for (int i=0; i<list.getSelectedValues().length; i++) {
					gen[i] = (Genres)list.getSelectedValues()[i];
				}	
				switch ((String)comboBox.getSelectedItem()) {

				case "Movie":
					ArrayList<String> actorsArrayList = new ArrayList<>();
					for (String actors : actors.getText().split(",")) {
						actorsArrayList.add(actors);
					}

					Languages[] lang = {(Languages)subtitleComo.getSelectedItem()};

					try {
						BCM.program=new Movie(Name.getText(),gen, Integer.parseInt(programTime.getText()), Double.parseDouble(startHour.getText()), Double.parseDouble(endhour.getText()), BCM.managers[(ManSelc.getSelectedIndex())], (double)IMDBSpin.getValue(),(DaysOfTheWeek)dayPick.getSelectedItem(), dayPick.getSelectedIndex(), actorsArrayList,lang );
						BCM.schedule.addProgram(BCM.program);
						BCM.Menu(7);
					} catch (NumberFormatException | ProgramException | UnavailableSpotException e3) {
						if (e3 instanceof UnavailableSpotException) {
							JOptionPane.showMessageDialog(jframe,"Spot is unavailable at " + e3.getMessage());
							Program.setSerial(Program.getSerialId()-1);
						}
					}
					break;
				case "News":
					try {
						BCM.program = new News(Name.getText(),gen, Integer.parseInt(programTime.getText()), Double.parseDouble(startHour.getText()), Double.parseDouble(endhour.getText()), BCM.managers[(ManSelc.getSelectedIndex())],null, 7, BroadcastertextArea.getText());
						BCM.schedule.addProgram(BCM.program);
						BCM.Menu(7);
					} catch (NumberFormatException | ProgramException e1) {
						Program.setSerial(Program.getSerialId()-1);
						e1.printStackTrace();
					} catch (UnavailableSpotException e1) {
						Program.setSerial(Program.getSerialId()-1);
						JOptionPane.showMessageDialog(jframe, e1.getMessage());
					}
					break;
				case "Series":
					List<DaysOfTheWeek> daysPicked = dayList.getSelectedValuesList();
					DaysOfTheWeek[] daysArray = new DaysOfTheWeek[daysPicked.size()];
					int i=0;
					for (DaysOfTheWeek day : daysPicked)
						daysArray[i++] = day;

					try {
						BCM.program = new Series(Name.getText(),gen, Integer.parseInt(programTime.getText()), Double.parseDouble(startHour.getText()), Double.parseDouble(endhour.getText()), BCM.managers[(ManSelc.getSelectedIndex())],null ,daysArray.length,daysArray);
						BCM.schedule.addProgram(BCM.program);
						BCM.Menu(7);
					} catch (NumberFormatException | ProgramException | UnavailableSpotException e2) {
						Program.setSerial(Program.getSerialId()-1);
						if (e2 instanceof UnavailableSpotException)
							JOptionPane.showMessageDialog(jframe,"Spot is unavailable at " + e2.getMessage());
					}

					break;
				case "TvShow":

					String[] guests = {GuestText.getText()};

					try {
						BCM.program = new 
								TvShow(Name.getText(),gen, Integer.parseInt(programTime.getText()), Double.parseDouble(startHour.getText()), Double.parseDouble(endhour.getText()), BCM.managers[(ManSelc.getSelectedIndex())],comboDays.getSelectedIndex(),(DaysOfTheWeek)comboDays.getSelectedItem(),guests,HostText.getText());
						BCM.schedule.addProgram(BCM.program);
						BCM.Menu(7);
					} catch (NumberFormatException | ProgramException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						Program.setSerial(Program.getSerialId()-1);
					} catch (UnavailableSpotException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						Program.setSerial(Program.getSerialId()-1);
					}
					break;
				default:
					break;
				}
			}
		});

		//TODO: UPDATE TAB

		JPanel UpdateProgram = new JPanel();

		tabbedPane.addTab("Update Program ", null, UpdateProgram, null);
		DefaultComboBoxModel<String> model = new DefaultComboBoxModel(new String[] {"1", "2", "3"});
		UpdateProgram.setLayout(null);

		JLabel lblNewLabel = new JLabel("Pick Day");
		lblNewLabel.setBounds(125, 6, 151, 27);
		UpdateProgram.add(lblNewLabel);

		JLabel lblPickProgramType = new JLabel("Pick Program Type");
		lblPickProgramType.setBounds(331, 6, 145, 27);
		UpdateProgram.add(lblPickProgramType);

		dayComboBox = new JComboBox();
		dayComboBox.setBounds(125, 28, 151, 27);
		DefaultComboBoxModel<DaysOfTheWeek> updateDays = new DefaultComboBoxModel<>(DaysOfTheWeek.values());

		JLabel lblPick = new JLabel("Pick");
		lblPick.setBounds(531, 6, 150, 27);
		UpdateProgram.add(lblPick);
		dayComboBox.setModel(updateDays);
		UpdateProgram.add(dayComboBox);

		programTypeCombo = new JComboBox();
		programTypeCombo.setBounds(331, 28, 145, 27);

		DefaultComboBoxModel<String> typeModel = new DefaultComboBoxModel<>(new String[] {"Movies", "News", "Series", "TV Show"});
		programTypeCombo.setModel(typeModel);
		UpdateProgram.add(programTypeCombo);

		programCombo = new JComboBox();
		programCombo.setBounds(531, 28, 150, 27);
		DefaultComboBoxModel<Program> programModel = null;
		UpdateProgram.add(programCombo);

		Movie[] movies = new Movie[BCM.schedule.getMovies(dayComboBox.getSelectedIndex()).size()];
		int i=0;
		for (Movie m : BCM.schedule.getMovies(dayComboBox.getSelectedIndex()))
			movies[i++] = m;
		System.out.println(Arrays.toString(movies));
		DefaultComboBoxModel<Movie> movieModel = new DefaultComboBoxModel<Movie>(movies);
		programCombo.setModel(movieModel);

		JButton updateBtn = new JButton("update");

		updateBtn.setBounds(303, 476, 220, 47);
		UpdateProgram.add(updateBtn);
		DefaultListModel<Genres> lm2 = new DefaultListModel<>();
		//BCM.Menu(6);
		BCM.Menu(5);
		//		lm.addAll((List<Genres>)Arrays.asList(Genres.values()));
		for (Genres g : Genres.values())
			lm2.addElement(g);


		JComboBox comboBoxUpdate = new JComboBox();
		comboBoxUpdate.setModel(new DefaultComboBoxModel(new String[] {"Movie", "News", "Series", "TvShow"}));
		comboBoxUpdate.setBounds(166, 93, 182, 26);
		comboBoxUpdate.setEditable(false);
		UpdateProgram.add(comboBoxUpdate);


		JLabel labelUpdate = new JLabel("Program Type");
		labelUpdate.setBounds(6, 88, 172, 31);
		UpdateProgram.add(labelUpdate);

		JLabel ProgramNameUpdate = new JLabel("Program Name");
		ProgramNameUpdate.setBounds(6, 151, 172, 31);
		UpdateProgram.add(ProgramNameUpdate);

		Name = new JTextField();
		Name.setBounds(166, 153, 188, 29);
		UpdateProgram.add(Name);
		Name.setColumns(10);

		JLabel programGenersUpdate = new JLabel("program Geners");
		programGenersUpdate.setBounds(6, 198, 153, 26);
		UpdateProgram.add(programGenersUpdate);

		JLabel lblProgramTimeUpdate = new JLabel("Program time");
		lblProgramTimeUpdate.setBounds(6, 283, 129, 26);
		UpdateProgram.add(lblProgramTimeUpdate);

		programTimeUpdate = new JTextField();
		programTimeUpdate.setBounds(166, 283, 181, 26);
		UpdateProgram.add(programTimeUpdate);
		programTimeUpdate.setColumns(10);


		JLabel lblStartHourUpdate = new JLabel("start hour");
		lblStartHourUpdate.setBounds(6, 325, 129, 26);
		UpdateProgram.add(lblStartHourUpdate);

		startHourUpdate = new JTextField();
		startHourUpdate.setBounds(166, 325, 182, 31);
		UpdateProgram.add(startHourUpdate);
		startHourUpdate.setColumns(10);

		endhourUpdate = new JTextField();
		endhourUpdate.setColumns(10);
		endhourUpdate.setBounds(166, 372, 182, 31);
		UpdateProgram.add(endhourUpdate);

		JLabel endHourUpdateLabel = new JLabel("end hour");
		endHourUpdateLabel.setBounds(6, 372, 129, 26);
		UpdateProgram.add(endHourUpdateLabel);

		JLabel lblProgarmManagerUpdate = new JLabel("Progarm Manager");
		lblProgarmManagerUpdate.setBounds(6, 414, 153, 31);
		UpdateProgram.add(lblProgarmManagerUpdate);

		JComboBox ManSelcUpdate = new JComboBox();
		ManSelcUpdate.setBounds(166, 419, 182, 26);
		//					ManSelc.setModel(new DefaultComboBoxModel(BCM.managers));
		ManSelcUpdate.setModel(new DefaultComboBoxModel(MyAPP.managers.toArray()));

		UpdateProgram.add(ManSelcUpdate);

		JPanel moviePanelUpdate = new JPanel();
		moviePanelUpdate.setBounds(424, 100, 342, 164);
		UpdateProgram.add(moviePanelUpdate);
		moviePanelUpdate.setLayout(null);

		JLabel lblProgramDayUpdate = new JLabel("Program day");
		lblProgramDayUpdate.setBounds(0, 0, 146, 31);
		moviePanelUpdate.add(lblProgramDayUpdate);

		JComboBox dayPickUpdate = new JComboBox();
		dayPickUpdate.setBounds(160, 2, 182, 26);
		moviePanelUpdate.add(dayPickUpdate);
		dayPickUpdate.setModel(new DefaultComboBoxModel(DaysOfTheWeek.values()));


		JSpinner IMDBSpinUpdate = new JSpinner();
		IMDBSpinUpdate.setBounds(160, 44, 182, 26);
		moviePanelUpdate.add(IMDBSpinUpdate);
		IMDBSpinUpdate.setModel(new SpinnerNumberModel(new Double(0), new Double(0), new Double(10.0), new Double(0.1)));

		JLabel lblImdbUpdate = new JLabel("IMDB");
		lblImdbUpdate.setBounds(0, 47, 153, 26);
		moviePanelUpdate.add(lblImdbUpdate);

		JTextField actorsUpdate = new JTextField();
		actorsUpdate.setBounds(160, 83, 182, 39);
		moviePanelUpdate.add(actorsUpdate);

		JLabel actorsLabelUpdate = new JLabel("Actors");
		actorsLabelUpdate.setBounds(0, 89, 144, 33);
		moviePanelUpdate.add(actorsLabelUpdate);

		JLabel lblSubtitelUpdate = new JLabel("Subtitel");
		lblSubtitelUpdate.setBounds(0, 138, 129, 26);
		moviePanelUpdate.add(lblSubtitelUpdate);

		JComboBox subtitleComoUpdate = new JComboBox();
		subtitleComoUpdate.setBounds(160, 138, 182, 26);
		moviePanelUpdate.add(subtitleComoUpdate);
		subtitleComoUpdate.setModel(new DefaultComboBoxModel(Languages.values()));

		JPanel NewsPanelUpdate = new JPanel();
		NewsPanelUpdate.setLayout(null);
		NewsPanelUpdate.setBounds(424, 100, 342, 164);
		UpdateProgram.add(NewsPanelUpdate);

		JTextField BroadcastertextAreaUpdate = new JTextField();
		BroadcastertextAreaUpdate.setBounds(145, 36, 182, 39);
		NewsPanelUpdate.add(BroadcastertextAreaUpdate);

		JLabel lblBroadcasterUpdate = new JLabel("Broadcaster");
		lblBroadcasterUpdate.setBounds(15, 36, 144, 39);
		NewsPanelUpdate.add(lblBroadcasterUpdate);

		JPanel SeriesPanelUpdate = new JPanel();
		SeriesPanelUpdate.setLayout(null);
		SeriesPanelUpdate.setBounds(424, 100, 342, 164);
		UpdateProgram.add(SeriesPanelUpdate);

		JLabel label_1Update = new JLabel("Program day");
		label_1Update.setBounds(0, 0, 146, 31);
		SeriesPanel.add(label_1Update);

		JScrollPane scrollPane_1Update = new JScrollPane();
		scrollPane_1Update.setBounds(121, 10, 154, 130);
		SeriesPanelUpdate.add(scrollPane_1Update);

		JList dayListUpdate = new JList<>();
		DefaultListModel<DaysOfTheWeek> daysModelUpdate = new DefaultListModel<>();

		for (DaysOfTheWeek d : DaysOfTheWeek.values())
			daysModelUpdate.addElement(d);

		dayListUpdate.setModel(daysModelUpdate);
		scrollPane_1Update.setViewportView(dayListUpdate);

		JPanel TVPanelUpdate = new JPanel();
		TVPanelUpdate.setLayout(null);
		TVPanelUpdate.setBounds(424, 100, 342, 143);
		UpdateProgram.add(TVPanelUpdate);

		JLabel dayPickerUpdate = new JLabel("Program day:");
		dayPickerUpdate.setSize(100, 39);
		dayPickerUpdate.setLocation(15, 90);
		TVPanelUpdate.add(dayPickerUpdate);

		JComboBox<DaysOfTheWeek> comboDaysUpdate = new JComboBox<>();
		comboDaysUpdate.setSize(172, 49);
		comboDaysUpdate.setLocation(155, 90);
		comboDaysUpdate.setModel(new DefaultComboBoxModel<>(DaysOfTheWeek.values()));
		TVPanelUpdate.add(comboDaysUpdate);

		JTextField HostTextUpdate = new JTextField();
		HostTextUpdate.setBounds(145, 5, 182, 26);
		TVPanelUpdate.add(HostTextUpdate);

		JLabel lblHostUpdate = new JLabel("Host");
		lblHostUpdate.setBounds(15, 5, 144, 39);
		TVPanelUpdate.add(lblHostUpdate);

		JLabel lblGuestUpdate = new JLabel("Guest");
		lblGuestUpdate.setBounds(15, 50, 144, 39);
		TVPanelUpdate.add(lblGuestUpdate);

		JTextField GuestTextUpdate = new JTextField();
		GuestTextUpdate.setBounds(145, 50, 182, 26);
		TVPanelUpdate.add(GuestTextUpdate);

		JScrollPane scrollPaneUpdate = new JScrollPane();
		scrollPaneUpdate.setBounds(174, 194, 174, 58);
		UpdateProgram.add(scrollPaneUpdate);
		JList listUpdate = new JList();
		scrollPaneUpdate.setViewportView(listUpdate);
		listUpdate.setDropMode(DropMode.ON);
		listUpdate.setModel(lm2);
		listUpdate.setVisibleRowCount(4);

		//	JButton btnAddProgram = new JButton("Add Program");

		NewsPanelUpdate.setVisible(false);
		SeriesPanelUpdate.setVisible(false);
		TVPanelUpdate.setVisible(false);


		//btnAddProgram.setBounds(310, 440, 182, 41);
		//UpdateProgram.add(btnAddProgram);
		programTypeCombo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				switch ((String)programTypeCombo.getSelectedItem()) {
				case "Movies":
					moviePanelUpdate.setVisible(true);
					NewsPanelUpdate.setVisible(false);
					SeriesPanelUpdate.setVisible(false);
					TVPanelUpdate.setVisible(false);

					break;
				case "News":
					moviePanelUpdate.setVisible(false);
					NewsPanelUpdate.setVisible(true);
					SeriesPanelUpdate.setVisible(false);
					TVPanelUpdate.setVisible(false);
					break;
				case "Series":
					moviePanelUpdate.setVisible(false);
					NewsPanelUpdate.setVisible(false);
					SeriesPanelUpdate.setVisible(true);
					TVPanelUpdate.setVisible(false);
					break;
				case "TV Show":
					moviePanelUpdate.setVisible(false);
					NewsPanelUpdate.setVisible(false);
					SeriesPanelUpdate.setVisible(false);
					TVPanelUpdate.setVisible(true);
					System.out.println("IN TV SHOW");
					break;
				default:
					break;
				}

			}
		});

		//		btnAddProgram.addActionListener(new ActionListener() {
		//			public void actionPerformed(ActionEvent e) {
		//				
		//				Genres[] gen = new Genres[list.getSelectedValues().length];
		//				for (int i=0; i<list.getSelectedValues().length; i++) {
		//					gen[i] = (Genres)list.getSelectedValues()[i];
		//				}	
		//				switch ((String)comboBox.getSelectedItem()) {
		//
		//				case "Movie":
		//					ArrayList<String> actor = new ArrayList<String>();
		//					actor.add(actors.getText());
		//					Languages[] lang = {(Languages)subtitleComo.getSelectedItem()};
		//
		//					try {
		//						BCM.program=new Movie(Name.getText(),gen, Integer.parseInt(programTime.getText()), Double.parseDouble(startHour.getText()), Double.parseDouble(endhour.getText()), BCM.managers[(ManSelc.getSelectedIndex())], (double)IMDBSpin.getValue(),(DaysOfTheWeek)dayPick.getSelectedItem(), dayPick.getSelectedIndex(), actor,lang );
		//						BCM.schedule.addProgram(BCM.program);
		//						BCM.Menu(7);
		//					} catch (NumberFormatException | ProgramException | UnavailableSpotException e3) {
		//						if (e3 instanceof UnavailableSpotException)
		//							JOptionPane.showMessageDialog(jframe,"Spot is unavailable at " + e3.getMessage());
		//					}
		//					break;
		//				case "News":
		//					try {
		//						BCM.program = new News(Name.getText(),gen, Integer.parseInt(programTime.getText()), Double.parseDouble(startHour.getText()), Double.parseDouble(endhour.getText()), BCM.managers[(ManSelc.getSelectedIndex())],null, 7, BroadcastertextArea.getText());
		//						BCM.schedule.addProgram(BCM.program);
		//						BCM.Menu(7);
		//					} catch (NumberFormatException | ProgramException e1) {
		//						// TODO Auto-generated catch block
		//						e1.printStackTrace();
		//					} catch (UnavailableSpotException e1) {
		//						// TODO Auto-generated catch block
		//						//e1.printStackTrace();
		//						JOptionPane.showMessageDialog(jframe, e1.getMessage());
		//					}
		//					break;
		//				case "Series":
		//					List<DaysOfTheWeek> daysPicked = dayList.getSelectedValuesList();
		//					DaysOfTheWeek[] daysArray = new DaysOfTheWeek[daysPicked.size()];
		//					int i=0;
		//					for (DaysOfTheWeek day : daysPicked)
		//						daysArray[i++] = day;
		//
		//					try {
		//						BCM.program = new Series(Name.getText(),gen, Integer.parseInt(programTime.getText()), Double.parseDouble(startHour.getText()), Double.parseDouble(endhour.getText()), BCM.managers[(ManSelc.getSelectedIndex())],null ,daysArray.length,daysArray);
		//						BCM.schedule.addProgram(BCM.program);
		//						BCM.Menu(7);
		//					} catch (NumberFormatException | ProgramException | UnavailableSpotException e2) {
		//						if (e2 instanceof UnavailableSpotException)
		//							JOptionPane.showMessageDialog(jframe,"Spot is unavailable at " + e2.getMessage());
		//					}
		//
		//					break;
		//				case "TvShow":
		//
		//					String[] guests = {GuestText.getText()};
		//
		//					try {
		//						BCM.program = new 
		//								TvShow(Name.getText(),gen, Integer.parseInt(programTime.getText()), Double.parseDouble(startHour.getText()), Double.parseDouble(endhour.getText()), BCM.managers[(ManSelc.getSelectedIndex())],7 ,DaysOfTheWeek.Friday,guests,HostText.getText());
		//						BCM.schedule.addProgram(BCM.program);
		//						BCM.Menu(7);
		//					} catch (NumberFormatException | ProgramException e1) {
		//						// TODO Auto-generated catch block
		//						e1.printStackTrace();
		//					} catch (UnavailableSpotException e1) {
		//						// TODO Auto-generated catch block
		//						e1.printStackTrace();
		//					}
		//					break;
		//				default:
		//					break;
		//				}
		//			}
		//		});

		//END UPDATE

		updateBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {



				if(BCM.schedule.removeProgram((Program)programCombo.getSelectedItem())) {

					JOptionPane.showMessageDialog(notificationFrame, "Program " + (Program)deleteProgramComboBox.getSelectedItem() + "Deleted Succesfully and move to reAdded it");

					//BCM.Menu(7);

					Genres[] gen = new Genres[listUpdate.getSelectedValues().length];
					for (int i=0; i<listUpdate.getSelectedValues().length; i++) {
						gen[i] = (Genres)listUpdate.getSelectedValues()[i];
					}	
					switch ((String)programTypeCombo.getSelectedItem()) {

					case "Movies":
						ArrayList<String> actorsArrayList = new ArrayList<>();
						for (String actors : actorsUpdate.getText().split(",")) {
							actorsArrayList.add(actors);
						}

						//actor.add(actors.getText());

						Languages[] lang = {(Languages)subtitleComoUpdate.getSelectedItem()};

						try {
							System.out.println("IN TRY MOVIE");
							BCM.program=new Movie(Name.getText(),gen, Integer.parseInt(programTimeUpdate.getText()), Double.parseDouble(startHourUpdate.getText()), Double.parseDouble(endhourUpdate.getText()), BCM.managers[(ManSelcUpdate.getSelectedIndex())], (double)IMDBSpinUpdate.getValue(),(DaysOfTheWeek)comboDaysUpdate.getSelectedItem(), comboDaysUpdate.getSelectedIndex(), actorsArrayList,lang );
							BCM.schedule.addProgram(BCM.program);
							BCM.Menu(7);
							System.out.println("SUCCESS CREATING " + BCM.program);
						} catch (NumberFormatException | ProgramException | UnavailableSpotException e3) {
							if (e3 instanceof UnavailableSpotException)
								JOptionPane.showMessageDialog(jframe,"Spot is unavailable at " + e3.getMessage());
						}
						break;
					case "News":
						try {
							BCM.program = new News(Name.getText(),gen, Integer.parseInt(programTimeUpdate.getText()), Double.parseDouble(startHourUpdate.getText()), Double.parseDouble(endhourUpdate.getText()), BCM.managers[(ManSelcUpdate.getSelectedIndex())],null, 7, BroadcastertextAreaUpdate.getText());
							BCM.schedule.addProgram(BCM.program);
							BCM.Menu(7);
						} catch (NumberFormatException | ProgramException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (UnavailableSpotException e1) {
							// TODO Auto-generated catch block
							//e1.printStackTrace();
							JOptionPane.showMessageDialog(jframe, e1.getMessage());
						}
						break;
					case "Series":
						List<DaysOfTheWeek> daysPicked = dayListUpdate.getSelectedValuesList();
						DaysOfTheWeek[] daysArray = new DaysOfTheWeek[daysPicked.size()];
						int i=0;
						for (DaysOfTheWeek day : daysPicked)
							daysArray[i++] = day;

						try {
							BCM.program = new Series(Name.getText(),gen, Integer.parseInt(programTimeUpdate.getText()), Double.parseDouble(startHourUpdate.getText()), Double.parseDouble(endhourUpdate.getText()), BCM.managers[(ManSelcUpdate.getSelectedIndex())],null ,daysArray.length,daysArray);
							BCM.schedule.addProgram(BCM.program);
							BCM.Menu(7);
						} catch (NumberFormatException | ProgramException | UnavailableSpotException e2) {
							if (e2 instanceof UnavailableSpotException)
								JOptionPane.showMessageDialog(jframe,"Spot is unavailable at " + e2.getMessage());
						}

						break;
					case "TV Show":

						String[] guests = {GuestText.getText()};

						try {
							BCM.program = new 
									TvShow(Name.getText(),gen, Integer.parseInt(programTimeUpdate.getText()), Double.parseDouble(startHourUpdate.getText()), Double.parseDouble(endhourUpdate.getText()), BCM.managers[(ManSelcUpdate.getSelectedIndex())],dayPickUpdate.getSelectedIndex(),(DaysOfTheWeek)dayPickUpdate.getSelectedItem(),guests,HostText.getText());
							BCM.schedule.addProgram(BCM.program);
							BCM.Menu(7);
						} catch (NumberFormatException | ProgramException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (UnavailableSpotException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						break;
					default:
						break;
					}

				} 

				else
					JOptionPane.showMessageDialog(notificationFrame, "There was a problem deleting the program");


			}


		});

		UpdateProgram.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent arg0) {
				updateBtn.setEnabled(true);

			}
		});

		programCombo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (programCombo.getSelectedItem() instanceof Movie) {
					System.out.println(((Movie)programCombo.getSelectedItem()));
					Name.setText(((Movie)programCombo.getSelectedItem()).getProName());
					startHourUpdate.setText(String.valueOf(((Movie)programCombo.getSelectedItem()).getStartHour()));
					endhourUpdate.setText(String.valueOf(((Movie)programCombo.getSelectedItem()).getEndHour()));
					programTimeUpdate.setText(String.valueOf(((Movie)programCombo.getSelectedItem()).getProTime()));
					String actorString = ((Movie)programCombo.getSelectedItem()).getStars().toString();
					actorString = actorString.substring(1, actorString.length()-1);
					actorsUpdate.setText(actorString);


				}
				else if (programCombo.getSelectedItem() instanceof News) {


					System.out.println(((News)programCombo.getSelectedItem()));
					Name.setText(((News)programCombo.getSelectedItem()).getProName());
					startHourUpdate.setText(String.valueOf(((News)programCombo.getSelectedItem()).getStartHour()));
					endhourUpdate.setText(String.valueOf(((News)programCombo.getSelectedItem()).getEndHour()));
					programTimeUpdate.setText(String.valueOf(((News)programCombo.getSelectedItem()).getProTime()));
					BroadcastertextAreaUpdate.setText(((News)programCombo.getSelectedItem()).getBroadCaster());
				}
				else if (programCombo.getSelectedItem() instanceof Series) {

					System.out.println(((Series)programCombo.getSelectedItem()));
					Name.setText(((Series)programCombo.getSelectedItem()).getProName());
					startHourUpdate.setText(String.valueOf(((Series)programCombo.getSelectedItem()).getStartHour()));
					endhourUpdate.setText(String.valueOf(((Series)programCombo.getSelectedItem()).getEndHour()));
					programTimeUpdate.setText(String.valueOf(((Series)programCombo.getSelectedItem()).getProTime()));


				}
				else if (programCombo.getSelectedItem() instanceof TvShow) {

					System.out.println(((TvShow)programCombo.getSelectedItem()));
					Name.setText(((TvShow)programCombo.getSelectedItem()).getProName());
					startHourUpdate.setText(String.valueOf(((TvShow)programCombo.getSelectedItem()).getStartHour()));
					endhourUpdate.setText(String.valueOf(((TvShow)programCombo.getSelectedItem()).getEndHour()));
					programTimeUpdate.setText(String.valueOf(((TvShow)programCombo.getSelectedItem()).getProTime()));
					HostTextUpdate.setText(((TvShow)programCombo.getSelectedItem()).getHost());
					GuestTextUpdate.setText(Arrays.toString(((TvShow)programCombo.getSelectedItem()).getGuest()));

				}
			}


		});

		//TODO: DELETE TAB

		JPanel DeleteProgram = new JPanel();
		tabbedPane.addTab("Delete Program", null, DeleteProgram, null);
		DeleteProgram.setLayout(null);

		JLabel label_2 = new JLabel("Pick Day");
		label_2.setBounds(56, 0, 54, 16);
		DeleteProgram.add(label_2);

		JLabel label_3 = new JLabel("Pick Program Type");
		label_3.setBounds(262, 0, 116, 16);
		DeleteProgram.add(label_3);

		JLabel label_4 = new JLabel("Pick");
		label_4.setBounds(462, 0, 26, 16);
		DeleteProgram.add(label_4);

		deleteDaysComboBox = new JComboBox();
		deleteDaysComboBox.setBounds(56, 21, 151, 27);
		DeleteProgram.add(deleteDaysComboBox);
		deleteDaysComboBox.setModel(updateDays);

		deleteTypeComboBox = new JComboBox();
		deleteTypeComboBox.setBounds(262, 21, 145, 27);
		deleteTypeComboBox.setModel(typeModel);
		DeleteProgram.add(deleteTypeComboBox);

		deleteProgramComboBox = new JComboBox();
		deleteProgramComboBox.setBounds(462, 21, 150, 27);
		DeleteProgram.add(deleteProgramComboBox);

		deleteProgramComboBox.setModel(movieModel);

		JButton deleteProgramButton = new JButton("Delete Program");
		deleteProgramButton.setBounds(264, 151, 140, 57);

		AddProgram.add(btnSchedule);
		UpdateProgram.add(btnScheduleUpdate);
		DeleteProgram.add(btnScheduleDelete);

		deleteProgramButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(BCM.schedule.removeProgram((Program)deleteProgramComboBox.getSelectedItem())) {
					JOptionPane.showMessageDialog(notificationFrame, "Program " + (Program)deleteProgramComboBox.getSelectedItem() + "Deleted Succesfully");
					try {
						BCM.Menu(7);
					} catch (ProgramException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				else
					JOptionPane.showMessageDialog(notificationFrame, "There was a problem deleting the program");
			}
		});
		DeleteProgram.add(deleteProgramButton);

		//TODO: LISTENERS

		deleteTypeComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				importantSwitchDELETE();
			}
		});

		deleteDaysComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = 0;
				switch ((DaysOfTheWeek)deleteDaysComboBox.getSelectedItem()) {
				case Sunday:
					importantSwitchDELETE();
					break;
				case Monday:
					importantSwitchDELETE();
					break;
				case Tuesday:
					importantSwitchDELETE();
					break;
				case Wednesday:
					importantSwitchDELETE();
					break;
				case Thursday:
					importantSwitchDELETE();
					break;
				case Friday:
					importantSwitchDELETE();
					break;
				case Saturday:
					importantSwitchDELETE();
					break;
				}
			}
		});


		programTypeCombo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				importantSwitchUPDATE();
			}
		});

		dayComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = 0;
				switch ((DaysOfTheWeek)dayComboBox.getSelectedItem()) {
				case Sunday:
					importantSwitchUPDATE();
					break;
				case Monday:
					importantSwitchUPDATE();
					break;
				case Tuesday:
					importantSwitchUPDATE();
					break;
				case Wednesday:
					importantSwitchUPDATE();
					break;
				case Thursday:
					importantSwitchUPDATE();
					break;
				case Friday:
					importantSwitchUPDATE();
					break;
				case Saturday:
					importantSwitchUPDATE();
					break;
				}
			}
		});
	}

	public void importantSwitchUPDATE() {
		int i = 0;
		switch ((String)programTypeCombo.getSelectedItem()) {
		case "Movies":
			Movie[] movies = new Movie[BCM.schedule.getMovies(dayComboBox.getSelectedIndex()).size()];
			i=0;
			for (Movie m : BCM.schedule.getMovies(dayComboBox.getSelectedIndex()))
				movies[i++] = m;
			System.out.println(Arrays.toString(movies));
			DefaultComboBoxModel<Movie> movieModel = new DefaultComboBoxModel<Movie>(movies);
			programCombo.setModel(movieModel);
			break;
		case "News":
			News[] news = new News[BCM.schedule.getNews(dayComboBox.getSelectedIndex()).size()];
			i = 0;
			for (News m : BCM.schedule.getNews(dayComboBox.getSelectedIndex()))
				news[i++] = m;
			System.out.println(Arrays.toString(news));
			DefaultComboBoxModel<News> newsModel = new DefaultComboBoxModel<News>(news);
			programCombo.setModel(newsModel);
			break;
		case "Series":
			Series[] series = new Series[BCM.schedule.getSeries(dayComboBox.getSelectedIndex()).size()];
			i = 0;
			for (Series m : BCM.schedule.getSeries(dayComboBox.getSelectedIndex()))
				series[i++] = m;
			System.out.println(Arrays.toString(series));
			DefaultComboBoxModel<Series> seriesModel = new DefaultComboBoxModel<Series>(series);
			programCombo.setModel(seriesModel);
			break;
		case "TV Show":
			TvShow[] tv = new TvShow[BCM.schedule.getTvShow(dayComboBox.getSelectedIndex()).size()];
			i = 0;
			for (TvShow m : BCM.schedule.getTvShow(dayComboBox.getSelectedIndex()))
				tv[i++] = m;
			System.out.println(Arrays.toString(tv));
			DefaultComboBoxModel<TvShow> tvModel = new DefaultComboBoxModel<TvShow>(tv);
			programCombo.setModel(tvModel);
		}
	}

	public void importantSwitchDELETE() {
		int i = 0;
		switch ((String)deleteTypeComboBox.getSelectedItem()) {
		case "Movies":
			Movie[] movies = new Movie[BCM.schedule.getMovies(deleteDaysComboBox.getSelectedIndex()).size()];
			i=0;
			for (Movie m : BCM.schedule.getMovies(deleteDaysComboBox.getSelectedIndex()))
				movies[i++] = m;
			System.out.println(Arrays.toString(movies));
			DefaultComboBoxModel<Movie> movieModel = new DefaultComboBoxModel<Movie>(movies);
			deleteProgramComboBox.setModel(movieModel);
			break;
		case "News":
			News[] news = new News[BCM.schedule.getNews(deleteDaysComboBox.getSelectedIndex()).size()];
			i = 0;
			for (News m : BCM.schedule.getNews(deleteDaysComboBox.getSelectedIndex()))
				news[i++] = m;
			System.out.println(Arrays.toString(news));
			DefaultComboBoxModel<News> newsModel = new DefaultComboBoxModel<News>(news);
			deleteProgramComboBox.setModel(newsModel);
			break;
		case "Series":
			Series[] series = new Series[BCM.schedule.getSeries(deleteDaysComboBox.getSelectedIndex()).size()];
			i = 0;
			for (Series m : BCM.schedule.getSeries(deleteDaysComboBox.getSelectedIndex()))
				series[i++] = m;
			System.out.println(Arrays.toString(series));
			DefaultComboBoxModel<Series> seriesModel = new DefaultComboBoxModel<Series>(series);
			deleteProgramComboBox.setModel(seriesModel);
			break;
		case "TV Show":
			TvShow[] tv = new TvShow[BCM.schedule.getTvShow(deleteDaysComboBox.getSelectedIndex()).size()];
			i = 0;
			for (TvShow m : BCM.schedule.getTvShow(deleteDaysComboBox.getSelectedIndex()))
				tv[i++] = m;
			System.out.println(Arrays.toString(tv));
			DefaultComboBoxModel<TvShow> tvModel = new DefaultComboBoxModel<TvShow>(tv);
			deleteProgramComboBox.setModel(tvModel);
		}

	}

}
