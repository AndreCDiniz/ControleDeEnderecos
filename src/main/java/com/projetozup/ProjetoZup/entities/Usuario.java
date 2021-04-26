package com.projetozup.ProjetoZup.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "Usuario")
@Table(name = "Usuario")
public class Usuario implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario")
	private Long idUsuario;
	
	@Column(name = "cpf")
	private String cpf;
	@Column(name = "nm_usuario")
	private String nmUsuario;
	@Column(name = "email")
	private String email;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	@Column(name = "dt_nasc")
	private LocalDate dtNasc;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "id_usuario", foreignKey = @ForeignKey(name = "fk_endereco_usuario"))
	@JsonManagedReference	
	private List<Endereco> enderecoList = new ArrayList<>();

	public void addEndereco(Endereco endereco) {
		enderecoList.add(endereco);
	}
	
	public void removerEndereco(Endereco endereco) {
		enderecoList.remove(endereco);
	}

	public Usuario(Long idUsuario, String cpf, String nmUsuario, String email, LocalDate dtNasc,
			List<Endereco> enderecoList) {
		super();
		this.idUsuario = idUsuario;
		this.cpf = cpf;
		this.nmUsuario = nmUsuario;
		this.email = email;
		this.dtNasc = dtNasc;
		this.enderecoList = enderecoList;
	}
	
	public Usuario(){}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNmUsuario() {
		return nmUsuario;
	}

	public void setNmUsuario(String nmUsuario) {
		this.nmUsuario = nmUsuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDtNasc() {
		return dtNasc;
	}

	public void setDtNasc(LocalDate dtNasc) {
		this.dtNasc = dtNasc;
	}

	public List<Endereco> getEnderecoList() {
		return enderecoList;
	}

	public void setEnderecoList(List<Endereco> enderecoList) {
		this.enderecoList = enderecoList;
	}
	
	
	

}
