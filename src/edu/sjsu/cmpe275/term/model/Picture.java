package edu.sjsu.cmpe275.term.model;

import java.io.Serializable;
import javax.persistence.Transient;
import org.springframework.web.multipart.MultipartFile;

public class Picture implements Serializable {
	private static final long serialVersionUID = 5865760835716664141L;
	private int pictureId;
	private String imageLocation;
	private MultipartFile image;
	
	public Picture() {
		super();
	}
	
	public Picture(int pictureId, String location, MultipartFile image) {
		super();
		this.pictureId = pictureId;
		this.imageLocation = location;
		this.image = image;
	}
	
	public int getPictureId() {
		return pictureId;
	}
	public void setPictureId(int pictureId) {
		this.pictureId = pictureId;
	}
	public String getLocation() {
		return imageLocation;
	}
	public void setLocation(String location) {
		this.imageLocation = location;
	}
	@Transient
	public MultipartFile getImage() {
		return image;
	}
	public void setImage(MultipartFile image) {
		this.image = image;
	}
}
