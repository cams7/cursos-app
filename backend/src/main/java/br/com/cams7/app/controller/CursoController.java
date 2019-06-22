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
import org.springframework.web.bind.annotation.ResponseStatus;
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
@RequestMapping(path = "/cursos", produces = APPLICATION_JSON_UTF8_VALUE)
@Api("Endpoint utilizado para criação, recuperação, atualização e exclusão de cursos.")
public class CursoController {

	@Autowired
	private CursoService cursoService;

	@ApiOperation("Lista todos os cursos.")
	@JsonView(View.Public.class)
	@PreAuthorize("hasRole('USER')")
	@ResponseStatus(value = OK)
	@GetMapping
	public Iterable<CursoEntity> getAllCursos() {
		return cursoService.getAllCursos();
	}

	@ApiOperation("Busca o curso pelo ID.")
	@JsonView(View.Public.class)
	@PreAuthorize("hasRole('USER')")
	@ResponseStatus(value = OK)
	@GetMapping(path = "{id}")
	public CursoEntity getCursoById(@ApiParam("ID do curso.") @PathVariable(value = "id") Long cursoId) {
		CursoEntity curso = cursoService.getCursoById(cursoId);
		return curso;
	}

	@ApiOperation("Cadastra um novo curso.")
	@PreAuthorize("hasRole('ADMIN')")
	@ResponseStatus(value = CREATED)
	@PostMapping(consumes = APPLICATION_JSON_UTF8_VALUE)
	public CursoEntity createCurso(@ApiParam("Entidade curso.") @Valid @RequestBody CursoEntity curso) {
		CursoEntity savedCurso = cursoService.createCurso(curso);
		return savedCurso;
	}

	@ApiOperation("Atualiza o curso pelo ID.")
	@PreAuthorize("hasRole('ADMIN')")
	@ResponseStatus(value = OK)
	@PutMapping(consumes = APPLICATION_JSON_UTF8_VALUE)
	public void updateCurso(@ApiParam("Entidade curso.") @Valid @RequestBody CursoEntity curso) {
		cursoService.updateCurso(curso);
	}

	@ApiOperation("Remove o curso pelo ID.")
	@PreAuthorize("hasRole('ADMIN')")
	@ResponseStatus(value = OK)
	@DeleteMapping(path = "{id}")
	public void deleteCurso(@ApiParam("ID do curso.") @PathVariable(value = "id") Long cursoId) {
		cursoService.deleteCurso(cursoId);
	}
}
