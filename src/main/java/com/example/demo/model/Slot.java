package com.example.demo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "slots")
public class Slot {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	
	@Column(name = "start_time")
	private Date start_time = new Date();
	
	@Column(name = "end_time")
	private Date end_time = new Date();
	
	@Column(name = "is_booked")
	private boolean isBooked;
	
	public Slot() {
		
	}
	
	public Slot(Date start_time, Date end_time, boolean isBooked) {
		super();
		this.start_time = start_time;
		this.end_time = end_time;
		this.isBooked = isBooked;
	}
	
	
	public long getId() {
		return id;
	}

	public Date getStart_time() {
		return start_time;
	}
	
	public void setStart_time(Date start_time) {
		this.start_time = start_time;
	}
	
	public Date getEnd_time() {
		return end_time;
	}
	
	public void setEnd_time(Date end_time) {
		this.end_time = end_time;
	}
	
	public boolean isBooked() {
		return isBooked;
	}
	
	public void setBooked(boolean isBooked) {
		this.isBooked = isBooked;
	}
	
}
