import java.io.Serializable;
import java.util.Arrays;

@SuppressWarnings("serial")
public class TvShow extends Program implements Serializable {
	
	private int daySchduled;

	private String [] Guest;
	
	private String Host;

	/**
	 * @param serialId
	 * @param proName
	 * @param genres
	 * @param proTime
	 * @param startHour
	 * @param manger
	 * @param daySchduled
	 * @param guest
	 * @param host
	 * @throws ProgramException 
	 */
	
	
	
	public TvShow(String proName, Genres[] genres, int proTime, double startHour,double endtHour, Manager manger,
			int daySchduled,DaysOfTheWeek day, String[] guest, String host) throws ProgramException {
		super(proName, genres, proTime, startHour, endtHour, manger, day);
		this.daySchduled = daySchduled;
		this.Guest = guest;
		this.Host = host;
	}

	/**
	 * @return the daySchduled
	 */
	public int getDaySchduled() {
		return daySchduled;
	}

	/**
	 * @return the guest
	 */
	public String[] getGuest() {
		return Guest;
	}

	/**
	 * @return the host
	 */
	public String getHost() {
		return Host;
	}

	/**
	 * @param daySchduled the daySchduled to set
	 */
	public void setDaySchduled(int daySchduled) {
		this.daySchduled = daySchduled;
	}

	/**
	 * @param guest the guest to set
	 */
	public void setGuest(String[] guest) {
		Guest = guest;
	}

	/**
	 * @param host the host to set
	 */
	public void setHost(String host) {
		Host = host;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return super.toString();
	}
	
	

}
