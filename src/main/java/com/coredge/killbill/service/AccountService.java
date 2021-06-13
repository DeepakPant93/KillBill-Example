package com.coredge.killbill.service;

import org.killbill.billing.client.KillBillClientException;
import org.killbill.billing.client.model.gen.Account;
import org.springframework.stereotype.Service;

import com.coredge.killbill.utils.KillBillUtils;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@AllArgsConstructor
public class AccountService {

	private KillBillUtils killBillUtils;

	public Account create(Account request) {
		Account account = null;
		try {
			account = createAccount(request);
		} catch (KillBillClientException exp) {
			log.error("Exception occured while creating an account in kill-bill", exp);
		}
		return account;
	}

	private Account createAccount(Account request) throws KillBillClientException {
		return killBillUtils.accountApi().createAccount(request, killBillUtils.requestOptions());
	}
}
