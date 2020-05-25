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
import rpp.jpa.Racun;
import rpp.reps.RacunRepository;

@RestController
@Api(tags = {"Racun CRUD operacije"})
public class RacunRestController {
	
	@Autowired
	RacunRepository racunRepository;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@CrossOrigin
	@GetMapping("racun")
	@ApiOperation(value = "Vraća kolekciju svih racuna iz baze podataka")
	public Collection<Racun> getRacuni(){
		return racunRepository.findAll();
	}
	
	@CrossOrigin
	@GetMapping("racun/{id}")
	@ApiOperation(value = "Vraća racun iz baze podataka čiji je id vrednost prosleđena kao path varijabla")
	public Racun getRacun(@PathVariable ("id") Integer id) {
		return racunRepository.getOne(id);
	}
	
	@CrossOrigin
	@ApiOperation(value = "Briše racun iz baze podataka ciji je ID vrednost prosleđena kao path varijabla")
	@DeleteMapping("racun/{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable Integer id){
		
		if(id==-100 && !racunRepository.existsById(-100)) {
			jdbcTemplate.execute("INSERT INTO racun (\"id\", \"datum\", \"nacinPlacanja\") VALUES (-100,  to_date('02.07.2019.','dd.mm.yyyy'), 'Kartica)");
		}
		
		if (racunRepository.existsById(id)) {
			racunRepository.deleteById(id);
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		}
		
		return new ResponseEntity<HttpStatus>(HttpStatus.NOT_FOUND);
		
	}
	
	// insert
	@CrossOrigin
	@PostMapping("racun")
	public ResponseEntity<HttpStatus> addRacun(@RequestBody Racun racun){
		racunRepository.save(racun);
		return new ResponseEntity<HttpStatus>(HttpStatus.CREATED);
	}
	
	// update
	@CrossOrigin
	@PutMapping("racun/{id}")
	public ResponseEntity<HttpStatus> updateRacun(@RequestBody Racun racun, @PathVariable("id") Integer id) {
		if(racunRepository.existsById(id)) {
			racun.setId(id);
			racunRepository.save(racun);
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		}
		return new ResponseEntity<HttpStatus>(HttpStatus.NOT_FOUND);
	}

}
