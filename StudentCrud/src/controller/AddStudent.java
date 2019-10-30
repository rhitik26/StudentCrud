package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StudentDao;
import model.Student;

/**
 * Servlet implementation class AddStudent
 */
@WebServlet("/addstudent.do")
public class AddStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddStudent() {
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StudentDao sDao = new StudentDao();
		List<Student> students = sDao.findAll();
		request.setAttribute("students", students);
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String name = request.getParameter("name").trim();
		String email = request.getParameter("email").trim();
		String address = request.getParameter("address").trim();
		String phone = request.getParameter("phone").trim();
		
		Student s = new Student(name, email, address, phone);
		
		StudentDao sDao = new StudentDao();
		try {
			sDao.create(s);
			request.setAttribute("created", true);
			List<Student> students = sDao.findAll();
			request.setAttribute("students", students);
		}catch(Exception ex) {
			request.setAttribute("created", false);
			ex.printStackTrace();
		}finally {
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}

}