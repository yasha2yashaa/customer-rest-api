package com.hsbc.customerrestapi;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerRestApiApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Test
	public void whenCustomerDoesNotExistsThen404IsReceived() throws IOException {
		// Given
		HttpUriRequest request = new HttpGet( "localhost:8080/api/customers/1" );
		// When
		HttpResponse response = HttpClientBuilder.create().build().execute( request );
		// Then
		assertThat(
				response.getStatusLine().getStatusCode(),
				equalTo(HttpStatus.SC_NOT_FOUND));
	}

}
