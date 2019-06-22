/**
 * 
 */
package br.com.cams7.app.service;

import br.com.cams7.app.model.UsuarioEntity;

/**
 * @author ceanm
 *
 */
public interface UsuarioService {
	Iterable<UsuarioEntity> getAllUsuarios();

	UsuarioEntity getUsuarioById(Long usuarioId);

	UsuarioEntity getUsuarioByNome(String nome);

	UsuarioEntity createUsuario(UsuarioEntity usuario);

	void updateUsuario(UsuarioEntity usuario);

	void deleteUsuario(Long usuarioId);
}
