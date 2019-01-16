import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

public class Series extends Program implements NewsAndSeries ,Serializable {
	
	private int FreqPerWeek;
	
	private ArrayList<Integer>daysScheduled ;
	private DaysOfTheWeek[] days;
	
	
	/**
	 * @param serialId
	 * @param proName
	 * @param genres
	 * @param proTime
	 * @param startHour
	 * @param manger
	 * @param freqPerWeek
	 * @param daysScheduled
	 * @throws ProgramException 
	 */
	public Series(String proName, Genres[] genres, int proTime, double startHour,double endtHour, Manager manger,
			DaysOfTheWeek day,int freqPerWeek,DaysOfTheWeek[] days) throws ProgramException {
		super( proName, genres, proTime, startHour, endtHour, manger, days[0]);
		this.FreqPerWeek = freqPerWeek;
		this.days= days;
	//	this.daysScheduled = new ArrayList<Integer>();
	}


	/**
	 * @return the freqPerWeek
	 */
	public int getFreqPerWeek() {
		return FreqPerWeek;
	}


	/**
	 * @param freqPerWeek the freqPerWeek to set
	 */
	public void setFreqPerWeek(int freqPerWeek) {
		if(freqPerWeek>0 && freqPerWeek<8)
		FreqPerWeek = freqPerWeek;
	}


//	/**
//	 * @return the daysScheduled
//	 */
//	public ArrayList<Integer> getDaysScheduled() {
//		return daysScheduled;
//	}
//
//
//	/**
//	 * @param daysScheduled the daysScheduled to set
//	 */
//	public void setDaysScheduled(ArrayList<Integer> daysScheduled) {
//		this.daysScheduled = daysScheduled;
//	}





	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return super.toString();
	}


	/**
	 * @return the days
	 */
	public DaysOfTheWeek[] getDays() {
		return days;
	}


	/**
	 * @param days the days to set
	 */
	public void setDays(DaysOfTheWeek[] days) {
		this.days = days;
	}


	@Override
	public double calcCost() {
		final int minuteCost=120;
		return (this.getProTime()*minuteCost)*this.FreqPerWeek  ;
	}
	
	

}
