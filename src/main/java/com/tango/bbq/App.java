package com.tango.bbq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


/**
 * start
 *
 */
@RestController
@SpringBootApplication
@ServletComponentScan
public class App extends WebMvcConfigurerAdapter{
//public class App {
//    @RequestMapping("/")
//    public String home() {
//        return "login";
//    }
    
//    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
//      registry.addViewController("/").setViewName("index");
//      registry.addViewController("/error").setViewName("error");
//      registry.addViewController("/profile").setViewName("profile");
//    }
//	
//	  @SuppressWarnings("deprecation")
//	  @Bean
//	  public EmbeddedServletContainerCustomizer containerCustomizer() {
//	    return container -> container.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/error"), new ErrorPage(HttpStatus.FORBIDDEN, "/error"));
//	  }
    
    public static void main(String[] args) throws Exception {
        SpringApplication.run(App.class, args);
    }
}

