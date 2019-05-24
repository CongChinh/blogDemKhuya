package entity;

public class Images_Category {
	private int images_category_id;
	private String images_category_name;
	public Images_Category(int images_category_id, String images_category_name) {
		super();
		this.images_category_id = images_category_id;
		this.images_category_name = images_category_name;
	}
	public Images_Category() {
		super();
	}
	public int getImages_category_id() {
		return images_category_id;
	}
	public void setImages_category_id(int images_category_id) {
		this.images_category_id = images_category_id;
	}
	public String getImages_category_name() {
		return images_category_name;
	}
	public void setImages_category_name(String images_category_name) {
		this.images_category_name = images_category_name;
	}
	
}
