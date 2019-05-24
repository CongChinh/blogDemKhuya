package servlet.customer;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
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

import entity.Image;
import entity.Images_Category;
import utils.DBUtils;
import utils.MyUtils;
@WebServlet(urlPatterns = { "/images" })
public class Images extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	PrintWriter out;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Connection conn = MyUtils.getStoredConnection(req);
		String errorString = null;
        List<Image> list = null;
        List<Images_Category> listIC = null;
        ResultSet rs = null;
        
        String image_id = req.getParameter("image_id");
        
        int page = 1;
        int recordsPerPage = 5;
        if(req.getParameter("page") != null)
        	page = Integer.parseInt(req.getParameter("page"));
                        
        try {
        	listIC = DBUtils.queryImageCategory(conn);
            list = DBUtils.queryImage(conn,(page-1)*recordsPerPage,recordsPerPage);
            new DBUtils();
			rs = DBUtils.getImage(conn, image_id);
			if(rs.next()) {
				Blob image_data = rs.getBlob("image_data");
				byte data[] = image_data.getBytes(1, (int) image_data.length());
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
        req.setAttribute("imagecategoryList", listIC);
        req.setAttribute("imageList", list);
        req.setAttribute("currentPage", page);
        req.setAttribute("totalRecords", pages);
        
        RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/WEB-INF/views/images.jsp");
        dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
