package com.skilldistillery.roundtablegaming;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class RoundTableGamingApplication extends SpringBootServletInitializer {

	@Override
	  protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	    return application.sources(RoundTableGamingApplication.class);
	  }
	  public static void main(String[] args) {
	    SpringApplication.run(RoundTableGamingApplication.class, args);
	  }

}
