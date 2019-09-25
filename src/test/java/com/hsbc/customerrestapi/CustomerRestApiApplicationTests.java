package com.hsbc.customerrestapi;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
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
		HttpUriRequest request = new HttpGet(getHostUriWithId(1));
		// When
		HttpResponse response = HttpClientBuilder.create().build().execute(request);
		// Then
		assertThat(
				response.getStatusLine().getStatusCode(),
				equalTo(HttpStatus.SC_NOT_FOUND));
	}

	@Test
	public void whenValidCustomerPostThen201IsReceived() throws IOException {
	    // Given
        String jsonString = "{\n" +
                "    \"name\": \"newCustomerName\",\n" +
                "    \"address\": {\n" +
                "        \"city\": \"cityName\",\n" +
                "        \"street\": \"streetName\",\n" +
                "        \"zipCode\": \"newZipCode\"\n" +
                "    }\n" +
                "}";
        StringEntity requestEntity = new StringEntity(
                jsonString,
                ContentType.APPLICATION_JSON);
        HttpPost postMethod = new HttpPost(getHostUri());
        postMethod.setEntity(requestEntity);
        // When
        HttpResponse response = HttpClientBuilder.create().build().execute(postMethod);
        // Then
        assertThat(
                response.getStatusLine().getStatusCode(),
                equalTo(HttpStatus.SC_CREATED));
    }

	@Test
	public void whenGetCustomerExistsThen200IsReceived() throws IOException {
		// Given
		String jsonString = "{\n" +
				"    \"name\": \"newCustomerName\",\n" +
				"    \"address\": {\n" +
				"        \"city\": \"cityName\",\n" +
				"        \"street\": \"streetName\",\n" +
				"        \"zipCode\": \"newZipCode\"\n" +
				"    }\n" +
				"}";
		StringEntity requestEntity = new StringEntity(
				jsonString,
				ContentType.APPLICATION_JSON);
		HttpPost postMethod = new HttpPost(getHostUri());
		postMethod.setEntity(requestEntity);
		HttpClientBuilder.create().build().execute(postMethod);
		HttpUriRequest getRequest = new HttpGet(getHostUriWithId(1));
		// When
		HttpResponse response = HttpClientBuilder.create().build().execute(getRequest);
		// Then
		assertThat(
				response.getStatusLine().getStatusCode(),
				equalTo(HttpStatus.SC_OK));
	}

	@Test
	public void whenInvalidCustomerPostThen409IsReceived() throws IOException {
		// Given
		String jsonString = "{\n" +
				"    \"invalidField1\": \"invalid\",\n" +
				"    \"invalidField2\": {\n" +
				"        \"dd\": \"cityName\",\n" +
				"        \"street\": \"streetName\"" +
				"    }\n" +
				"}";
		StringEntity requestEntity = new StringEntity(
				jsonString,
				ContentType.APPLICATION_JSON);
		HttpPost postMethod = new HttpPost(getHostUri());
		postMethod.setEntity(requestEntity);
		// When
		HttpResponse response = HttpClientBuilder.create().build().execute(postMethod);
		// Then
		assertThat(
				response.getStatusLine().getStatusCode(),
				equalTo(HttpStatus.SC_CONFLICT));
	}

	private String getHostUri() {
		return String.format("http://localhost:%s/api/customers", port);
	}

	private String getHostUriWithId(int id) {
	    return String.format("http://localhost:%s/api/customers/%s", port, id);
    }

}
