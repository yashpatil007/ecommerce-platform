package com.sheryians.major.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "orders") 
public class Order {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String firstName;
	    private String lastName;
	    private String addressLine1;
	    private String addressLine2;
	    private String city;
	    private String zipCode;
	    private String phone;
	    private String email;
	    private String additionalInfo;
	    private Double totalAmount;
		public Order() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Order(Long id, String firstName, String lastName, String addressLine1, String addressLine2, String city,
				String zipCode, String phone, String email, String additionalInfo, Double totalAmount) {
			super();
			this.id = id;
			this.firstName = firstName;
			this.lastName = lastName;
			this.addressLine1 = addressLine1;
			this.addressLine2 = addressLine2;
			this.city = city;
			this.zipCode = zipCode;
			this.phone = phone;
			this.email = email;
			this.additionalInfo = additionalInfo;
			this.totalAmount = totalAmount;
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		public String getAddressLine1() {
			return addressLine1;
		}
		public void setAddressLine1(String addressLine1) {
			this.addressLine1 = addressLine1;
		}
		public String getAddressLine2() {
			return addressLine2;
		}
		public void setAddressLine2(String addressLine2) {
			this.addressLine2 = addressLine2;
		}
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public String getZipCode() {
			return zipCode;
		}
		public void setZipCode(String zipCode) {
			this.zipCode = zipCode;
		}
		public String getPhone() {
			return phone;
		}
		public void setPhone(String phone) {
			this.phone = phone;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getAdditionalInfo() {
			return additionalInfo;
		}
		public void setAdditionalInfo(String additionalInfo) {
			this.additionalInfo = additionalInfo;
		}
		public Double getTotalAmount() {
			return totalAmount;
		}
		public void setTotalAmount(Double totalAmount) {
			this.totalAmount = totalAmount;
		}
		@Override
		public String toString() {
			return "Order [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", addressLine1="
					+ addressLine1 + ", addressLine2=" + addressLine2 + ", city=" + city + ", zipCode=" + zipCode
					+ ", phone=" + phone + ", email=" + email + ", additionalInfo=" + additionalInfo + ", totalAmount="
					+ totalAmount + "]";
		}
	    
}
