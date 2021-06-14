package com.coredge.kilbill.model;

import java.util.UUID;

import org.joda.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Builder
@NoArgsConstructor
@Data
public class InvoiceRequest {

	private String accountNumber;
	private LocalDate startDate;
	private LocalDate endDate;

	public UUID getAccountNumber() {
		return UUID.fromString(accountNumber);
	}

}
