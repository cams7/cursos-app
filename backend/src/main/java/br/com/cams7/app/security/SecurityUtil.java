/**
 * 
 */
package br.com.cams7.app.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import br.com.cams7.app.model.UsuarioEntity;

/**
 * @author ceanm
 *
 */
public final class SecurityUtil {
	public static final UsuarioEntity getUsuarioLogado() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication == null)
			return null;

		return (UsuarioEntity) authentication.getPrincipal();
	}

}
