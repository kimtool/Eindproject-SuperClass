

package hexagon.demodrop.api.entitiy;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class DemoEntity implements Serializable {
	
		
		private static final long serialVersionUID = 8189290160489648127L;

		// primary key
		@Id
		// auto-generated and incremented value (one-by-one)
		@GeneratedValue
		private long demoId;
		
		@Column(nullable=false)
		private String fileName;
		
		@Column(nullable=false)
		private String fileType;
		
		@Column(nullable=false)
		private String fileSize;
		
		@Column(nullable=false)
		private Date addedDate;
		
		
		// getters
		public long getDemoId() {
			return demoId;
		}

		public String getFileName() {
			return fileName;
		}

		public String getFileType() {
			return fileType;
		}

		public String getFileSize() {
			return fileSize;
		}

		public Date getAddedDate() {
			return addedDate;
		}
		
		// setters
		public void setDemoId(long demoId) {
			this.demoId = demoId;
		}

		public void setFileName(String fileName) {
			this.fileName = fileName;
		}

		public void setFileType(String fileType) {
			this.fileType = fileType;
		}

		public void setFileSize(String fileSize) {
			this.fileSize = fileSize;
		}

		public void setAddedDate(Date addedDate) {
			this.addedDate = addedDate;
		}
		
		
		
		
		
	
}
