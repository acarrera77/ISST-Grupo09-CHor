package es.upm.dit.isst.trabajo.servlets;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;



import es.upm.dit.isst.trabajo.dao.AsociacionesDAOImplementation;
import es.upm.dit.isst.trabajo.dao.InformeDAOImplementation;
import es.upm.dit.isst.trabajo.dao.TrabajadorDAOImplementation;
import es.upm.dit.isst.trabajo.model.Asociaciones;
import es.upm.dit.isst.trabajo.model.GestorDeProyectos;
import es.upm.dit.isst.trabajo.model.Informe;
import es.upm.dit.isst.trabajo.model.Trabajador;

/**
 * Servlet implementation class EnviarInformeServlet
 */
@WebServlet("/EnviarInformeServlet")
@MultipartConfig
public class EnviarInformeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EnviarInformeServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String email = req.getParameter("email");
		String ano = req.getParameter("ano");
		String mes = req.getParameter("mes");

		Part filePart = req.getPart("informe");
		InputStream fileContent = filePart.getInputStream();
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		byte[] buffer = new byte[1024];
		
		Trabajador trabajador = TrabajadorDAOImplementation.getInstance().read(email);

		GestorDeProyectos gestor = (GestorDeProyectos) req.getSession().getAttribute("gestor");

		if(null != trabajador) {

			Informe informe = new Informe();
			for (int length = 0; (length = fileContent.read(buffer)) > 0;) {
				output.write(buffer, 0, length);
			}
			informe.setAno(ano);
			informe.setMes(mes);
			informe.setGestor(gestor);
			informe.setTrabajador(trabajador);
			informe.setInforme(output.toByteArray());
			InformeDAOImplementation.getInstance().update(informe);
			getServletContext().getRequestDispatcher("/Gestor.jsp").forward(req,resp);

		}else {
			getServletContext().getRequestDispatcher("/Gestor.jsp").forward(req,resp);
		}
	}


}
