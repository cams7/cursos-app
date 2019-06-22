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
@ApiModel(description = "Classe que representa um curso.")
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(of = "id", callSuper = false)
@Entity
@Table(name = "tb_curso")
@EntityListeners(AuditingEntityListener.class)
public class CursoEntity extends Auditable {

	@ApiModelProperty(notes = "Identificador unico do curso.", example = "1", required = true, position = 0)
	@JsonView(View.Public.class)
	@Id
	@SequenceGenerator(name = "sq_curso", sequenceName = "sq_curso", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_curso")
	@Column(name = "id_curso")
	private Long id;

	@ApiModelProperty(notes = "Nome do curso.", example = "Curso de Java Básico", required = true, position = 5)
	@JsonView(View.Public.class)
	@NotBlank
	@Size(min = 3, max = 50)
	private String nome;

	@ApiModelProperty(notes = "Flag que indica se o curso tem alunos matriculas.", required = true, position = 6)
	@JsonView(View.Public.class)
	@Column(name = "tem_alunos_matriculados", nullable = false)
	private boolean temAlunosMatriculados;

	@ApiModelProperty(notes = "Listagem com os alunos do curso.", required = false, position = 7)
	@JsonView(View.Public.class)
	@ManyToMany(mappedBy = "cursos", fetch = FetchType.LAZY)
	private List<AlunoEntity> alunos;
}
