package kr.team1.app.config;

import javax.servlet.Filter;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import kr.team1.app.config.filter.UTF8Filter;
import kr.team1.app.config.mybatis.MybatisConfig;
import kr.team1.app.config.spring.SecurityConfig;
import kr.team1.app.config.spring.SpringConfig;

public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] {SecurityConfig.class, MybatisConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] {SpringConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}
	
	@Override
    protected Filter[] getServletFilters() {
        return new Filter[] {new UTF8Filter()};
    }
	
}
