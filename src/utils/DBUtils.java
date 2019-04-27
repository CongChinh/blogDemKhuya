package utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Subject;


public class DBUtils {
	public static List<Subject> querySubject(Connection conn, int start, int total) throws SQLException {
        String sql = "Select * from Subjects limit ?,?";
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
		String sql = "Select COUNT(subject_id) from Subjects";
		PreparedStatement pstm = conn.prepareStatement(sql);
		ResultSet rs = pstm.executeQuery();
		int totalRecords = 0;
		if (rs.next()) {
			totalRecords = rs.getInt(1);
		}
		return totalRecords;
	}
	public static void insertSubject(Connection conn, Subject subject) throws SQLException {
	    String sql = "Insert into Subjects(subject_name) values (?)";
	 
	    PreparedStatement pstm = conn.prepareStatement(sql);
	 
	    pstm.setString(1, subject.getSubject_name());
	 
	    pstm.executeUpdate();
	}
	public static void updateSubject(Connection conn, Subject subject, int subject_id) throws SQLException {
        String sql = "Update Subjects set subject_name = ? where subject_id = ?";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
 
        pstm.setInt(1, subject_id);
        pstm.setString(2, subject.getSubject_name());
         
        pstm.executeUpdate();
    }
	public static void deleteSubject(Connection conn, int subject_id) throws SQLException {
        String sql = "Delete From Subjects where subject_id = ?";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
 
        pstm.setInt(1, subject_id);
 
        pstm.executeUpdate();
    }
}
