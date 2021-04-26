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

import com.projetozup.ProjetoZup.entities.Usuario;
import com.projetozup.ProjetoZup.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioService service;
	
	@GetMapping("/buscar")
	public ResponseEntity<?> buscarTodosUsuarios() {
		return service.buscarTodosUsuarios();
	}

	@GetMapping(value = "{id}")
	public ResponseEntity<?> buscarPorIdDoUsuario(@PathVariable Long id) {
		return service.buscarPorIdDoUsuario(id);
	}
	
	@PostMapping
	public ResponseEntity<?> salvarUsuario(@RequestBody Usuario usuario) {
		return service.salvarUsuario(usuario);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@PutMapping(value = "{id}")
	public ResponseEntity<?> atualizarUsuario(@PathVariable long id, @RequestBody Usuario usuario){
			return service.atualizarUsuario(id, usuario);		
	}
	
	@DeleteMapping(path = { "{id}" })
	public ResponseEntity<?> excluirUsuario(@PathVariable long id) {
		return service.excluirUsuario(id);
	
	}
}
