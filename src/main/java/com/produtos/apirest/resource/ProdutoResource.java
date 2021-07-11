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

@RestController // Classe que recebe requisições http
@RequestMapping(value = "/api")
@Api(value = "API REST Produtos")
@CrossOrigin(origins = "*") // Defino qual aplicação pode acessar os métodos(*usado para todos)
public class ProdutoResource {

	@Autowired
	ProdutoRepository produtoRepository;

	@GetMapping("/produtos")
	@ApiOperation(value = "Lista todos os dados salvos no banco de dados")
	public List<Produto> getAll() {
		return produtoRepository.findAll();
	}

	@GetMapping("/produto/search/id/{id}")
	@ApiOperation(value = "Lista um dado salvo no banco de dados apartir do id")
	public Produto getById(@PathVariable(value = "id") long id) {
		return produtoRepository.findById(id);
	}

	@GetMapping("/produto/search/codigobarras/{codigoBarras}")
	@ApiOperation(value = "Lista um dado salvo no banco de dados apartir do código de barras")
	public Produto getByCb(@PathVariable(value = "codigoBarras") String codigoBarras) {
		return produtoRepository.findByCodigoBarras(codigoBarras);
	}

	@PostMapping("/produto/save")
	@ApiOperation(value = "Adiciona um produto no banco de dados")
	public Produto save(@RequestBody Produto produto) {
		return produtoRepository.save(produto);
	}

	@DeleteMapping("/produto/delete")
	@ApiOperation(value = "Deleta um produto no banco de dados")
	public void delete(@RequestBody Produto produto) {
		produtoRepository.delete(produto);
	}

	@PutMapping("/produto/update")
	@ApiOperation(value = "Atualiza um produto no banco de dados")
	public Produto update(@RequestBody Produto produto) {
		return produtoRepository.save(produto);
	}

}
