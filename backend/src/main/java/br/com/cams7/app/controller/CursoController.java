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
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import br.com.cams7.app.View;
import br.com.cams7.app.model.CursoEntity;
import br.com.cams7.app.service.CursoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @author ceanm
 *
 */
@RestController
@RequestMapping(path = "/cursos", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@Api("Endpoint utilizado para criação, recuperação, atualização e exclusão de cursos.")
public class CursoController {

	@Autowired
	private CursoService cursoService;

	@ApiOperation("Lista todos os cursos.")
	@JsonView(View.Public.class)
	@GetMapping
	public List<CursoEntity> getAllCursos() {
		return cursoService.getAllCursos();
	}

	@ApiOperation("Busca o curso pelo ID.")
	@JsonView(View.Public.class)
	@GetMapping(path = "{id}")
	public ResponseEntity<CursoEntity> getCursoById(
			@ApiParam("ID do curso.") @PathVariable(value = "id") Long cursoId) {
		CursoEntity curso = cursoService.getCursoById(cursoId);
		return ResponseEntity.ok().body(curso);
	}

	@ApiOperation("Cadastra um novo curso.")
	@PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public CursoEntity createCurso(@ApiParam("Entidade curso.") @Valid @RequestBody CursoEntity curso) {
		CursoEntity savedCurso = cursoService.createCurso(curso);
		return savedCurso;
	}

	@ApiOperation("Atualiza o curso pelo ID.")
	@PutMapping(path = "{id}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<CursoEntity> updateCurso(@ApiParam("ID do curso.") @PathVariable(value = "id") Long cursoId,
			@ApiParam("Entidade curso.") @Valid @RequestBody CursoEntity curso) {
		final CursoEntity updatedCurso = cursoService.updateCurso(cursoId, curso);
		return ResponseEntity.ok(updatedCurso);
	}

	@ApiOperation("Remove o curso pelo ID.")
	@DeleteMapping(path = "{id}")
	public Map<String, Boolean> deleteCurso(@ApiParam("ID do curso.") @PathVariable(value = "id") Long cursoId) {
		cursoService.deleteCurso(cursoId);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
