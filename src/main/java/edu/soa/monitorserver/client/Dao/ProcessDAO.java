package edu.soa.monitorserver.client.Dao;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import edu.soa.monitorserver.client.model.Proceso;

public class ProcessDAO {

	private String urlDestino;
	
	public ProcessDAO(String urlDestino){
		this.urlDestino = urlDestino;
	}
	
	/**Metodo para obtener los procesos corriendo en el servidor
	 * 
	 * @return lista de procesos
	 */
	public List<Proceso> obtenerProcesos(){
		
		RestTemplate restTemplate = new RestTemplate();
		
		restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
		
		ResponseEntity<Proceso[]> array = restTemplate.getForEntity(this.urlDestino+"/proceso", Proceso[].class);
		
		List<Proceso> lista = Arrays.asList(array.getBody());
		
		return lista;
	}

	/**Metodo para terminar la ejecucion de un proceso en el servior
	 * 
	 * @param pid
	 */
	public void killProceso(String pid){
		
		RestTemplate restTemplate = new RestTemplate();
		
		restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
		
		restTemplate.delete(urlDestino+"/"+pid);	
	}
}
