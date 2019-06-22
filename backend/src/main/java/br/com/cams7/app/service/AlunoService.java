/**
 * 
 */
package br.com.cams7.app.service;

import br.com.cams7.app.model.AlunoEntity;

/**
 * @author ceanm
 *
 */
public interface AlunoService {
	Iterable<AlunoEntity> getAllAlunos();
	
	Iterable<AlunoEntity> getAlunosByNomeAndCurso(String alunoNome, String cursoNome);

	AlunoEntity getAlunoById(Long alunoId);

	AlunoEntity createAluno(AlunoEntity aluno);

	void updateAluno(AlunoEntity aluno);

	void deleteAluno(Long alunoId);
}
