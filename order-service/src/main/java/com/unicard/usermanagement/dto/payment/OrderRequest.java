package com.unicard.usermanagement.dto.payment;

import lombok.Data;

@Data
public class OrderRequest {
	private Long userID;
	private String customerName;
	private String email;
	private String phoneNumber;
	private String amount;
}
