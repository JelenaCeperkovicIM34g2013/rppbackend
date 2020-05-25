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
import rpp.jpa.Proizvodjac;
import rpp.reps.ProizvodjacRepository;

@RestController
@Api(tags = {"Proizvodjac CRUD operacije"})
public class ProizvodjacRestController {
	
	@Autowired
	private ProizvodjacRepository proizvodjacRepository;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

    @CrossOrigin
	@GetMapping("proizvodjac")
	@ApiOperation(value = "Vraća kolekciju svih proizvodjaca iz baze podataka")
	public Collection<Proizvodjac> getProizvodjaci() {
		return proizvodjacRepository.findAll();
	}
	
    @CrossOrigin
	@GetMapping("proizvodjac/{id}")
	@ApiOperation(value = "Vraća proizvodjaca iz baze podataka čiji je id vrednost prosleđena kao path varijabla")
	public Proizvodjac getProizvodjac(@PathVariable("id") Integer id) {
		return proizvodjacRepository.getOne(id);
	}
	
    @CrossOrigin
	@GetMapping("proizvodjacNaziv/{naziv}")
	@ApiOperation(value = "Vraća kolekciju proizvodjaca iz baze podataka koji u nazivu sadrže string prosleđen kao path varijabla")
	public Collection<Proizvodjac> getProizvodjacByNaziv(@PathVariable("naziv") String naziv){
		return proizvodjacRepository.findByNazivContainingIgnoreCase(naziv);
	}
	
    @CrossOrigin
	@ApiOperation(value = "Briše proizvodjaca iz baze podataka ciji je ID vrednost prosleđena kao path varijabla")
	@DeleteMapping("proizvodjac/{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable Integer id){
		
		if(id==-100 && !proizvodjacRepository.existsById(-100)) {
			jdbcTemplate.execute("INSERT INTO racun (\"id\", \"adresa\", \"kontakt\", \"naziv\") VALUES (-100, 'Kralja Petra 1', '062548795','Nike')");
		}
		
		if (proizvodjacRepository.existsById(id)) {
			proizvodjacRepository.deleteById(id);
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		}
		
		return new ResponseEntity<HttpStatus>(HttpStatus.NOT_FOUND);
		
	}
	
	// insert
    @CrossOrigin
	@PostMapping("proizvodjac")
	public ResponseEntity<HttpStatus> addProizvodjac(@RequestBody Proizvodjac proizvodjac){
		proizvodjacRepository.save(proizvodjac);
		return new ResponseEntity<HttpStatus>(HttpStatus.CREATED);
	}
	
	// update
    @CrossOrigin
	@PutMapping("proizvodjac/{id}")
	public ResponseEntity<HttpStatus> updateProizvodjac(@RequestBody Proizvodjac proizvodjac, @PathVariable("id") Integer id) {
		if(proizvodjacRepository.existsById(id)) {
			proizvodjac.setId(id);
			proizvodjacRepository.save(proizvodjac);
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		}
		return new ResponseEntity<HttpStatus>(HttpStatus.NOT_FOUND);
	}

}
