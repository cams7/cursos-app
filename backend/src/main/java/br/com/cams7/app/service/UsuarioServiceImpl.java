/**
 * 
 */
package br.com.cams7.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.cams7.app.error.ResourceNotFoundException;
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
	public Iterable<UsuarioEntity> getAllUsuarios() {
		return usuarioRepository.findAll();
	}

	@Transactional(readOnly = true)
	@Override
	public UsuarioEntity getUsuarioById(Long usuarioId) {
		return usuarioRepository.findById(usuarioId).orElseThrow(() -> new ResourceNotFoundException(
				String.format("O usuario não foi encontrado pelo id: %d", usuarioId)));
	}

	@Transactional(readOnly = true)
	@Override
	public UsuarioEntity getUsuarioByNome(String nome) {
		return usuarioRepository.findByNome(nome).orElseThrow(
				() -> new ResourceNotFoundException(String.format("O usuario não foi encontrado pelo nome: %s", nome)));
	}

	@Override
	public UsuarioEntity createUsuario(UsuarioEntity usuario) {
		return usuarioRepository.save(usuario);
	}

	@Override
	public void updateUsuario(UsuarioEntity usuario) {
		createUsuario(usuario);
	}

	@Override
	public void deleteUsuario(Long usuarioId) {
		UsuarioEntity usuario = getUsuarioById(usuarioId);
		usuarioRepository.delete(usuario);
	}

}
