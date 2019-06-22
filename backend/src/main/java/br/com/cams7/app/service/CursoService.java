/**
 * 
 */
package br.com.cams7.app.service;

import br.com.cams7.app.model.CursoEntity;

/**
 * @author ceanm
 *
 */
public interface CursoService {
	Iterable<CursoEntity> getAllCursos();

	CursoEntity getCursoById(Long cursoId);

	CursoEntity createCurso(CursoEntity curso);

	void updateCurso(CursoEntity curso);

	void updateCurso(Long cursoId, boolean temAlunosMatriculados);

	void deleteCurso(Long cursoId);
}
