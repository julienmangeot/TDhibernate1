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
 * Servlet implementation class AllFormationServlet
 */
@WebServlet("/showf")
public class AllFormationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllFormationServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		IFormationDao dao = new FormationDao();
//		List<Formation> list = new ArrayList<Formation>();
//		
//		list=dao.showFormations();
//		request.setAttribute("listing", list);
//		this.getServletContext().getRequestDispatcher("/WEB-INF/webpages/showing.jsp").forward(request, response);
		
		ILieuDao dao = new LieuDao();
		List<Lieu> listLieu = new ArrayList<Lieu>();
		
		listLieu=dao.showLieu();
		request.setAttribute("listingl", listLieu);
		this.getServletContext().getRequestDispatcher("/WEB-INF/webpages/showing.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IFormationDao dao = new FormationDao();
		List<Formation> listFormation = new ArrayList<Formation>();
		Lieu lieu =new Lieu();
		lieu.setIdLieu(Integer.parseInt(request.getParameter("location")));
		
		listFormation=dao.getFormations(lieu);
		request.setAttribute("listingf", listFormation);
		//this.getServletContext().getRequestDispatcher("/WEB-INF/webpages/showing.jsp").forward(request, response);
		doGet(request, response);
	}

}
