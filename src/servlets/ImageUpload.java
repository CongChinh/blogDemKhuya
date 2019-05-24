package servlets;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import entity.Images_Category;
import utils.DBUtils;
import utils.MyUtils;

@WebServlet(urlPatterns = { "/admin/imageUpload" })
@MultipartConfig(maxFileSize = 16177216)
public class ImageUpload extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	PrintWriter out;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Connection conn = MyUtils.getStoredConnection(req);
		List<Images_Category> listIC = null;
		try {
			listIC = DBUtils.queryImageCategory(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		req.setAttribute("imagescategoryList", listIC);
		
		
		RequestDispatcher dispatcher = this.getServletContext()
				.getRequestDispatcher("/WEB-INF/views/admin/imageUpload.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		out = resp.getWriter();
		int result = 0;
		
		Part part = req.getPart("image");//image o cho name jsp
		if(part != null) {
			try {
				Connection conn = MyUtils.getStoredConnection(req);
				PreparedStatement ps = conn.prepareStatement("insert into images(image_data, image_date, images_category_id) values(?,?,?)");
				InputStream is = part.getInputStream();
				Date now = new Date(System.currentTimeMillis());
				int imagesCategory = Integer.parseInt(req.getParameter("imagesCategory"));//lay tu name cua seclect upload jsp
				ps.setBlob(1, is);
				ps.setDate(2, now);
				ps.setInt(3, imagesCategory);
				result = ps.executeUpdate();
				if(result>0) {
					RequestDispatcher dispatcher = this.getServletContext()
							.getRequestDispatcher("/WEB-INF/views/admin/imageUpload.jsp");
					dispatcher.forward(req, resp);
				}else {
					resp.sendRedirect("home.jsp?messege=Error");
				}
			}catch(Exception ex) {
				ex.getMessage();
			}
		}
	}

}
