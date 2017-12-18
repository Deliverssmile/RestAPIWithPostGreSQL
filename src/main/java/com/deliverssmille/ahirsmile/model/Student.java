package com.deliverssmille.ahirsmile.model;

import java.util.Date;

public class Student {

	private long id;
	private String name;
	private String subject;

	public Student() {
	}

	public Student( String name, String subject) {
		super();
		this.id = (new Date()).getTime();
		this.name = name;
		this.subject = subject;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getSubject() {
		return subject;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", subject=" + subject + "]";
	}

}
