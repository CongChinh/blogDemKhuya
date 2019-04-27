package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Subject;
import utils.DBUtils;
import utils.MyUtils;

@WebServlet(urlPatterns = { "/admin/subjectList" })
public class SubjectList extends HttpServlet{
	private static final long serialVersionUID = 1L;
	public SubjectList(){
		super();
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Connection conn = MyUtils.getStoredConnection(req);
		String errorString = null;
        List<Subject> list = null;
        
        //Phan trang
        int page = 1;
        int recordsPerPage = 5;
        if(req.getParameter("page") != null)
        	page = Integer.parseInt(req.getParameter("page"));
                        
        try {
            list = DBUtils.querySubject(conn,(page-1)*recordsPerPage,recordsPerPage);
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
        // Lưu thông tin vào request attribute trước khi forward sang views.
        req.setAttribute("errorString", errorString);
        req.setAttribute("subjectList", list);
        req.setAttribute("currentPage", page);
        req.setAttribute("totalRecords", pages);
         
        // Forward sang /WEB-INF/views/productListView.jsp
        RequestDispatcher dispatcher = req.getServletContext()
                .getRequestDispatcher("/WEB-INF/views/admin/subjectList.jsp");
        dispatcher.forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
