package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FormationDao;
import dao.IFormationDao;
import dao.ILieuDao;
import dao.LieuDao;
import model.Formation;
import model.Lieu;

/**
 * Servlet implementation class FormationServlet
 */
@WebServlet("/addf")
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
		List<Lieu> list = new ArrayList<Lieu>();
		ILieuDao dao = new LieuDao();
		
		list=dao.showLieu();
		request.setAttribute("listing", list);
		this.getServletContext().getRequestDispatcher("/WEB-INF/webpages/addingformation.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Formation f = new Formation();
		Lieu l = new Lieu();
		IFormationDao dao = new FormationDao();
		
		f.setTheme(request.getParameter("theme"));
		l.setIdLieu(Integer.parseInt(request.getParameter("formationlocation")));
		f.setLieu(l);
		dao.createFormation(f);
		
		if(dao.createFormation(f)==true) {
			request.setAttribute("message", "Formation successfully saved");
		}
		else {
			request.setAttribute("message", "Formation saving failed");
		}
		this.getServletContext().getRequestDispatcher("/WEB-INF/webpages/addingformation.jsp").forward(request, response);
	}

}
