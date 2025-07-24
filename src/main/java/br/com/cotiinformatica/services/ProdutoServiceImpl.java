package br.com.cotiinformatica.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import br.com.cotiinformatica.dtos.ProdutoRequest;
import br.com.cotiinformatica.dtos.ProdutoResponse;
import br.com.cotiinformatica.entities.Produto;
import br.com.cotiinformatica.repositories.ProdutoRepository;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    private final ProdutoRepository produtoRepository;
    private final ModelMapper modelMapper;

    public ProdutoServiceImpl(ProdutoRepository produtoRepository, ModelMapper modelMapper) {
        this.produtoRepository = produtoRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ProdutoResponse create(ProdutoRequest request) {
        Produto produto = modelMapper.map(request, Produto.class);
        Produto salvo = produtoRepository.save(produto);
        return modelMapper.map(salvo, ProdutoResponse.class);
    }

    @Override
    public List<ProdutoResponse> findAll() {
        List<Produto> produtos = produtoRepository.findAll();
        return produtos.stream()
            .map(produto -> modelMapper.map(produto, ProdutoResponse.class))
            .collect(Collectors.toList());
    }
}
