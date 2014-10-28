package edu.soa.monitorserver.client;

import java.util.List;

import edu.soa.monitorserver.client.Dao.ProcessDAO;
import edu.soa.monitorserver.client.model.Proceso;

public class Prueba {

	public static void main(String[] args) {
		
		ProcessDAO pd = new ProcessDAO("http://localhost:8080/proceso");
		
		List<Proceso> lp;
		lp = pd.obtenerProcesos();
		
		for(Proceso p : lp){
			System.out.println(p);
		}

		pd.killProceso("-2966");
		
		System.out.println("Fin");
		
	}

}
