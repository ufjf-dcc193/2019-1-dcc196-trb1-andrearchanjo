package br.ufjf.dcc193.trabalho01;

import java.util.List;

import org.apache.catalina.Context;
import org.apache.tomcat.util.scan.StandardJarScanner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import br.ufjf.dcc193.trabalho01.model.Membro;
import br.ufjf.dcc193.trabalho01.model.Sede;
import br.ufjf.dcc193.trabalho01.persistence.MembroRepository;
import br.ufjf.dcc193.trabalho01.persistence.SedeRepository;

@SpringBootApplication
public class MainApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(MainApplication.class, args);
		
		SedeRepository repSede = ctx.getBean(SedeRepository.class);
		MembroRepository repMembro = ctx.getBean(MembroRepository.class);

		/*Membro membro1 = new Membro("André", "TI", "email@yahoo.com.br", "16 de julho", "20 de julho");

		Sede sede1 = new Sede("Microsoft", "MG", "Bicas", "Centro", "32710001", "microsoft.com.br");
		sede1.addMembro(membro1);
		repSede.save(sede1);*/
		//repSede.deleteAll();
		//repSede.save(new Sede("Microsoft", "MG", "Bicas", "Centro", "32710001", "microsoft.com.br"));
		//repSede.save(new Sede("Google", "Minas Gerais", "Bicas", "Centro", "32710001", "google.com.br"));

		List<Sede> sedes = repSede.findAll();

		for (Sede sede : sedes) {
			
			System.err.println(sede.toString());
		}

		List<Membro> membros = repMembro.findAll();

		for (Membro membro : membros) {
			System.err.println(membro.toString());
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
