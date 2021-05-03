package br.com.zupacademy.stewart.casadocodigo.novacategoria;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Categoria {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	private String nome;

	public Categoria(@NotBlank String nome) {
		super();
		this.nome = nome;
	}

	@Deprecated
	public Categoria() {
		super();
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}
	
	

}
