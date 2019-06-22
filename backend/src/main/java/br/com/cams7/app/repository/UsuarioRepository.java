/**
 * 
 */
package br.com.cams7.app.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import br.com.cams7.app.model.UsuarioEntity;

/**
 * @author ceanm
 *
 */
public interface UsuarioRepository extends UsuarioRepositoryCustom, CrudRepository<UsuarioEntity, Long> {
	
	Optional<UsuarioEntity> findByNome(String nome);

}
