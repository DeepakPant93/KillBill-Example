package com.coredge.killbill.utils;

import static com.coredge.killbill.utils.KillBillConstants.API_KEY_PARAMETER;
import static com.coredge.killbill.utils.KillBillConstants.API_SECRET_PARAMETER;
import static com.coredge.killbill.utils.KillBillConstants.CREATED_BY_PARAMETER;
import static com.coredge.killbill.utils.KillBillConstants.PASSWORD_PARAMETER;
import static com.coredge.killbill.utils.KillBillConstants.USERNAME_PARAMETER;

import org.killbill.billing.client.KillBillHttpClient;
import org.killbill.billing.client.RequestOptions;
import org.killbill.billing.client.api.gen.AccountApi;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class KillBillUtils {

	@Value("${kill.bill.url}")
	private String killBillUrl;

	public KillBillHttpClient killBillHttpClient() {

		String username = MDC.get(USERNAME_PARAMETER);
		String password = MDC.get(PASSWORD_PARAMETER);
		String apiKey = MDC.get(API_KEY_PARAMETER);
		String apiSecret = MDC.get(API_SECRET_PARAMETER);

		return new KillBillHttpClient(killBillUrl, username, password, apiKey, apiSecret);
	}

	public RequestOptions requestOptions() {
		return RequestOptions.builder().withCreatedBy(MDC.get(CREATED_BY_PARAMETER)).build();
	}

	public AccountApi accountApi() {
		return new AccountApi(killBillHttpClient());
	}
}
