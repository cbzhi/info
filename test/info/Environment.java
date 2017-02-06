package info;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cbz.info.bean.Test1;
import com.cbz.info.bean.User;
import com.cbz.info.dao.BaseDao;
import com.cbz.info.dao.impl.BaseDaoImpl;
import com.mchange.v2.c3p0.ComboPooledDataSource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:/spring/spring-config.xml")
public class Environment {
	

	@Test
	public void test() throws SQLException {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:/spring/spring-config.xml");
		ComboPooledDataSource bean = ctx.getBean("dataSource", ComboPooledDataSource.class);
		Connection connection = bean.getConnection();
		PreparedStatement prepareStatement = connection.prepareStatement("select * from role");
		ResultSet executeQuery = prepareStatement.executeQuery();
		while(executeQuery.next()){
			System.out.println(executeQuery.getString(2));	}
		
		System.out.println(bean);
		
	}
	
	@Test
	public void test1(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:/spring/spring-config.xml");
		Test1 bean = ctx.getBean("test1",Test1.class);
		bean.info();
	}
	
	@Test
	public void test2(){
		BaseDaoImpl<User> user = new BaseDaoImpl<User>();
		user.findAll("from user");
	}

}
