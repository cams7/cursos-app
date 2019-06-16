/**
 * 
 */
package br.com.cams7.app.audit;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;

import br.com.cams7.app.model.UsuarioEntity;

/**
 * @author ceanm
 *
 */
public class AuditorAwareImpl implements AuditorAware<UsuarioEntity> {

	@Override
	public Optional<UsuarioEntity> getCurrentAuditor() {
		return Optional.of(new UsuarioEntity(1l));
	}

}
