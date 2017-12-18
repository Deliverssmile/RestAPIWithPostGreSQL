package com.deliverssmille.ahirsmile.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.deliverssmille.ahirsmile.AhirsmileApplication;
import com.deliverssmille.ahirsmile.model.Quote;
import com.deliverssmille.ahirsmile.model.Student;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping(value="/rest/student")
public class StudentService {
	
	  @RequestMapping(value="/",method = RequestMethod.GET)
	   public HashMap<Long,Student> getAllStudents(){
	      return AhirsmileApplication.hmStudent;
	   }
	  
	  @RequestMapping(value="/quotes",method = RequestMethod.GET)
	   public Quote getAllQuote(){
	      RestTemplate restTemplate = new RestTemplate();
	        Quote quote = restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/random", Quote.class);
	      //  log.info(quote.toString());
			return quote;
	   
	     // return AhirsmileApplication.hmStudent;
	   }
	  
	  @RequestMapping(value="/add",method= RequestMethod.POST)
	  public Student addStudent(@RequestParam(value="name")String name,@RequestParam(value="subject",defaultValue="unknown")String subject){
		
		  Student student=new Student(name,subject);
		  
		  AhirsmileApplication.hmStudent.put(new Long(student.getId()), student);
		  
		return student;
		  
		  
	  }
	  
	  @RequestMapping(value="/update",method = RequestMethod.PUT)
	  public Student updateStudent(@RequestBody Student student) throws Exception {

	     if(AhirsmileApplication.hmStudent.containsKey(new Long(student.getId()))){
	    	 AhirsmileApplication.hmStudent.put(new Long(student.getId()),student);
	     }else{
	    	 
	    	 AhirsmileApplication.hmStudent.put(new Long(student.getId()), student); 
	       // throw new Exception("Student "+student.getId()+" does not exists");
	     }

	     return student;
	  } 
	  
	  
	  
	  @RequestMapping(value="/addNew",method = RequestMethod.POST)
	  public Student addNewStudent(@RequestBody Student student) throws Exception {

	     if(AhirsmileApplication.hmStudent.containsKey(new Long(student.getId()))){
	    	 AhirsmileApplication.hmStudent.put(new Long(student.getId()),student);
	     }else{
	    	 
	    	 AhirsmileApplication.hmStudent.put(new Long(student.getId()), student); 
	       // throw new Exception("Student "+student.getId()+" does not exists");
	     }

	     return student;
	  } 
	  
	  @RequestMapping(value="/delete/{id}",method = RequestMethod.DELETE)
	  public Student deleteStudent(@PathVariable long id) throws Exception {
	   
	     Student student;
	   
	     if(AhirsmileApplication.hmStudent.containsKey(new Long(id))){
	        student=AhirsmileApplication.hmStudent.get(new Long(id));
	       // AhirsmileApplication.hmStudent.remove(new Long(id));
	     }else{
	        throw new Exception("Student "+id+" does not exists");
	     }
	     return student;
	  }
	  
	  @RequestMapping(value="/{id}",method = RequestMethod.GET)
	  public Student getStudent(@PathVariable long id) throws Exception {
	   
	     Student student;
	   
	     if(AhirsmileApplication.hmStudent.containsKey(id)){
	    	 
	    	 System.out.println("Come in this method");
	        student=AhirsmileApplication.hmStudent.get(new Long(id));
	      //  AhirsmileApplication.hmStudent.remove(new Long(id));
	     }else{
	        throw new Exception("Student "+id+" does not exists");
	     }
	     return student;
	  }
	  
	  
	  @RequestMapping(value="/anyquotes",method = RequestMethod.GET)
	   public Quote getAnyQuoteUsingHttp(){
		  String quote = null;
		  Quote quote1 = null;
		  try {

				URL url = new URL("http://gturnquist-quoters.cfapps.io/api/random");
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setRequestMethod("GET");
				conn.setRequestProperty("Accept", "application/json");

				if (conn.getResponseCode() != 200) {
					throw new RuntimeException("Failed : HTTP error code : "
							+ conn.getResponseCode());
				}

				BufferedReader br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));

				
				System.out.println("Output from Server .... \n");
				while ((quote = br.readLine()) != null) {
					System.out.println(quote);
					ObjectMapper mapper = new ObjectMapper();
					 quote1=mapper.readValue(quote, Quote.class);
				}

				conn.disconnect();

			  } catch (MalformedURLException e) {

				e.printStackTrace();

			  } catch (IOException e) {

				e.printStackTrace();

			  }
			return quote1;
	   
	     
	   }
	  
	  
	  

}
