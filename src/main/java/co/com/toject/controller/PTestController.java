package co.com.toject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.com.toject.model.PTest;
import co.com.toject.repository.PTestRepository;

@RestController
@RequestMapping("/api/v1")
public class PTestController {

	@Autowired
	private PTestRepository i;

	/*
	 * @GetMapping("/people") public List<PTest> toList() { return i.findAll(); }
	 */
	/*
	 * @GetMapping("/people") public ResponseEntity<List<PTest>>
	 * toList(@RequestParam(required = false) String n) {
	 * 
	 * List<PTest> pT; if (n == null) pT = i.findAll(); else pT =
	 * i.findByEmailContaining(n);
	 * 
	 * return ResponseEntity.ok().body(pT); }
	 */

	@GetMapping("/people")
	public List<PTest> toList(@RequestParam(required = false) String email) { // people?email=n

		// List<PTest> pT;

		if (email == null)
			return i.findAll();
		else
			return i.findByEmailContaining(email);

		// return pT;
	}
	// byId v1

	/*
	 * @GetMapping("/getptest/{id}") public PTest byId(@PathVariable("id") Integer
	 * id) { PTest pT = i.findById(id) .orElseThrow(); return pT; }
	 */

	@GetMapping("/people/{id}")
	public ResponseEntity<PTest> getById(@PathVariable("id") Integer id) {
		PTest pT = i.findById(id)
				.orElseThrow();
		return ResponseEntity.ok().body(pT);
	}

	@GetMapping("/people/published")
	public List<PTest> findByPublished() {

		return i.findByPublished(true);
	}

	@PostMapping("/people")
	public PTest toIns(@RequestBody PTest p) { // JSON to Object
		return i.save(p); // si no existe, inserta

	}

	// updateEntity v1
	/*
	 * @PutMapping public void toUpd(@RequestBody PTest p) { // JSON to Object
	 * i.save(p); // if existe, modifica
	 * 
	 * }
	 */

	@PutMapping("/people/{id}")
	public ResponseEntity<PTest> toUpd(@PathVariable("id") Integer id, @RequestBody PTest p) { // JSON to Object

		PTest pT = i.findById(id)
				.orElseThrow();

		pT.setName(p.getName());
		pT.setEmail(p.getEmail());
		final PTest upd = i.save(pT);

		return ResponseEntity.ok(upd);

	}

	// delById v1
	/*
	 * @DeleteMapping(value = "/{id}") public void toDel(@PathVariable("id") Integer
	 * id) { // i.deleteById(id);
	 * 
	 * }
	 */
	@DeleteMapping("/people/{id}")
	public void toDel(@PathVariable("id") Integer id) { //
		PTest pT = i.findById(id)
				.orElseThrow();
		i.delete(pT);

	}

}
