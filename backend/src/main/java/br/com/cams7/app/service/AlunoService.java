/**
 * 
 */
package br.com.cams7.app.service;

import java.util.List;

import br.com.cams7.app.model.AlunoEntity;

/**
 * @author ceanm
 *
 */
public interface AlunoService {
	List<AlunoEntity> getAllAlunos();
	
	List<AlunoEntity> getAlunosByNomeAndCurso(String alunoNome, String cursoNome);

	AlunoEntity getAlunoById(Long alunoId);

	AlunoEntity createAluno(AlunoEntity aluno);

	AlunoEntity updateAluno(Long alunoId, AlunoEntity aluno);

	void deleteAluno(Long alunoId);
}
