/**
 * 
 */
package br.com.cams7.app.service;

import java.util.List;

import br.com.cams7.app.model.UsuarioEntity;

/**
 * @author ceanm
 *
 */
public interface UsuarioService {
	List<UsuarioEntity> getAllUsuarios();

	UsuarioEntity getUsuarioById(Long usuarioId);

	UsuarioEntity createUsuario(UsuarioEntity usuario);

	UsuarioEntity updateUsuario(Long usuarioId, UsuarioEntity usuario);

	void deleteUsuario(Long usuarioId);
}
