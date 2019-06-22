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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonView;

import br.com.cams7.app.View;
import br.com.cams7.app.audit.Auditable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author ceanm
 *
 */
@ApiModel(description = "Classe que representa um usuário.")
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(of = "id", callSuper = false)
@Entity
@Table(name = "tb_usuario")
@EntityListeners(AuditingEntityListener.class)
public class UsuarioEntity extends Auditable {

	@ApiModelProperty(notes = "Identificador unico do usuário.", example = "1", required = true, position = 0)
	@JsonView(View.Public.class)
	@Id
	@SequenceGenerator(name = "sq_usuario", sequenceName = "sq_usuario", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_usuario")
	@Column(name = "id_usuario")
	private Long id;

	@ApiModelProperty(notes = "Nome do usuário.", example = "jose1981", required = true, position = 5)
	@JsonView(View.Public.class)
	@NotBlank
	@Size(min = 3, max = 30)
	private String nome;

	@ApiModelProperty(notes = "Senha criptografada do usuário.", example = "CR!PT0GR@F!@", required = true, position = 6)
	@JsonView(View.LoggedIn.class)
	@Column(nullable = false, length = 100)
	private String senha;

	@ApiModelProperty(notes = "Flag que indica se o usuário é um administrador.", required = true, position = 7)
	@Column(name = "administrador", nullable = false)
	private boolean admin;
}
