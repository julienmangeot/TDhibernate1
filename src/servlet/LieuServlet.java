package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ILieuDao;
import dao.LieuDao;
import model.Lieu;

/**
 * Servlet implementation class LieuServlet
 */
@WebServlet("/addl")
public class LieuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LieuServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	this.getServletContext().getRequestDispatcher("/WEB-INF/webpages/addinglieu.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ILieuDao dao = new LieuDao();
		Lieu lieu = new Lieu();
		
		lieu.setAddress(request.getParameter("adress"));
		lieu.setCity(request.getParameter("city"));
		
		dao.createLieu(lieu);
		
		this.getServletContext().getRequestDispatcher("/showf").forward(request, response);
	}

}
