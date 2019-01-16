
import java.awt.Label;
import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.naming.ldap.StartTlsResponse;

//import com.sun.tools.javac.code.Type.UndetVar.InferenceBound;

public class BCM implements Serializable {
	static ObjectOutputStream output;
	static ObjectInputStream read;
	static Scanner input = new Scanner(System.in);
	static Schedule weekScheduled;
	static int menupick;
	static Program program;
	static Schedule schedule = new Schedule();
	final static DaysOfTheWeek[] days = DaysOfTheWeek.values(); 
	static Manager[] managers = new Manager[5];
	final static Genres[] geners = Genres.values();
	final static Languages[] lang = Languages.values(); 
	static int choice;
	static ArrayList<Program> scheduleList ;
	//parameters for the manager class
	static String ManagerName;
	static int ManagerId;

	//parameters for programs the abstract class
	static int ProgramId;
	static String ProgramName;
	static Genres[] gener;
	static int doration;
	static double startsHour;
	static double endHour;
	static Manager  manger;
	static int dayPicked;

	//parameters for series class
	static 	int freq;
	static DaysOfTheWeek daysPicked[];

	//parameters for news
	static String broadCasterName;


	//parameters for movie
	static ArrayList<String> stars;
	static double rank;
	static Languages[] subtitle;

	//parameters for TvShow

	static String host;
	static	String[] guest;


	public static void main(String[] args) throws ProgramException {


		do {
			PrintMenu();
			menupick = input.nextInt();
			Menu(menupick);
		}while(menupick>0 && menupick<9);
	}





	private static void PrintMenu() {

		System.out.println("----------------------------------");
		System.out.println("this is BCM tv program ");
		System.out.println("_________________________________"+"\n");

		System.out.println("press 1for start a new weekScheduled press : ");

		System.out.println("_________________________________"+"\n");

		System.out.println("press 2 for create  5 mangers Manager press 2 : ");
		System.out.println("_________________________________"+"\n");

		System.out.println(" press 3 for create  programs press  : ");
		System.out.println("_________________________________"+"\n");
		System.out.println("press 4 for show all programs that cost more than 1000 nis :");
		System.out.println("_________________________________"+"\n");
		System.out.println("press 5  for show all programs  weekScheduled  : ");
		System.out.println("_________________________________"+"\n");
		System.out.println("press 6  to read data from file  : ");
		System.out.println("_________________________________"+"\n");
		System.out.println("press 7  to create file from sceduale  : ");
		System.out.println("_________________________________"+"\n");
		System.out.println("press 8 to read file from sceduale.ser  : ");
		System.out.println("_________________________________"+"\n");
		System.out.println("press  9 to exit  : ");

		System.out.println("----------------------------------");

	}



	static void Menu(int menupick) throws ProgramException {

		switch (menupick) {
		case 1:

			weekScheduled = new Schedule();

			break;

		case 2:

			System.out.println("hello to  our new Manger please enter your id and name");

			for(int i=0 ; i<managers.length;i++) {
				System.out.println("enter your name:");
				ManagerName= input.nextLine();
				ManagerName+=input.nextLine();
				if(checkString(ManagerName)) {
					System.out.println("enter your id:");
					ManagerId= input.nextInt();

					manger = new Manager(ManagerId, ManagerName);
					managers[i]=manger;
				}
				else {
					System.out.println("Incorrect input. name should match pattern [first last] with - only");
					//i--;
					continue;
				}


			}
			break;


		case 3:
			System.out.println("welcome to the schedule  we need to enter At least 30 programs");
			System.out.println("enter the how many program types would you like to add:");

			int choose = input.nextInt();

			while(choose>0) {

				System.out.println( "choose what program to insert"
						+ "\n 1. for movie at least 10"
						+ "\n 2.News at least 3"
						+ "\n 3 for series  at least 7"
						+ "\n 4 for TvShows at least 10");
				int pronNum= input.nextInt();

				switch (pronNum) {

				case 1:
					System.out.println("how many movies would you like to add:");
					choice = input.nextInt();
					while (choice>0) {
						System.out.println("enter the movie data");
						System.out.println("name");
						ProgramName= input.next();
						System.out.println("please choose movie generes");
						//System.out.println("from this options"+Arrays.toString(geners).split(",").toString());
						for (int i=1; i<=geners.length; i++) {
							System.out.println(i + "." + geners[i-1]);
							System.out.println();
						}
						System.out.println("how many geners does your movie have?");
						int generChoice = input.nextInt();
						gener = new Genres[generChoice];
						for (int i=0; i<gener.length; i++) {
							System.out.println("please choose genres by number:");
							generChoice = input.nextInt();
							gener[i] = geners[generChoice-1];
						}
						System.out.println("what's the movie duration time?");
						doration = input.nextInt();
						System.out.println("what's the movie start time? (HH:MM) 24Hours");
						startsHour = input.nextDouble();
						System.out.println("what's the movie end time? (HH:MM) 24Hours");
						endHour = input.nextDouble();
						System.out.println("who is the manager of the schedualed movie?");

						for (int i=1; i<=managers.length; i++) {
							System.out.println(i + "." + managers[i-1]);
							System.out.println();
						}
						int managerChoice = input.nextInt();
						manger = managers[managerChoice-1];
						System.out.println("please enter the movie's rating:");
						rank = input.nextDouble();
						System.out.println("please enter day that the movie is schedualed: [1-7]");
						dayPicked = input.nextInt();

						//days[dayPicked];
						System.out.println("please enter how many actors are in the movie:");
						int starsNum = input.nextInt();

						stars = new ArrayList<String>();
						for (int i=0; i<starsNum; i++) {
							String star = input.next();
							stars.add(star);
						}

						System.out.println("please enter how many subtitle languages are you offering:");
						int subNum = input.nextInt();

						for (int i=1; i<=lang.length; i++) {
							System.out.println(i + "." + lang[i-1]);
							System.out.println();
						}
						System.out.println("please choose from the list:");
						subtitle = new Languages[subNum];
						for (int i=1; i<=subtitle.length; i++) {
							subNum = input.nextInt();
							subtitle[i-1] = lang[subNum-1];
						}

						try {
							program = new Movie(ProgramName, gener, doration, startsHour, endHour, manger, rank, days[dayPicked-1], dayPicked, stars, subtitle);
							System.out.println(program);

						} catch (ProgramException e) {
							e.printStackTrace();

							new Exception("was not");
						}

						try {
							schedule.addProgram(program);
						} 
						catch (UnavailableSpotException e) {
							e.getMessage();
							do {
								PrintMenu();
								menupick=input.nextInt();
								Menu(menupick);
							}while(menupick>0 && menupick<6);
						}
						choice--;
					}

					break;

				case 2:
					System.out.println("how many News shows would you like to add:");
					choice = 1;
					while (choice<4) {
						System.out.println("please enter " + choice + " news data:");
						System.out.println("please enter " + choice + "News name:");
						ProgramName= input.next();
						System.out.println("please choose News topics:");

						for (int i=1; i<=geners.length; i++) {
							System.out.println(i + "." + geners[i-1]);
							System.out.println();
						}
						System.out.println("how many topics the News have?");
						int generChoice = input.nextInt();
						gener = new Genres[generChoice];
						for (int i=0; i<gener.length; i++) {
							System.out.println("please choose topics by number:");
							generChoice = input.nextInt();
							gener[i] = geners[generChoice-1];
						}
						System.out.println("what's the News duration time?");
						doration = input.nextInt();
						System.out.println("please enter News start time? (HH:MM) 24Hours");
						startsHour = input.nextDouble();
						System.out.println("please enter News end time? (HH:MM) 24Hours");
						endHour = input.nextDouble();
						System.out.println("who is the manager of the schedualing?");

						for (int i=1; i<=managers.length; i++) {
							System.out.println(i + "." + managers[i-1]);
							System.out.println();
						}
						int managerChoice = input.nextInt();
						manger = managers[managerChoice-1];
						System.out.println("please enter broadcaster name:");
						broadCasterName = input.next();
						try {
							program = new News(ProgramName, gener, doration, startsHour, endHour, manger, null, 7, broadCasterName);
							System.out.println(program);
						} catch (ProgramException e) {
							new Exception("was not");			
							e.printStackTrace();
						}
						try {
							schedule.addProgram(program);
						} 
						catch (UnavailableSpotException e) {
							e.getMessage();
							do {
								PrintMenu();
								menupick=input.nextInt();
								Menu(menupick);
							}while(menupick>0 && menupick<6);
						}

						choice++;

					}
					break;
				case 3:

					System.out.println("how many Series would you like to add:");
					choice = input.nextInt();
					while (choice>0) {
						System.out.println("please enter Series data:");
						System.out.println("please enter Series name:");
						ProgramName= input.next();
						System.out.println("please choose Series topics:");

						for (int i=1; i<=geners.length; i++) {
							System.out.println(i + "." + geners[i-1]);
							System.out.println();
						}
						System.out.println("how many topics the Series have?");
						int generChoice = input.nextInt();
						gener = new Genres[generChoice];
						for (int i=0; i<gener.length; i++) {
							System.out.println("please choose topics by number:");
							generChoice = input.nextInt();
							gener[i] = geners[generChoice-1];
						}
						System.out.println("what's the Series duration time?");
						doration = input.nextInt();
						System.out.println("please enter Series start time? (HH:MM) 24Hours");
						startsHour = input.nextDouble();
						System.out.println("please enter Series end time? (HH:MM) 24Hours");
						endHour = input.nextDouble();
						System.out.println("who is the manager of the schedualing?");

						for (int i=1; i<=managers.length; i++) {
							System.out.println(i + "." + managers[i-1]);
							System.out.println();
						}
						int managerChoice = input.nextInt();
						manger = managers[managerChoice-1];


						System.out.println("please enter how many times a week the Series is on:");
						freq = input.nextInt();

						for (int i=1; i<=days.length; i++) {
							System.out.println(i + "." + days[i-1]);
							System.out.println();
						}
						System.out.println("please choose the days from the list by number:");
						daysPicked = new DaysOfTheWeek[freq];
						for (int i=1; i<=daysPicked.length; i++) {
							int day = input.nextInt();
							daysPicked[i-1] = days[day -1];
						}


						try {
							program = new Series(ProgramName, gener, doration, startsHour, endHour, manger,null,freq,  days);

							System.out.println(program);
						} catch (ProgramException e) {

							new Exception("was not");

							e.printStackTrace();
						}
						try {
							schedule.addProgram(program);
						} 
						catch (UnavailableSpotException e) {
							e.getMessage();
							do {
								PrintMenu();
								menupick=input.nextInt();
								Menu(menupick);
							}while(menupick>0 && menupick<10);
						}
						choice--;

					}

					break;


				case 4:

					System.out.println("how many TvShows would you like to add:");
					choice = input.nextInt();
					while (choice>0) {
						System.out.println("enter the TvShows name");
						System.out.println("name");
						ProgramName= input.next();
						System.out.println("please choose TvShows generes");
						for (int i=1; i<=geners.length; i++) {
							System.out.println(i + "." + geners[i-1]);
							System.out.println();
						}
						System.out.println("how many geners does your TvShows have?");
						int generChoice = input.nextInt();
						gener = new Genres[generChoice];
						for (int i=0; i<gener.length; i++) {
							System.out.println("please choose genres by number:");
							generChoice = input.nextInt();
							gener[i] = geners[generChoice-1];
						}
						System.out.println("what's the TvShows duration time?");
						doration = input.nextInt();
						System.out.println("what's the TvShows start time? (HH:MM) 24Hours");
						startsHour = input.nextDouble();
						System.out.println("what's the TvShows end time? (HH:MM) 24Hours");
						endHour = input.nextDouble();
						System.out.println("who is the manager of the schedualed ?");

						for (int i=1; i<=managers.length; i++) {
							System.out.println(i + "." + managers[i-1]);
							System.out.println();
						}
						int managerChoice = input.nextInt();
						manger = managers[managerChoice-1];


						System.out.println("please enter day that the TvShows is schedualed: [1-7]");
						dayPicked = input.nextInt();

						//days[dayPicked];
						System.out.println("please enter how many guest  in the TvShows:");
						int guestNum = input.nextInt();

						guest = new String[guestNum];
						for (int i=0; i<guestNum; i++) {
							guest[i]= input.next();

						}

						System.out.println("please enter how many subtitle languages are you offering:");
						int subNum = input.nextInt();

						for (int i=1; i<=lang.length; i++) {
							System.out.println(i + "." + lang[i-1]);
							System.out.println();
						}
						System.out.println("please choose from the list:");
						subtitle = new Languages[subNum];
						for (int i=1; i<=subtitle.length; i++) {
							subNum = input.nextInt();
							subtitle[i-1] = lang[subNum-1];
						}

						try {
							program = new TvShow(ProgramName, gener, doration, startsHour, endHour, manger, dayPicked,days[dayPicked-1], guest, host);

							System.out.println(program);
						} catch (ProgramException e) {

							new Exception("was not");

							e.printStackTrace();
						}
						System.out.println(program);
						try {
							schedule.addProgram(program);
						} 
						catch (UnavailableSpotException e) {
							e.getMessage();
							do {
								PrintMenu();
								menupick=input.nextInt();
								Menu(menupick);
							}while(menupick>0 && menupick<6);
						}

						choice--;


					}
					break;

				default:
					break;

				}
				choose--;
			}

			break;
		case 4:
			System.out.println("get all the new and series that are over than 10000 nis cost");
			schedule.costShow();
			break;
		case 5:
			System.out.println("this is thr full schedule in order of the shows and days");
			System.out.println(schedule.toString());
			break;
		case 6:
			System.out.println("TRY READING DATA FROM FILE");
			try (Scanner input = new Scanner(Paths.get("scedh.txt")))
			{
				//String option = input.next();
				while (input.hasNext()) // more data to read
				{ 

					String option = input.next();
					switch(option) {
					case "Managers":
						System.out.println("THIS IS MANAGERS");
						for(int i=0; i<5;i++) {
							String name="";
							name = input.next();

							name+=" " + input.next();

							//int id = Integer.parseInt(input.next());
							if (checkString(name)) {
								Manager manager = new Manager(input.nextInt(), name);
								managers[i] = manager;
								System.out.println(manager);
							}
						}
						break;
					case "Movies":
						input.next();
						System.out.println("THIS IS MOVIE");
						while(!input.hasNext("News"))
						{
							String movieName="";
							String tempString="";
							while(true) {
								tempString=input.next();
								if(tempString.equals("GENERS"))
									break;
								movieName+=tempString + " ";
							}

							ArrayList<Genres> geners = new ArrayList<>();

							while(true) {

								String generString = input.next();
								Genres gener = Genres.valueOf(generString);
								geners.add(gener);
								if(input.hasNextDouble()) {
									break;
								}

								System.out.println(geners);
							}
							int duration = input.nextInt();
							double startHour = input.nextDouble();
							double endHour = input.nextDouble();
							double rank = input.nextDouble();
							int day = input.nextInt();
							String starName="";
							while(true) {
								starName+=input.next() + " ";
								if(input.hasNext("SUBTITLE")) {
									input.next();
									break;

								}
							}
							String[] stars = starName.split(",");
							ArrayList<String> starsArrayList = new ArrayList<String>();
							for (int i=0; i<stars.length; i++) {
								if(checkString(stars[i]))

									starsArrayList.add(stars[i]);
							}
							ArrayList<Languages> languages = new ArrayList<>();

							String subString;
							while(true) {
								subString = input.next();
								Languages sub = Languages.valueOf(subString);
								languages.add(sub);
								if(input.hasNext("TITLE")) {
									input.next();
									break;
								}
								else if(input.hasNext("News")) {
									break;
								}
							}

							program= new Movie(movieName,geners.toArray(new Genres[geners.size()]), duration, startHour, endHour, managers[1], rank, days[day-1], day, starsArrayList, languages.toArray(new Languages[languages.size()]));
							System.out.println(program);
							try {
								schedule.addProgram(program);
							} catch (UnavailableSpotException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						break;
					case "News":
						System.out.println("THIS IS NEWS");
						input.next();

						while(!input.hasNext("Series"))
						{	
							String loopCheck = input.next();
							String newsName;
							if (loopCheck.equals("Series"))
								break;
							else {
								newsName=loopCheck;

								while(!input.hasNext("GENERS")) {
									newsName+= input.next() + " ";


									if(input.hasNext("GENERS")) {
										input.next();

										break;
									}

								}

								ArrayList<Genres> geners = new ArrayList<>();

								while(true) {

									String generString = input.next();
									Genres gener = Genres.valueOf(generString);
									geners.add(gener);
									if(input.hasNextDouble()) {
										break;
									}


								}
								int duration = input.nextInt();
								double startHour = input.nextDouble();
								double endHour = input.nextDouble();
								int mangerPick= input.nextInt();

								broadCasterName="";
								String nextString = "News";
								while(!nextString.equals("busink")) {
									nextString = input.next();
									if (nextString.equals("TITLE"))
										break;
									broadCasterName+=nextString + " ";

								}
								if(checkString(broadCasterName)) {
									program = new News(newsName,geners.toArray(new Genres[geners.size()]), duration, startHour, endHour, managers[mangerPick], null, 7, broadCasterName);
									System.out.println(program);
								}
								else
									continue;
								try {
									schedule.addProgram(program);
								}

								catch (UnavailableSpotException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}


							}
						}

						break;

					case "Series":
						System.out.println("THIS IS SERIES");
						String loopCheck = input.next();
						//System.out.println(loopCheck);
						while(!input.hasNext("TvShows"))
						{
							ProgramName="";
							loopCheck = ProgramName;


							while(!input.hasNext("GENERS")) {

								if(!input.hasNext("GENERS")) {
									ProgramName +=input.next() + " ";
									loopCheck = ProgramName;
									loopCheck = input.next();
									if (!loopCheck.equals("GENERS"))
										ProgramName+=loopCheck;
									else {

										break;
									}
								}
								else {
									break;
								}
								//String generString = input.next();

							}
							//System.out.println(ProgramName);


							ArrayList<Genres> geners = new ArrayList<>();
							//input.next();
							String stringInput = "NULL";
							int duration;
							while(true) {
								stringInput = input.next();
								String generString = stringInput;



								if (stringInput.charAt(0)<'A' || stringInput.charAt(0)>'z') {
									duration = Integer.parseInt(stringInput);
									break;
								}
								else if (stringInput.equals("GENERS")) {
									stringInput = input.next();
									Genres gener = Genres.valueOf(stringInput);
									geners.add(gener);
								}
								else {
									//generString = stringInput;
									Genres gener = Genres.valueOf(generString);		
									geners.add(gener);
								}

							}
							//duration = Integer.parseInt(stringInput);

							double startHour = input.nextDouble();
							double endHour = input.nextDouble();
							int mangerPick= input.nextInt();
							DaysOfTheWeek days= null;
							input.next();
							int day = input.nextInt();
							broadCasterName="";

							ArrayList<DaysOfTheWeek> daysoftheweek = new ArrayList<>();

							while(true) {
								String daysof = input.next();
								DaysOfTheWeek daypick = DaysOfTheWeek.valueOf(daysof);
								daysoftheweek.add(daypick);
								if(input.hasNext("TITLE")) {
									input.next();
									break;
								}
								else if(input.hasNext("TvShows")) {
									break;
								}

							}

							program = new Series(ProgramName, geners.toArray(new Genres[geners.size()]), duration, startHour, endHour, managers[mangerPick],null,day, daysoftheweek.toArray(new  DaysOfTheWeek[day]));
							System.out.println(program);
							try {
								schedule.addProgram(program);
							} catch (UnavailableSpotException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						break;
					case"TvShows":
						String checkString = input.next();
						while(!checkString.equals("END"))
						{
							ProgramName="";
							while(!input.hasNext("GENERS")) {

								if(!input.hasNext("GENERS")) {
									ProgramName = input.next();
									if(ProgramName.equals("END")) {
										System.out.println("--------FINISHED READING FROM FILE---------");
										return;
									}
									if(input.hasNext("GENERS"))
										input.next();
									else
										ProgramName+=" " + input.next();

								}

								input.next();
								break;

							}

							ArrayList<Genres> geners = new ArrayList<>();

							while(true) {

								String generString = input.next();
								Genres gener = Genres.valueOf(generString);
								geners.add(gener);
								if(input.hasNextDouble()) {
									break;
								}

							}
							int duration = input.nextInt();
							double startHour = input.nextDouble();
							double endHour = input.nextDouble();
							int mangerPick= input.nextInt();
							int day = input.nextInt();



							String gust="";
							while(true) {
								gust+=input.next() + " ";
								if(input.hasNext("Host")) {
									input.next();
									break;

								}
								//starName=input.next();
							}
							String[] guests = gust.split(",");
							ArrayList<String> gustList = new ArrayList<String>();
							for (int i=0; i<guests.length; i++) {
								if(checkString(guests[i]))

									gustList.add(guests[i]);
							}

							broadCasterName="";
							while(true) {
								broadCasterName+=input.next() + " ";
								if(input.hasNext("TITLE")) {
									input.next();
									break;
								}
								else if(input.hasNext("END")) {
									break;
								}

							}

							program = new TvShow(ProgramName, geners.toArray(new Genres[geners.size()]), duration, startHour, endHour, managers[mangerPick], day,days[day-1], gustList.toArray(new String[gustList.size()]), broadCasterName);
							System.out.println(program);
							try {
								schedule.addProgram(program);
							} catch (UnavailableSpotException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();

							}
						}
						break;

						//Movie movie = new Movie(proName, geners.toArray(), proTime, startHour, endtHour, manger, IMDB, day, daySchduled, stars, subtitle)

					default:

						break;

					}
				}
			} catch (IOException e) {
				System.out.println("ehat");
				System.out.println(e.getStackTrace().toString());
				System.out.println(e.getMessage());
				System.exit(1);
			}

		case 7:
			//serialize("schedule.ser",Schedule.getWeekly3());
			extractToFile("schedule.ser", schedule);


			break;
		case 8:
			deserialize("schedule.ser");
			break;

		default:
			break;
		}


	}

	public static boolean checkString(String string) {
		Pattern regex = Pattern.compile("[A-Za-z-]+\\s[A-Za-z-]+.");
		Matcher m = regex.matcher(string);
		return m.matches();
	}


	private static void serialize(String fileName, ArrayList<Program>[] programs) {
		try 
		{
			output = new ObjectOutputStream(
					Files.newOutputStream(Paths.get(fileName)));

			output.writeObject(programs);
		}
		catch (IOException ioException)
		{
			System.err.println("Error opening file. Terminating.");
			System.exit(1); // terminate the program
		} 
	}

	@SuppressWarnings( { "unchecked", "static-access" } )
	static void deserialize(String fileName) {
		scheduleList = new ArrayList<Program>();
		Schedule sc = new Schedule();
		try // open file
		{
			//			read = new ObjectInputStream(          
			//					Files.newInputStream(Paths.get(fileName)));
			InputStream file = new FileInputStream(fileName);

			//System.out.println(read.read());
			InputStream buffer = new BufferedInputStream(file);
			ObjectInput input = new ObjectInputStream (buffer);

			for(int i =0 ; i<sc.getWeekly3().length;i++) {
				scheduleList=(ArrayList<Program>) input.readObject();
				if(scheduleList!=null) {
					try {
						for(Program p: scheduleList)
							sc.addProgram(p);
						// program = 
					} catch (UnavailableSpotException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			managers = (Manager[]) input.readObject();
			System.out.println(Arrays.toString(managers));
			//System.out.println(scheduleList);


		} 
		catch (IOException | ClassNotFoundException ioException)
		{
			System.err.println("Error opening file.");
			System.exit(1);
		}
		System.out.println("programs that cost more then 10000");	
		schedule.costShow();
		System.out.println("_________________");
		System.out.println("the scedule for the week");
		System.out.println( schedule.toString());
	}


	static void extractToFile(String fileName, Schedule sceduale) {
		boolean check=false;
		for (int i=0; i<sceduale.getWeekly3().length; i++) {
			if (!sceduale.getWeekly3()[i].isEmpty()) {
				System.out.println("inside if " + i);
				check=true;
			}

		}
		if (check) {
			try {
				output = new ObjectOutputStream(Files.newOutputStream(Paths.get(fileName)));
			} catch (IOException e) {
				System.out.println("error creating file");
			}

			try {


				for (int i=0; i<sceduale.getWeekly3().length; i++) {
					output.writeObject(sceduale.getWeekly3()[i]);
					System.out.println("Writing to file DAY NUMBER: " + (i+1) + " finished successfully.");
				}

				output.writeObject(managers);

				output.close();
			} catch (IOException e) {
				System.out.println("error adding employee to file");
			}
		} 
		else {
			System.out.println("Sceduale is EMPTY!!!");
		}

	}
}
