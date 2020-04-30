package es.upm.dit.isst.trabajo.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.trabajo.dao.RegistroDAOImplementation;
import es.upm.dit.isst.trabajo.model.Registro;
import es.upm.dit.isst.trabajo.model.Trabajador;


/**
 * Servlet implementation class DescansosServlet
 */
@WebServlet("/DescansosServlet")
public class EnviarDescansosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnviarDescansosServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		@SuppressWarnings("deprecation")
		Date token = new Date(130, 0, 1);
		Trabajador trabajador = (Trabajador) req.getSession().getAttribute("trabajador");
		String email = trabajador.getEmail();
		try {
		Registro registro = RegistroDAOImplementation.getInstance().login(email,token);
		Integer horaDescanso = registro.getHoraDescanso();
			if(horaDescanso == 0) {
				registro.setHoraDescanso(1);
				RegistroDAOImplementation.getInstance().update(registro);
				getServletContext().getRequestDispatcher("/Trabajador.jsp").forward(req,resp);
			}else if(horaDescanso == 1) {
				registro.setHoraDescanso(2);
				RegistroDAOImplementation.getInstance().update(registro);
				getServletContext().getRequestDispatcher("/Trabajador.jsp").forward(req,resp);
			}else {
				registro.setHoraDescanso(3);
				RegistroDAOImplementation.getInstance().update(registro);
				getServletContext().getRequestDispatcher("/Trabajador.jsp").forward(req,resp);
			}
		
		} catch(java.lang.NullPointerException exception) {
			getServletContext().getRequestDispatcher("/Trabajador.jsp").forward(req,resp);
		} 
	
	}
}

