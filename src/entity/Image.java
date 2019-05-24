package entity;

import java.sql.Blob;
import java.util.Date;

public class Image {
	private int image_id;
	private Blob image_data;
	private Date image_date;
	private int images_category_id;
	public Image() {
		super();
	}
	
	
	public Image(int image_id, Blob image_data, Date image_date, int images_category_id) {
		super();
		this.image_id = image_id;
		this.image_data = image_data;
		this.image_date = image_date;
		this.images_category_id = images_category_id;
	}


	public int getImage_id() {
		return image_id;
	}
	public void setImage_id(int image_id) {
		this.image_id = image_id;
	}
	public Blob getImage_data() {
		return image_data;
	}
	public void setImage_data(Blob image_data) {
		this.image_data = image_data;
	}
	public Date getImage_date() {
		return image_date;
	}
	public void setImage_date(Date image_date) {
		this.image_date = image_date;
	}


	public int getImages_category_id() {
		return images_category_id;
	}


	public void setImages_category_id(int images_category_id) {
		this.images_category_id = images_category_id;
	}
	
}
