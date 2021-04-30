package com.example.demo.controllers;

import com.example.demo.model.requests.CreateUserRequest;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.core.StringContains.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
public class UserIntegrationTest {

	@Autowired
	private MockMvc mockMvc;


	@Test
	public void testCreateRetrieveWithMockMVC() throws Exception {

		String json="{\n" +
			"    \"username\": \"testUser\",\n" +
			"    \"password\": \"testPassword\",\n" +
			"    \"confirmPassword\": \"testPassword\"\n" +
			"}";

		this.mockMvc.perform(post("/api/user/create").contentType(
			MediaType.APPLICATION_JSON).content(json)).andExpect(status().is2xxSuccessful());
		this.mockMvc.perform(get("/api/user/testUser")).andDo(print()).andExpect(status().isOk())
			.andExpect(content().string(containsString("testUser")));
	}

}

