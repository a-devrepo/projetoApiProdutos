package br.com.cotiinformatica.services;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.cotiinformatica.dtos.ProdutoRequest;
import br.com.cotiinformatica.dtos.ProdutoResponse;

public interface ProdutoService {

	ProdutoResponse create(ProdutoRequest request);

	List<ProdutoResponse> findAll();
}
