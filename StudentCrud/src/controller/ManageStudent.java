package controller;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.HibernateOGMUtil;
import dao.StudentDao;
import model.Student;

/**
 * Servlet implementation class ManageStudent
 */
@WebServlet("/managestudent.do")
public class ManageStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EntityManagerFactory emf;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ManageStudent() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		try {
			String id = request.getParameter("id").trim();
			StudentDao st = new StudentDao();
			String op = request.getParameter("option");
			emf = HibernateOGMUtil.getEntityManagerFactory();

			EntityManager em = emf.createEntityManager();
			switch (op) {
			case "E":
				Student s = st.find(Long.parseLong(id));
				request.setAttribute("s", s);
				em.getTransaction().begin();
				em.merge(s);
				em.getTransaction().commit();
				break;
			case "D":
				s = st.find(Long.parseLong(id));
				st.delete(Long.parseLong(id));
				request.setAttribute("s", s);
				break;
			}
		} finally {
			request.getRequestDispatcher("index.jsp").forward(request, response);

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		try {
			String id = request.getParameter("id").trim();
			StudentDao st = new StudentDao();
			String op = request.getParameter("option");
			switch (op) {
			case "E":
				Student s = st.find(Long.parseLong(id));
				request.setAttribute("s", s);
				st.update(s);
				break;
			case "D":
				Student s2 = st.find(Long.parseLong(id));
				request.setAttribute("s", s2);
				st.delete(s2);
				break;
			}
		} finally {
			request.getRequestDispatcher("index.jsp").forward(request, response);

		}
	}

}
