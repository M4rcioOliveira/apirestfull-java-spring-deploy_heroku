package com.produtos.apirest.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.produtos.apirest.models.Produto;
import com.produtos.apirest.repository.ProdutoRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController // classe que recebe requisicoes http
@RequestMapping(value = "/api")
@Api(value = "API REST Produtos")
@CrossOrigin(origins = "*") //defino qual aplicação pode acessaros métodos(*usado para todos)
public class ProdutoResource {

	@Autowired
	ProdutoRepository produtoRepository;

	// Lista dados salvos no banco de dados
	@GetMapping("/produtos")
	@ApiOperation(value = "Lista dados salvos no banco de dados")
	public List<Produto> listaProdutos() {
		return produtoRepository.findAll();
	}

	// Lista um dado salvo no banco de dados apartir do id
	@GetMapping("/produto/{id}")
	@ApiOperation(value = "Lista um dado salvo no banco de dados apartir do id")
	public Produto listaProdutoUnico(@PathVariable(value = "id") long id) {
		return produtoRepository.findById(id);
	}

	// Adiciona um produto no banco de dados
	@PostMapping("/produto")
	@ApiOperation(value = "Adiciona um produto no banco de dados")
	public Produto salvarProduto(@RequestBody Produto produto) {
		return produtoRepository.save(produto);
	}

	// Deleta um produto no banco de dados
	@DeleteMapping("/produto")
	@ApiOperation(value = "Deleta um produto no banco de dados")
	public void deletarProduto(@RequestBody Produto produto) {
		produtoRepository.delete(produto);
	}

	// Atualizar um produto no banco de dados
	@PutMapping("/produto")
	@ApiOperation(value = "Atualizar um produto no banco de dados")
	public Produto atualizarProduto(@RequestBody Produto produto) {
		return produtoRepository.save(produto);
	}

}
