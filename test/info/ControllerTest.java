package info;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.cbz.info.controller.UserController; 


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:/spring/spring-web.xml","classpath:/spring/spring-dao.xml","classpath:/spring/spring-service.xml"})
@WebAppConfiguration
public class ControllerTest {
	
	private MockMvc mockMvc;
	
	@Autowired
    private WebApplicationContext webApplicationContext;
	 @Before
	 public void setup() {
		 //单独配置
	  /*  InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
	    viewResolver.setSuffix(".action");
	    mockMvc = MockMvcBuilders.standaloneSetup(new UserController())
	                                 .setViewResolvers(viewResolver)
	                                 .build();*/
		//Mockito.reset(todoServiceMock);
	     mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	        
	}
	@Test
	public void testLoginPage() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get("/user/login")).
		andExpect(MockMvcResultMatchers.view().name("/user/login"));
		
		
	}

}
