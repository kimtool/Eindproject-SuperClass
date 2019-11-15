package hexagon.demodrop.api.entitiy;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="employee")
public class EmployeeEntity extends UserEntity {

	
	private static final long serialVersionUID = -2594984367813501370L;
	
	// primary key
	@Id
	// auto-generated and incremented value (one-by-one)
	@GeneratedValue
	private long employeeId;
	
	private String employeeName;
	
	private ArrayList<String> employeeComments = new ArrayList<String>();

	
	// getters
	public String getEmployeeName() {
		return employeeName;
	}

	public ArrayList<String> getEmployeeComments() {
		return employeeComments;
	}
	
	// setters
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public void setEmployeeComments(ArrayList<String> employeeComments) {
		this.employeeComments = employeeComments;
	}
	
	

}
