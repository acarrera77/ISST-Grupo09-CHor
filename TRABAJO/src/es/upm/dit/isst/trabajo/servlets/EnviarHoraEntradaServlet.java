package es.upm.dit.isst.trabajo.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import es.upm.dit.isst.trabajo.dao.RegistroDAOImplementation;
import es.upm.dit.isst.trabajo.dao.SessionFactoryService;
import es.upm.dit.isst.trabajo.dao.TrabajadorDAOImplementation;
import es.upm.dit.isst.trabajo.model.Registro;
import es.upm.dit.isst.trabajo.model.Trabajador;

/**
 * Servlet implementation class EnviarHoraEntradaServlet
 */
@WebServlet("/EnviarHoraEntradaServlet")
public class EnviarHoraEntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnviarHoraEntradaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Date horaEntrada = new Date();
		Date horaSalida = new Date(130, 0, 1);
		
		Trabajador trabajador = (Trabajador) req.getSession().getAttribute("trabajador");
		Registro registro = new Registro();
		registro.setHoraEntrada(horaEntrada);
		registro.setHoraSalida(horaSalida);
		registro.setWorker(trabajador);
		RegistroDAOImplementation.getInstance().update(registro);
		getServletContext().getRequestDispatcher("/Trabajador.jsp").forward(req,resp);
				
	}

}


//int contador = 0;
//
//List<Trabajador> lt = new ArrayList <Trabajador>();
//Integer lttotal = lt.size() * 31;
//for(int i = 1; i < lttotal; i++) {
//	
//	if(contador !=0) { 
//		contador++;  //contador =+ contador
//	}
//}
//

//String Id = req.getParameter("Id"); No podemos hacerlo así. Tenemos que crear un bucle para que vaya generando ids e ir incrementando segun se crea.  


//if(Id == registro.getId()) {
//	Id = Id++;
//}
//registro.setId(Id);

//
//
//
//		if(registro.getId() == null) {
//			id = id;
//		}else {
//			int h = registro.getId();
//			id = h++;
//		}

//Random r = new Random();
//
//Integer idt = 500;
//Integer id = r.nextInt(idt);		
