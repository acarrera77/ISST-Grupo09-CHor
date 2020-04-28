package es.upm.dit.isst.trabajo.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.trabajo.dao.InformeDAOImplementation;
import es.upm.dit.isst.trabajo.dao.ProyectoDAOImplementation;
import es.upm.dit.isst.trabajo.dao.RegistroDAOImplementation;
import es.upm.dit.isst.trabajo.dao.TrabajadorDAOImplementation;
import es.upm.dit.isst.trabajo.model.Informe;
import es.upm.dit.isst.trabajo.model.Proyecto;
import es.upm.dit.isst.trabajo.model.Registro;
import es.upm.dit.isst.trabajo.model.Trabajador;

/**
 * Servlet implementation class EnviarBuscadorRRHHServlet
 */
@WebServlet("/EnviarBuscadorRRHHServlet")
public class EnviarBuscadorRRHHServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnviarBuscadorRRHHServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String ano = req.getParameter("ano");
		
		Trabajador trabajador = TrabajadorDAOImplementation.getInstance().read(email);
		
		List<Informe> linf = InformeDAOImplementation.getInstance().login2(email, ano);
		
		if(null != trabajador) {	
			req.getSession().setAttribute("linf", linf);
			getServletContext().getRequestDispatcher("/TablasBuscadorRRHH.jsp").forward(req,resp);
		}else {
			getServletContext().getRequestDispatcher("/RRHH.jsp").forward(req,resp);
		}
	}


}
