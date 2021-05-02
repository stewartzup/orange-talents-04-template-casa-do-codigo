package br.com.zupacademy.stewart.casadocodigo.novoAutor;

//import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;


@RestController
@RequestMapping("autores")
public class AutorController {

	@Autowired
	private AutorRepository autorRepository;
	
	@GetMapping
	public List<AutorDto> lista() {
		List<Autor> autores = autorRepository.findAll();
		return AutorDto.converter(autores);
	}

	@PostMapping
	public ResponseEntity<AutorDto> cadastrarAutor(@RequestBody @Valid AutorRequest request, UriComponentsBuilder uriBuilder) {
		Autor autor = request.converterToModel();
		Autor autorSalvo = autorRepository.save(autor);
		return ResponseEntity.ok().build();
		//URI uri = uriBuilder.path("/autor/{id}").buildAndExpand(autor.getId()).toUri();
		//return ResponseEntity.created(uri).body(new AutorDto(autor));
		

	}

}
