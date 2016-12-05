package edu.sjsu.cmpe275.term.model;
/**
 * @author Pratik
 *
 */
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import org.springframework.web.multipart.MultipartFile;

@Entity
public class Picture implements Serializable {
	private static final long serialVersionUID = 5865760835716664141L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PICTUREID")
	private int pictureId;
	@Column(name = "IMAGELOCATION")
	private String imageLocation;
	@Transient
	private MultipartFile image;
	
	public Picture() {
		super();
	}
	
	/**
	 * 
	 * @param pictureId
	 * @param imageLocation
	 */
	public Picture(int pictureId, String imageLocation) {
		super();
		this.pictureId = pictureId;
		this.imageLocation = imageLocation;
	}

	/**
	 * 
	 * @param pictureId
	 * @param location
	 */
	public Picture(int pictureId, String location, MultipartFile image) {
		super();
		this.pictureId = pictureId;
		this.imageLocation = location;
		this.image = image;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getPictureId() {
		return pictureId;
	}
	
	/**
	 * 
	 * @param pictureId
	 */
	public void setPictureId(int pictureId) {
		this.pictureId = pictureId;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getLocation() {
		return imageLocation;
	}
	
	/**
	 * 
	 * @param location
	 */
	public void setLocation(String location) {
		this.imageLocation = location;
	}
	
	/**
	 * 
	 * @return
	 */
	public MultipartFile getImage() {
		return image;
	}
	
	/**
	 * 
	 * @param image
	 */
	public void setImage(MultipartFile image) {
		this.image = image;
	}
}
