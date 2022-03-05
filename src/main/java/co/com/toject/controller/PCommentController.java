package co.com.toject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.toject.model.PComment;
import co.com.toject.repository.PCommentRepository;
import co.com.toject.repository.PTestRepository;

@RestController
@RequestMapping("/api/v1")
public class PCommentController {

	@Autowired
	private PTestRepository i;
	@Autowired
	private PCommentRepository j;

	@PostMapping("/people/{id}/comments")
	public PComment creaComm(@PathVariable("id") Integer id, @RequestBody PComment pCReq) {

		PComment pC = i.findById(id).map(tutorial -> {
			pCReq.setTutorial(tutorial);
			return j.save(pCReq);
		}).orElseThrow();
		return pC;

	}

	@GetMapping("/people/{id}/comments")
	public List<PComment> allCByPeopleId(@PathVariable("id") Integer id) {

		if (!i.existsById(id)) {
			System.out.println("Not found id = " + id); // people
		}

		List<PComment> pC = j.findByTutorialId(id); // PComment ()

		return pC;
	}

	@GetMapping("/comments/{id}")
	public PComment cByCId(@PathVariable("id") Integer id) {

		PComment p = j.findById(id).orElseThrow();

		return p;
	}

	@PutMapping("/comments/{id}")
	public PComment updComm(@PathVariable("id") Integer id, @RequestBody PComment p) {

		PComment pC = j.findById(id).orElseThrow();
		pC.setContent(p.getContent());
		return j.save(pC);

	}

	@DeleteMapping("/comments/{id}")
	public void toDel(@PathVariable("id") Integer id) {
		j.deleteById(id);

	}

	@DeleteMapping("/people/{id}/comments")
	public void delAllCByPId(@PathVariable("id") Integer id) {
		if (!i.existsById(id)) {
			System.out.println("Not found id = " + id); // people
		}

		j.deleteByTutorialId(id);
	}

}
