package co.com.toject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import co.com.toject.y.ITestService;
import co.com.toject.y.TestServiceImpl;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
public class DemotojectApplication implements CommandLineRunner { // Console app

	public static Logger lInfo = LoggerFactory.getLogger(DemotojectApplication.class);

	// @Autowired
	private ITestService testService;

	public static void main(String[] args) {
		SpringApplication.run(DemotojectApplication.class, args);

	}

	/*@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("co.com.toject")).build();
	}*/

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		// System.out.println("\n" + "From Console!");
		// lInfo.info("Ronald from Console!");
		// lInfo.warn("Keep Learning!");

		testService = new TestServiceImpl();

		testService.showInfo("Ronald");

	}

}
