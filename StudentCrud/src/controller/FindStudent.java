package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StudentDao;
import model.Student;

/**
 * Servlet implementation class FindStudent
 */
@WebServlet("/findstudent.do")
public class FindStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			String id = request.getParameter("id").trim();
			StudentDao sDao = new StudentDao();
			Student s = sDao.find(Long.parseLong(id));
			request.setAttribute("s", s);
		}catch (NumberFormatException nfe) {
			request.setAttribute("nfe", true);
		}catch (NullPointerException npe) {
			request.setAttribute("npe", true);
		}catch (Exception ex) {
			request.setAttribute("ex", true);
		}finally {
			request.getRequestDispatcher("index.jsp").forward(request, response);
			
		}
	}

}