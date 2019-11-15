package hexagon.demodrop.api.entitiy;

import java.util.ArrayList;


public class EmployeeEntity extends UserEntity {

	
	private static final long serialVersionUID = -2594984367813501370L;
	
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
