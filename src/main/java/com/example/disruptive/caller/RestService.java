package com.example.disruptive.caller;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.disruptive.bankaccount.Account;
import com.example.disruptive.bankaccount.AccountRequest;
import com.example.disruptive.bankaccount.AccountResponse;
import com.example.disruptive.postings.PostingRequest;
import com.example.disruptive.user.Customer;
import com.example.disruptive.user.CustomerRequest;
import com.example.disruptive.user.CustomerResponse;

@Service
public class RestService {
	
	private final RestTemplate restTemplate;
	
	public RestService(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate = restTemplateBuilder.build();
	}
	
	public CustomerRequest createCustomerOnVault(CustomerRequest newCustomer) {
	    String url = "https://core-api-demo.rhino.tmachine.io/v1/customers";

	    // create headers
	    HttpHeaders headers = new HttpHeaders();
	    // set `content-type` header
	    headers.setContentType(MediaType.APPLICATION_JSON);
	    // set `accept` header
	    headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
	    headers.set("X-Auth-Token", "A0007387918138424947469!/5Q+IX/CR4e8OU7nI3hgP6QpnhLaPqhxu9eVkAFXqHbIJm/1Bn2QH+RZ4F1VOUu1ImEqPj2HuyKN9mQP+ZZzVicWmnU=");
	    
	    // build the request
	    HttpEntity<CustomerRequest> entity = new HttpEntity<>(newCustomer, headers);
	    // send POST request
	    return restTemplate.postForObject(url, entity, CustomerRequest.class);
	}
	
	//Tramite mail (puoi valutare di cambiarlo nel numero di telefono)
	public Customer retriveCustomerOnVault(String email) {
	    String url = "https://core-api-demo.rhino.tmachine.io/v1/customers?email_identifiers=" + email +"&page_size=1";
	 // create headers
	    HttpHeaders headers = new HttpHeaders();
	    // set `content-type` header
	    headers.setContentType(MediaType.APPLICATION_JSON);
	    // set `accept` header
	    headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
	    headers.set("X-Auth-Token", "A0007387918138424947469!/5Q+IX/CR4e8OU7nI3hgP6QpnhLaPqhxu9eVkAFXqHbIJm/1Bn2QH+RZ4F1VOUu1ImEqPj2HuyKN9mQP+ZZzVicWmnU=");
	    
	    HttpEntity request = new HttpEntity(headers);
	    ResponseEntity<CustomerResponse> response = this.restTemplate.exchange(url, HttpMethod.GET, request, CustomerResponse.class);
	    return response.getBody().getSingleCustomer(0);
	}
	
	//Crea l'Account su Vault associato al Customer.
	public void createAccountOnVault(AccountRequest newAccountRequest) {
	    String url = "https://core-api-demo.rhino.tmachine.io/v1/accounts";
	    
	    // create headers
	    HttpHeaders headers = new HttpHeaders();
	    // set `content-type` header
	    headers.setContentType(MediaType.APPLICATION_JSON);
	    // set `accept` header
	    headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
	    headers.set("X-Auth-Token", "A0007387918138424947469!/5Q+IX/CR4e8OU7nI3hgP6QpnhLaPqhxu9eVkAFXqHbIJm/1Bn2QH+RZ4F1VOUu1ImEqPj2HuyKN9mQP+ZZzVicWmnU=");
	    // build the request
	    HttpEntity<AccountRequest> entity = new HttpEntity<>(newAccountRequest, headers);
	    // send POST request
	    restTemplate.postForObject(url, entity, AccountRequest.class);
	}
	
	
	//Recupera l'Account da Vault partendo dal customer_id
	public Account retrieveAccountOnVault(String customer_id) {
		String url = "https://core-api-demo.rhino.tmachine.io/v1/accounts?stakeholder_id=" + customer_id +"&page_size=1";
		 // create headers
		    HttpHeaders headers = new HttpHeaders();
		    // set `content-type` header
		    headers.setContentType(MediaType.APPLICATION_JSON);
		    // set `accept` header
		    headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		    headers.set("X-Auth-Token", "A0007387918138424947469!/5Q+IX/CR4e8OU7nI3hgP6QpnhLaPqhxu9eVkAFXqHbIJm/1Bn2QH+RZ4F1VOUu1ImEqPj2HuyKN9mQP+ZZzVicWmnU=");
		    
		    HttpEntity request = new HttpEntity(headers);
		    ResponseEntity<AccountResponse> response = this.restTemplate.exchange(url, HttpMethod.GET, request, AccountResponse.class);
		    return response.getBody().getAccount(0);
	}
	
	//Serve per trasferire soldi dal PnL (account interno della banca) all'account del Cliente.
	public void foundAccountWithInitialBalance(PostingRequest newPostingRequest) {
		String url = "https://core-api-demo.rhino.tmachine.io/v1/posting-instruction-batches:asyncCreate";
	    // create headers
	    HttpHeaders headers = new HttpHeaders();
	    // set `content-type` header
	    headers.setContentType(MediaType.APPLICATION_JSON);
	    // set `accept` header
	    headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
	    headers.set("X-Auth-Token", "A0007387918138424947469!/5Q+IX/CR4e8OU7nI3hgP6QpnhLaPqhxu9eVkAFXqHbIJm/1Bn2QH+RZ4F1VOUu1ImEqPj2HuyKN9mQP+ZZzVicWmnU=");
	    // build the request
	    HttpEntity<PostingRequest> entity = new HttpEntity<>(newPostingRequest, headers);
	    // send POST request
	    restTemplate.postForObject(url, entity, PostingRequest.class);
	}
	
	public Customer retriveCustomerOnVaultByPhone(String phone) {
			String url = "https://core-api-demo.rhino.tmachine.io/v1/customers?phone_identifiers=" + phone +"&page_size=1";
			// create headers
		    HttpHeaders headers = new HttpHeaders();
		    // set `content-type` header
		    headers.setContentType(MediaType.APPLICATION_JSON);
		    // set `accept` header
		    headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		    headers.set("X-Auth-Token", "A0007387918138424947469!/5Q+IX/CR4e8OU7nI3hgP6QpnhLaPqhxu9eVkAFXqHbIJm/1Bn2QH+RZ4F1VOUu1ImEqPj2HuyKN9mQP+ZZzVicWmnU=");
		    
		    HttpEntity request = new HttpEntity(headers);
		    ResponseEntity<CustomerResponse> response = this.restTemplate.exchange(url, HttpMethod.GET, request, CustomerResponse.class);
		    return response.getBody().getSingleCustomer(0);
	}
	
	public void transferMoneyBetweenCustomersAccounts(PostingRequest newPostingRequest) {
		String url = "https://core-api-demo.rhino.tmachine.io/v1/posting-instruction-batches:asyncCreate";
	    // create headers
	    HttpHeaders headers = new HttpHeaders();
	    // set `content-type` header
	    headers.setContentType(MediaType.APPLICATION_JSON);
	    // set `accept` header
	    headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
	    headers.set("X-Auth-Token", "A0007387918138424947469!/5Q+IX/CR4e8OU7nI3hgP6QpnhLaPqhxu9eVkAFXqHbIJm/1Bn2QH+RZ4F1VOUu1ImEqPj2HuyKN9mQP+ZZzVicWmnU=");
	    // build the request
	    HttpEntity<PostingRequest> entity = new HttpEntity<>(newPostingRequest, headers);
	    // send POST request
	    restTemplate.postForObject(url, entity, PostingRequest.class);
	}
}
