package in.anand.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import in.anand.bindings.Book;
import in.anand.rest.BookRestControlleer;
import in.anand.service.BookService;

@WebMvcTest(value=BookRestControlleer.class)
public class BookRestControllerTest {
	
	@MockBean
	private BookService bookService;
	
	@Autowired
	private MockMvc mockmvc;
	
	
	@Test
	public void bookTest() throws Exception
	{
	
		when(bookService.saveBook(ArgumentMatchers.any())).thenReturn(true);
		
		Book book =new Book(101,"spring",450.00);
		ObjectMapper objmap=new ObjectMapper();
		String valueAsString = objmap.writeValueAsString(book);
		
		MockHttpServletRequestBuilder mockHttpServletRequestBuilder = MockMvcRequestBuilders.post("/book")
		.contentType(MediaType.APPLICATION_JSON)
		.content(valueAsString);
		
		ResultActions resultActions = mockmvc.perform(mockHttpServletRequestBuilder);
		MvcResult mvcResult = resultActions.andReturn();
		MockHttpServletResponse response = mvcResult.getResponse();
		int status = response.getStatus();
		assertEquals(201,status);
	}

}
