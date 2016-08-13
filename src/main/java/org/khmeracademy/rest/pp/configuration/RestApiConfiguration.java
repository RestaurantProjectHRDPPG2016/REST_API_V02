package org.khmeracademy.rest.pp.configuration;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@MapperScan("org.khmeracademy.rest.pp.repository")
@EnableSwagger2
@EnableWebMvc
public class RestApiConfiguration extends WebMvcConfigurerAdapter {
	@Autowired
	private DataSource dataSource; 

	@Bean
	public MultipartResolver multipartResolver() {
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
		multipartResolver.setMaxUploadSize(500*1024*1024); //Maximum Size: 500MB
		//multipartResolver.setMaxUploadSizePerFile(50*1024*1024); //Maximum Size Per File: 50MB
		return multipartResolver;
	}
	
	@Bean
	public SqlSessionFactoryBean sqlSessionFactoryBean(){
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource);
		return sqlSessionFactoryBean;
	}
	@Bean
	public DataSourceTransactionManager tranSactionManager(){
		return new DataSourceTransactionManager(dataSource);
	}
	@Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()                                  
          .apis(RequestHandlerSelectors.any())              
          .paths(PathSelectors.any())                          
          .build();                                           
    }
   @Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
				.allowedMethods("GET","POST","DELETE","PUT","OPTIONS","PATCH")
				.allowedOrigins("*");
	}

   @Override
   public void addResourceHandlers(ResourceHandlerRegistry registry) {
       registry
           .addResourceHandler("swagger-ui.html")
           .addResourceLocations("classpath:/META-INF/resources/");
       registry
           .addResourceHandler("/webjars/**")
           .addResourceLocations("classpath:/META-INF/resources/webjars/");
   }


   
}
