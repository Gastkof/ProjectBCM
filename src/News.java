import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

@SuppressWarnings("serial")
public class News extends Series  implements NewsAndSeries ,Serializable  {
	
	//private DaysOfTheWeek[] days = DaysOfTheWeek.values();

		private String  broadCaster ;

		/**
		 * @param serialId
		 * @param proName
		 * @param genres
		 * @param proTime
		 * @param startHour
		 * @param manger
		 * @param freqPerWeek
		 * @param daysScheduled
		 * @param broadCaster
		 * @throws ProgramException 
		 */
		public News(String proName, Genres[] genres, int proTime, double startHour,double endHour, Manager manger,
				DaysOfTheWeek day,int freqPerWeek, String broadCaster) throws ProgramException {
			super(proName, genres, proTime, startHour, endHour, manger, day,freqPerWeek,DaysOfTheWeek.values());
			this.broadCaster = broadCaster;

		}

		/**
		 * @return the broadCaster
		 */
		public String getBroadCaster() {
			return broadCaster;
		}

		/**
		 * @param broadCaster the broadCaster to set
		 */
		public void setBroadCaster(String broadCaster) {
			this.broadCaster = broadCaster;
		}

		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return super.toString();
		}
		
}
		
