package com.web.restfulwebservices.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="starttrd.merchant")
public class Merchant {

	@Id
	@Column(name="mchnt_id")
	private String mchntId;
	@Column(name="mchnt_name")
	private String mchntName;
	@Column(name="mchnt_city")
	private String mchntCity;
	
	public String getMchntId() {
		return mchntId;
	}
	public void setMchntId(String mchntId) {
		this.mchntId = mchntId;
	}
	public String getMchntName() {
		return mchntName;
	}
	public void setMchntName(String mchntName) {
		this.mchntName = mchntName;
	}
	public String getMchntCity() {
		return mchntCity;
	}
	public void setMchntCity(String mchntCity) {
		this.mchntCity = mchntCity;
	}
	@Override
	public String toString() {
		return "Merchant [mchntId=" + mchntId + ", mchntName=" + mchntName + ", mchntCity=" + mchntCity + "]";
	}
	
	
	
	
}
