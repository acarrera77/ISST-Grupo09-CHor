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
import es.upm.dit.isst.trabajo.dao.TrabajadorDAOImplementation;

import es.upm.dit.isst.trabajo.model.Registro;
import es.upm.dit.isst.trabajo.model.Trabajador;


/**
 * Servlet implementation class EnviarHoraSalidaServlet
 */
@WebServlet("/EnviarHoraSalidaServlet")
public class EnviarHoraSalidaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnviarHoraSalidaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Date horaSalida = new Date();
		Date horaSalidaCompara = new Date(130, 0, 1);
		
		List<Trabajador> trabajadores = (List<Trabajador>) TrabajadorDAOImplementation.getInstance().readAll();
		List<Registro> registros = (List<Registro>) RegistroDAOImplementation.getInstance().readAll();
		
		for (Registro regi: registros) {
			if(regi.getHoraSalida().compareTo(horaSalidaCompara) == 0 ) { //|| regi.getWorker().equals(email)
				regi.setHoraSalida(horaSalida);
				List<Registro> lr = new ArrayList<Registro>();
				lr.addAll((List<Registro>)
									req.getSession().getAttribute("registros"));
				lr.add(regi);
				req.getSession().setAttribute("registros", lr);
				System.out.println(registros);
				RegistroDAOImplementation.getInstance().update(regi);
				break;
			}
		}
		registros.remove(0);
		
		getServletContext().getRequestDispatcher("/Trabajador.jsp").forward(req,resp);
		
	}
		

		
	}


//while(true) {
//	for(Registro regis: Registros) {
//		if(regis.getId().contentEquals(id)) {
//			req.getSession().setAttribute("registros", registros);
//			break;
//		}
//		
//	}
//}	

//String horaSalida = req.getParameter("horaSalida");
//
//
//List <Registro> lr2 = new ArrayList<Registro>();
//lr2.addAll((List<Registro>)
//		req.getSession().getAttribute("registros"));
////
////Registro registro = new Registro();
////Integer id = registro.getId();
////registro.setId(id);
////System.out.println(id);
////registro = lr2.get(id);
////System.out.println(registro);
////
////Integer id = lr2.;
//
////for(int i=1; i<lr2.size();i++) {
////	
////}
//
//
//registro.setHoraSalida(horaSalida);
//RegistroDAOImplementation.getInstance().update(registro);
//
//lr2.add(registro);
//req.getSession().setAttribute("registros", lr2);
//getServletContext().getRequestDispatcher("/Trabajador.jsp").forward(req,resp);

//
//		Session session = SessionFactoryService.get().openSession();
//		session.beginTransaction();
//		TFG tfg = null;
//		Query q = session.createQuery("select registro from Registro registro where registro.id = :id"); //Objeto de clase consulta = Query
//		q.setParameter("id", id); //Parametros de consulta
//		List<Registro> registros = q.getResultList(); //Lista de resultados que si no es nula devolver el primero de ellos
//		if (registros.size() > 0)
//			registro = (Registro) (q.getResultList().get(0));
//		session.getTransaction().commit();
//		session.close();
//		return registro;

//Integer id = (Integer) req.getSession().getAttribute("id");


//if(id == req.getSession().getAttribute("id")) {
//	
//registro.setHoraSalida(horaSalida);
//
//}
//

