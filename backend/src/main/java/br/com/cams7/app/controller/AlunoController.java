/**
 * 
 */
package br.com.cams7.app.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
@RequestMapping(path = "/alunos", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@Api("Endpoint utilizado para criação, recuperação, atualização e exclusão de alunos.")
public class AlunoController {

	@Autowired
	private AlunoService alunoService;

	@ApiOperation("Lista todos os alunos.")
	@JsonView(View.Public.class)
	@GetMapping()
	public List<AlunoEntity> getAllAlunos() {
		return alunoService.getAllAlunos();
	}

	@ApiOperation("Busca os alunos pelo nome e curso.")
	@JsonView(View.Public.class)
	@GetMapping(params = { "aluno", "curso" })
	public List<AlunoEntity> getAlunosByNomeAndCurso(
			@ApiParam("Nome do aluno.") @RequestParam(value = "aluno", required = true) String alunoNome,
			@ApiParam("Nome do curso.") @RequestParam(value = "curso", required = true) String cursoNome) {
		return alunoService.getAlunosByNomeAndCurso(alunoNome, cursoNome);
	}

	@ApiOperation("Busca o aluno pelo ID.")
	@JsonView(View.Public.class)
	@GetMapping(path = "{id}")
	public ResponseEntity<AlunoEntity> getAlunoById(
			@ApiParam("ID do aluno.") @PathVariable(value = "id") Long alunoId) {
		AlunoEntity aluno = alunoService.getAlunoById(alunoId);
		return ResponseEntity.ok().body(aluno);
	}

	@ApiOperation("Cadastra um novo aluno.")
	@PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public AlunoEntity createAluno(@ApiParam("Entidade aluno.") @Valid @RequestBody AlunoEntity aluno) {
		AlunoEntity savedAluno = alunoService.createAluno(aluno);
		return savedAluno;
	}

	@ApiOperation("Atualiza o aluno pelo ID.")
	@PutMapping(path = "{id}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<AlunoEntity> updateAluno(@ApiParam("ID do aluno.") @PathVariable(value = "id") Long alunoId,
			@ApiParam("Entidade aluno.") @Valid @RequestBody AlunoEntity aluno) {
		final AlunoEntity updatedAluno = alunoService.updateAluno(alunoId, aluno);
		return ResponseEntity.ok(updatedAluno);
	}

	@ApiOperation("Remove o aluno pelo ID.")
	@DeleteMapping(path = "{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Map<String, Boolean> deleteAluno(@ApiParam("ID do aluno.") @PathVariable(value = "id") Long alunoId) {
		alunoService.deleteAluno(alunoId);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
