package youngcapital.hotel.JavaBackendHotel;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import youngcapital.hotel.JavaBackendHotel.controller.AccountRepository;
import youngcapital.hotel.JavaBackendHotel.controller.AccountService;
import youngcapital.hotel.JavaBackendHotel.domain.Account;


import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@AutoConfigureMockMvc
class JavaBackendHotelApplicationTests {
	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private AccountService accountService;

	@MockBean
	private AccountRepository accountRepository;

	@BeforeEach
	public void setUp(){
		Account[] accounts ={
				new Account(),
		};
		when(accountService.getAllAccounts()).thenReturn(List.of(accounts));
	}


	@Test
	void contextLoads() {
	}

	@Test
	public void accountEndpointReturnsObjectArray()throws Exception{
		this.mockMvc.perform(get("/accounts")).andDo(print()).andExpect(status().isOk()).andExpect(content()
				.string(containsString("[{\"id\":0,\"email\":null,\"password\":null,\"points\":0,\"birthDate\":null,\"userType\":0}]")));
	}



}
