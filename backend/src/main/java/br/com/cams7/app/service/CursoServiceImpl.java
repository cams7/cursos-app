/**
 * 
 */
package br.com.cams7.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.cams7.app.model.CursoEntity;
import br.com.cams7.app.repository.CursoRepository;

/**
 * @author ceanm
 *
 */
@Service
@Transactional
public class CursoServiceImpl implements CursoService {

	@Autowired
	private CursoRepository cursoRepository;

	@Transactional(readOnly = true)
	@Override
	public List<CursoEntity> getAllCursos() {
		return cursoRepository.findAll();
	}

	@Transactional(readOnly = true)
	@Override
	public CursoEntity getCursoById(Long cursoId) {
		return cursoRepository.findById(cursoId).get();
	}

	@Override
	public CursoEntity createCurso(CursoEntity curso) {
		return cursoRepository.save(curso);
	}

	@Override
	public CursoEntity updateCurso(Long cursoId, CursoEntity curso) {
		return createCurso(curso);
	}

	@Override
	public void updateCurso(Long cursoId, boolean temAlunosMatriculados) {
		if (cursoId == 4l)
			throw new IllegalArgumentException("O curso \"Curso de Excel Avançado\" já esta lotado");

		if (!cursoRepository.isTemAlunosMatriculados(cursoId))
			cursoRepository.updateCurso(cursoId, temAlunosMatriculados);
	}

	@Override
	public void deleteCurso(Long cursoId) {
		cursoRepository.deleteById(cursoId);
	}

}
