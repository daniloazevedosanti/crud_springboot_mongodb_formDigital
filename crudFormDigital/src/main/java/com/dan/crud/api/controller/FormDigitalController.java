package com.dan.crud.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dan.crud.api.models.Client;
import com.dan.crud.api.models.Product;
import com.dan.crud.api.services.ClientService;
import com.dan.crud.api.services.ProductService;

@RestController
@RequestMapping(path = "/api/digital")
public class FormDigitalController {

	@Autowired
	private ClientService ClientService;
	
	@Autowired
	private ProductService ProductService;
	
	
	@GetMapping(path = "/cliente")
	public ResponseEntity<List<Client>> listarTodosClients() {
		return ResponseEntity.ok(this.ClientService.listAll());
	}

	@GetMapping(path = "/cliente/{id}")
	public ResponseEntity<Optional<Client>> listarClientPorId(@PathVariable(name = "id") String id) {
		return ResponseEntity.ok(this.ClientService.listById(id));
	}


	@PostMapping(path = "/cliente")
	public ResponseEntity<Client> cadastrarClient(@RequestBody Client Client) {
		return ResponseEntity.ok(this.ClientService.register(Client));
	}

	@PutMapping(path = "/cliente/{id}")
	public ResponseEntity<Client> atualizarClient(@PathVariable(name = "id") String id,
			@RequestBody Client Client) {
		Client.setId(id);
		return ResponseEntity.ok(this.ClientService.updateRegister(Client));
	}

	@DeleteMapping(path = "/cliente/{id}")
	public ResponseEntity<Integer> deletarClient(@PathVariable(name = "id") String id) {
		this.ClientService.remove(id);
		return ResponseEntity.ok(1);
	}
	
	
	@GetMapping(path = "/produto")
	public ResponseEntity<List<Product>> listarTodosProducts() {
		return ResponseEntity.ok(this.ProductService.listAll());
	}


	@GetMapping(path = "/produto/{id}")
	public ResponseEntity<Optional<Product>> listarProductPorId(@PathVariable(name = "id") String id) {
		return ResponseEntity.ok(this.ProductService.listById(id));
	}
	
	@GetMapping(path = "/produto/simular/{idClient}")
	public ResponseEntity<List<Product>> simularContratacao(@PathVariable(name = "idClient") String idClient) {

		var Client = this.ClientService.listById(idClient).get();
		var objRetorno = this.ProductService.simularContratacao(Client);

		return ResponseEntity.ok(objRetorno);
	}
	
	@PutMapping(path = "/produto/{id}")
	public ResponseEntity<Product> atualizarProduct(@PathVariable(name = "id") String id,
			@RequestBody Product Product) {
		Product.setId(id);
		return ResponseEntity.ok(this.ProductService.register(Product));
	}
	
	@GetMapping(path = "/cliente/contratar/{idClient}/{idProduct}")
	public ResponseEntity<String> contratacao(@PathVariable(name = "idProduct") String idProduct, @PathVariable(name = "idClient") String idClient) {

		var cliente = this.ClientService.listById(idClient).get();
		var produto = this.ProductService.listById(idProduct).get();
		
		var clienteN = this.ClientService.Contratacao(produto, cliente);
		
		return ResponseEntity.ok("Sucesso na contratação! - Cliente cpf:" 
		+ clienteN.getCpf() + ", Id Produto: " + clienteN.getProduto() );
	}

//	@PostMapping(path = "/produto")
//	public ResponseEntity<Product> cadastrarProduct(Product Product) {
//		return ResponseEntity.ok(this.ProductService.register(Product));
//	}

	

//	@DeleteMapping(path = "/produto/{id}")
//	public ResponseEntity<Integer> deletarProduct(@PathVariable(name = "id") String id) {
//		this.ProductService.remove(id);
//		return ResponseEntity.ok(1);
//	}

	

	/*public ResponseEntity<String> contratacao(@PathVariable(name = "idProduct") String idProduct, @PathVariable(name = "idClient") String idClient) {

		this.contratar.Contratacao(idProduct, idClient);
		return ResponseEntity.ok("Sucesso na contratação!");
	}*/
	
	
}
