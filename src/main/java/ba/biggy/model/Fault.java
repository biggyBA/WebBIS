package ba.biggy.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Fault {
	
	private int id;
	
	private String date;
	private String time;
	private String productType;
	private String serialNumber;
	private String ident;
	private String client;
	private String street;
	private String place;
	private String phoneOne;
	private String phoneTwo;
	private String faultDescription;
	private String note;
	private String serviceman;
	private String orderBy;
	private String typeOfService;
	private String status;
	private String priority;
	
	
	
	
	
	public Fault() {
		
	}
	
	
	public Fault(String date, String ident, String client) {
		this.date = date;
		this.ident = ident;
		this.client = client;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getIdent() {
		return ident;
	}


	public void setIdent(String ident) {
		this.ident = ident;
	}


	public String getClient() {
		return client;
	}


	public void setClient(String client) {
		this.client = client;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public String getTime() {
		return time;
	}


	public void setTime(String time) {
		this.time = time;
	}


	public String getProductType() {
		return productType;
	}


	public void setProductType(String productType) {
		this.productType = productType;
	}


	public String getSerialNumber() {
		return serialNumber;
	}


	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}


	public String getStreet() {
		return street;
	}


	public void setStreet(String street) {
		this.street = street;
	}


	public String getPlace() {
		return place;
	}


	public void setPlace(String place) {
		this.place = place;
	}


	public String getPhoneOne() {
		return phoneOne;
	}


	public void setPhoneOne(String phoneOne) {
		this.phoneOne = phoneOne;
	}


	public String getPhoneTwo() {
		return phoneTwo;
	}


	public void setPhoneTwo(String phoneTwo) {
		this.phoneTwo = phoneTwo;
	}


	public String getFaultDescription() {
		return faultDescription;
	}


	public void setFaultDescription(String faultDescription) {
		this.faultDescription = faultDescription;
	}


	public String getNote() {
		return note;
	}


	public void setNote(String note) {
		this.note = note;
	}


	public String getServiceman() {
		return serviceman;
	}


	public void setServiceman(String serviceman) {
		this.serviceman = serviceman;
	}


	public String getOrderBy() {
		return orderBy;
	}


	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}


	public String getTypeOfService() {
		return typeOfService;
	}


	public void setTypeOfService(String typeOfService) {
		this.typeOfService = typeOfService;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getPriority() {
		return priority;
	}


	public void setPriority(String priority) {
		this.priority = priority;
	}
	
	
	
	
	
	
}
