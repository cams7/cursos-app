/**
 * 
 */
package br.com.cams7.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.cams7.app.model.UsuarioEntity;
import br.com.cams7.app.repository.UsuarioRepository;

/**
 * @author ceanm
 *
 */
@Service
@Transactional
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Transactional(readOnly = true)
	@Override
	public List<UsuarioEntity> getAllUsuarios() {
		return usuarioRepository.findAll();
	}

	@Transactional(readOnly = true)
	@Override
	public UsuarioEntity getUsuarioById(Long usuarioId) {
		return usuarioRepository.findById(usuarioId).get();
	}

	@Override
	public UsuarioEntity createUsuario(UsuarioEntity usuario) {
		return usuarioRepository.save(usuario);
	}

	@Override
	public UsuarioEntity updateUsuario(Long usuarioId, UsuarioEntity usuario) {
		return createUsuario(usuario);
	}

	@Override
	public void deleteUsuario(Long usuarioId) {
		usuarioRepository.deleteById(usuarioId);
	}

}
