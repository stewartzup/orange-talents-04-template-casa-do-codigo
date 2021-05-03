package br.com.zupacademy.stewart.casadocodigo.novacategoria;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonCreator;

public class CategoriaRequest {
	@NotBlank
	private String nome;

	@JsonCreator
	public CategoriaRequest(@NotBlank String nome) {
		super();
		this.nome = nome;
	}

	public Categoria converterToModel() {
		return new Categoria(this.nome);
	}

	public String getNome() {
		return nome;
	}

}
