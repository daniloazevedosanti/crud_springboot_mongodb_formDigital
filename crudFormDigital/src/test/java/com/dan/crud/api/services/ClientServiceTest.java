package com.dan.crud.api.services;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.dan.crud.api.CrudFormDigitalApplicationTests;
import com.dan.crud.api.repositories.ClientRepository;

public class ClientServiceTest extends CrudFormDigitalApplicationTests {

	private final String BASE_API_URL = "/api/digital/cliente";

	private MockMvc mockMvc;

	@Autowired
	ClientRepository clientRepository;

	@Before
	public void setUp() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(clientRepository).build();
	}

	@Test
	public void testGETClientResource() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.get(BASE_API_URL)).andExpect(MockMvcResultMatchers.status().isOk());
	}

}
