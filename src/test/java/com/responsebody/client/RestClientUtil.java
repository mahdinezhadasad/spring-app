package com.responsebody.client;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.responsebody.domain.Book;

public class RestClientUtil {

	public void getBookDemoABC() throws URISyntaxException {
		URI uri = new URI("http://localhost:8080/bookABC");
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Book[]> resEntity = restTemplate.getForEntity(uri, Book[].class);
		System.out.println(resEntity.getStatusCode());
		for (Book b : resEntity.getBody()) {
			System.out.println(b);
		}
	}

	public void getBookDemoXYZ() throws URISyntaxException {
		URI uri = new URI("http://localhost:8080/bookXYZ");
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_XML));
		RequestEntity<List<Book>> reqEntity = new RequestEntity<>(headers, HttpMethod.GET, uri);
		ParameterizedTypeReference<List<Book>> typeRef = new ParameterizedTypeReference<List<Book>>() {
		};
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<List<Book>> resEntity = restTemplate.exchange(reqEntity, typeRef);
		System.out.println(resEntity.getStatusCode());
		for (Book b : resEntity.getBody()) {
			System.out.println(b);
		}
	}

	public static void main(String args[]) throws URISyntaxException {
		RestClientUtil util = new RestClientUtil();
		util.getBookDemoABC();
		util.getBookDemoXYZ();
	}
}