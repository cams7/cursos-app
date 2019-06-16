/**
 * 
 */
package br.com.cams7.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.cams7.app.model.CursoEntity;

/**
 * @author ceanm
 *
 */
public interface CursoRepository extends CursoRepositoryCustom, JpaRepository<CursoEntity, Long> {

	@Modifying(flushAutomatically = true)
	@Query("UPDATE CursoEntity SET temAlunosMatriculados = :temAlunosMatriculados WHERE id = :cursoId")
	void updateCurso(@Param("cursoId") Long cursoId, @Param("temAlunosMatriculados") boolean temAlunosMatriculados);
	
	@Query("SELECT c.temAlunosMatriculados FROM CursoEntity c WHERE c.id = :cursoId")
	boolean isTemAlunosMatriculados(@Param("cursoId") Long cursoId);

}
