package br.ufjf.dcc193.trabalho01;

import java.util.List;

import org.apache.catalina.Context;
import org.apache.tomcat.util.scan.StandardJarScanner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import br.ufjf.dcc193.trabalho01.model.Sede;
import br.ufjf.dcc193.trabalho01.persistence.SedeRepository;

@SpringBootApplication
public class MainApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(MainApplication.class, args);
		
		SedeRepository rep = ctx.getBean(SedeRepository.class);

		//rep.deleteAll();
		//rep.save(new Sede("Microsoft", "MG", "Bicas", "Centro", "32710001", "microsoft.com.br"));
		//rep.save(new Sede("Google", "Minas Gerais", "Bicas", "Centro", "32710001", "google.com.br"));

		List<Sede> sedes = rep.findAll();

		for (Sede sede : sedes) {
			System.err.println(sede.toString());
		}
		
	}

	@Bean
	public TomcatServletWebServerFactory tomcatFactory() {
   		return new TomcatServletWebServerFactory() {
      @Override
      protected void postProcessContext(Context context) {
         ((StandardJarScanner) context.getJarScanner()).setScanManifest(false);
	   }};
	}


}
