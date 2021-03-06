package com.cdm.depaul.coffeeShop.configuration;

import com.cdm.depaul.coffeeShop.CoffeeShopApplication;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * https://docs.spring.io/spring-framework/docs/5.0.9.RELEASE/javadoc-api/org/springframework/web/WebApplicationInitializer.html?is-external=true
 *
 * This is the servlet.xml file in Java. Configures the DispatcherServlet / FrontController of Spring.
 */
public class DispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

  @Override
  protected Class<?>[] getRootConfigClasses() {
    return new Class[0];
  }

  /**
   * Tells the Front Controller where the applicationContext / application configuration is.
   * @return
   */
  @Override
  protected Class<?>[] getServletConfigClasses() {
    return new Class[] { CoffeeShopApplication.class };
  }

  /**
   *
   * Tells the Front Controller to handle all requests of this pattern: "/", all requests.
   * @return
   */
  @Override
  protected String[] getServletMappings() {
    return new String[] { "/" };
  }
}
