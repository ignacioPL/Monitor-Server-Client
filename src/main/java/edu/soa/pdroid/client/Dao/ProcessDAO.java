package edu.soa.pdroid.client.Dao;

import java.util.Arrays;
import java.util.List;

import edu.soa.pdroid.client.model.OsProcess;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

public class ProcessDAO {

	private String url;
	
	public ProcessDAO(String url){
        this.url = url;
	}

	public List<OsProcess> obtainProcess(){
		
		RestTemplate restTemplate = new RestTemplate();
		
		restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
		
		ResponseEntity<OsProcess[]> array = restTemplate.getForEntity(this.url+"/process", OsProcess[].class);
		
		return Arrays.asList(array.getBody());
	}

	public void killProcess(String pid){
		
		RestTemplate restTemplate = new RestTemplate();
		
		restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
		
		restTemplate.delete(url+"/process/"+pid);
	}
}
