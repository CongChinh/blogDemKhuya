package utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import entity.Image;
import entity.Images_Category;
import entity.Music;
import entity.Musics_Category;
import entity.Subject;


public class DBUtils {
	public static List<Subject> querySubject(Connection conn, int start, int total) throws SQLException {
        String sql = "Select * from subjects limit ?,?";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, start);
        pstm.setInt(2, total);
        ResultSet rs = pstm.executeQuery();
        List<Subject> list = new ArrayList<Subject>();        
        
        while (rs.next()) {
        	int subject_id = rs.getInt("subject_id");
            String subject_name = rs.getString("subject_name");
            
            Subject subject = new Subject();
            subject.setSubject_id(subject_id);
            subject.setSubject_name(subject_name);
            list.add(subject);
        }
        return list;
    }
	
	public static int getTotalRecords(Connection conn) throws SQLException {
		String sql = "Select COUNT(subject_id) from subjects";
		PreparedStatement pstm = conn.prepareStatement(sql);
		ResultSet rs = pstm.executeQuery();
		int totalRecords = 0;
		if (rs.next()) {
			totalRecords = rs.getInt(1);
		}
		return totalRecords;
	}
	public static void insertSubject(Connection conn, Subject subject) throws SQLException {
	    String sql = "Insert into subjects(subject_name) values (?)";
	 
	    PreparedStatement pstm = conn.prepareStatement(sql);
	 
	    pstm.setString(1, subject.getSubject_name());
	 
	    pstm.executeUpdate();
	}
	public static void updateSubject(Connection conn, Subject subject, int subject_id) throws SQLException {
        String sql = "Update subjects set subject_name = ? where subject_id = ?";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
 
        pstm.setInt(1, subject_id);
        pstm.setString(2, subject.getSubject_name());
         
        pstm.executeUpdate();
    }
	public static void deleteSubject(Connection conn, int subject_id) throws SQLException {
        String sql = "Delete From subjects where subject_id = ?";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
 
        pstm.setInt(1, subject_id);
 
        pstm.executeUpdate();
    }
	//Musics_Category
	public static List<Musics_Category> queryMusicCategory(Connection conn) throws SQLException {
        String sql = "Select * from musics_category";
        PreparedStatement pstm = conn.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();
        List<Musics_Category> list = new ArrayList<Musics_Category>();        
        while (rs.next()) {
        	int musics_category_id = rs.getInt("musics_category_id");
        	String musics_category_name = rs.getString("musics_category_name");
        	Musics_Category musics_category = new Musics_Category();
        	musics_category.setMusics_category_id(musics_category_id);
        	musics_category.setMusics_category_name(musics_category_name);
            list.add(musics_category);
        }
        return list;
    }
	//Music All
	public static List<Music> queryMusic(Connection conn, int start, int total) throws SQLException {
        String sql = "Select music_id, music_name, music_filename, music_singer,music_date,musics_category_id  from musics limit ?,?";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, start);
        pstm.setInt(2, total);
        ResultSet rs = pstm.executeQuery();
        List<Music> list = new ArrayList<Music>();        
        
        while (rs.next()) {
        	int music_id = rs.getInt("music_id");
            String music_name = rs.getString("music_name");
            String music_filename = rs.getString("music_filename");
            String music_singer = rs.getString("music_singer");
            Date music_date = rs.getDate("music_date");
            int musics_category_id = rs.getInt("musics_category_id");
            Music music = new Music();
            music.setMusic_id(music_id);
            music.setMusic_name(music_name);
            music.setMusic_filename(music_filename);
            music.setMusic_singer(music_singer);
            music.setMusic_date(music_date);
            music.setMusics_category_id(musics_category_id);
            list.add(music);
        }
        return list;
    }
	public static ResultSet getMusic(Connection conn, String music_id) throws SQLException {
		String sql = "Select music_filedata from musics where music_id = ?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, music_id);
		return pstm.executeQuery();
	}
	public static List<Music> top10Musics(Connection conn) throws SQLException {
        String sql = "Select music_id, music_name, music_singer from musics";
        PreparedStatement pstm = conn.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();
        List<Music> list = new ArrayList<Music>();        
        
        while (rs.next()) {
        	int music_id = rs.getInt("music_id");
            String music_name = rs.getString("music_name");
            String music_singer = rs.getString("music_singer");
            Music music = new Music();
            music.setMusic_id(music_id);
            music.setMusic_name(music_name);
            music.setMusic_singer(music_singer);
            list.add(music);
        }
        return list;
	}
	//Images_Category
	public static List<Images_Category> queryImageCategory(Connection conn) throws SQLException {
        String sql = "Select * from images_category";
        PreparedStatement pstm = conn.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();
        List<Images_Category> list = new ArrayList<Images_Category>();        
        while (rs.next()) {
        	int images_category_id = rs.getInt("images_category_id");
        	String images_category_name = rs.getString("images_category_name");
        	Images_Category images_category = new Images_Category();
        	images_category.setImages_category_id(images_category_id);
        	images_category.setImages_category_name(images_category_name);
            list.add(images_category);
        }
        return list;
    }
	//Image
	public static List<Image> queryImage(Connection conn, int start, int total) throws SQLException {
        String sql = "Select image_id, image_date, images_category_id from images limit ?,?";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, start);
        pstm.setInt(2, total);
        ResultSet rs = pstm.executeQuery();
        List<Image> list = new ArrayList<Image>();        
        while (rs.next()) {
        	int image_id = rs.getInt("image_id");
        	Date image_date = rs.getDate("image_date");
        	int images_category_id = rs.getInt("images_category_id");
            Image image = new Image();
            image.setImage_id(image_id);
            image.setImage_date(image_date);
            image.setImages_category_id(images_category_id);
            list.add(image);
        }
        return list;
    }
	public static ResultSet getImage(Connection conn, String image_id) throws SQLException {
		String sql = "Select image_data from images where image_id = ?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, image_id);
		return pstm.executeQuery();
	}
}
