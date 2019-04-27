package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Subject;
import utils.DBUtils;
import utils.MyUtils;

@WebServlet(urlPatterns = { "/admin/subjectCreate" })
public class SubjectCreate extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Connection conn = MyUtils.getStoredConnection(req);
		
		String subject_name = (String) req.getParameter("subject_name");
		
		
		Subject subject = new Subject(subject_name);
		
		try {
			DBUtils.insertSubject(conn, subject);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		req.setAttribute("subject", subject);
		
		resp.sendRedirect(req.getContextPath() + "/admin/subjectList");
	}
}
