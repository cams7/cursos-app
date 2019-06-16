/**
 * 
 */
package br.com.cams7.app.repository;

import java.util.List;

import br.com.cams7.app.model.AlunoEntity;

/**
 * @author ceanm
 *
 */
public interface AlunoRepositoryCustom {

	List<AlunoEntity> findAlunosByNomeAndCurso(String alunoNome, String cursoNome);

}
