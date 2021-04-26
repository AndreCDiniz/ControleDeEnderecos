package com.projetozup.ProjetoZup.service;

import java.util.Collection;
import java.util.Optional;

import org.hibernate.exception.GenericJDBCException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.stereotype.Service;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.projetozup.ProjetoZup.entities.Usuario;
import com.projetozup.ProjetoZup.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;

//	public ResponseEntity buscarPorIdDoUsuario(Long id) {
//		return repository.findById(id).map(record -> ResponseEntity.ok().body(record))
//				.orElse(ResponseEntity.notFound().build());
//	}

	public ResponseEntity<?> buscarPorIdDoUsuario(Long id) {
			Optional<Usuario> record = this.repository.findById(id);

			if (record.orElseGet(() -> null) != null) {
				return new ResponseEntity<Usuario>(record.get(), HttpStatus.OK);
			} else {
				return new ResponseEntity<String>("Usuário não localizado. Tente novamente!", HttpStatus.BAD_REQUEST);
			}
		}

	public ResponseEntity<?> buscarTodosUsuarios() {
		try {
			Collection<Usuario> lista = this.repository.findAll();
			return new ResponseEntity<Collection<Usuario>>(lista, HttpStatus.OK);
		} catch (MethodArgumentTypeMismatchException | NumberFormatException e) {
			e.printStackTrace();
			return new ResponseEntity<String>(
					"Não foi possível encontrar os dados. Verifique se o link digitado está correto.",
					HttpStatus.NOT_FOUND);
		}
	}

	public ResponseEntity<?> salvarUsuario(Usuario usuario) {
		try {
			return new ResponseEntity<Usuario>(this.repository.save(usuario), HttpStatus.CREATED);
		} catch (JpaSystemException | GenericJDBCException | HttpMessageNotReadableException
				| DataIntegrityViolationException e) {
			e.printStackTrace();
			return new ResponseEntity<String>(
					"Dados informados inválido! Verificar se os dados informados já foram cadastrados.",
					HttpStatus.BAD_REQUEST);
		}
	}

	public ResponseEntity<?> atualizarUsuario(long id, Usuario usuario) {
		try {
			return repository.findById(id).map(record -> {
				record.setCpf(usuario.getCpf());
				record.setNmUsuario(usuario.getNmUsuario());
				record.setEmail(usuario.getEmail());
				record.setDtNasc(usuario.getDtNasc());

				Usuario update = repository.save(record);

				return new ResponseEntity(update, HttpStatus.OK);
			}).orElse(ResponseEntity.badRequest()
					.body("Não foi possível atualizar o usuário. Por favor, tente novamente."));
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity("Erro não identificado", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	public ResponseEntity<?> excluirUsuario(long id) {
		return repository.findById(id).map(record -> {
			repository.deleteById(id);

			return ResponseEntity.ok().body("Usuario do ID " + id + " foi deletado com sucesso!");
		}).orElse(ResponseEntity.notFound().build());
	}

}
