/**
 * 
 */
package br.com.cams7.app.service;

import java.util.List;

import br.com.cams7.app.model.CursoEntity;

/**
 * @author ceanm
 *
 */
public interface CursoService {
	List<CursoEntity> getAllCursos();

	CursoEntity getCursoById(Long cursoId);

	CursoEntity createCurso(CursoEntity curso);

	CursoEntity updateCurso(Long cursoId, CursoEntity curso);

	void updateCurso(Long cursoId, boolean temAlunosMatriculados);

	void deleteCurso(Long cursoId);
}
