package co.com.toject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import co.com.toject.model.PTest;
import co.com.toject.x.IPTestRepo;

@Controller // redireccionar la petición hacia alguna lógica de negocio
public class DemoController {

	@Autowired
	private IPTestRepo iPTest;

	@GetMapping("/greeting") // ?name=Ronald
	public String greeting(@RequestParam(name = "name", required = false, defaultValue = "World") String name,
			Model model) {
		PTest pT = new PTest();
		pT.setName("Estrella");
		iPTest.save(pT);
		model.addAttribute("name", name);
		return "greeting"; // .html

	}

	@GetMapping("/getTest") // ?name=Ronald
	public String greeting(Model m) {
		m.addAttribute("pTest", iPTest.findAll());

		return "greeting"; // .html

	}
}

//https://spring.io/guides/gs/serving-web-content/

//https://spring.io/projects/spring-data-jpa

//https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fdocs.spring.io%2Fspring%2Fdocs%2F5.0.0.RC3%2Fspring-framework-reference%2Fimages%2Fspring-overview.png&f=1&nofb=1
