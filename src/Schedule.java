import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

@SuppressWarnings("serial")
public  class Schedule  implements Serializable {

	//private HashMap<Integer, ArrayList<Program>> weekly;

	@SuppressWarnings("unchecked")
	private static ArrayList<Program>[] weekly3= new ArrayList[7];


	//	private ArrayList<Program> weekly5;

	/**
	 * @return the weekly3
	 */
	public static ArrayList<Program>[] getWeekly3() {
		return weekly3;
	}


	/**
	 * @param weekly3 the weekly3 to set
	 */
	public static void setWeekly3(ArrayList<Program>[] weekly3) {
		Schedule.weekly3 = weekly3;
	}


	/**
	 * 
	 */
	public Schedule() {
		super();
		// = new HashMap<>();

		for (int i=0; i<weekly3.length; i++) {
			weekly3[i]= new ArrayList<Program>();
		}
	}


	public void addProgram(Program p) throws UnavailableSpotException {
		if (p instanceof News) {

			for (int i=0; i<weekly3.length; i++) {
				if((!weekly3[i].contains(p)) && checkAvailability(p, weekly3[i]))
					weekly3[i].add(p);

			}
		}
		else if(p instanceof Series && p.getClass().getName()!="News") {
			Series temp = (Series)p;
			for(int j = 0 ; j<temp.getDays().length; j++) {
				DaysOfTheWeek day = temp.getDays()[j];
				if(temp.getDays()[j]!=null) {
					if(!weekly3[dayToInt(day)-1].contains(temp) && checkAvailability(temp, weekly3[dayToInt(day)-1]))
						weekly3[dayToInt(day)-1].add(temp);
					else
						throw new UnavailableSpotException(day.toString());
				}
			}

		} else
			try {
				scheduleInit(p);
			} catch (UnavailableSpotException e) {
				// TODO Auto-generated catch block
				throw new UnavailableSpotException(e.getMessage());
			}

	}

	public ArrayList<Movie> getMovies(int day) {
		ArrayList<Movie> moviesArray = new ArrayList();
		for (Program p : weekly3[day])
			if (p instanceof Movie)
				moviesArray.add((Movie) p);

		return moviesArray;
	}

	public ArrayList<News> getNews(int day) {
		ArrayList<News> newsArray = new ArrayList();

		for (Program p : weekly3[day])
			if (p instanceof News)
				newsArray.add((News) p);

		return newsArray;
	}

	public ArrayList<Series> getSeries(int day) {
		ArrayList<Series> seriesArray = new ArrayList();
		for (Program p : weekly3[day])
			if (p instanceof Series && p.getClass().getName().equals("Series"))
				seriesArray.add((Series) p);
		return seriesArray;
	}

	public ArrayList<TvShow> getTvShow(int day) {
		ArrayList<TvShow> tvArray = new ArrayList();
		for (Program p : weekly3[day])
			if (p instanceof TvShow)
				tvArray.add((TvShow) p);

		return tvArray;
	}



	private void scheduleInit(Program p) throws UnavailableSpotException {
		switch (p.getDay()) {
		case Sunday:
			if(!weekly3[0].contains(p)) {
				if (checkAvailability(p, weekly3[0]))
					weekly3[0].add(p);
				else
					throw new UnavailableSpotException("Sunday");
			}
			//weekly.put((Integer)1, weekly.get((Integer)1).add(p));

			break;
		case Monday:
			if(!weekly3[1].contains(p)) {
				if (checkAvailability(p, weekly3[1]))
					weekly3[1].add(p);
				else
					throw new UnavailableSpotException("Monday");
			}

			break;
		case Tuesday:
			if(!weekly3[2].contains(p)) {
				if (checkAvailability(p, weekly3[2]))
					weekly3[2].add(p);
				else
					throw new UnavailableSpotException("Tuesday");
			}

			break;
		case Wednesday:
			if(!weekly3[3].contains(p)) {
				if (checkAvailability(p, weekly3[3]))
					weekly3[3].add(p);
				else
					throw new UnavailableSpotException("Wednesday");
			}
			break;
		case Thursday:
			if(!weekly3[4].contains(p)) {
				if (checkAvailability(p, weekly3[4]))
					weekly3[4].add(p);
				else
					throw new UnavailableSpotException("Thursday");
			}
			break;
		case Friday:
			if(!weekly3[5].contains(p)) {
				if (checkAvailability(p, weekly3[5]))
					weekly3[5].add(p);
				else
					throw new UnavailableSpotException("Friday");
			}
			break;
		case Saturday:
			if(!weekly3[6].contains(p)) {
				if (checkAvailability(p, weekly3[6]))
					weekly3[6].add(p);
				else
					throw new UnavailableSpotException("Saturday");
			}
			break;

		default:
			break;
		}


	}

	public boolean checkAvailability(Program program, ArrayList<Program> dayArray) {
		if (dayArray.isEmpty())
			return true;
		for(Program other: dayArray) {
			if(other.getStartHour()-program.getStartHour() > 0) {
				if (other.getEndHour() - program.getStartHour() <= 0) {
					return false;
				}
				else if (other.getStartHour()-program.getEndHour()<0) {
					return false;
				}
			}
			if(program.getStartHour()-other.getStartHour() >= 0) {
				if(program.getEndHour() - other.getStartHour() <= 0) {
					return false;
				}
				else if (program.getStartHour()-other.getEndHour()<0) {
					return false;
				}
			}
		}
		//System.out.println("false????");
		return true;
	}


	public static void   costShow() {
		String t="\n";
		for(int k=0 ; k<weekly3.length;k++) {



			for(Program p:weekly3[k]) {
				//System.out.println(p);

				if(p instanceof Series ) {
					if(((Series) p).calcCost()>1000) {
						System.out.println(p);
					}

				}

			}
		}

	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public  String toString() {
		DaysOfTheWeek[] days= DaysOfTheWeek.values();
		String t="\n";
		String[] sch=new String [7];
		for(int k=0 ; k<weekly3.length;k++) {
			Collections.sort(weekly3[k]);
			t+=days[k]+"\n";

			for(Program p:weekly3[k]) {
				//System.out.println(p);

				t+=p.toString()+"\n";

			}
			sch[k]=t;
			t="";
		}

		return Arrays.toString(sch);
	}

	public int dayToInt(DaysOfTheWeek day) {
		switch (day) {
		case Sunday:
			return 1;
		case Monday:
			return 2;
		case Tuesday:
			return 3;
		case Wednesday:
			return 4;
		case Thursday:
			return 5;
		case Friday:
			return 6;
		case Saturday:
			return 7;
		default:
			return -1;
		}
	}

	public boolean removeProgram(Program program) {
		for (int i=0; i<weekly3.length; i++) {
			if (weekly3[i].contains(program)) {
				weekly3[i].remove(program);
			}
			if (i==6)
				return true;
		}
		return false;
	}

		public static String   costShow(int val) {
			String t="\n";
			for(int k=0 ; k<weekly3.length;k++) {
				for(Program p:weekly3[k]) {
					//System.out.println(p);
					if(p instanceof Series ) {
						if(((Series) p).calcCost()>val) {
							t+=p.toString()+"\n";
						}
					}
				}
			}
			return t;
		}
		
		public int getLastIndex() {
			int max = 1;
			for (int i=0; i<weekly3.length; i++) {
				for (Program p : weekly3[i])
					if (p.getId()>max)
						max = p.getId();
			}
			return max;
		}
	}

