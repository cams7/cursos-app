/**
 * 
 */
package br.com.cams7.app.security;

import static br.com.cams7.app.security.SecurityConstants.EXPIRATION_TIME;
import static br.com.cams7.app.security.SecurityConstants.HEADER_STRING;
import static br.com.cams7.app.security.SecurityConstants.JWT_SUBJECT;
import static br.com.cams7.app.security.SecurityConstants.SECRET;
import static br.com.cams7.app.security.SecurityConstants.TOKEN_PREFIX;
import static br.com.cams7.app.security.SecurityConstants.USUARIO_ADMIN;
import static br.com.cams7.app.security.SecurityConstants.USUARIO_ID;
import static br.com.cams7.app.security.SecurityConstants.USUARIO_NOME;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import br.com.cams7.app.model.UsuarioEntity;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * @author ceanm
 *
 */
public class TokenAuthenticationService {

	public static void addAuthentication(HttpServletResponse response, UsuarioEntity user) throws IOException {
		// @formatter:off
		String token = Jwts.builder()
				.setSubject(JWT_SUBJECT)
				.claim(USUARIO_ID, user.getId())
				.claim(USUARIO_NOME, user.getNome())
				.claim(USUARIO_ADMIN, user.isAdmin())
				.setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
				.signWith(SignatureAlgorithm.HS512, SECRET).compact();
		// @formatter:on
		final String BEARER_TOKER = TOKEN_PREFIX + " " + token;

		response.addHeader(HEADER_STRING, BEARER_TOKER);
		response.getWriter().write(BEARER_TOKER);
	}

	public static Authentication getAuthentication(HttpServletRequest request) {
		String token = request.getHeader(HEADER_STRING);
		if (token == null || !token.startsWith(TOKEN_PREFIX))
			return null;

		Claims claims = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token.replace(TOKEN_PREFIX, "")).getBody();

		String subject = claims.getSubject();
		UsuarioEntity user = new UsuarioEntity();
		user.setId(((Integer) claims.get(USUARIO_ID)).longValue());
		user.setNome((String) claims.get(USUARIO_NOME));
		user.setAdmin((Boolean) claims.get(USUARIO_ADMIN));

		return subject != null && JWT_SUBJECT.equals(subject)
				? new UsernamePasswordAuthenticationToken(user, null, UsuarioLogado.getAuthorities(user.isAdmin()))
				: null;
	}

}
