package ba.biggy.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import ba.biggy.dao.FaultDAO;
import ba.biggy.dao.FaultDAOImpl;
import ba.biggy.testPackage.TestModelDAO;
import ba.biggy.testPackage.TestModelDAOImpl;

@Configuration
@ComponentScan(basePackages="ba.biggy.*")
@EnableWebMvc
public class MvcConfiguration extends WebMvcConfigurerAdapter{

	
	@Bean
    public ViewResolver getViewResolver(){
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }
	
	
	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }
	
	@Bean
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        
        //local db
        dataSource.setUrl("jdbc:mysql://localhost:3306/webbisdb");
        dataSource.setUsername("root");
        dataSource.setPassword("admin");
        
        //online db
        /*dataSource.setUrl("jdbc:mysql://localhost:3306/biggyba_webbisdb");
        dataSource.setUsername("biggyba_webbis");
        dataSource.setPassword("#u+0#?@s$_GX");*/
         
        return dataSource;
    }
	
	@Bean
	public TestModelDAO getTestModelDAO() {
		return new TestModelDAOImpl(getDataSource());
	}
	
	@Bean
	public FaultDAO getFaultDAO() {
		return new FaultDAOImpl(getDataSource());
	}
	
}
