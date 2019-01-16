import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;

import javax.sql.rowset.spi.TransactionalWriter;

@SuppressWarnings("serial")
public class Movie extends Program implements Serializable{
	
	private double IMDB;
	
	private int daySchduled;
	
	private ArrayList<String> stars;
	
	private Languages [] subtitle;

	/**
	 * @param serialId
	 * @param proName
	 * @param genres
	 * @param proTime
	 * @param startHour
	 * @param manger
	 * @param iMDB
	 * @param daySchduled
	 * @param stars
	 * @param subtitle
	 * @throws ProgramException 
	 */
	public Movie( String proName, Genres[] genres, int proTime, double startHour,double endtHour, Manager manger, double IMDB,
			DaysOfTheWeek day,int daySchduled, ArrayList<String> stars, Languages[] subtitle) throws ProgramException {
		super( proName, genres, proTime, startHour, endtHour, manger,day);	
		this.IMDB=IMDB;
		this.daySchduled = daySchduled;
		this.stars = stars;
		this.subtitle = subtitle;
		
	}
	

	/**
	 * @param iMDB the iMDB to set
	 */
	public void setIMDB(double iMDB) throws IMDBExecption  {
		if(iMDB>0&&iMDB<11)
		IMDB = iMDB;
		else
			 new IMDBExecption("wrong input");
			
	}



	/**
	 * @param daySchduled the daySchduled to set
	 */
	public void setDaySchduled(int daySchduled) {
		this.daySchduled = daySchduled;
	}

	/**
	 * @param stars the stars to set
	 */
	public void setStars(ArrayList<String> stars) {
		this.stars = stars;
	}

	/**
	 * @param subtitle the subtitle to set
	 */
	public void setSubtitle(Languages[] subtitle) throws SubtitleExecption {
		if(subtitle!=null)
		this.subtitle = subtitle;
		else
			new SubtitleExecption("wrong leng");
	}

	/**
	 * @return the iMDB
	 */
	public double getIMDB() {
		return IMDB;
	}

	/**
	 * @return the daySchduled
	 */
	public int getDaySchduled() {
		return daySchduled;
	}

	/**
	 * @return the stars
	 */
	public ArrayList<String> getStars() {
		return stars;
	}

	/**
	 * @return the subtitle
	 */
	public Languages[] getSubtitle() {
		return subtitle;
	}
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return super.toString();
	}

	
	

}
