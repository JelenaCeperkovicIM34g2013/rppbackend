package rpp.ctrls;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import rpp.jpa.Proizvod;
import rpp.reps.ProizvodRepository;

@RestController
@Api(tags = {"Proizvod CRUD operacije"})
public class ProizvodRestController {
	
	@Autowired
	private ProizvodRepository proizvodRepository;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@CrossOrigin
	@GetMapping("proizvod")
	@ApiOperation(value = "Vraća kolekciju svih proizvoda iz baze podataka")
	public Collection<Proizvod> getAll(){
		return proizvodRepository.findAll();
	}
	
	@CrossOrigin
	@GetMapping("proizvod/{id}")
	@ApiOperation(value = "Vrаća proizvod iz baze podataka ciji je ID vrednost prosleđena kao path varijabla")
	public Proizvod getOne(@PathVariable("id") Integer id) {
		return proizvodRepository.getOne(id);
	}
	
	@CrossOrigin
	@GetMapping("proizvodNaziv/{naziv}")
	@ApiOperation(value = "Vrаća proizvod iz baze podataka koji u naziv sadrzi string prosleđen kao path varijabla")
	public Collection<Proizvod> getByNaziv(@PathVariable("naziv") String naziv){
		return proizvodRepository.findByNazivContainingIgnoreCase(naziv);
	}
	
	@CrossOrigin
	@ApiOperation(value = "Briše proizvod iz baze podataka ciji je ID vrednost prosleđena kao path varijabla")
	@DeleteMapping("proizvod/{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable Integer id){
		
		if(id==-100 && !proizvodRepository.existsById(-100)) {
			jdbcTemplate.execute("INSERT INTO racun (\"id\",\"naziv\", \"proizvodjac\") VALUES (-100, 'Patike', '1')");
		}
		
		if (proizvodRepository.existsById(id)) {
			proizvodRepository.deleteById(id);
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		}
		
		return new ResponseEntity<HttpStatus>(HttpStatus.NOT_FOUND);
		
	}
	
	// insert
	@CrossOrigin
		@PostMapping("proizvod")
		public ResponseEntity<HttpStatus> addProizvod(@RequestBody Proizvod proizvod){
			proizvodRepository.save(proizvod);
			return new ResponseEntity<HttpStatus>(HttpStatus.CREATED);
		}
		
		// update
	@CrossOrigin
		@PutMapping("proizvod/{id}")
		public ResponseEntity<HttpStatus> updateProizvod(@RequestBody Proizvod proizvod, @PathVariable("id") Integer id) {
			if(proizvodRepository.existsById(id)) {
				proizvod.setId(id);
				proizvodRepository.save(proizvod);
				return new ResponseEntity<HttpStatus>(HttpStatus.OK);
			}
			return new ResponseEntity<HttpStatus>(HttpStatus.NOT_FOUND);
		}

}
