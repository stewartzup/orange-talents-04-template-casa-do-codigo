package br.com.zupacademy.stewart.casadocodigo.novacategoria;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/categorias")
public class CategoriaController {
	
	@Autowired
	private CategoriaRepository categoriaRepository;

	@PostMapping
	public ResponseEntity<CategoriaResponse> cadastrarAutor(@RequestBody @Valid CategoriaRequest request) {
		// verifica se categoria ja existe
		Optional<Categoria> categoriaNome = categoriaRepository.findByNome(request.getNome());

		if (!categoriaNome.isPresent()) {
			Categoria categoria = request.converterToModel();
			Categoria categoriaSalvo = categoriaRepository.save(categoria);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.badRequest().build();

	}
}
