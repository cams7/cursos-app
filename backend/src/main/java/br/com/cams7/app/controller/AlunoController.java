/**
 * 
 */
package br.com.cams7.app.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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

/**
 * @author ceanm
 *
 */
@RestController
@RequestMapping("/alunos")
public class AlunoController {

	@Autowired
	private AlunoService alunoService;

	@JsonView(View.Public.class)
	@GetMapping
	public List<AlunoEntity> getAllAlunos() {
		return alunoService.getAllAlunos();
	}

	@JsonView(View.Public.class)
	@GetMapping(params = { "aluno", "curso" })
	public List<AlunoEntity> getAlunosByNomeAndCurso(@RequestParam("aluno") String alunoNome,
			@RequestParam("curso") String cursoNome) {
		return alunoService.getAlunosByNomeAndCurso(alunoNome, cursoNome);
	}

	@JsonView(View.Public.class)
	@GetMapping("{id}")
	public ResponseEntity<AlunoEntity> getAlunoById(@PathVariable(value = "id") Long alunoId) {
		AlunoEntity aluno = alunoService.getAlunoById(alunoId);
		return ResponseEntity.ok().body(aluno);
	}

	@PostMapping
	public AlunoEntity createAluno(@Valid @RequestBody AlunoEntity aluno) {
		AlunoEntity savedAluno = alunoService.createAluno(aluno);
		return savedAluno;
	}

	@PutMapping("{id}")
	public ResponseEntity<AlunoEntity> updateAluno(@PathVariable(value = "id") Long alunoId,
			@Valid @RequestBody AlunoEntity aluno) {
		final AlunoEntity updatedAluno = alunoService.updateAluno(alunoId, aluno);
		return ResponseEntity.ok(updatedAluno);
	}

	@DeleteMapping("{id}")
	public Map<String, Boolean> deleteAluno(@PathVariable(value = "id") Long alunoId) {
		alunoService.deleteAluno(alunoId);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
