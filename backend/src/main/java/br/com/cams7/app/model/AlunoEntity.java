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
import javax.validation.constraints.NotEmpty;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonView;

import br.com.cams7.app.View;
import br.com.cams7.app.audit.Auditable;

/**
 * @author ceanm
 *
 */
@NamedEntityGraph(name = AlunoEntity.SHOW_CURSOS, attributeNodes = { @NamedAttributeNode("cursos") })
@NamedEntityGraph(name = AlunoEntity.SHOW_CURSOS_AND_CREATEDBY_AND_LASTMODIFIEDBY, attributeNodes = {
		@NamedAttributeNode("createdBy"), @NamedAttributeNode("lastModifiedBy"), @NamedAttributeNode("cursos") })
@Entity
@Table(name = "tb_aluno", uniqueConstraints = { @UniqueConstraint(columnNames = { "email" }) })
@EntityListeners(AuditingEntityListener.class)
public class AlunoEntity extends Auditable {

	public static final String SHOW_CURSOS = "Aluno.showCursos";
	public static final String SHOW_CURSOS_AND_CREATEDBY_AND_LASTMODIFIEDBY = "Aluno.showCursosAndCreatedByAndLastModifiedBy";

	@JsonView(View.Public.class)
	@Id
	@SequenceGenerator(name = "sq_aluno", sequenceName = "sq_aluno", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_aluno")
	@Column(name = "id_aluno")
	private Long id;

	@JsonView(View.Public.class)
	@NotEmpty
	@Column(nullable = false)
	private String nome;

	@JsonView(View.Public.class)
	@Email
	@NotEmpty
	@Column(nullable = false)
	private String email;

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
