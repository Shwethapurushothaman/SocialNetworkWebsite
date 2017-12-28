package com.socialappbackend.Config;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.socialappbackend.dao.blogcommentdao;
import com.socialappbackend.dao.blogcommentimpl;
import com.socialappbackend.dao.blogdao;
import com.socialappbackend.dao.blogdaoimpl;
import com.socialappbackend.dao.forumcommentdao;
import com.socialappbackend.dao.forumcommentimpl;
import com.socialappbackend.dao.forumdao;
import com.socialappbackend.dao.forumdaoimpl;
import com.socialappbackend.dao.jobdao;
import com.socialappbackend.dao.jobdaoimpl;
import com.socialappbackend.dao.userdao;
import com.socialappbackend.dao.userdaoimpl;
@Configuration
@EnableTransactionManagement
@ComponentScan("com.socialappbackend.*")
public class ApplicationConfig {
	   //1.Creating a DataSource Object which is used for LocalSessionFactory
		public DataSource getOracleDataSource()
		{
			DriverManagerDataSource driverManagerDataSource=new DriverManagerDataSource();
			driverManagerDataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
			driverManagerDataSource.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");
			driverManagerDataSource.setUsername("hr");
			driverManagerDataSource.setPassword("hr");
			return driverManagerDataSource;
		}
		
		//2.Creating Hibernate Properties which is used by LocalSessionFactory
		public Properties getHibernateProperties()
		{
			Properties properties=new Properties();
			properties.setProperty("hibernate.hbm2ddl.auto", "update");
			properties.put("hibernate.dialect","org.hibernate.dialect.Oracle10gDialect");
			return properties;
		}
		
		@Bean
		public SessionFactory getSessionFactory()
		{
			LocalSessionFactoryBuilder localSessionFactoryBuilder=new LocalSessionFactoryBuilder(getOracleDataSource());
			localSessionFactoryBuilder.addProperties(getHibernateProperties());
			localSessionFactoryBuilder.scanPackages("com.socialappbackend.model");
			System.out.println("SessionFactory Bean Created");
			return localSessionFactoryBuilder.buildSessionFactory();
			
		}
		
		@Bean
		public HibernateTransactionManager getHibernateTransactionManager(SessionFactory sessionFactory)
		{
			return new HibernateTransactionManager(sessionFactory);
		}
		
		@Bean("blogDAO")
		public blogdao getBlogDAO(SessionFactory sessionFactory)
		{
			System.out.println("Blog DAO object Created");
			return new blogdaoimpl(sessionFactory);
		}
		@Bean("userDAO")
		public userdao getUserDAO(SessionFactory sessionFactory)
		{
			System.out.println("User DAO object Created");
			return new userdaoimpl(sessionFactory);
		}
		@Bean("forumDAO")
		public forumdao getForumDAO(SessionFactory sessionFactory)
		{
			System.out.println("Forum DAO object Created");
			return new forumdaoimpl(sessionFactory);
		}
		@Bean("jobDAO")
		public jobdao getJobDAO(SessionFactory sessionFactory)
		{
			return new jobdaoimpl(sessionFactory);
		}
		@Bean("forumCommentsDAO")
		public forumcommentdao getForumCommentsDAO(SessionFactory sessionFactory)
		{
			System.out.println("ForumComments DAO object Created");
			return new forumcommentimpl(sessionFactory);
		}
		@Bean("blogCommentsDAO")
		public blogcommentdao getBlogCommentsDAO(SessionFactory sessionFactory)
		{
			System.out.println("BlogComments DAO object Created");
			return new blogcommentimpl(sessionFactory);
		}

}

