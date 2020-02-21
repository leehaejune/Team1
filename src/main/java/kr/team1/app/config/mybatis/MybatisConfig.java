package kr.team1.app.config.mybatis;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;

@Configuration
public class MybatisConfig {

	@Bean
	public DataSource dataSource() throws Exception {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("net.sf.log4jdbc.sql.jdbcapi.DriverSpy");
		dataSource.setUrl("jdbc:log4jdbc:mariadb://localhost:3306/project");
		dataSource.setUsername("team1");
		dataSource.setPassword("team1234");
//		JndiDataSourceLookup jdsl = new JndiDataSourceLookup();
//		jdsl.setResourceRef(true);
//		DataSource dataSource = jdsl.getDataSource("jdbc/team1db");
		return dataSource;
	}
	
	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource, ApplicationContext applicationContext) throws Exception {
		SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
		sessionFactoryBean.setDataSource(dataSource);
		sessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath:/sql/*.xml"));
		return sessionFactoryBean.getObject();
	}
	
	@Bean
	public SqlSession sqlSession(SqlSessionFactory sqlSessionFactory) throws Exception {		
		return new SqlSessionTemplate(sqlSessionFactory);
	}
	
}
