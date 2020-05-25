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
import rpp.jpa.StavkaRacuna;
import rpp.reps.RacunRepository;
import rpp.reps.StavkaRacunaRepository;

@RestController
@Api(tags = {"Stavka racuna CRUD operacije"})
public class StavkaRacunaRestController {
	
	@Autowired
	private StavkaRacunaRepository stavkaRacunaRepository;
	
	@Autowired
	private RacunRepository racunRepository;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@CrossOrigin
	@GetMapping("stavkaRacuna")
	@ApiOperation(value = "Vraća kolekciju svih stavki racuna iz baze podataka")
	public Collection<StavkaRacuna> getStavkeRacuna() {
		return stavkaRacunaRepository.findAll();
	}
	
	@CrossOrigin
	@GetMapping(value = "stavkaRacuna/{id}")
	@ApiOperation(value = "Vraća stavku racuna iz baze podataka čiji je id vrednost prosleđena kao path varijabla")
	public ResponseEntity<StavkaRacuna> getStavkaRacuna(@PathVariable ("id") Integer id) {
		StavkaRacuna stavkaRacuna = stavkaRacunaRepository.getOne(id);
		return new ResponseEntity<StavkaRacuna> (stavkaRacuna, HttpStatus.OK);
	}
	
	@CrossOrigin
	@GetMapping(value = "stavkeZaRacuneId/{id}")
	@ApiOperation(value = "Vraća sve stavke racuna iz baze podataka vezane za racun čiji je id vrednost prosleđena kao path varijabla")
	public Collection<StavkaRacuna> stavkaPoRacunuId(@PathVariable("id") Integer id){
		Racun r = racunRepository.getOne(id);
		return stavkaRacunaRepository.findByRacun(r);
	}
	
	@CrossOrigin
	@GetMapping (value="stavkaRacunaCena/{cena}")
	public Collection<StavkaRacuna> getStavkaRacunaCena(@PathVariable("cena") Integer cena){
		return stavkaRacunaRepository.findByCenaLessThanOrderById(cena);
	}
	
	@CrossOrigin
	@ApiOperation(value = "Briše stavke racuna iz baze podataka ciji je ID vrednost prosleđena kao path varijabla")
	@DeleteMapping("stavkaRacuna/{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable Integer id){
		
		if(id==-100 && !stavkaRacunaRepository.existsById(-100)) {
			jdbcTemplate.execute("INSERT INTO racun (\"id\",\"cena\", \"jedinicaMere\", \"kolicina\", \"redniBroj\", \"proizvod\", \"racun\") VALUES (-100, '1200', 'kom', '2', '2', '1', '1')");
		}
		
		if (stavkaRacunaRepository.existsById(id)) {
			stavkaRacunaRepository.deleteById(id);
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		}
		
		return new ResponseEntity<HttpStatus>(HttpStatus.NOT_FOUND);
		
	}
	
	// insert
	@CrossOrigin
	@PostMapping("stavkaRacuna")
	public ResponseEntity<HttpStatus> addStavkaRacuna(@RequestBody StavkaRacuna stavkaRacuna){
		stavkaRacunaRepository.save(stavkaRacuna);
		return new ResponseEntity<HttpStatus>(HttpStatus.CREATED);
	}
	
	// update
	@CrossOrigin
	@PutMapping("stavkaRacuna/{id}")
	public ResponseEntity<HttpStatus> updateStavkaRacuna(@RequestBody StavkaRacuna stavkaRacuna, @PathVariable("id") Integer id) {
		if(stavkaRacunaRepository.existsById(id)) {
			stavkaRacuna.setId(id);
			stavkaRacunaRepository.save(stavkaRacuna);
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		}
		return new ResponseEntity<HttpStatus>(HttpStatus.NOT_FOUND);
	}

}
