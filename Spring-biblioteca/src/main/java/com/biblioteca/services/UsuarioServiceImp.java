package com.biblioteca.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biblioteca.model.Usuario;
import com.biblioteca.repositories.UsuarioRepository;

@Service
public class UsuarioServiceImp implements IUsuarioService {
	
	@Autowired
	private UsuarioRepository ur;

	@Override
	public Usuario crearUsuario(Usuario u) {
		return ur.save(u);
	}

	@Override
	public Usuario actualizarUsuario(Usuario u) {
		return ur.save(u);
	}

	@Override
	public void eliminarUsuario(Usuario u) {
		ur.delete(u);
	}

	@Override
	public List<Usuario> listarTodosUsuarios() {
		return ur.findAll();
	}

	@Override
	public Usuario buscarUsuarioId(Long id) {
		return ur.getOne(id);
	}

	@Override
	public Usuario buscarUsuarioCc(String cc) {
		return ur.findByCc(cc);
	}
	
	@Override
	public Usuario buscarUsuarioEmail(String email) {
		return ur.findByEmail(email);
	}

}
