package br.com.cotiinformatica.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cotiinformatica.dtos.ProdutoRequest;
import br.com.cotiinformatica.dtos.ProdutoResponse;
import br.com.cotiinformatica.services.ProdutoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/produtos")
public class ProdutosController {

    private final ProdutoService produtoService;

    public ProdutosController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @Operation(summary = "Cria um novo produto")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Produto criado com sucesso",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProdutoResponse.class))),
        @ApiResponse(responseCode = "400", description = "Dados inválidos para o produto",
            content = @Content)
    })
    @PostMapping
    public ResponseEntity<ProdutoResponse> createProduto(@RequestBody @Valid ProdutoRequest produtoRequest) {
        ProdutoResponse produtoResponse = produtoService.create(produtoRequest);
        return new ResponseEntity<>(produtoResponse, HttpStatus.CREATED);
    }

    @Operation(summary = "Lista todos os produtos")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Lista de produtos retornada com sucesso",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProdutoResponse.class)))
    })
    @GetMapping
    public ResponseEntity<List<ProdutoResponse>> listarProdutos() {
        List<ProdutoResponse> produtos = produtoService.findAll();
        return ResponseEntity.ok(produtos);
    }
}
