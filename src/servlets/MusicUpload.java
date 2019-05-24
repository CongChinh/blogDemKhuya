package servlets;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import database.ConnectionUtils;
import entity.Images_Category;
import entity.Musics_Category;
import utils.DBUtils;
import utils.MyUtils;

@WebServlet(urlPatterns = { "/admin/musicUpload" })
@MultipartConfig(fileSizeThreshold = 314572800, // 2MB
		maxFileSize = 314572800, // 10MB
		maxRequestSize = 314572800) // 50MB
public class MusicUpload extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final String SAVE_DIRECTORY = "uploadDir";

	public MusicUpload() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Connection conn = MyUtils.getStoredConnection(req);
		List<Musics_Category> listMC = null;
		try {
			listMC = DBUtils.queryMusicCategory(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		req.setAttribute("musicscategoryList", listMC);
		
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/admin/musicUpload.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Connection conn = null;
		try {
			// Káº¿t ná»‘i tá»›i Database
			conn = ConnectionUtils.getConnection();
			conn.setAutoCommit(false);
			
			String music_name = req.getParameter("music_name");
			String music_singer = req.getParameter("music_singer");
			// Danh má»¥c cÃ¡c pháº§n Ä‘Ã£ upload lÃªn (CÃ³ thá»ƒ lÃ  nhiá»�u file).
			for (Part part : req.getParts()) {
				String music_filename = extractFileName(part);
				if (music_filename != null && music_filename.length() > 0) {
					// Dá»¯ liá»‡u file.
					InputStream music_filedata = part.getInputStream();

					// Ghi vÃ o file.
					String sql = "Insert into musics(music_id,music_name,music_filename,music_singer,music_filedata,music_date,musics_category_id)" //
							+ " values (?,?,?,?,?,?,?) ";
					PreparedStatement pstm = conn.prepareStatement(sql);
					Date now = new Date(System.currentTimeMillis());
					int musicsCategory = Integer.parseInt(req.getParameter("musicsCategory"));
					Long id = this.getMaxMusicId(conn) + 1;
					pstm.setLong(1, id);
					pstm.setString(2, music_name);
					pstm.setString(3, music_filename);
					pstm.setString(4, music_singer);
					pstm.setBlob(5, music_filedata);
					pstm.setDate(6, now);
					pstm.setInt(7, musicsCategory);
					pstm.executeUpdate();
				}
			}
			conn.commit();

			// Upload thÃ nh cÃ´ng.
			RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher("/WEB-INF/views/admin/musicUpload.jsp");
			dispatcher.forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("errorMessage", "Error: " + e.getMessage());
			RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher("/WEB-INF/views/admin/musicUpload.jsp");
			dispatcher.forward(req, resp);
		} finally {
			this.closeQuietly(conn);
		}
	}

	private String extractFileName(Part part) {
		// form-data; name="file"; filename="C:\file1.zip"
		// form-data; name="file"; filename="C:\Note\file2.zip"
		String contentDisp = part.getHeader("content-disposition");
		String[] items = contentDisp.split(";");
		for (String s : items) {
			if (s.trim().startsWith("filename")) {
				// C:\file1.zip
				// C:\Note\file2.zip
				String clientFileName = s.substring(s.indexOf("=") + 2, s.length() - 1);
				clientFileName = clientFileName.replace("\\", "/");
				int i = clientFileName.lastIndexOf('/');
				// file1.zip
				// file2.zip
				return clientFileName.substring(i + 1);
			}
		}
		return null;
	}

	private Long getMaxMusicId(Connection conn) throws SQLException {
		String sql = "Select max(m.music_id) from musics m";
		PreparedStatement pstm = conn.prepareStatement(sql);
		ResultSet rs = pstm.executeQuery();
		if (rs.next()) {
			long max = rs.getLong(1);
			return max;
		}
		return 0L;
	}

	private void closeQuietly(Connection conn) {
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
		}
	}
}
