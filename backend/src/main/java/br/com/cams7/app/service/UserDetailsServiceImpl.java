/**
 * 
 */
package br.com.cams7.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.cams7.app.error.ResourceNotFoundException;
import br.com.cams7.app.model.UsuarioEntity;
import br.com.cams7.app.security.UsuarioLogado;

/**
 * @author cams7
 *
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UsuarioService usuarioService;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.security.core.userdetails.UserDetailsService#
	 * loadUserByUsername(java.lang.String)
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		try {
			UsuarioEntity usuario = usuarioService.getUsuarioByNome(username);
			return new UsuarioLogado(usuario);
		} catch (ResourceNotFoundException e) {
			throw new UsernameNotFoundException(e.getMessage());
		}
	}

}
