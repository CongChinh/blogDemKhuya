package servlet.customer;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Music;
import entity.Musics_Category;
import utils.DBUtils;
import utils.MyUtils;

@WebServlet(urlPatterns = { "/musics" })
public class Musics extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Connection conn = MyUtils.getStoredConnection(req);
		String errorString = null;
		List<Music> list = null;
		List<Music> listTop10Musics = null;
		List<Musics_Category> listMC = null;
		ResultSet rs = null;
		
		String music_id = req.getParameter("music_id");
		
		int page = 1;
        int recordsPerPage = 5;
        if(req.getParameter("page") != null)
        	page = Integer.parseInt(req.getParameter("page"));
                        
        try {
        	listTop10Musics = DBUtils.top10Musics(conn);
        	listMC = DBUtils.queryMusicCategory(conn);
            list = DBUtils.queryMusic(conn,(page-1)*recordsPerPage,recordsPerPage);
            new DBUtils();
			rs = DBUtils.getMusic(conn, music_id);
			if(rs.next()) {
				Blob music_filedata = rs.getBlob("music_filedata");
				byte data[] = music_filedata.getBytes(1, (int) music_filedata.length());
				OutputStream os = resp.getOutputStream();
				os.write(data);
				os.flush();
				os.close();
			}
            
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }
        
        int totalRecords = 0;
        try {
        	totalRecords = DBUtils.getTotalRecords(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        int pages = (int) Math.ceil(totalRecords*1.0/recordsPerPage);
        req.setAttribute("errorString", errorString);
        req.setAttribute("musiccategoryList", listMC);
        req.setAttribute("musicList", list);
        req.setAttribute("top10Musics", listTop10Musics);
        
        req.setAttribute("currentPage", page);
        req.setAttribute("totalRecords", pages);
		
		
		
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/musics.jsp");
		dispatcher.forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}