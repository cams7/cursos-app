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
import javax.persistence.ManyToMany;
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
@Table(name = "tb_curso")
@EntityListeners(AuditingEntityListener.class)
public class CursoEntity extends Auditable {

	@JsonView(View.Public.class)
	@Id
	@SequenceGenerator(name = "sq_curso", sequenceName = "sq_curso", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_curso")
	@Column(name = "id_curso")
	private Long id;

	@JsonView(View.Public.class)
	@NotEmpty
	@Column(nullable = false)
	private String nome;

	@JsonView(View.Public.class)
	@Column(name = "tem_alunos_matriculados")
	private boolean temAlunosMatriculados;

	@JsonView(View.Public.class)
	@ManyToMany(mappedBy = "cursos", fetch = FetchType.LAZY)
	private List<AlunoEntity> alunos;

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

	public boolean isTemAlunosMatriculados() {
		return temAlunosMatriculados;
	}

	public void setTemAlunosMatriculados(boolean temAlunosMatriculados) {
		this.temAlunosMatriculados = temAlunosMatriculados;
	}

	public List<AlunoEntity> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<AlunoEntity> alunos) {
		this.alunos = alunos;
	}

}
