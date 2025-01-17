package br.com.zupacademy.stewart.casadocodigo.novoAutor;

import java.time.LocalDateTime;
import java.util.Date;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import br.com.zupacademy.stewart.casadocodigo.compartilhado.UniqueValue;
import br.com.zupacademy.stewart.casadocodigo.novacategoria.Categoria;



public class AutorRequest {

	@NotBlank
	private String nome;
	@NotBlank
	@Email
	@UniqueValue(domainClass = Autor.class, fieldName = "email", message = "o email deve ser unico")
	private String email;
	@NotBlank
	@Size(max = 400)
	private String descricao;
	private LocalDateTime dataCriacao = LocalDateTime.now();
	
	public Autor converterToModel() {
		return new Autor(this.nome,this.email,this.descricao);
	}
	
	public AutorRequest(@NotBlank String nome, @NotBlank @Email String email,
			@NotBlank @Size(max = 400) String descricao,  LocalDateTime dataCriacao) {
		super();
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
		this.dataCriacao = dataCriacao;
	}

	

	public String getEmail() {
		return email;
	}


	

}
