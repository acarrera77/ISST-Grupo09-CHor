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
import es.upm.dit.isst.trabajo.model.Proyecto;
import es.upm.dit.isst.trabajo.dao.ProyectoDAO;
import es.upm.dit.isst.trabajo.dao.ProyectoDAOImplementation;

/**
 * Se le llama desde GestionDeProyectos.jsp evalua los datos introducidos y asigna proyectos a trabajadores
 */
@WebServlet("/AsignarProyectoServlet")
public class AsignarProyectoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String proyecto = request.getParameter("proyecto");
		//Lista de proyecto y trabajadores
		List<Trabajador> trabajadores = (List<Trabajador>) TrabajadorDAOImplementation.getInstance().readAll();
		List<Proyecto> proyectos = (List<Proyecto>) ProyectoDAOImplementation.getInstance().readAll();
		
		/**
		 * Aqui con un bucle se reccorerian las listas para ver si coinciden trabajador y proyecto con los string introducidos
		 * posteriormente se asignaria un proyecto a un trabajador pero como las relaciones de las bases de datos no estan hechas
		 * no quiero poner aqui codigo todavia
		 */
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
