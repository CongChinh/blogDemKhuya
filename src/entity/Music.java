package entity;

import java.sql.Blob;
import java.util.Date;

public class Music {
	private int music_id;
	private String music_name;
	private String music_filename;
	private String music_singer;
	private Blob music_filedata;
	private Date music_date;
	private int musics_category_id;
	public Music() {
		super();
	}
	
	public Music(int music_id, String music_name, String music_filename, String music_singer, Blob music_filedata,
			Date music_date, int musics_category_id) {
		super();
		this.music_id = music_id;
		this.music_name = music_name;
		this.music_filename = music_filename;
		this.music_singer = music_singer;
		this.music_filedata = music_filedata;
		this.music_date = music_date;
		this.musics_category_id = musics_category_id;
	}

	public int getMusic_id() {
		return music_id;
	}
	public void setMusic_id(int music_id) {
		this.music_id = music_id;
	}
	public String getMusic_name() {
		return music_name;
	}
	public void setMusic_name(String music_name) {
		this.music_name = music_name;
	}
	public String getMusic_singer() {
		return music_singer;
	}
	public void setMusic_singer(String music_singer) {
		this.music_singer = music_singer;
	}

	public String getMusic_filename() {
		return music_filename;
	}

	public void setMusic_filename(String music_filename) {
		this.music_filename = music_filename;
	}

	public Blob getMusic_filedata() {
		return music_filedata;
	}

	public void setMusic_filedata(Blob music_filedata) {
		this.music_filedata = music_filedata;
	}

	public Date getMusic_date() {
		return music_date;
	}

	public void setMusic_date(Date music_date) {
		this.music_date = music_date;
	}

	public int getMusics_category_id() {
		return musics_category_id;
	}

	public void setMusics_category_id(int musics_category_id) {
		this.musics_category_id = musics_category_id;
	}
	
}
