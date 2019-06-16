/**
 * 
 */
package br.com.cams7.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.cams7.app.model.AlunoEntity;
import br.com.cams7.app.model.CursoEntity;
import br.com.cams7.app.repository.AlunoRepository;

/**
 * @author ceanm
 *
 */
@Service
@Transactional
public class AlunoServiceImpl implements AlunoService {

	@Autowired
	private AlunoRepository alunoRepository;

	@Autowired
	private CursoService cursoService;

	@Transactional(readOnly = true)
	@Override
	public List<AlunoEntity> getAllAlunos() {
		return alunoRepository.findAll();
	}

	@Transactional(readOnly = true)
	@Override
	public List<AlunoEntity> getAlunosByNomeAndCurso(String alunoNome, String cursoNome) {
		return alunoRepository.findAlunosByNomeAndCurso(alunoNome, cursoNome);
	}

	@Transactional(readOnly = true)
	@Override
	public AlunoEntity getAlunoById(Long alunoId) {
		return alunoRepository.findAlunoWithCursosById(alunoId).get();
	}

	@Override
	public AlunoEntity createAluno(AlunoEntity aluno) {
		AlunoEntity savedAluno = alunoRepository.save(aluno);
		List<CursoEntity> cursos = savedAluno.getCursos();
		if (cursos != null)
			cursos.stream().filter(curso -> curso.getId() != null).mapToLong(curso -> curso.getId())
					.forEach(cursoId -> {
						if (cursoId == 1l)
							throw new RuntimeException("O curso \"Curso de Springboot 2 e Angular 8\" já esta lotado");
						cursoService.updateCurso(cursoId, true);
					});

		return savedAluno;
	}

	@Override
	public AlunoEntity updateAluno(Long alunoId, AlunoEntity aluno) {
		return createAluno(aluno);
	}

	@Override
	public void deleteAluno(Long alunoId) {
		alunoRepository.deleteById(alunoId);
	}

}
