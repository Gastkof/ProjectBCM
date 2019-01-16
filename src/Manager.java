import java.io.Serializable;

/**
 * 
 * @author gaston
 *
 */
@SuppressWarnings("serial")
public class Manager implements Serializable {
	
	private int managerId;
	private String name;
	
	
	public Manager(int managerId, String name) {
		super();
		this.managerId = managerId;
		this.name = name;
	
	}
	
	
	
	public int getManagerId() {
		return managerId;
	}




	public void setManagerId(int managerId) {
		if(managerId>0)
		this.managerId = managerId;
	}




	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}



	@Override
	public String toString() {
		return getClass().getName()+ " managerId : " + managerId + ", name: " + name + "]";
	}





	
	
}
