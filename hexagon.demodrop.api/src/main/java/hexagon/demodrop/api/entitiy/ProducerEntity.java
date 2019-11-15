package hexagon.demodrop.api.entitiy;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;



@Entity(name="producers")
public class ProducerEntity extends UserEntity {


	private static final long serialVersionUID = 1571268586835884834L;
	
	
	// primary key
	@Id
	// auto-generated and incremented value (one-by-one)
	@GeneratedValue
	private long producerId;
	
	@Column(nullable=false)
	private String firstname;

	@Column(nullable=false)
	private String lastName;
	
	@Column(nullable=false)
	private int age;
	
	private ArrayList<String> producerComments = new ArrayList<String>();

	
	// getters
	public long getProducerId() {
		return producerId;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getLastName() {
		return lastName;
	}

	public int getAge() {
		return age;
	}

	public ArrayList<String> getProducerComments() {
		return producerComments;
	}
	
	
	// setters
	public void setProducerId(long producerId) {
		this.producerId = producerId;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setProducerComments(ArrayList<String> producerComments) {
		this.producerComments = producerComments;
	}
	
	
	

}
