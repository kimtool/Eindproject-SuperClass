

package hexagon.demodrop.api.entitiy;

import java.awt.image.BufferedImage;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class ProfileEntity extends ProducerEntity{
	
	private static final long serialVersionUID = 5215357912383745365L;
	
	
	
	@Id
	@GeneratedValue
	private long profileId;
	
	@Column(nullable=false)
	private Date editDate;
	
	@Column
	private BufferedImage image;
	
	
	// getters
	public long getProfileId() {
		return profileId;
	}

	public Date getEditDate() {
		return editDate;
	}

	public BufferedImage getImage() {
		return image;
	}

	// setters
	public void setProfileId(long profileId) {
		this.profileId = profileId;
	}

	public void setEditDate(Date editDate) {
		this.editDate = editDate;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}
	
	
	
}
