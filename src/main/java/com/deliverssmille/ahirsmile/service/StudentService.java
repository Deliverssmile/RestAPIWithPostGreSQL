package com.deliverssmille.ahirsmile.service;

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
	  
	  
	  

}
