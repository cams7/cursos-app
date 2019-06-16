/**
 * 
 */
package br.com.cams7.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonView;

import br.com.cams7.app.View;
import br.com.cams7.app.audit.Auditable;

/**
 * @author ceanm
 *
 */
@Entity
@Table(name = "tb_usuario")
@EntityListeners(AuditingEntityListener.class)
public class UsuarioEntity extends Auditable {

	@JsonView(View.Public.class)
	@Id
	@SequenceGenerator(name = "sq_usuario", sequenceName = "sq_usuario", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_usuario")
	@Column(name = "id_usuario")
	private Long id;

	@JsonView(View.Public.class)
	@NotEmpty
	@Column(nullable = false)
	private String nome;

	@JsonView(View.LoggedIn.class)
	@NotEmpty
	@Column(nullable = false)
	private String senha;

	public UsuarioEntity() {
		super();
	}

	public UsuarioEntity(Long id) {
		super();
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
