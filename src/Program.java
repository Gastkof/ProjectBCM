import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;

@SuppressWarnings("serial")
public abstract class Program  implements Comparable<Program>,Serializable {

	private static int SerialId=1;
	private int id;
	private String ProName;
	private Genres[] genres;
	private int proTime;
	private double startHour;
	private double endHour;
	private Manager manger;
	private DaysOfTheWeek day;
	





	public Program(String proName, Genres[] genres, int proTime, double startHour,double endHour, Manager manger,DaysOfTheWeek day) throws ProgramException {
		super();
		setId();
		ProName = proName;
		this.genres = genres;
		this.proTime = proTime;
		this.startHour = startHour;
		this.manger = manger;
		setEndtHour(endHour);
		this.day=day;


	}
	


	public int getId() {
		return this.id;
	}
	public void setId() {
		id=SerialId++;
	}



	/**
	 * @return the day
	 */
	public DaysOfTheWeek getDay() {
		return day;
	}



	/**
	 * @param day the day to set
	 */
	public void setDay(DaysOfTheWeek day) {
		this.day = day;
	}




	public String getProName() {
		return ProName;
	}
	public Genres[] getGenres() {
		return genres;
	}
	public int getProTime() {
		return proTime;
	}
	public double getStartHour() {
		return startHour;
	}
	public Manager getManger() {
		return manger;
	}



	public double getEndHour() {
		return endHour;
	}



	public void setEndtHour(double endHour) {
		this.endHour = endHour;
	}


	/**
	 * @return the serialId
	 */
	public static int getSerialId() {
		return SerialId;
	}
	
	public static void setSerial(int maxId) {
		SerialId=BCM.schedule.getLastIndex()+1;
	}



	/**
	 * @param serialId the serialId to set
	 */
	public static void setSerialId( ) {
		SerialId=BCM.schedule.getLastIndex();
	}



	/**
	 * @param endHour the endHour to set
	 */
	public void setEndHour(double endHour) {
		this.endHour = endHour;
	}



	public void setProName(String proName) {
		ProName = proName;
	}
	public void setGenres(Genres[] genres) throws GenerException {
		if(genres!=null)
			this.genres = genres;
		else
			new GenerException("wrong input");
	}
	public void setProTime(int proTime) {
		this.proTime = proTime;
	}
	public void setStartHour(double startHour) {
		this.startHour = startHour;
	}
	public void setManger(Manager manger) {
		this.manger = manger;
	}




	@Override
	public int compareTo(Program o) {

		return (int) (this.startHour-o.startHour);
	}


	@Override
	public String toString() {
		return "ID: " + getId() + " - " + ProName;
	}
}
