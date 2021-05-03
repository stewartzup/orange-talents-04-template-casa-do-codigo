package br.com.zupacademy.stewart.casadocodigo.novacategoria;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

public class CategoriaResponse {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	private String nome;
	
	
	public CategoriaResponse(Long id, @NotBlank String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}
	
	

}
