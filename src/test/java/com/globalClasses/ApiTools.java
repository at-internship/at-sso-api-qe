package com.globalClasses;


import java.io.IOException;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpResponse;

import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

public class ApiTools {
	public String hostName = ApiPaths.SSO_API_JAVA_ENDPOINT;
	public ResponseEntity<String> response;
	public ResponseEntity<String> requestBody;
	public MediaType contentType = MediaType.APPLICATION_JSON;
	public RestTemplate restTemplate = new RestTemplate();
	public HttpHeaders headers = new HttpHeaders();
	
//	public ApiTools(String service, String env) {
//		getCredentials();
//	}
	
	public ResponseEntity<String> retrieve(String apiPath) {
//		SSLCertificateValidation.disable();
		try {
			
//			headers.add("Authorization", null);
			headers.add("User-Agent", "cheese");
			headers.setContentType(contentType);
			
			restTemplate.setErrorHandler(new ResponseErrorHandler() {
				
				@Override
				public boolean hasError(ClientHttpResponse response) throws IOException {
					return false;
				}
				
				@Override
				public void handleError(ClientHttpResponse response) throws IOException {
				}
			});
			HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
			response = restTemplate.exchange(hostName + apiPath, HttpMethod.GET, requestEntity, String.class);
		} catch (HttpClientErrorException e) {
			
			System.out.println(e.getMessage());
			response = new ResponseEntity<String>(((HttpStatusCodeException) e).getResponseBodyAsString(),((HttpStatusCodeException) e).getStatusCode());
		
		}
		
		return response;
	}
	
	public ResponseEntity<String> POSTMethod(String apiPath, String requestBody) {

		try {
		    HttpHeaders headers = new HttpHeaders();
			headers.add("OUser-Agent", "User-Agent");
			headers.add("Content-Type", "application/json");

			restTemplate.setErrorHandler(new ResponseErrorHandler() {
				
				@Override
				public boolean hasError(ClientHttpResponse response) throws IOException {
					return false;
				}
				
				@Override
				public void handleError(ClientHttpResponse response) throws IOException {
				}
			});

			HttpEntity<String> requestEntity = new HttpEntity<>(requestBody, headers);
			response = restTemplate.exchange(hostName + apiPath, HttpMethod.POST, requestEntity, String.class);	
		} catch (HttpClientErrorException e) {
			System.out.println(e.getMessage());
			response = new ResponseEntity<String>(((HttpStatusCodeException) e).getResponseBodyAsString(),((HttpStatusCodeException) e).getStatusCode());		
		}
		return response;
	}
}