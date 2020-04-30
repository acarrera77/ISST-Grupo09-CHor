package es.upm.dit.isst.trabajo.servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import es.upm.dit.isst.trabajo.dao.GestorDeProyectosDAOImplementation;
import es.upm.dit.isst.trabajo.dao.RRHHDAOImplementation;
import es.upm.dit.isst.trabajo.dao.RegistroDAOImplementation;
import es.upm.dit.isst.trabajo.dao.SessionFactoryService;
import es.upm.dit.isst.trabajo.dao.TrabajadorDAOImplementation;
import es.upm.dit.isst.trabajo.model.Registro;
import es.upm.dit.isst.trabajo.model.Trabajador;
import es.upm.dit.isst.trabajo.model.GestorDeProyectos;
import es.upm.dit.isst.trabajo.model.RRHH;


/**
 * Servlet implementation class FormLoginServlet
 */
@WebServlet("/FormLoginServlet")
public class FormLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private final String ADMIN_EMAIL = "root";
	private final String ADMIN_PASSWORD = "root";


	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FormLoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String email = req.getParameter("email");
		String password = req.getParameter("password");

		Trabajador trabajador = TrabajadorDAOImplementation.getInstance().login(email, password);
		GestorDeProyectos gestor = GestorDeProyectosDAOImplementation.getInstance().login(email, password);
		RRHH rrhh = RRHHDAOImplementation.getInstance().login(email, password);

		if(trabajador != null) {
			req.getSession().setAttribute("trabajador", trabajador);
			getServletContext().getRequestDispatcher("/Trabajador.jsp").forward(req,resp);;

		} else if (gestor != null){
			req.getSession().setAttribute("gestor", gestor);
			getServletContext().getRequestDispatcher("/Gestor.jsp").forward(req,resp);;

			
		} else if(rrhh !=null) {
			req.getSession().setAttribute("rrhh", rrhh);
			getServletContext().getRequestDispatcher("/RRHH.jsp").forward(req,resp);;
		}else {
			getServletContext().getRequestDispatcher("/index.html").forward(req,resp);
		}
			
			
}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
//Integer ano = date.get(Calendar.YEAR);
//Integer mes = date.get(Calendar.MONTH);
//Integer dia = date.get(Calendar.DAY_OF_MONTH);
//String fano = Integer.toString(ano); 
//String fmes = Integer.toString(mes);
//String fdia = Integer.toString(dia);
//String f = fano + "-"+ fmes+"-" + fdia;
//System.out.println(f);
//('dia' + 'mes' + 'ano');
//for(Trabajador worker: trabajadores) {
//	if(worker.getPassword().contentEquals(password) && worker.getEmail().contentEquals(email)) {
//		req.getSession().setAttribute("registros", registros);
//		req.getSession().setAttribute("worker", worker);
//		Trabajador trabajador = TrabajadorDAOImplementation.getInstance().read(email);
//		if( null != trabajador) {
//			if (registros.size() == 0){
//				System.out.println(3);
//				Registro registro = new Registro();
//				registro.setWorker(trabajador);
//				registro.setHoraEntrada(horaEntrada);
//				registro.setHoraSalida(horaSalida);
//				RegistroDAOImplementation.getInstance().update(registro);
//				getServletContext().getRequestDispatcher("/Trabajador.jsp").forward(req,resp);
//				break;
//			}else {
//			for(Registro regi: registros) {
//				System.out.println(0);
//				if(regi.getHoraEntrada().compareTo(horaEntrada) == 0 && regi.getHoraSalida().compareTo(horaSalida) == 0) {
//					System.out.println(1);
//					break;
//				}else if (regi.getHoraEntrada().compareTo(horaEntrada) != 0 && regi.getHoraSalida().compareTo(horaSalida) == 0){
//					System.out.println(2);
//					break;
//				}else {
//					System.out.println(4);
//					Registro registro = new Registro();
//					registro.setWorker(trabajador);
//					registro.setHoraEntrada(horaEntrada);
//					registro.setHoraSalida(horaSalida);
//					RegistroDAOImplementation.getInstance().update(registro);
//					break;
//				}
//			}
//			}
//		getServletContext().getRequestDispatcher("/Trabajador.jsp").forward(req,resp);
//		break;
//	}
//	
//}
//for(GestorDeProyectos gestor: gestores) {
//	if(gestor.getpassword().contentEquals(password) && gestor.getEmail().contentEquals(email)) {
//		req.getSession().setAttribute("registros", registros);
//		getServletContext().getRequestDispatcher("/Gestor.jsp").forward(req,resp);
//		break;
//	}
//}
//if( ADMIN_EMAIL.equals(email) && ADMIN_PASSWORD.equals(password)) {
//	req.getSession().setAttribute("admin", true);
//	req.getSession().setAttribute("registros", registros);
//	getServletContext().getRequestDispatcher("/Trabajador.jsp").forward(req,resp);
//}
//}
