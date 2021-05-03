package br.com.zupacademy.stewart.casadocodigo.novacategoria;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonCreator;

import br.com.zupacademy.stewart.casadocodigo.compartilhado.UniqueValue;

public class CategoriaRequest {
	@NotBlank
	@UniqueValue(domainClass = Categoria.class, fieldName = "nome", message = "o nome deve ser unico")
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
