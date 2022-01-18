package co.com.toject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import co.com.toject.y.ITestService;
import co.com.toject.y.TestServiceImpl;

@SpringBootApplication
public class DemotojectApplication implements CommandLineRunner { // Console app

	public static Logger lInfo = LoggerFactory.getLogger(DemotojectApplication.class);

	// @Autowired
	private ITestService testService;

	public static void main(String[] args) {
		SpringApplication.run(DemotojectApplication.class, args);

	}

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
