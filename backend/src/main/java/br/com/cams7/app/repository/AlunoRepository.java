/**
 * 
 */
package br.com.cams7.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.cams7.app.model.AlunoEntity;

/**
 * @author ceanm
 *
 */
public interface AlunoRepository extends AlunoRepositoryCustom, JpaRepository<AlunoEntity, Long> {

	@EntityGraph(value = AlunoEntity.SHOW_CURSOS_AND_CREATEDBY_AND_LASTMODIFIEDBY)
	@Query("SELECT a FROM AlunoEntity a WHERE a.id = :alunoId")
	Optional<AlunoEntity> findAlunoWithCursosById(@Param("alunoId") Long alunoId);

}
