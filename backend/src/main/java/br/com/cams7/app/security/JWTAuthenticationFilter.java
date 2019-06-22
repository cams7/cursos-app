/**
 * 
 */
package br.com.cams7.app.security;

import java.io.IOException;
import java.util.Collections;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.cams7.app.model.UsuarioEntity;

/**
 * @author cams7
 *
 */
public class JWTAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

	public JWTAuthenticationFilter(String url, AuthenticationManager authenticationManager) {
		super(new AntPathRequestMatcher(url));
		setAuthenticationManager(authenticationManager);
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException, JsonParseException, JsonMappingException, IOException {
		UsuarioEntity usuario = new ObjectMapper().readValue(request.getInputStream(), UsuarioEntity.class);

		return getAuthenticationManager().authenticate(new UsernamePasswordAuthenticationToken(usuario.getNome(),
				usuario.getSenha(), Collections.emptyList()));
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {

		UsuarioLogado usuarioLogado = (UsuarioLogado) authResult.getPrincipal();
		UsuarioEntity usuario = usuarioLogado.getUsuario();

		TokenAuthenticationService.addAuthentication(response, usuario);
	}
}
