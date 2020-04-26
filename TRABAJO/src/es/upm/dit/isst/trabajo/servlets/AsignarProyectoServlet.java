package es.upm.dit.isst.trabajo.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import es.upm.dit.isst.trabajo.model.Trabajador;
import es.upm.dit.isst.trabajo.dao.TrabajadorDAO;
import es.upm.dit.isst.trabajo.dao.TrabajadorDAOImplementation;
import es.upm.dit.isst.trabajo.model.Asociaciones;
import es.upm.dit.isst.trabajo.model.GestorDeProyectos;
import es.upm.dit.isst.trabajo.model.Proyecto;
import es.upm.dit.isst.trabajo.model.Registro;
import es.upm.dit.isst.trabajo.dao.AsociacionesDAOImplementation;
import es.upm.dit.isst.trabajo.dao.ProyectoDAO;
import es.upm.dit.isst.trabajo.dao.ProyectoDAOImplementation;
import es.upm.dit.isst.trabajo.dao.RegistroDAOImplementation;

/**
 * Se le llama desde GestionDeProyectos.jsp evalua los datos introducidos y asigna proyectos a trabajadores
 */
@WebServlet("/AsignarProyectoServlet")
public class AsignarProyectoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String email = req.getParameter("email");
		String proyectoId = req.getParameter("proyectoId");
		
		Trabajador trabajador = TrabajadorDAOImplementation.getInstance().read(email);
		
		Proyecto proyecto = ProyectoDAOImplementation.getInstance().read(proyectoId);
		
		GestorDeProyectos gestor = (GestorDeProyectos) req.getSession().getAttribute("gestor");

		if(null != trabajador && null != proyecto) {

		Asociaciones asociacion = new Asociaciones();
		asociacion.setGestores(gestor);
		asociacion.setProyectos(proyecto);
		asociacion.setTrabajadores(trabajador);
		AsociacionesDAOImplementation.getInstance().update(asociacion);
		getServletContext().getRequestDispatcher("/Gestor.jsp").forward(req,resp);

		}else {
			getServletContext().getRequestDispatcher("/Gestor.jsp").forward(req,resp);
		}
	}


}
