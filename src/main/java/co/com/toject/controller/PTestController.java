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
import org.springframework.web.bind.annotation.RestController;

import co.com.toject.model.PTest;
import co.com.toject.repository.PTestRepository;

@RestController
@RequestMapping("/api/v1")
public class PTestController {

	@Autowired
	private PTestRepository i;

	@GetMapping("/getptest")
	public List<PTest> toList() {
		return i.findAll();
	}

	// byId v1

	/*
	 * @GetMapping("/getptest/{id}") public PTest byId(@PathVariable("id") Integer
	 * id) { PTest pT = i.findById(id) .orElseThrow(); return pT; }
	 */

	@GetMapping("/getptest/{id}")
	public ResponseEntity<PTest> byId(@PathVariable("id") Integer id) {
		PTest pT = i.findById(id).
				orElseThrow();
		return ResponseEntity.ok().body(pT);
	}

	@PostMapping
	public PTest toIns(@RequestBody PTest p) { // JSON to Object
		return i.save(p); // si no existe, inserta

	}

	/*
	 * @PutMapping public void toUpd(@RequestBody PTest p) { // JSON to Object
	 * i.save(p); // if existe, modifica
	 * 
	 * }
	 */

	@PutMapping("/getptest/{id}")
	public ResponseEntity<PTest> toUpd(@PathVariable("id") Integer id, @RequestBody PTest p) { // JSON to Object

		PTest pT = i.findById(id)
				.orElseThrow();

		pT.setName(p.getName());
		pT.setEmail(p.getEmail());
		final PTest upd = i.save(pT);

		return ResponseEntity.ok(upd);

	}

	@DeleteMapping(value = "/{id}")
	public void toDel(@PathVariable("id") Integer id) { //
		i.deleteById(id);

	}
}
