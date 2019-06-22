/**
 * 
 */
package br.com.cams7.app.security;

import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

import br.com.cams7.app.model.UsuarioEntity;
import lombok.Getter;

/**
 * @author ceanm
 *
 */
@SuppressWarnings("serial")
public class UsuarioLogado extends User {

	@Getter
	private UsuarioEntity usuario;

	public static final List<GrantedAuthority> getAuthorities(boolean isAdmin) {
		return isAdmin ? AuthorityUtils.createAuthorityList("ROLE_USER", "ROLE_ADMIN")
				: AuthorityUtils.createAuthorityList("ROLE_USER");
	}

	public UsuarioLogado(UsuarioEntity usuario) {
		super(usuario.getNome(), usuario.getSenha(), getAuthorities(usuario.isAdmin()));
		this.usuario = usuario;
	}

	public UsuarioLogado(UsuarioEntity usuario, boolean enabled, boolean accountNonExpired,
			boolean credentialsNonExpired, boolean accountNonLocked) {
		super(usuario.getNome(), usuario.getSenha(), enabled, accountNonExpired, credentialsNonExpired,
				accountNonLocked, getAuthorities(usuario.isAdmin()));
		this.usuario = usuario;
	}

}
