package com.deliverssmille.ahirsmile.model;

import org.apache.commons.math3.random.RandomDataGenerator;
import org.springframework.data.annotation.Id;

import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBObject;

public class StudentManual {


    private long id;
	private String name;
	private String subject;
	//private long count;
	int lLimit=1;
	long rLimit=100L;
	public StudentManual() {
	}

	public StudentManual( String name, String subject,long id) {
		super();
		this.id = new RandomDataGenerator().nextLong(lLimit, rLimit);
		this.name = name;
		this.subject = subject;
		//this.count=count;
	}

	public long getId() {
		return id;
	}
	/*public long getId() {
		return id;
	}*/
	public String getName() {
		return name;
	}


	
	public String getSubject() {
		return subject;
	}

	public void setId(long id) {
		this.id = id;
	}





/*	public void setId(long id) {
		this.id = id;
	}*/

	public void setName(String name) {
		this.name = name;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	//add for converting java object to mongo object
    public DBObject toDBObject(){
    	
    	BasicDBObjectBuilder documentBuilder = BasicDBObjectBuilder
    			.start("id", id)
    			.append("name", name)
    			.append("subject", subject);
    			
		return documentBuilder.get();
    	
    	
    }
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", subject=" + subject + "]";
	}



}
