package com.unicard.usermanagement.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The persistent class for the user_order database table.
 * 
 */
@Entity
@Table(name = "user_order")
@NoArgsConstructor
@Getter
@Setter
public class Order implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 65981149772133526L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Long userId;

	private String razorpayPaymentId;

	private String razorpayOrderId;

	private String razorpaySignature;

}