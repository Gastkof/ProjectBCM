
public class UnavailableSpotException extends Exception {
	
	private String msg;
	
	public UnavailableSpotException(String msg) {
		super(msg);
		this.msg=msg;
	}
	
	@Override
	public String getMessage() {
		return msg;
	}

}
