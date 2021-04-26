package com.projetozup.ProjetoZup.controller;

import java.util.List;

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

import com.projetozup.ProjetoZup.entities.Endereco;
import com.projetozup.ProjetoZup.service.EnderecoService;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

	@Autowired
	private EnderecoService service;
	
	@GetMapping
	public List buscarTodosEnderecos() {
		return service.buscarTodosEnderecos();
	}
	
	@GetMapping(value = "{id}")
	public ResponseEntity<?> buscarPorIdDoEndereco(@PathVariable Long id){
		return service.buscarPorIdDoEndereco(id);
	}
	
	@PostMapping
	public ResponseEntity<?> salvarEndereco(@RequestBody Endereco endereco) {
		return service.salvarEndereco(endereco);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@PutMapping(value = "{id}")
	public ResponseEntity<?> atualizarEndereco(@PathVariable long id, @RequestBody Endereco endereco){
		return service.atualizarEndereco(id, endereco);
	}
	
	@DeleteMapping(path = { "{id}" })
	public ResponseEntity<?> excluirEndereco(@PathVariable long id) {
		return service.excluirEndereco(id);
	}

}
