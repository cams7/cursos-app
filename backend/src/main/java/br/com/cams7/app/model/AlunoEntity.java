/**
 * 
 */
package br.com.cams7.app.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonView;

import br.com.cams7.app.View;
import br.com.cams7.app.audit.Auditable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author ceanm
 *
 */
@ApiModel(description = "Classe que representa um aluno.")
@NamedEntityGraph(name = AlunoEntity.SHOW_CURSOS, attributeNodes = { @NamedAttributeNode("cursos") })
@NamedEntityGraph(name = AlunoEntity.SHOW_CURSOS_AND_CREATEDBY_AND_LASTMODIFIEDBY, attributeNodes = {
		@NamedAttributeNode("createdBy"), @NamedAttributeNode("lastModifiedBy"), @NamedAttributeNode("cursos") })
@Entity
@Table(name = "tb_aluno", uniqueConstraints = { @UniqueConstraint(columnNames = { "email" }) })
@EntityListeners(AuditingEntityListener.class)
public class AlunoEntity extends Auditable {

	public static final String SHOW_CURSOS = "Aluno.showCursos";
	public static final String SHOW_CURSOS_AND_CREATEDBY_AND_LASTMODIFIEDBY = "Aluno.showCursosAndCreatedByAndLastModifiedBy";

	@ApiModelProperty(notes = "Identificador unico do aluno.", example = "1", required = true, position = 0)
	@JsonView(View.Public.class)
	@Id
	@SequenceGenerator(name = "sq_aluno", sequenceName = "sq_aluno", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_aluno")
	@Column(name = "id_aluno")
	private Long id;

	@ApiModelProperty(notes = "Nome do aluno.", example = "Fábio Joaquim da Mata", required = true, position = 5)
	@JsonView(View.Public.class)
	@NotBlank
	@Size(min = 3, max = 50)
	private String nome;

	@ApiModelProperty(notes = "E-mail do aluno.", example = "fabio@teste.com", required = true, position = 6)
	@JsonView(View.Public.class)
	@NotBlank
	@Size(min = 10, max = 30)
	@Email
	private String email;

	@ApiModelProperty(notes = "Listagem com os cursos do aluno.", required = false, position = 3)
	@JsonView(View.Public.class)
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "tb_aluno_curso", joinColumns = { @JoinColumn(name = "id_aluno") }, inverseJoinColumns = {
			@JoinColumn(name = "id_curso") })
	private List<CursoEntity> cursos;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<CursoEntity> getCursos() {
		return cursos;
	}

	public void setCursos(List<CursoEntity> cursos) {
		this.cursos = cursos;
	}

}
