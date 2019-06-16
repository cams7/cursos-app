/**
 * 
 */
package br.com.cams7.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cams7.app.model.UsuarioEntity;

/**
 * @author ceanm
 *
 */
public interface UsuarioRepository extends UsuarioRepositoryCustom, JpaRepository<UsuarioEntity, Long> {

}
