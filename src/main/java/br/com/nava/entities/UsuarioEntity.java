package br.com.nava.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "USUARIOS")
@Entity
public class UsuarioEntity {
	@Id // --> chave primária 
	@GeneratedValue(strategy = GenerationType.IDENTITY)//dizer cmo será gerada a chave primaria
	private int id;
	@Column (name = "nome") // -->a coluna do banco "nome" estará associada ao atributo "nome" 
	private String nome;
	private String email;
	
	
	//SELECT * FROM USUARIO U INNER JOINENDERECOS E
	//		ON U.ID = E.ID
	// JOIN COLUMN é a entidade mais forte(a que possui o campo com a chave estrangeira)
	
	@OneToOne
	@JoinColumn(name= "endereco_id")
	private EnderecoEntity endereco;
	
//	@Override
//	public String toString() {
//		return "UsuarioEntity [id=" + id + ", nome=" + nome + ", email=" + email + "]";
//	}
	@JsonIgnore
	@OneToMany(mappedBy = "usuario")
	private List<VendasEntity> vendas;
}
