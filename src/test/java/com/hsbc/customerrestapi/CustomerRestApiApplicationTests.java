package com.hsbc.customerrestapi;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CustomerRestApiApplication.class, webEnvironment = RANDOM_PORT)
public class CustomerRestApiApplicationTests {

	@LocalServerPort
	private int port;

	@Test
	public void contextLoads() {;
	}

	@Test
	public void whenGetCustomerDoesNotExistsThen404IsReceived() throws IOException {
		// Given
		HttpUriRequest request = new HttpGet(String.format("http://localhost:%s/api/customers/1", port));
		// When
		HttpResponse response = HttpClientBuilder.create().build().execute(request);
		// Then
		assertThat(
				response.getStatusLine().getStatusCode(),
				equalTo(HttpStatus.SC_NOT_FOUND));
	}
}
