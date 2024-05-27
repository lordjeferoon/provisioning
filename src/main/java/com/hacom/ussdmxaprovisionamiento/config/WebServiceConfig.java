package com.hacom.ussdmxaprovisionamiento.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class WebServiceConfig {
	
	@Bean
    public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean<>(servlet, "/ws/*");
    }

    @Bean(name = "provisioning")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema provisioningSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("ProvisioningPort");
        wsdl11Definition.setLocationUri("/ws");
        wsdl11Definition.setTargetNamespace("http://www.example.com/provisioning");
        wsdl11Definition.setSchema(provisioningSchema);
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema provisioningSchema() {
        ClassPathResource resource = new ClassPathResource("provisioning.xsd");
        if (!resource.exists()) {
            throw new IllegalArgumentException("XSD file not found: " + resource.getPath());
        }else {
        	System.out.println("Sí se carga");
        }
        return new SimpleXsdSchema(resource);
    }

}
