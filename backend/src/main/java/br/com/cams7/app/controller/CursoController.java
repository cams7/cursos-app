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
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import br.com.cams7.app.View;
import br.com.cams7.app.model.CursoEntity;
import br.com.cams7.app.service.CursoService;

/**
 * @author ceanm
 *
 */
@RestController
@RequestMapping("/cursos")
public class CursoController {

	@Autowired
	private CursoService cursoService;

	@JsonView(View.Public.class)
	@GetMapping
	public List<CursoEntity> getAllCursos() {
		return cursoService.getAllCursos();
	}

	@JsonView(View.Public.class)
	@GetMapping("{id}")
	public ResponseEntity<CursoEntity> getCursoById(@PathVariable(value = "id") Long cursoId) {
		CursoEntity curso = cursoService.getCursoById(cursoId);
		return ResponseEntity.ok().body(curso);
	}

	@PostMapping
	public CursoEntity createCurso(@Valid @RequestBody CursoEntity curso) {
		CursoEntity savedCurso = cursoService.createCurso(curso);
		return savedCurso;
	}

	@PutMapping("{id}")
	public ResponseEntity<CursoEntity> updateCurso(@PathVariable(value = "id") Long cursoId,
			@Valid @RequestBody CursoEntity curso) {
		final CursoEntity updatedCurso = cursoService.updateCurso(cursoId, curso);
		return ResponseEntity.ok(updatedCurso);
	}

	@DeleteMapping("{id}")
	public Map<String, Boolean> deleteCurso(@PathVariable(value = "id") Long cursoId) {
		cursoService.deleteCurso(cursoId);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
