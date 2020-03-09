package com.hibernate.demo.HibernateDemo;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

//@Entity(name="user_table")
@Entity
//@Table(name="user")// this will create the table named user
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class Student {
	
	@Id
	private int uid;
	@Column(name="uname") //this will rename the name column in database to uname
//	@Transient //this will not add the name column in database 
	private Name name;
	
	public int getUid() {
		return uid;
	}
	public Name getName() {
		return name;
	}
	public void setName(Name name) {
		this.name = name;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	
	@Override
	public String toString() {
		return "Student [uid=" + uid + ", name=" + name + "]";
	}
}
