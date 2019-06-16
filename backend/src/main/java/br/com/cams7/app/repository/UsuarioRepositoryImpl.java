/**
 * 
 */
package br.com.cams7.app.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

/**
 * @author ceanm
 *
 */
@Repository
public class UsuarioRepositoryImpl implements UsuarioRepositoryCustom {

	@PersistenceContext
	private EntityManager em;
}
