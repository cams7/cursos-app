/**
 * 
 */
package br.com.cams7.app.security;

/**
 * @author cams7
 *
 */
public class SecurityConstants {
	// Authorization Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ
	public static final String SECRET = "CursoApp";
	public static final String TOKEN_PREFIX = "Bearer";
	public static final String HEADER_STRING = "Authorization";
	public static final long EXPIRATION_TIME = 86400000l; // 1000x60x60x24 = 1 day

	public static final String LOGIN_URL = "/login";
	public static final String SIGNUP_URL = "/sign-up";

	public static final String JWT_SUBJECT = "loggedUser";
	public static final String USUARIO_ID = "id";
	public static final String USUARIO_NOME = "nome";
	public static final String USUARIO_ADMIN = "admin";
}
