package com.deliverssmille.ahirsmile;

import java.util.HashMap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.deliverssmille.ahirsmile.model.Quote;
import com.deliverssmille.ahirsmile.model.Student;

@SpringBootApplication
public class AhirsmileApplication {

	private static final Logger log = LoggerFactory.getLogger(AhirsmileApplication.class);

/*	public static void main(String[] args) {
		SpringApplication.run(AhirsmileApplication.class, args);
	}*/
	
	 public static HashMap<Long,Student> hmStudent;
	 
	   public static void main(String[] args) {
	      hmStudent=new HashMap<Long,Student>();
	 
	      Student one=new Student("John","math");
	      hmStudent.put(new Long(one.getId()),one);
	 
	      SpringApplication.run(AhirsmileApplication.class, args);
	 
	      Student two=new Student("Jane","history");
	      hmStudent.put(new Long(two.getId()),two);
	      
	      RestTemplate restTemplate = new RestTemplate();
	        Quote quote = restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/random", Quote.class);
	        log.info(quote.toString());
	   }
	   
//		@Bean
//		public RestTemplate restTemplate(RestTemplateBuilder builder) {
//			return builder.build();
//		}

//		@Bean
//		public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
//			return args -> {
//				Quote quote = restTemplate.getForObject(
//						"http://gturnquist-quoters.cfapps.io/api/random", Quote.class);
//				log.info(quote.toString());
//			};
//		}
}
