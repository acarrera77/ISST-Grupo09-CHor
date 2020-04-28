package es.upm.dit.isst.trabajo.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.trabajo.dao.InformeDAOImplementation;
import es.upm.dit.isst.trabajo.dao.TrabajadorDAOImplementation;
import es.upm.dit.isst.trabajo.model.Informe;
import es.upm.dit.isst.trabajo.model.Trabajador;

/**
 * Servlet implementation class BuscadorInformeServlet
 */
@WebServlet("/BuscadorInformeServlet")
public class BuscadorInformeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuscadorInformeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String email = req.getParameter("email");
		String mes = req.getParameter("mes");
		String ano = req.getParameter("ano");
		
		Trabajador trabajador = TrabajadorDAOImplementation.getInstance().read(email);
		
		Informe informe = InformeDAOImplementation.getInstance().login(email, mes, ano);
		
		if(null != trabajador && null != mes && null != ano) {
			resp.setContentType("application/pdf");
			resp.setHeader("Content-Disposition", String.format("attachment; filename=\"%s\"", "informe.pdf"));
			resp.setContentLength(informe.getInforme().length);
			resp.getOutputStream().write(informe.getInforme());
			}else {
			getServletContext().getRequestDispatcher("/Gestor.jsp").forward(req,resp);
		}
	}


}
