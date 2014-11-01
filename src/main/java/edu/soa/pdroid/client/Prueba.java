package edu.soa.pdroid.client;

import java.util.List;

import edu.soa.pdroid.client.Dao.ProcessDAO;
import edu.soa.pdroid.client.model.Proceso;

public class Prueba {

	public static void main(String[] args) {
		
		ProcessDAO pd = new ProcessDAO("http://localhost:8080");
		
		List<Proceso> lp;
		lp = pd.obtenerProcesos();
		
		for(Proceso p : lp){
			System.out.println(p);
		}

		pd.killProceso("-2966");
		
		System.out.println("Fin");
		
	}

}
