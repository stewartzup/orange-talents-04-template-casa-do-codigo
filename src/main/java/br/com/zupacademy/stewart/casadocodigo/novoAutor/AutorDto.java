package br.com.zupacademy.stewart.casadocodigo.novoAutor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class AutorDto {

	private String nome;
	private String descricao;
	private LocalDateTime dataCriacao;

	public AutorDto(Autor autor) {

		this.nome = autor.getNome();
		this.descricao = autor.getDescricao();
		this.dataCriacao = autor.getDataCriacao();
	

	}
	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}
	public static List<AutorDto> converter(List<Autor> autores) {
			return autores.stream().map(AutorDto::new).collect(Collectors.toList());
	}

	
}
