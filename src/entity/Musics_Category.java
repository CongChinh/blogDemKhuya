package entity;

public class Musics_Category {
	private int musics_category_id;
	private String musics_category_name;
	public Musics_Category() {
		super();
	}
	public Musics_Category(int musics_category_id, String musics_category_name) {
		super();
		this.musics_category_id = musics_category_id;
		this.musics_category_name = musics_category_name;
	}
	public int getMusics_category_id() {
		return musics_category_id;
	}
	public void setMusics_category_id(int musics_category_id) {
		this.musics_category_id = musics_category_id;
	}
	public String getMusics_category_name() {
		return musics_category_name;
	}
	public void setMusics_category_name(String musics_category_name) {
		this.musics_category_name = musics_category_name;
	}
	
}
