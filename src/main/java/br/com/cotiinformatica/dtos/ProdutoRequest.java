package br.com.cotiinformatica.dtos;

import lombok.Data;

@Data
public class ProdutoRequest {

	private String nome;
	private Integer quantidade;
	private Double preco;
}
