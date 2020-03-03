package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FormationDao;
import dao.IFormationDao;
import model.Formation;

/**
 * Servlet implementation class FormationServlet
 */
@WebServlet("/add")
public class FormationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormationServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/webpages/adding.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Formation f = new Formation();
		IFormationDao dao = new FormationDao();
		
		f.setTheme(request.getParameter("theme"));
		dao.createFormation(f);
		if(dao.createFormation(f)==true) {
			request.setAttribute("message", "Formation successfully saved");
		}
		else {
			request.setAttribute("message", "Formation saving failed");
		}
		this.getServletContext().getRequestDispatcher("/WEB-INF/webpages/adding.jsp").forward(request, response);
	}

}
