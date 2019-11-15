package hexagon.demodrop.api.entitiy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import java.io.Serializable;
import java.util.Date;

@Entity(name="users")
public class UserEntity implements Serializable {
	

	private static final long serialVersionUID = -331502494278011419L;

	@Id
	@GeneratedValue
	private long id;
	
	@Column(nullable=false)
	private String userId;

	@Column(nullable=false)
	private String encryptedPassword;
	
	@Column(nullable=false, length=120, unique=true)
	private String email;
	
	@Column(nullable=false)
	private Date registerDate;
	
	@Column(nullable=false)
	private Boolean emailVerificationStatus = false;

	
	
	// getters
	public long getId() {
		return id;
	}

	public String getUserId() {
		return userId;
	}

	public String getEncryptedPassword() {
		return encryptedPassword;
	}

	public String getEmail() {
		return email;
	}

	public Date getRegisterDate() {
		return registerDate;
	}

	public Boolean getEmailVerificationStatus() {
		return emailVerificationStatus;
	}
	
	// setters
	public void setId(long id) {
		this.id = id;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setEncryptedPassword(String encryptedPassword) {
		this.encryptedPassword = encryptedPassword;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	public void setEmailVerificationStatus(Boolean emailVerificationStatus) {
		this.emailVerificationStatus = emailVerificationStatus;
	}
	
	
	
	
	
	
}
