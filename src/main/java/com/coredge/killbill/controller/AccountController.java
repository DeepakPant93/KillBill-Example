package com.coredge.killbill.controller;

import org.killbill.billing.client.model.gen.Account;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.coredge.killbill.service.AccountService;

import io.swagger.annotations.ApiImplicitParam;
import lombok.AllArgsConstructor;

@RestController("/kill-bill")
@AllArgsConstructor
public class AccountController {

	private AccountService accountService;

	@PostMapping("/account")
	@ApiImplicitParam(name = "created-by", required = true, paramType = "header", example = "deepakp", dataTypeClass = String.class)
	public ResponseEntity<Account> createAccount(@RequestBody Account request) {
		return ResponseEntity.ok(accountService.create(request));
	}

}
