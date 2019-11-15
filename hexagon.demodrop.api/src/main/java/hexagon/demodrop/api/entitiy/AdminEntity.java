package hexagon.demodrop.api.entitiy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="admin")
public class AdminEntity extends UserEntity {

	
	private static final long serialVersionUID = -868519825006474585L;
	
	@Id
	@GeneratedValue
	private double adminId;
	
	private String adminName;
	
	
	// getter
	public String getAdminName() {
		return adminName;
	}
	
	
	// setter
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	
	
	
}
