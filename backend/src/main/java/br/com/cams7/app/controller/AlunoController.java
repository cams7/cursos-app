/**
 * 
 */
package br.com.cams7.app.controller;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import br.com.cams7.app.View;
import br.com.cams7.app.model.AlunoEntity;
import br.com.cams7.app.service.AlunoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @author ceanm
 *
 */
@RestController()
@RequestMapping(path = "/alunos", produces = APPLICATION_JSON_UTF8_VALUE)
@Api("Endpoint utilizado para criação, recuperação, atualização e exclusão de alunos.")
public class AlunoController {

	@Autowired
	private AlunoService alunoService;

	@ApiOperation("Lista todos os alunos.")
	@JsonView(View.Public.class)
	@PreAuthorize("hasRole('USER')")
	@ResponseStatus(value = OK)
	@GetMapping
	public Iterable<AlunoEntity> getAllAlunos() {
		return alunoService.getAllAlunos();
	}

	@ApiOperation("Busca os alunos pelo nome e curso.")
	@JsonView(View.Public.class)
	@PreAuthorize("hasRole('USER')")
	@ResponseStatus(value = OK)
	@GetMapping(params = { "aluno", "curso" })
	public Iterable<AlunoEntity> getAlunosByNomeAndCurso(
			@ApiParam("Nome do aluno.") @RequestParam(value = "aluno", required = true) String alunoNome,
			@ApiParam("Nome do curso.") @RequestParam(value = "curso", required = true) String cursoNome) {
		return alunoService.getAlunosByNomeAndCurso(alunoNome, cursoNome);
	}

	@ApiOperation("Busca o aluno pelo ID.")
	@JsonView(View.Public.class)
	@PreAuthorize("hasRole('USER')")
	@ResponseStatus(value = OK)
	@GetMapping(path = "{id}")
	public AlunoEntity getAlunoById(@ApiParam("ID do aluno.") @PathVariable(value = "id") Long alunoId) {
		AlunoEntity aluno = alunoService.getAlunoById(alunoId);
		return aluno;
	}

	@ApiOperation("Cadastra um novo aluno.")
	@PreAuthorize("hasRole('ADMIN')")
	@ResponseStatus(value = CREATED)
	@PostMapping(consumes = APPLICATION_JSON_UTF8_VALUE)
	public AlunoEntity createAluno(@ApiParam("Entidade aluno.") @Valid @RequestBody AlunoEntity aluno) {
		AlunoEntity savedAluno = alunoService.createAluno(aluno);
		return savedAluno;
	}

	@ApiOperation("Atualiza o aluno pelo ID.")
	@PreAuthorize("hasRole('ADMIN')")
	@ResponseStatus(value = OK)
	@PutMapping(consumes = APPLICATION_JSON_UTF8_VALUE)
	public void updateAluno(@ApiParam("Entidade aluno.") @Valid @RequestBody AlunoEntity aluno) {
		alunoService.updateAluno(aluno);
	}

	@ApiOperation("Remove o aluno pelo ID.")
	@PreAuthorize("hasRole('ADMIN')")
	@ResponseStatus(value = OK)
	@DeleteMapping(path = "{id}")
	public void deleteAluno(@ApiParam("ID do aluno.") @PathVariable(value = "id") Long alunoId) {
		alunoService.deleteAluno(alunoId);
	}
}
