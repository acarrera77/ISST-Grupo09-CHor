package es.upm.dit.isst.trabajo.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.trabajo.dao.ProyectoDAOImplementation;
import es.upm.dit.isst.trabajo.dao.RegistroDAOImplementation;
import es.upm.dit.isst.trabajo.dao.TrabajadorDAOImplementation;
import es.upm.dit.isst.trabajo.model.Proyecto;
import es.upm.dit.isst.trabajo.model.Registro;
import es.upm.dit.isst.trabajo.model.Trabajador;

/**
 * Servlet implementation class EnviarBuscadorServlet
 */
@WebServlet("/EnviarBuscadorServlet")
public class EnviarBuscadorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnviarBuscadorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String email = req.getParameter("email");
		String proyectoId = req.getParameter("proyectoId");
		
		Trabajador trabajador = TrabajadorDAOImplementation.getInstance().read(email);
		
		Proyecto proyecto = ProyectoDAOImplementation.getInstance().read(proyectoId);
		
		List<Registro> lr = RegistroDAOImplementation.getInstance().login2(email, proyectoId);
		
		if(null != trabajador && null != proyecto) {	
			req.getSession().setAttribute("lr", lr);
			getServletContext().getRequestDispatcher("/TablasBuscador.jsp").forward(req,resp);
		}else {
			getServletContext().getRequestDispatcher("/Gestor.jsp").forward(req,resp);
		}
	}


}
