package com.example.order_service.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="orders")
public class Order {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	    
//	    @JsonIgnore
//	    @OneToOne(mappedBy = "order")
//	    private Payment payment;
//	    
	    private LocalDateTime orderDate;
//	    
//	    @ManyToOne
//	    @JsonIgnore
//	    @JoinColumn(name = "customer_id")
//	    private Customer customer;
//	    
//	    @ManyToMany(mappedBy = "orders")
//	    private List<Product> products = new ArrayList();
//	    

	    // Getters and Setters
	    

//		public Customer getCustomer() {
//			return customer;
//		}
//
//		public void setCustomer(Customer customer) {
//			this.customer = customer;
//		}

		public Order() {
	    	super();
	    }

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

//		public Payment getPayment() {
//			return payment;
//		}
//
//		public void setPayment(Payment payment) {
//			this.payment = payment;
//		}
//
		public LocalDateTime getOrderDate() {
			return orderDate;
		}

		public void setOrderDate(LocalDateTime orderDate) {
			this.orderDate = orderDate;
		}

		@Override
		public String toString() {
			return "Order [id=" + id +   ", orderDate=" + orderDate + "]";
		}
}
